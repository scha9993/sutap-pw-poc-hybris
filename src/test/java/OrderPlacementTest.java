import com.sysco.brakes.qe.webui.data.CardData;
import com.sysco.brakes.qe.webui.data.UserData;
import com.sysco.brakes.qe.webui.function.BOUnit;
import com.sysco.brakes.qe.webui.function.Favorite;
import com.sysco.brakes.qe.webui.function.HeaderPanel;
import com.sysco.brakes.qe.webui.function.Home;
import com.sysco.brakes.qe.webui.function.Login;
import com.sysco.brakes.qe.webui.function.MyAccount;
import com.sysco.brakes.qe.webui.function.OrderConfirmation;
import com.sysco.brakes.qe.webui.function.OrderDetails;
import com.sysco.brakes.qe.webui.function.OrderSummary;
import com.sysco.brakes.qe.webui.function.PaymentPanel;
import com.sysco.brakes.qe.webui.function.ProductDetails;
import com.sysco.brakes.qe.webui.model.Card;
import com.sysco.brakes.qe.webui.model.User;
import com.sysco.brakes.qe.webui.util.DateTimeUtil;
import com.syscolab.qe.core.playwright.ui.BaseBrowser;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;
import common.Constants;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;

public class OrderPlacementTest extends BaseBrowser {
    SyscoLabPW page;
    SoftAssert softAssert;
    Login login;
    HeaderPanel headerPanel;
    Favorite favorite;
    OrderSummary orderSummary;
    UserData userData;
    MyAccount myAccount;
    PaymentPanel paymentPanel;
    OrderConfirmation orderConfirmation;
    OrderDetails orderDetails;
    ProductDetails productDetails;
    Home home;
    BOUnit boUnit;

    @BeforeClass(alwaysRun = true)
    public void setUp(ITestContext iTestContext) throws IOException {
        iTestContext.setAttribute("feature", "Playwright - PWSS");
        ArrayList<String> options = new ArrayList<>();
        options.add("--disable-web-security");
        page=getPage("Default");
        login = new Login(page);
        headerPanel = new HeaderPanel(page);
        userData = new UserData(Constants.TEST_DATA_PATH+"loginData.json");
    }

    @BeforeMethod(alwaysRun = true)
    public void declareSoftAssert(){
        softAssert = new SoftAssert();
    }

    @Test(priority = 1, description = "3115_7_b Validate Continue shopping CTA will be available to the customer allowing them to return to the Home Page", invocationCount = 10)
    public void ContinueShoppingCTAReturnsHomeTest() throws InterruptedException {
        favorite = new Favorite(page);
        orderSummary = new OrderSummary(page);
        orderConfirmation=new OrderConfirmation(page);
        orderDetails =new OrderDetails(page);
        productDetails= new ProductDetails(page);
        home= new Home(page);

        login.navigateToHybris();
        User favoriteUser = userData.getUsers().get(0);
        login.loginToHybris(favoriteUser.getUsername(), favoriteUser.getPassword());
        headerPanel.gotoMyFavorites();
        favorite.addFavoriteList("FavTest.231013");
        headerPanel.gotoCheckout();
        orderSummary.clickCheckout();
        orderSummary.placeOrder();
        orderSummary.clickCheckout();
        orderSummary.clickCheckout();
        orderSummary.placeOrderWithPoReference("PO_" + DateTimeUtil.getCurrentDateTime());
        orderConfirmation.isOrderPlacementSuccess();
        orderConfirmation.clickContinue();
        home.isHomePageDisplayed();
//        orderDetails.isOrderDetailsHeaderDisplayed();
//        orderDetails.amendOrder();
//        headerPanel.searchProduct("F 120847");
//        productDetails.selectSearched_Product("120847");
//        productDetails.addQuantity("5");
//        productDetails.resubmit();
//        orderConfirmation.isAmendedOrderSuccess();
        login.logout();
    }

    @Test(priority = 2, description = "SP4.0.0_776.1.2/776.2.1/776.2.3 - Verify GOT IT CTA Button")
    public void GotItCTATest() throws InterruptedException, IOException {
        myAccount = new MyAccount(page);
        orderSummary = new OrderSummary(page);
        paymentPanel = new PaymentPanel(page);
        login.navigateToHybris();
        User cardUser = userData.getUsers().get(1);
        CardData cardData = new CardData(Constants.TEST_DATA_PATH+"paymentCard.json");
        Card updateCard;
        Card masterCard = cardData.getCards().get(0);
        Card visaCard = cardData.getCards().get(2);
        login.loginToHybris(cardUser.getUsername(), cardUser.getPassword());
//        headerPanel.switchAccount();
        headerPanel.clickHome();
        headerPanel.gotoMyDetails();
        myAccount.clickPaymentCardTab();
        if (paymentPanel.isMasterCard().equals(visaCard.getCardStarNumber())){
            updateCard = masterCard;
        }else{
            updateCard = visaCard;
        }
        paymentPanel.updateCard(updateCard.getCardNo(), updateCard.getCardHolder(), updateCard.getExpiryDate(), updateCard.getCvv(), updateCard.getSecretCode());
        myAccount.clickPaymentCardTab();

    }

    @Test(priority = 3, description = "SP4.0.0_775.1/775.3.1/775.3.3/775.5/775.7.1/775.7.2/775.7.3/ - Verify Payment Card Is Nearly Expired\n" +
            "        Banner and UPDATE CTA Are Available Underneath the Benefits Bar When Card Is About to Expire", invocationCount = 10)
    public void CardExpiryBannerTest() throws InterruptedException {
        User expiringCardUser = userData.getUsers().get(4);
        User bOUser = userData.getUsers().get(3);
        boUnit = new BOUnit(page);
        headerPanel = new HeaderPanel(page);
        home = new Home(page);
        orderSummary = new OrderSummary(page);
        orderConfirmation = new OrderConfirmation(page);
        boUnit.bOLogin(bOUser.getUsername(), bOUser.getPassword());
        boUnit.setNearlyExpiredCardAtDefaultPaymentCardForB2BUnit("B2B Unit", bOUser.getAccountNumber(), DateTimeUtil.getCurrentYear(), DateTimeUtil.getCurrentMonth());
        boUnit.signOut();
        login.navigateToHybris();
        login.loginToHybris(expiringCardUser.getUsername(), expiringCardUser.getPassword());
        softAssert.assertEquals(home.getCardExpiringBannerText(), "Payment card is nearly expired. Update your card details ASAP.", "Payment card is nearly expired banner message is not correct.");
        headerPanel.searchProduct("Cheese");
        home.addXQuantityOfNthProduct(0, "8");
        home.addXQuantityOfNthProduct(1, "8");
        headerPanel.gotoCheckout();
        orderSummary.clickCheckout();
        softAssert.assertTrue(orderSummary.isPlaceOrderButtonEnabled(), "Place order button is not enabled");
        softAssert.assertFalse(orderSummary.isCardDisabled(), "Card is disabled");
        orderSummary.placeOrder();
        orderSummary.clickCheckout();
        orderSummary.clickCheckout();
        orderSummary.placeOrderWithPoReference("PO_" + DateTimeUtil.getCurrentDateTime());
        orderConfirmation.isOrderPlacementSuccess();
        orderConfirmation.clickContinue();
        home.isHomePageDisplayed();
        login.logout();
    }

}

import com.google.gson.JsonObject;
import com.sysco.brakes.qe.webui.data.UserData;
import com.sysco.brakes.qe.webui.function.favorite.Favorite;
import com.sysco.brakes.qe.webui.function.headerPanel.HeaderPanel;
import com.sysco.brakes.qe.webui.function.login.Login;
import com.sysco.brakes.qe.webui.function.orderSummary.OrderSummary;
import com.sysco.brakes.qe.webui.model.User;
import com.sysco.brakes.qe.webui.util.JsonUtil;
import com.syscolab.qe.core.playwright.ui.BaseBrowser;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;
import common.Constants;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class OrderPlacementTest extends BaseBrowser {
    SyscoLabPW page;
    SoftAssert softAssert;
    Login login;
    HeaderPanel headerPanel;
    Favorite favorite;
    OrderSummary orderSummary;
    UserData userData;

    @BeforeClass(alwaysRun = true)
    public void setUp(ITestContext iTestContext) throws IOException {
        iTestContext.setAttribute("feature", "Playwright - PWSS");
        page=getPage("Default");
        login = new Login(page);
        headerPanel = new HeaderPanel(page);
        userData = new UserData(Constants.TEST_DATA_PATH+"loginData.json");
    }

    @BeforeMethod(alwaysRun = true)
    public void declareSoftAssert(){
        softAssert = new SoftAssert();
    }

    @Test(priority = 1, description = "3115_7_b Validate Continue shopping CTA will be available to the customer allowing them to return to the Home Page")
    public void ContinueShoppingCTAReturnsHomeTest() throws InterruptedException, IOException {
        favorite = new Favorite(page);
        orderSummary = new OrderSummary(page);
        login.navigateToHybris();
        User favoriteUser = userData.getUsers().get(0);
        login.loginToHybris(favoriteUser.getUsername(), favoriteUser.getPassword());
        headerPanel.gotoMyFavorites();
        favorite.addFavoriteList("FavTest.SP22.0.0_2269.2_02");
        headerPanel.gotoCheckout();
        orderSummary.clickCheckout();
        orderSummary.placeOrder();
        orderSummary.clickCheckout();


    }

    @Test(priority = 2, description = "SP4.0.0_776.1.2/776.2.1/776.2.3 - Verify GOT IT CTA Button")
    public void GotItCTATest() throws InterruptedException {
        favorite = new Favorite(page);
        login.navigateToHybris();
//        login.loginToHybris();
        headerPanel.gotoMyDetails();

    }


}

package com.sysco.brakes.qe.webui.function;

import com.sysco.brakes.qe.webui.page.PaymentCardPanelPage;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;

public class PaymentPanel {

    PaymentCardPanelPage paymentCardPanelPage;

    public PaymentPanel(SyscoLabPW page) {
        paymentCardPanelPage = new PaymentCardPanelPage(page);
    }

    public String isMasterCard(){
        return paymentCardPanelPage.getCardNumberWithStars();
    }

    public void updateCard(String cardNumber, String name, String expiryDate, String cvv, String secret){
        paymentCardPanelPage.clickUpdate();
        enterCardDetails(cardNumber, name, expiryDate, cvv);
        paymentCardPanelPage.enterSecret(secret);
        paymentCardPanelPage.clickSubmit();
    }

    public void enterCardDetails(String cardNumber, String name, String expiryDate, String cvv){
        paymentCardPanelPage.enterCardNumber(cardNumber);
        paymentCardPanelPage.enterName(name);
        paymentCardPanelPage.enterExpiryDate(expiryDate);
        paymentCardPanelPage.enterCVV(cvv);
        paymentCardPanelPage.clickConfirm();
    }
}

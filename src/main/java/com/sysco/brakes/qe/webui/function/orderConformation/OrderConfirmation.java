package com.sysco.brakes.qe.webui.function.orderConformation;

import com.sysco.brakes.qe.webui.page.orderConformation.OrderConformationPage;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;

public class OrderConfirmation {

    OrderConformationPage orderConformationPage;

    public OrderConfirmation(SyscoLabPW page) {
        orderConformationPage = new OrderConformationPage(page);
    }

    public void isOrderPlacementSuccess(){
        orderConformationPage.isContinueCtaDisplayed();
        orderConformationPage.isStockMessageDisplayed();
    }

    public void isAmendedOrderSuccess(){
        orderConformationPage.isOrderAmendedMessageDisplayed();
        orderConformationPage.isContinueCtaDisplayed();
    }

    public void clickContinue() throws InterruptedException {
        orderConformationPage.clickContinueShopping();
        Thread.sleep(3000);
    }
}

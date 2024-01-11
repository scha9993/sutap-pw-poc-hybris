package com.sysco.brakes.qe.webui.function;

import com.sysco.brakes.qe.webui.page.OrderSummaryPage;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;

public class OrderSummary{

    OrderSummaryPage orderSummaryPage;

    public OrderSummary(SyscoLabPW page) {
        orderSummaryPage = new OrderSummaryPage(page);
    }

    public void clickCheckout() throws InterruptedException {
        orderSummaryPage.clickCheckout();
    }

    public void placeOrder() {
        orderSummaryPage.clickDeliveryDate();
        orderSummaryPage.selectDeliveryDate();
        orderSummaryPage.clickConfirm();
    }

    public void placeOrderWithPoReference(String poReference){
        orderSummaryPage.enterPoReference(poReference);
        orderSummaryPage.clickPlaceOrder();
    }

    public boolean isPlaceOrderButtonEnabled(){
        return orderSummaryPage.isPlaceOrderButtonEnabled();
    }

    public boolean isCardDisabled(){
        return orderSummaryPage.isCardDisabled();
    }
}

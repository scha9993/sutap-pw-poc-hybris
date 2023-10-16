package com.sysco.brakes.qe.webui.function.orderSummary;

import com.sysco.brakes.qe.webui.page.orderSummary.OrderSummaryPage;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;

public class OrderSummary{

    OrderSummaryPage orderSummaryPage;

    public OrderSummary(SyscoLabPW page) {
        orderSummaryPage = new OrderSummaryPage(page);
    }

    public void clickCheckout(){
        orderSummaryPage.clickCheckout();
    }

    public void placeOrder(){
        orderSummaryPage.clickDeliveryDate();
        orderSummaryPage.selectDeliveryDate();
        orderSummaryPage.clickConfirm();
    }

    public void placeOrderWithPoReference(String poReference){
        orderSummaryPage.enterPoReference(poReference);
        orderSummaryPage.clickPlaceOrder();
    }
}

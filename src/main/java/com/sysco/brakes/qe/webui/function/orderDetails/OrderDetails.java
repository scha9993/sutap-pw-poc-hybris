package com.sysco.brakes.qe.webui.function.orderDetails;

import com.sysco.brakes.qe.webui.page.orderDetails.OrderDetailsPage;
import com.sysco.brakes.qe.webui.page.orderSummary.OrderSummaryPage;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;

public class OrderDetails {

    OrderDetailsPage orderDetailsPage;

    public OrderDetails(SyscoLabPW page) {
        orderDetailsPage = new OrderDetailsPage(page);
    }

    public void isOrderDetailsHeaderDisplayed(){
        orderDetailsPage.isInOrderDetailsPage();
    }

    public void amendOrder(){
        orderDetailsPage.refreshUntilOrderConfirmed();
        orderDetailsPage.clickAmendOrder();
    }

}

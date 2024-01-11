package com.sysco.brakes.qe.webui.function;

import com.sysco.brakes.qe.webui.page.OrderDetailsPage;
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

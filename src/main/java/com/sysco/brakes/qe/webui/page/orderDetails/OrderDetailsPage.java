package com.sysco.brakes.qe.webui.page.orderDetails;

import com.sysco.brakes.qe.webui.util.HybrisUtil;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;

public class OrderDetailsPage extends HybrisUtil {

   //private String btnCheckout = "Checkout";
    private String txtOrderDetailsHeader = "//h1[(contains(.,'Order Details'))]";
    private String btnAmendOrder = "//button[normalize-space()='Re-order']";
    private String txtOrderStatus = "Waiting for Confirmation";

    public OrderDetailsPage(SyscoLabPW page) {
        super(page);
    }

    public void isInOrderDetailsPage(){
        page.elemVisibility(page.findByLocator(txtOrderDetailsHeader));
    }

    public void clickAmendOrder(){
        page.waitFor(50000);
        page.click(page.findByLocator(btnAmendOrder));
    }

    public void refreshUntilOrderConfirmed(){
        while (page.elemVisibility(page.findByLocator(txtOrderStatus))){
            page.refresh();
            page.waitFor(1000);
        }
    }




}

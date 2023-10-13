package com.sysco.brakes.qe.webui.page.orderSummary;

import com.sysco.brakes.qe.webui.util.HybrisUtil;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;

public class OrderSummaryPage extends HybrisUtil {

   //private String btnCheckout = "Checkout";
    private String btnCheckout = "//a[contains(normalize-space(), 'Checkout')]";
    private String btnNextAvailableDate = "//span[contains( @class,'flatpickr-day') and not(contains(@class,'disabled')) and not(contains(@class,'selected'))]";
    private String btnConfirmNewDate = "Confirm new delivery date";
    private String txtDeliveryDate = "//a[@data-id='delivery-calendar']";
    private String txtPoReference = "checkout.purchaseordernumber";
    private String btnPlaceOrder = "checkout.summary.placeOrder";

    public OrderSummaryPage(SyscoLabPW page) {
        super(page);
    }

    public void clickCheckout(){
        page.clickFirst(page.findByLocator(btnCheckout));
    }

    public void clickDeliveryDate(){
        page.click(page.findByLocator(txtDeliveryDate));
    }

    public void selectDeliveryDate(){
        page.clickFirst(page.findByLocator(btnNextAvailableDate));
    }

    public void clickConfirm(){
        page.click(page.findByText(btnConfirmNewDate));
    }

    public void enterPoReference(String poReference){
        page.typeInto(page.findById(txtPoReference),poReference);
    }
    public void clickPlaceOrder(){
        page.click(page.findById(btnPlaceOrder));
    }


}

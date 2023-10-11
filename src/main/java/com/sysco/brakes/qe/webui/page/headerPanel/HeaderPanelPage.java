package com.sysco.brakes.qe.webui.page.headerPanel;

import com.sysco.brakes.qe.webui.util.HybrisUtil;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;

public class HeaderPanelPage extends HybrisUtil {

    private String btnUserIcon = "//button[@aria-label='My Brakes']";
    private String lnkMyFavourites = "//a[.='My favourites']";
    private String lnkMyDetails = "//a[.='My details']";
    private String lnkCart = "//a[@href='/cart']";
    private String lnkCheckout = "Checkout";

    public HeaderPanelPage(SyscoLabPW page) {
        super(page);
    }

    public void clickUserIcon(){
        page.click(btnUserIcon);
    }

    public void clickMyFavourites(){
        page.click(lnkMyFavourites);
    }

    public void clickMyDetails(){
        page.click(lnkMyDetails);
    }

    public void clickCheckout(){
        page.clickFirst(page.findByText(lnkCheckout));
    }

}

package com.sysco.brakes.qe.webui.function.headerPanel;

import com.sysco.brakes.qe.webui.page.headerPanel.HeaderPanelPage;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;

public class HeaderPanel extends HeaderPanelPage {

    HeaderPanelPage headerPanelPage;

    public HeaderPanel(SyscoLabPW page) {
        super(page);
        headerPanelPage = new HeaderPanelPage(page);
    }

    public void gotoMyFavorites(){
        headerPanelPage.clickUserIcon();
        headerPanelPage.clickMyFavourites();
    }

    public void gotoMyDetails(){
        headerPanelPage.clickUserIcon();
        headerPanelPage.clickMyDetails();
    }

    public void gotoCheckout(){
        headerPanelPage.clickCheckout();
    }
}

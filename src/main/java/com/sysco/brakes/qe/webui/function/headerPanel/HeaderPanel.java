package com.sysco.brakes.qe.webui.function.headerPanel;

import com.sysco.brakes.qe.webui.page.headerPanel.HeaderPanelPage;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;

public class HeaderPanel {

    HeaderPanelPage headerPanelPage;

    public HeaderPanel(SyscoLabPW page) {
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

    public void switchAccount(){
        headerPanelPage.clickUserIcon();
        headerPanelPage.clickSwitchAccount();
        headerPanelPage.selectAccount();
        headerPanelPage.clickBack();
        headerPanelPage.clickUserIcon();
    }

    public void clickHome(){
        headerPanelPage.clickHome();
    }

    public void searchProduct(String productCode){
        headerPanelPage.search_product(productCode);
    }

    public void clickUserIcon(){
        headerPanelPage.clickUserIcon();
    }
}

package com.sysco.brakes.qe.webui.page.headerPanel;

import com.sysco.brakes.qe.webui.util.HybrisUtil;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;

public class HeaderPanelPage extends HybrisUtil {

    private String btnUserIcon = "//button[@aria-label='My Brakes']";
    private String lnkMyFavourites = "//a[.='My favourites']";
    private String lnkMyDetails = "//a[.='My details']";
    private String lnkCart = "//a[@href='/cart']";
    private String lnkCheckout = "Checkout";
    private String lnkSwitchAccount = "//button[.='Switch account']";
    private String lnkBack = "//button[.='Back']";
    private String chkBoxUserAccount = "//input[@checked and @value='1723095']";
    private String imgHome = "//img[@title='brakes-ampliance-logo.png']";
    private String txtFldsearchBar = "Search products...";
    private String btnSearch = "//button[@aria-label='Search products...']";

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

    public void clickCheckout() throws InterruptedException {
        page.clickFirst(page.findByText(lnkCheckout));
        Thread.sleep(4000);
    }

    public void clickSwitchAccount(){
        page.click(lnkSwitchAccount);
    }

    public void selectAccount(){
        page.switchToChildFrame("", 0);
        page.frameCheckBoxClick(chkBoxUserAccount);
    }

    public void clickBack(){
        page.switchToChildFrame("", 0);
        page.frameClick(lnkBack);
    }

    public void clickHome(){
        page.click(imgHome);
    }

    public void search_product(String searchText){
        page.click(page.findByPlaceHolder(txtFldsearchBar));
        page.typeInto(page.findByPlaceHolder(txtFldsearchBar),searchText);
        page.click(page.findByLocator(btnSearch));
    }
}

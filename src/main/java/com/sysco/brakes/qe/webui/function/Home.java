package com.sysco.brakes.qe.webui.function;

import com.sysco.brakes.qe.webui.page.HomePage;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;

public class Home {

    HomePage homePage;

    public Home(SyscoLabPW page) {
        homePage = new HomePage(page);
    }

    public void isHomePageDisplayed(){
        homePage.isHomePageDisplayed();
    }

    public String getCardExpiringBannerText(){
        return homePage.getCardExpiringBannerText();
    }

    public void addXQuantityOfNthProduct(int n, String quantity){
        homePage.addNthProduct(n);
        homePage.enterQuantityForNthProduct(n, quantity);
    }
}

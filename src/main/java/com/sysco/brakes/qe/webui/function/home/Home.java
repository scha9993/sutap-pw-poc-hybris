package com.sysco.brakes.qe.webui.function.home;

import com.sysco.brakes.qe.webui.page.home.HomePage;
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
}

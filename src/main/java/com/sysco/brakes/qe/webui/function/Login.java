package com.sysco.brakes.qe.webui.function;

import com.sysco.brakes.qe.webui.page.HeaderPanelPage;
import com.sysco.brakes.qe.webui.page.LoginPage;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;

public class Login{
    LoginPage loginPage;
    HeaderPanelPage headerPanelPage;

    public Login(SyscoLabPW page) {
        loginPage = new LoginPage(page);
        headerPanelPage=new HeaderPanelPage(page);
    }

    public void navigateToHybris(){
        loginPage.navigateToHybris();
    }

    public void loginToHybris(String userName, String password) throws InterruptedException {
        loginPage.clickUserIcon();
        loginPage.enterUserName(userName);
        loginPage.clickNext();
        loginPage.enterPassword(password);
        loginPage.clickSignIn();
    }
    public void logout() throws InterruptedException {
        headerPanelPage.clickUserIcon();
        loginPage.clickSignOut();
    }
}

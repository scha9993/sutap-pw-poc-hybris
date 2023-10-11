package com.sysco.brakes.qe.webui.function.login;

import com.sysco.brakes.qe.webui.page.loginPage.LoginPage;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;

public class Login{
    LoginPage loginPage;

    public Login(SyscoLabPW page) {
        loginPage = new LoginPage(page);
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
}

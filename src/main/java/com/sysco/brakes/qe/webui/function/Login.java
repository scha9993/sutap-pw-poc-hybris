package com.sysco.brakes.qe.webui.function;

import com.sysco.brakes.qe.webui.page.LoginPage;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;

public class Login extends LoginPage {
    LoginPage loginPage;

    public Login(SyscoLabPW page) {
        super(page);
        loginPage = new LoginPage(page);
    }

    public void navigateToHybris(){
        loginPage.navigateToHybris();
    }

    public void loginToHybris() throws InterruptedException {
        loginPage.clickUserIcon();
        loginPage.enterUserName();
        loginPage.clickNext();
        loginPage.enterPassword();
    }
}

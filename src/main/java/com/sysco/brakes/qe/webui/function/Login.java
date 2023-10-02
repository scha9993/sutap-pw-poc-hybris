package com.sysco.brakes.qe.webui.function;

import com.sysco.brakes.qe.webui.page.LoginPage;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;

public class Login extends LoginPage {

    public Login(SyscoLabPW page) {
        super(page);
    }

    public void loginToHybris() throws InterruptedException {
        navigateToHybris();
//        clickAgreePopup();
        clickUserIcon();
        enterUserName();
        enterPassword();
    }
}

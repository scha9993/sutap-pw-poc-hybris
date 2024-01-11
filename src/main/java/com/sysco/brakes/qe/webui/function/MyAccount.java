package com.sysco.brakes.qe.webui.function;

import com.sysco.brakes.qe.webui.page.MyAccountPage;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;

public class MyAccount{
    MyAccountPage myAccountPage;

    public MyAccount(SyscoLabPW page) {
        myAccountPage = new MyAccountPage(page);
    }

    public void clickPaymentCardTab(){
        myAccountPage.clickPaymentCard();
    }
}

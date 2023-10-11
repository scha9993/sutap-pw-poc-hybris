package com.sysco.brakes.qe.webui.page.myAccount;

import com.sysco.brakes.qe.webui.util.HybrisUtil;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;

public class MyAccountPage extends HybrisUtil {

    private String btnPaymentCard = "My payment card";

    public MyAccountPage(SyscoLabPW page) {
        super(page);
    }

    public void clickPaymentCard(){
        page.clickFirst(page.findByText(btnPaymentCard));
    }

}

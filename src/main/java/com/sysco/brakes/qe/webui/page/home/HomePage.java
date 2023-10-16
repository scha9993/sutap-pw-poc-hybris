package com.sysco.brakes.qe.webui.page.home;

import com.sysco.brakes.qe.webui.util.HybrisUtil;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;

public class HomePage extends HybrisUtil {

    private String btnViewMyOrders = "//a[contains(normalize-space(),'View my Orders')]";

    public HomePage(SyscoLabPW page) {
        super(page);
    }

    public boolean isHomePageDisplayed(){
        return page.elemVisibility(page.findByLocator(btnViewMyOrders));
    }
}

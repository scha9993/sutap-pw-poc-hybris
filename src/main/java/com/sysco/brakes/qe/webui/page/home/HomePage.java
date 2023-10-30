package com.sysco.brakes.qe.webui.page.home;

import com.sysco.brakes.qe.webui.util.HybrisUtil;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;

public class HomePage extends HybrisUtil {

    private String btnViewMyOrders = "//a[contains(normalize-space(),'View my Orders')]";
    private String txtCardExpiringBanner = "//div[@class='payment-banner__content payment-banner__content--left hidden-xs']/span[2]";

    public HomePage(SyscoLabPW page) {
        super(page);
    }

    public boolean isHomePageDisplayed(){
        page.waitFor(5);
        return page.elemVisibility(page.findByLocator(btnViewMyOrders));
    }

    public String getCardExpiringBannerText(){
        return page.getText(page.findByLocator(txtCardExpiringBanner));
    }
}

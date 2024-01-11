package com.sysco.brakes.qe.webui.page;

import com.sysco.brakes.qe.webui.util.HybrisUtil;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;

public class ProductPage extends HybrisUtil {

    private String lnkSearchedProduct = "//a[contains(normalize-space(),'20847')]";


    public ProductPage(SyscoLabPW page) {
        super(page);
    }

    public void clickSearchedProduct(String productName){
        page.click(page.findByLocator(lnkSearchedProduct));
    }

}

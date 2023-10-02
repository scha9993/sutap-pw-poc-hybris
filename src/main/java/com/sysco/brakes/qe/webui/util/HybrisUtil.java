package com.sysco.brakes.qe.webui.util;

import com.syscolab.qe.core.playwright.ui.BaseBrowser;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;
import org.testng.asserts.SoftAssert;

public class HybrisUtil extends BaseBrowser {
    public SyscoLabPW page;
    public SoftAssert softAssert;

   public HybrisUtil(SyscoLabPW page){
       this.page = page;
       softAssert = new SoftAssert();
   }

}
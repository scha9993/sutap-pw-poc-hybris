package com.sysco.brakes.qe.webui.page;

import common.Constants;
import com.sysco.brakes.qe.webui.util.HybrisUtil;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;

public class LoginPage extends HybrisUtil {

    private String txtFldUserName = "//input[@name='username']";
    private String txtFldPassword = "//input[@name='password']";
    private String btnUserIcon = "//button[@aria-label='Sign In']";
    private String btnSignIn = "//input[@type='submit']";
    private String btnPopUpAgreeID = "#onetrust-accept-btn-handler";
    private String iFrameSignIn = "#sso-iframe";

    public LoginPage(SyscoLabPW page) {
        super(page);
    }

    public void navigateToHybris(){
        page.goTo(Constants.HYBRIS_URL);
    }

    public void clickAgreePopup(){
        page.click(btnPopUpAgreeID);
    }

    public void clickUserIcon() throws InterruptedException {
        page.click(btnUserIcon);
//        page.switchTabOnClick(page.findByLocator(btnUserIcon));
        Thread.sleep(5000);
    }

    public void enterUserName(){
        page.switchToFrameByURL(iFrameSignIn);
        page.frameClick(txtFldUserName);
        page.frameSendKeys(txtFldUserName, Constants.HYBRIS_USERNAME);
    }

    public void enterPassword(){
        page.sendKeys(txtFldPassword, Constants.HYBRIS_PASSWORD);
    }

    public void clickSignIn(){
        page.click(btnSignIn);
    }

}

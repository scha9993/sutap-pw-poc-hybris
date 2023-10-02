package com.sysco.brakes.qe.webui.page;

import common.Constants;
import com.sysco.brakes.qe.webui.util.HybrisUtil;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;

public class LoginPage extends HybrisUtil {

    private String txtFldUserName = "//input[@name='identifier']";
    private String txtFldPassword = "//input[@type='password']";
    private String btnUserIcon = "//button[@aria-label='Sign In']";
    private String btnNext = "//input[@value='Next']";
    private String btnSignIn = "//input[@type='submit']";
    private String btnPopUpAgreeID = "#onetrust-accept-btn-handler";

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
        Thread.sleep(5000);
    }

    public void enterUserName(){
        page.switchToChildFrame("", 0);
        page.frameSendKeys(txtFldUserName, Constants.HYBRIS_USERNAME);

    }

    public void enterPassword(){
        page.frameSendKeys(txtFldPassword, Constants.HYBRIS_PASSWORD);
    }

    public void clickNext(){
        page.frameClick(btnNext);
    }

    public void clickSignIn(){
        page.frameClick(btnSignIn);
    }

}

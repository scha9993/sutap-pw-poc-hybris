package com.sysco.brakes.qe.webui.page.loginPage;

import com.sysco.brakes.qe.webui.util.HybrisUtil;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;
import common.Constants;

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

    public void enterUserName(String userName){
        page.switchToChildFrame("", 0);
        page.frameSendKeys(txtFldUserName, userName);

    }

    public void enterPassword(String password){
        page.frameSendKeys(txtFldPassword, password);
    }

    public void clickNext(){
        page.frameClick(btnNext);
    }

    public void clickSignIn(){
        page.frameClick(btnSignIn);
    }

}
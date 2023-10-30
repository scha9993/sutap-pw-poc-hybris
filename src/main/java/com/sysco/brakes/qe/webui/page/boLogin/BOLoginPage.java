package com.sysco.brakes.qe.webui.page.boLogin;

import com.sysco.brakes.qe.webui.util.HybrisUtil;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;
import common.Constants;

public class BOLoginPage extends HybrisUtil {

    private String txtFldUsername = "input[name='j_username']";
    private String txtFldPassword = "input[name='j_password']";
    private String btnSignIn = "//*[text()=\"Sign In\"]";

    public BOLoginPage(SyscoLabPW page) {
        super(page);
    }

    public void navigateToBO(){
        page.goTo(Constants.BACKOFFICE_URL);
    }

    public void enterUserName(String username){
        page.typeInto(page.findByLocator(txtFldUsername), username);
    }

    public void enterUserPassword(String password){
        page.typeInto(page.findByLocator(txtFldPassword), password);
    }

    public void clickSignIn(){
        page.click(page.findByLocator(btnSignIn));
    }

}

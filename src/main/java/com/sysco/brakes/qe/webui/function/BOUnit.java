package com.sysco.brakes.qe.webui.function;

import com.sysco.brakes.qe.webui.page.BOLoginPage;
import com.sysco.brakes.qe.webui.page.BOUnitPage;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;

public class BOUnit {
    BOUnitPage boUnitPage;
    BOLoginPage boLoginPage;

    public BOUnit(SyscoLabPW page) {
        boUnitPage = new BOUnitPage(page);
        boLoginPage = new BOLoginPage(page);
    }

    public void navigateToBO(){
        boLoginPage.navigateToBO();
    }

    public void bOLogin(String username, String password) throws InterruptedException {
        boLoginPage.navigateToBO();
        Thread.sleep(3000);
        boLoginPage.enterUserName(username);
        boLoginPage.enterUserPassword(password);
        boLoginPage.clickSignIn();
    }

    public void setNearlyExpiredCardAtDefaultPaymentCardForB2BUnit(String unit, String accountName, String currentYear, String currentMonth) throws InterruptedException {
        boUnitPage.searchB2BUnit(unit);
        boUnitPage.clickB2BUnitMenuItem();
        boUnitPage.viewB2BUnitDetails(accountName);
        boUnitPage.clickAdministration();
        if (boUnitPage.isCardAvailable()){
            boUnitPage.openEditCardModal();
            boUnitPage.backDateExpiryYear(currentYear);
            boUnitPage.backDateExpiryMonth(currentMonth);
            if(boUnitPage.isSaveButtonEnabled()){
                boUnitPage.clickSave();
            }
            else{
                boUnitPage.clickClose();
            }

        }
    }

    public void signOut() throws InterruptedException {
        boUnitPage.logout();
    }

}

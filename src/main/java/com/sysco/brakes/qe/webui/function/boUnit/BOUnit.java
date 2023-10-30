package com.sysco.brakes.qe.webui.function.boUnit;

import com.sysco.brakes.qe.webui.page.boLogin.BOLoginPage;
import com.sysco.brakes.qe.webui.page.boUnit.BOUnitPage;
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

    public void bOLogin(String username, String password){
        boLoginPage.navigateToBO();
        boLoginPage.enterUserName(username);
        boLoginPage.enterUserPassword(password);
        boLoginPage.clickSignIn();
    }

    public void setNearlyExpiredCardAtDefaultPaymentCardForB2BUnit(String unit, String accountName, String currentYear, String currentMonth){
        boUnitPage.searchB2BUnit(unit);
        boUnitPage.clickB2BUnitMenuItem();
        boUnitPage.viewB2BUnitDetails(accountName);
        boUnitPage.clickAdministration();
        if (boUnitPage.isCardAvailable()){
            boUnitPage.openEditCardModal();
            boUnitPage.backDateExpiryYear(currentYear);
            boUnitPage.backDateExpiryMonth(currentMonth);
            boUnitPage.clickSave();
        }
    }

}

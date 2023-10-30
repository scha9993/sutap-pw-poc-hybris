package com.sysco.brakes.qe.webui.page.boUnit;

import com.sysco.brakes.qe.webui.util.HybrisUtil;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;
public class BOUnitPage extends HybrisUtil {

    private String txtFldSearchBar = "//input[@placeholder='Filter tree (Alt+Down for options)']";
    private String txtMenuItem = "//span[text()='B2B Unit']";
    private String txtFldSearchB2BAccount = "//*[@class='z-bandbox-input z-bandbox-rightedge']";
    private String btnSearch = "//button[contains(@class,'yw-textsearch')][text()='Search']";
    private String txtSearchResult = "//*[text()='B2BCUSTOMER']";
    private String txtAdmin = "//*[@title='Administration']";
    private String txtDefaultPaymentCard = "//*[@title='Default Payment Info']/../../div[2]";
    private String txtFldExpiryMonth = "(//*[@title='Month']//..//..//*[@class='ye-input-text ye-com_hybris_cockpitng_editor_defaulttext z-textbox'])[2]";
    private String txtFldExpiryYear = "//span[@title='Valid to year']/../..//input[@class='ye-input-text ye-com_hybris_cockpitng_editor_defaulttext z-textbox']";
    private String btnSave = "//div[contains(@class,'yw-editor-area-creditcardpaymentinfo')]//button[text()='Save']";

    public BOUnitPage(SyscoLabPW page) {
        super(page);
    }

    public void searchB2BUnit(String unit){
        page.typeInto(page.findByLocator(txtFldSearchBar), unit);
    }

    public void clickB2BUnitMenuItem(){
        page.click(page.findByLocator(txtMenuItem));
    }

    public void viewB2BUnitDetails(String accountName){
        page.typeInto(page.findByLocator(txtFldSearchB2BAccount), accountName);
        page.click(page.findByLocator(btnSearch));
        page.click(page.findByLocator(txtSearchResult.replace("B2BCUSTOMER", accountName)));
    }

    public void clickAdministration(){
        page.click(page.findByLocator(txtAdmin));
    }

    public boolean isCardAvailable(){
        if(page.getText(page.findByLocator(txtDefaultPaymentCard)).equalsIgnoreCase("")){return false;}
        else{return true;}
    }

    public void openEditCardModal(){
        page.doubleClick(page.findByLocator(txtDefaultPaymentCard));
    }

    public void backDateExpiryMonth(String currentMonth){
        page.doubleClick(page.findByLocator(txtFldExpiryMonth));
        page.pressKeyBoardKey(page.findByLocator(txtFldExpiryMonth), "Backspace");
        page.typeInto(page.findByLocator(txtFldExpiryMonth), currentMonth);
    }

    public void backDateExpiryYear(String currentYear){
        page.doubleClick(page.findByLocator(txtFldExpiryYear));
        page.pressKeyBoardKey(page.findByLocator(txtFldExpiryYear), "Backspace");
        page.typeInto(page.findByLocator(txtFldExpiryYear), currentYear);
    }

    public void clickSave(){
        page.click(page.findByLocator(btnSave));
    }

}

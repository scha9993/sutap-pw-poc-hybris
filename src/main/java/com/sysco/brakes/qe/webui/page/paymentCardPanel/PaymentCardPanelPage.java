package com.sysco.brakes.qe.webui.page.paymentCardPanel;

import com.sysco.brakes.qe.webui.util.HybrisUtil;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;

public class PaymentCardPanelPage extends HybrisUtil {

    private String btnUpdate = "//a[contains(.,'Update')]";
    private String btnConfirm = "//input[@value='Confirm']";
    private String btnSubmit = "//input[@value='SUBMIT']";
    private String txtCardNumber = "//span[@class='payment-form__val js-cardNumber']";
    private String txtFldCardNumber = "#CardNumber";
    private String txtFldName = "#CardHolderName";
    private String txtFldExpiryDate = "#ExpiryDate";
    private String txtFldCVV = "#CVV";
    private String txtFldSecret = "//input[@placeholder='Enter Code here']";

    public PaymentCardPanelPage(SyscoLabPW page) {
        super(page);
    }

    public String getCardNumberWithStars() {
        String card = "";
        try {
            page.getText(page.findByLocator(txtCardNumber));
            card = card.substring(card.length() - 4);

        } catch (Exception e) {
            return card;
        }
        return card;
    }

    public void clickUpdate(){
        page.click(btnUpdate);
    }

    public void enterCardNumber(String cardNumber){
        page.switchToChildFrame("",0);
        page.frameSendKeys(txtFldCardNumber,cardNumber);
    }

    public void enterName(String name){
        page.frameSendKeys(txtFldName, name);
    }

    public void enterExpiryDate(String expiryDate){
        page.frameSendKeys(txtFldExpiryDate, expiryDate);
    }

    public void enterCVV(String cvv){
        page.frameSendKeys(txtFldCVV, cvv);
    }

    public void clickConfirm(){
        page.frameClick(btnConfirm);
    }

    public void enterSecret(String secret){
        page.frameSendKeys(txtFldSecret, secret);
    }

    public void clickSubmit(){
        page.frameClick(btnSubmit);
    }

}

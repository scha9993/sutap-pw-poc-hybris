package com.sysco.brakes.qe.webui.page.orderConformation;

import com.sysco.brakes.qe.webui.util.HybrisUtil;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;
import org.python.antlr.ast.Continue;

public class OrderConformationPage extends HybrisUtil {

    private String btnContinue_Shopping = "//a[normalize-space()=,'Continue Shopping']";
    private String txtStockCheckMessage = "Please wait while we check our stock";
    private String txtOrderAmendedMessage = "Your order is being amended";

    public OrderConformationPage(SyscoLabPW page) {
        super(page);
    }

    public boolean isContinueCtaDisplayed(){
        return page.elemVisibility(page.findByLocator(btnContinue_Shopping));
    }

    public boolean isStockMessageDisplayed(){
        return page.elemVisibility(page.findByLocator(txtStockCheckMessage));
    }

    public boolean isOrderAmendedMessageDisplayed(){
        return page.elemVisibility(page.findByLocator(txtOrderAmendedMessage));
    }

    public void clickContinueShopping(){
        page.click(page.findByLocator(btnContinue_Shopping));
    }
}

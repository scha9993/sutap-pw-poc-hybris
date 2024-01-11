package com.sysco.brakes.qe.webui.page;

import com.sysco.brakes.qe.webui.util.HybrisUtil;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;

public class ProductDetailsPage extends HybrisUtil {

//    private String btnAdd = page.get_by_role("button", name="Add", exact=True);
//    private String btnReviewAmends = page.get_by_role("link", name="Review amends");
//    private String btnResubmit = page.get_by_role("button", name="Resubmit");
//    private String btnPlus = page.get_by_role("button", name="Add to cart");

    private String btnAdd = "//button[normalize-space()='Add']";
    private String txtFldQuantity = "//input[@aria-label='Quantity']";
    private String btnReviewAmends = "//a[.='Review amends']";
    private String btnResubmit = "//button[normalize-space()='Resubmit']";
    private String btnPlus = "";

    public ProductDetailsPage(SyscoLabPW page) {
        super(page);
    }

    public void enter_quantity(String quantity){
        page.clickFirst(txtFldQuantity);
        page.typeInto(page.findMultiElemNth(page.findByLocator(txtFldQuantity),0),quantity);
    }

    public void click_add_btn(){
        page.clickFirst(btnAdd);
    }

    public void click_btn_review_amends(){
        page.click(page.findByLocator(btnReviewAmends));
    }

    public void click_resubmit(){
        page.click(page.findByLocator(btnResubmit));
    }

    public void add_a_quantity_of_nth_product_to_cart(int index,int quantity){
        for (int i = 1; i <= quantity; i++) {
            page.clickMultiElemNth(page.findByLocator(btnPlus),index);
        }
        page.clickMultiElemNth(page.findByLocator(btnAdd),index);
    }

}

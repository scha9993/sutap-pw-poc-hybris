package com.sysco.brakes.qe.webui.page;

import com.sysco.brakes.qe.webui.util.HybrisUtil;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;

public class FavoritePage extends HybrisUtil {

    private String btnAddToCart = "Add list to basket";
    private String btnOk = "//div[@id=\"addWishlistToCartModal\"]//button[contains(@class, 'addWishlistToCart')]";


    public FavoritePage(SyscoLabPW page) {
        super(page);
    }

    public void clickFavoriteList(String favListName){
        page.click(page.findByText(favListName));
    }

    public void clickAddToCart(){
        page.clickFirst(page.findByText(btnAddToCart));
    }

    public void clickOk(){
        page.click(btnOk);
    }

}

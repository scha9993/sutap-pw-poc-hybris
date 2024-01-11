package com.sysco.brakes.qe.webui.function;

import com.sysco.brakes.qe.webui.page.FavoritePage;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;

public class Favorite{

    FavoritePage favoritePage;

    public Favorite(SyscoLabPW page) {
        favoritePage = new FavoritePage(page);
    }

    public void addFavoriteList(String favListName){
        favoritePage.clickFavoriteList(favListName);
        favoritePage.clickAddToCart();
        favoritePage.clickOk();
    }

}

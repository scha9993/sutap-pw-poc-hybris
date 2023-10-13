package com.sysco.brakes.qe.webui.function.productDetails;

import com.sysco.brakes.qe.webui.page.orderSummary.OrderSummaryPage;
import com.sysco.brakes.qe.webui.page.product.ProductPage;
import com.sysco.brakes.qe.webui.page.productDetails.ProductDetailsPage;
import com.syscolab.qe.core.playwright.ui.SyscoLabPW;
import org.python.modules.itertools.product;

import java.util.Random;

public class ProductDetails {

    ProductDetailsPage productDetailsPage;
    ProductPage productPage;

    public ProductDetails(SyscoLabPW page) {
        productDetailsPage = new ProductDetailsPage(page);
        productPage=new ProductPage(page);
    }

    public void selectSearched_Product(String productName){
        productPage.clickSearchedProduct(productName);
    }

    public void addQuantity(String quantity){
        productDetailsPage.enter_quantity(quantity);
        productDetailsPage.click_add_btn();
    }

    public void resubmit(){
        productDetailsPage.click_btn_review_amends();
        productDetailsPage.click_resubmit();
    }

    public void addNthProductToCart(int index,int quantity){
        productDetailsPage.add_a_quantity_of_nth_product_to_cart(index,quantity);
    }

    public void addMultipleProductsToCart(){
        Random random = new Random();
        for (int _ = 0; _ < 6; _++) {
            int x = random.nextInt(3) + 1;
            int y = random.nextInt(3) + 1;
            productDetailsPage.add_a_quantity_of_nth_product_to_cart(x,y);
        }
    }
}

package products;

import base.BaseTests;
import cart.CartTests;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ViewProductPage;


public class DetailedProductsTests extends BaseTests {
    ViewProductPage viewProductPage;
    SoftAssert softAssert = new SoftAssert();

    @Test
    @Parameters("index")
    public void testViewProductButton(@Optional("1") int index){
        viewProductPage = homePage.clickViewProduct(index);
        String url = viewProductPage.getURL();
        Assert.assertTrue(url.contains("product_details"),"Error Navigating to product page");
    }

    @Test(dependsOnMethods = "testViewProductButton")
    public void testAddToCartFromViewProductPage(){
        String itemTitle= viewProductPage.getItemTitle();
        String itemPrice = viewProductPage.getItemPrice();
        viewProductPage.setItemQuantity("3");
        viewProductPage.clickAddToCart();
        CartTests cartTests = new CartTests();
        cartTests.verifyAddToCart(itemTitle,itemPrice,"3");
    }

    @Test(dependsOnMethods = "testViewProductButton")
    public void testReviewProduct(){
        viewProductPage.enterReviewerName("alaa");
        viewProductPage.enterReviewerEmail("alaawahba@gmail.com");
        viewProductPage.enterReviewText("Good product");
        viewProductPage.clickSubmitReview();
        String message = viewProductPage.getSubmitMsg();
        softAssert.assertEquals(message,"Thank you for your review.","Error submitting review.");
    }
}

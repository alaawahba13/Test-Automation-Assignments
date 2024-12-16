package products;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC21_AddProductReview extends BaseTests {

    SoftAssert softAssert = new SoftAssert();

    @Test(priority = 1)
    public void viewProducts(){
        productsPage = homePage.clickProducts();
        String title = productsPage.getProductsTitle();
        Assert.assertEquals(title,"ALL PRODUCTS");

    }

    @Test(priority = 2)
    @Parameters("index")
    public void testViewProductButton(@Optional("1") int index){
        viewProductPage = homePage.clickViewProduct(index);
        String url = viewProductPage.getPageURL();
        Assert.assertTrue(url.contains("product_details"),"Error Navigating to product page");

    }
    @Test(dependsOnMethods = "testViewProductButton")
    public void testReviewProduct(){
        viewProductPage.scrollToItem("Write Your Review");
        viewProductPage.enterReviewerName("alaa");
        viewProductPage.enterReviewerEmail("alaawahba@gmail.com");
        viewProductPage.enterReviewText("Good product");
        viewProductPage.clickSubmitReview();
        String message = viewProductPage.getSubmitMsg();
        softAssert.assertEquals(message,"Thank you for your review.","Error submitting review.");
    }
}

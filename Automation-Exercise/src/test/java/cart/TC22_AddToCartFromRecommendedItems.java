package cart;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC22_AddToCartFromRecommendedItems extends BaseTests {
    @Test
    public void scrollToRecommendedItems(){
        homePage.scrollToItem("recommended items");
        Assert.assertEquals(homePage.getRecommendedTitle(),"RECOMMENDED ITEMS","Error scrolling");
    }
    @Test(dependsOnMethods = "scrollToRecommendedItems")
    public void addToCartFromRecommended(){
        String itemTitle = homePage.getRecommendedItemTitle(1);
        popUp =homePage.addRecommendedItemToCart(1);
        Assert.assertEquals(popUp.getPopUpTitle(),"Added!","Error adding to cart");
        cartPage = popUp.clickViewCartBtn();
        Assert.assertTrue(cartPage.getItemsTitle().contains(itemTitle),"Error Adding to cart");
    }
}

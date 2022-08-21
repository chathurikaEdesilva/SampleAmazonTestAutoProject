package org.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class AmazonTestShoppingCart_AddItem_ProceedToCheckOut extends BaseClass {
    @Test
    public void testLogin() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//to enable proper locating of clickable item
        homePage.loadSignInPage();
        loginPage.loginIn(testDataFileReader.getUserName(), testDataFileReader.getPassword());
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); //wait time added to overcome captcha manually
        Assert.assertEquals("Hello, " + testDataFileReader.getUserGivenName(), homePage.getLoggedInUser());
    }

    @Test(dependsOnMethods = {"testLogin"}, enabled = true)
    public void testSearchForItem() {
        homePage.searchItem(testDataFileReader.getSearchItem());
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        boolean status = homePage.checkFirstItemPresence();
        //Testng assert to check whether search results are present
        Assert.assertEquals(status, true);
    }

    @Test(dependsOnMethods = {"testSearchForItem"}, enabled = true)
    public void testClickingOnFirstItem() {
        homePage.clickOnFirstElementInList();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //Wait for product details page to load
        boolean status = productView.checkAddToCartButtonExistance();
        //Testng assert to check whether product view is open and add to cart button is visible
        Assert.assertEquals(status, true);
    }

    @Test(dependsOnMethods = {"testClickingOnFirstItem"}, enabled = true)
    public void testAddItemToCart() {
        productView.addToCart();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//Wait for product to be added to cart
        String text = addedToCartPage.getAddedToCartText();
        //Testng assert to check whether product is successfully added to cart
        Assert.assertEquals(text, "Added to Cart");
    }

    @Test(dependsOnMethods = {"testAddItemToCart"}, enabled = true)
    public void testProceedToCheckout() {
        addedToCartPage.proceedToCheckout();
        String text = selectPaymentPage.getSelectPaymentText();
        //Testng assert to check whether it's successfully navigated to Payment page
        Assert.assertEquals(text, "Select a payment method");
    }
}

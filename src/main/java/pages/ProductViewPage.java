/**
 * This class is the page object class for the product view page (this loads when a search item is clicked)
 * Following methods are there
 * checkAddToCartButtonExistance() - Check whether the add to cart button is visible
 * addToCart() - clicks the button and adds to cart
 */

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class ProductViewPage {

    WebDriver webDriver;

    public ProductViewPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    By addToCartBtn = By.id("add-to-cart-button");

    public boolean checkAddToCartButtonExistance() {
        boolean status = webDriver.findElement(addToCartBtn).isDisplayed();
        return status;
    }

    public void addToCart() {
        webDriver.findElement(addToCartBtn).click();

    }
}

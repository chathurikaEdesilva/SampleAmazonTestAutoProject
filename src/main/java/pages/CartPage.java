/**
 * This class is the page object class for the Cart
 * Following methods are available in this class
 * deleteCartItem() - delete an existing item
 */

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class CartPage {
    WebDriver webDriver;

    public CartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    By delete = By.xpath("//input[@data-action='delete']");

    public void deleteCartItem(){
        webDriver.findElement(delete).click();
    }
}

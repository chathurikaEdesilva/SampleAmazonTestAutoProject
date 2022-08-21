package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ProductViewPage {

    WebDriver webDriver;

    public ProductViewPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    By addToCartBtn = By.id("add-to-cart-button");
    //By popUp = By.xpath("//h4[@id='a-popover-header-3']");
    //By popUpClose = By.xpath("//button[@data-action='a-popover-close']");

    public boolean checkAddToCartButtonExistance() {
        boolean status = webDriver.findElement(addToCartBtn).isDisplayed();
        return status;
    }

    public void addToCart() {
        webDriver.findElement(addToCartBtn).click();

    }
}

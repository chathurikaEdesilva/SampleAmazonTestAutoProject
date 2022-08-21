package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class AddedToCartPage {
    WebDriver webDriver;

    public AddedToCartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    By proceedToCheckOut = By.xpath("//*[@id=\"sc-buy-box-ptc-button\"]/span/input");
    By addedToCartText = By.xpath("//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']");

    public String getAddedToCartText(){
        String text = webDriver.findElement(addedToCartText).getText();
        return text;
    }
    public void proceedToCheckout() {
        webDriver.findElement(proceedToCheckOut).click();
    }
}

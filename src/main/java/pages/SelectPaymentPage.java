package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

/**
 * This class is the page object class for the select payment page (appears when proceed to payment button is clicked)
 * Following method is there
 * getSelectPaymentText() - This will read the select payment text from the page
 */
public class SelectPaymentPage {
    WebDriver webDriver;

    public SelectPaymentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    By selectPaymentText = By.xpath("//h1[@class='a-spacing-base']");

    public String getSelectPaymentText() {
        String text = webDriver.findElement(selectPaymentText).getText();
        return text;
    }
}

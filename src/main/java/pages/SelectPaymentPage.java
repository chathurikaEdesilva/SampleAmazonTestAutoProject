package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

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

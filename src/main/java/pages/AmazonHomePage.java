package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class AmazonHomePage {

    WebDriver webDriver;

    public AmazonHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    By parentMenu = By.id("nav-link-accountList");
    By subMenuSignIn = By.id("nav-flyout-ya-signin");
    By search = By.id("twotabsearchtextbox");
    By findButton = By.id("nav-search-submit-button");
    By firstItemOnList = By.xpath("//img[@data-image-index='1']");
    By loggedInUser = By.xpath(" //span[@id='nav-link-accountList-nav-line-1']");


    public void loadSignInPage() {
        WebElement webElementMainMenu = webDriver.findElement(parentMenu);
        Actions action = new Actions(webDriver);
        action.moveToElement(webElementMainMenu);
        WebElement webElementSubMenu = webDriver.findElement(subMenuSignIn);
        action.moveToElement(webElementSubMenu);
        action.click().build().perform();
    }

    public String getLoggedInUser() {
        String text = webDriver.findElement(loggedInUser).getText();
        return text;
    }

    public boolean checkFirstItemPresence() {
        boolean status = webDriver.findElement(firstItemOnList).isDisplayed();
        return status;
    }

    public void searchItem(String item) {
        webDriver.findElement(search).sendKeys(item);
        webDriver.findElement(findButton).click();
    }

    public void clickOnFirstElementInList() {
        webDriver.findElement(firstItemOnList).click();
    }

}
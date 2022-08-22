/**
 * This class is the page object class for the Login page.
 * Following method is there
 * loginIn(String username, String password) - fills the username and password in the login flow and submits for sign in
 */

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LoginPage {
    WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    By email = By.id("ap_email");
    By contButton = By.id("continue");
    By passWord = By.id("ap_password");
    By signInButton = By.id("signInSubmit");

    public void loginIn(String username, String password) {
        webDriver.findElement(email).sendKeys(username);
        webDriver.findElement(contButton).click();
        webDriver.findElement(passWord).sendKeys(password);
        webDriver.findElement(signInButton).click();
    }
}

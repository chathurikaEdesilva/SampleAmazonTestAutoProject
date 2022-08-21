package org.test;

import dataProvider.ConfigFileReader;
import dataProvider.TestDataFileReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.*;
import setup.Driver;
import java.time.Duration;

public class BaseClass {
    public static WebDriver webDriver;
    ConfigFileReader configFileReader;
    TestDataFileReader testDataFileReader;
    Driver driver;
    AmazonHomePage homePage;
    LoginPage loginPage;
    ProductViewPage productView;
    AddedToCartPage addedToCartPage;
    SelectPaymentPage selectPaymentPage;
    CartPage cartPage;


    @BeforeTest
    public void startupTest() {
        configFileReader = new ConfigFileReader();
        testDataFileReader = new TestDataFileReader();
        driver = new Driver();
        System.setProperty(driver.getDriverProperty(), configFileReader.getDriverPath());
        this.webDriver = driver.getDriver();
        this.webDriver.get(configFileReader.getBaseURL());
        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        homePage = new AmazonHomePage(this.webDriver);
        loginPage = new LoginPage(this.webDriver);
        productView = new ProductViewPage(this.webDriver);
        addedToCartPage = new AddedToCartPage(this.webDriver);
        selectPaymentPage = new SelectPaymentPage(this.webDriver);
        cartPage = new CartPage(this.webDriver);
    }

    @AfterTest
    public void tearDown() {
        this.webDriver.get(testDataFileReader.getCartURL());
        this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        cartPage.deleteCartItem();
        this.webDriver.quit();
    }
}

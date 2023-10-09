package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;

public class lttCheck {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void driverInit() throws MalformedURLException{
        driver = Main.init(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void testLtt()  {
        while (true) {
            try {
                driver.get("https://ltt.rocks/login");
                visibilityOfElementLocated("//input [@id = 'username']").sendKeys("adminuser");
                visibilityOfElementLocated("//input [@id = 'password']").sendKeys("pass");
                visibilityOfElementLocated("//input [@type = 'submit']").click();

                Assert.assertTrue(visibilityOfElementLocated("//div [@id = 'linkList_wrapper']").isDisplayed());

                visibilityOfElementLocated("//button [contains (@class,  'user-area__menu-button')]").click();
                visibilityOfElementLocated("//a [@href = '/logout']").click();

                Assert.assertTrue(visibilityOfElementLocated("//input [@id = 'username']").isDisplayed());

                driver.manage().deleteAllCookies();
                driver.navigate().refresh();
            } catch (Exception ex) {
                String s = "";
            }
        }
    }

    private WebElement visibilityOfElementLocated(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
}

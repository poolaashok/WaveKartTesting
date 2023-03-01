package com.Wavecart.Auctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Actions{
    WebDriver driver;
    WebDriverWait wait;

    public Actions(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void click(By Expression) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Expression));
        driver.findElement(Expression).click();
    }

    public void waveMethodSendKeys(By Expression, String user) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Expression));
        driver.findElement(Expression).sendKeys(user);
    }

    public void dropDown(By expression, String value) {
        Select dropdown;
        dropdown = new Select(webElement(expression));
        dropdown.selectByVisibleText(value);
    }

    public WebElement webElement(By Expression) {
        return driver.findElement(Expression);
    }

    public void implicitlyWait() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void verifyElementText(By Expression, String expectedText) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Expression));
        String actualAddressText = driver.findElement(Expression).getText();
        Assert.assertEquals(actualAddressText, expectedText);
        System.out.println(expectedText);
    }
}

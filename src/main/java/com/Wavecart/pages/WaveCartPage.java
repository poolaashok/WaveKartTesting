package com.Wavecart.pages;


import com.Wavecart.Auctions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Wavecartlocators.Locators.*;


public class WaveCartPage{
    WebDriver driver;
    Actions action;

    public WaveCartPage(WebDriver driver){
        this.driver = driver;
        this.action = new Actions(driver, new WebDriverWait(driver, Duration.ofSeconds(50)));
    }

    public void addToCart(String productName, Integer noOfItems){
        action.implicitlyWait();
        action.click(By.xpath(String.format(label, productName)));
        action.verifyElementText(By.xpath(String.format(LABEL_WITH_NAME, "lbl_Available")),available);
        action.verifyElementText(By.xpath(String.format(LABEL_WITH_NAME, "Name")), productName);
        action.click(By.xpath(String.format(submitButton, "ADD TO CART")));
        action.waveMethodSendKeys(By.xpath(String.format(userNameInput, "j_username")), "user");
        action.waveMethodSendKeys(By.xpath(String.format(userNameInput, "j_password")), "user");
        action.click(By.xpath(String.format(submitButton, "Sign in")));
        action.verifyElementText(By.xpath(String.format(LABEL_WITH_NAME, "Name")), productName);
        action.dropDown(By.xpath("//select[@name='select_Qty']"), String.valueOf(noOfItems));
    }

    public void placeOrder(String productName, Integer noOfItems, Integer price,String Quantity) {
        action.click(By.xpath(String.format(submitButton, "Place Order")));
        action.click(By.xpath(String.format(orderContinue, "nextBtn_wizard_payment")));
        action.verifyElementText(By.xpath(String.format(Address)), "Mid Town 6-3-348, Road No. 1, Banjara Hills Icon");
        action.click(By.xpath(String.format(orderContinue, "nextBtn_wizard_payment")));
        action.click(By.xpath(String.format(orderContinue, "nextBtn_wizard_payment")));
        action.verifyElementText(By.xpath(String.format(label, "Mid Town 6-3-348, Road No. 1, Banjara Hills,Hyderabad,")), "Mid Town 6-3-348, Road No. 1, Banjara Hills,Hyderabad,");
        action.click(By.xpath(String.format(orderContinue, "doneBtn_wizard_payment")));
        action.verifyElementText(By.xpath(String.format(label, "Cash On Delivery(COD)")), COD);
        int finalAmount = noOfItems * price;
        action.verifyElementText(By.xpath(String.format(LABEL_WITH_NAME, "TotalAmount")), String.valueOf(finalAmount));
        action.verifyElementText(By.xpath(String.format(LABEL_WITH_NAME,"lbl_Qty")),Quantity);
        action.verifyElementText(By.xpath(String.format(LABEL_WITH_NAME, "productName")), productName);
        action.verifyElementText(By.xpath(String.format(orderStatus)), ordered);
    }
    public void canCelOrder() {
        action.click(By.xpath(String.format(signButton, "cancel order")));
        action.click(By.xpath(String.format(submitButton, "Submit button")));
        action.click(By.xpath(String.format(signButton, "continue shopping")));
        action.click(By.xpath(logOut));
    }
}


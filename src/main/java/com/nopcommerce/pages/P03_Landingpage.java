package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_Landingpage {
    WebDriver driver;

    // Constructor
    public P03_Landingpage(WebDriver driver) {
        this.driver = driver;
    }

    // Elements
    By section = By.cssSelector("[class=\"content-heading\"]");
    By price = By.cssSelector("[class=\"price\"]");

    public void goToSection() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(section));
    }

    public List<WebElement> getPrice(){
        return driver.findElements(price);
    }

    public boolean checkPrice(){
        boolean condition = false;
        for (int i = 1; i < getPrice().size(); i++){
            String priceText = getPrice().get(i).getText();
            System.out.println(priceText);
            condition = priceText.contains("$") && priceText.contains(".");
        }
        return condition;
    }
}

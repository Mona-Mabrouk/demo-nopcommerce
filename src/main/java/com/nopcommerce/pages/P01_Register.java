package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P01_Register {
        WebDriver driver;

        // Constructor
        public P01_Register(WebDriver driver){
            this.driver = driver;
        }

        // Elements
        By createAnAccountButton = By.xpath("(//a[@href=\"https://magento.softwaretestingboard.com/customer/account/create/\"])[1]");
        By firstName = By.id("firstname");
        By lastName = By.id("lastname");
        By emailLocator = By.id("email_address");
        By passwordLocator = By.id("password");
        By submitButton = By.cssSelector("button[title='Create an Account']");

        By confirmPasswordLocator = By.id("password-confirmation");


        // Actions
        public void CreateAnAccount() {
            driver.findElement(createAnAccountButton).click();
        }

        public void sendFirstName(String firstname) {
            driver.findElement(firstName).sendKeys(firstname);
        }

        public void sendLastName(String lastname) {
        driver.findElement(lastName).sendKeys(lastname);
        }

        public void sendEmail(String email) {
        driver.findElement(emailLocator).sendKeys(email);
        }

        public void sendPassword (String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        }

        public void submit() {
        driver.findElement(submitButton).click();
        }

        public String getCurrentURL(){
            return driver.getCurrentUrl();
        }

        public WebElement getErrorMessage1(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password-confirmation-error")));
        }

        public void sendConfirmPassword (String confirmPassword) {
                driver.findElement(confirmPasswordLocator).sendKeys(confirmPassword);
        }

        public WebElement getErrorMessage2(){
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password-confirmation-error")));
        }
}

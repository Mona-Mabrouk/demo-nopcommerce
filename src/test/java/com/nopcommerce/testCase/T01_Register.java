package com.nopcommerce.testCase;

import com.aventstack.extentreports.Status;
import com.nopcommerce.base.BaseTest;
import com.nopcommerce.pages.P01_Register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class T01_Register extends BaseTest {

    SoftAssert softAssert;

    @Test
    public void testCase01 (){
        P01_Register register = new P01_Register(driver);
        softAssert = new SoftAssert();
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, "Register");
        test.log(Status.INFO, "starting");
        test.assignCategory("P0");


        register.CreateAnAccount();
        register.sendFirstName("Mona");
        register.sendLastName("Mabrouk");
        register.sendEmail("test_123@gmail.com");
        register.sendPassword("Admin@123");
        register.submit();
        softAssert.assertEquals(register.getCurrentURL(),"https://magento.softwaretestingboard.com/customer/account/create/");
        softAssert.assertEquals(register.getErrorMessage1().getText(),"This is a required field.");
        softAssert.assertAll();
    }

    @Test
    public void testCase02 (){
        P01_Register register = new P01_Register(driver);
        softAssert = new SoftAssert();
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, "Register");
        test.log(Status.INFO, "starting");
        test.assignCategory("P0");

        register.CreateAnAccount();
        register.sendFirstName("Mona");
        register.sendLastName("Mabrouk");
        register.sendEmail("test_123@gmail.com");
        register.sendPassword("Admin@123");
        register.sendConfirmPassword("Admin@456");
        register.submit();
        softAssert.assertEquals(register.getCurrentURL(),"https://magento.softwaretestingboard.com/customer/account/create/");
        softAssert.assertEquals(register.getErrorMessage2().getText(),"Please enter the same value again.");
        softAssert.assertAll();
    }

}

package com.nopcommerce.testCase;

import com.aventstack.extentreports.Status;
import com.nopcommerce.base.BaseTest;
import com.nopcommerce.pages.P01_Register;
import com.nopcommerce.pages.P03_Landingpage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class T03_LandingPage extends BaseTest {

    SoftAssert softAssert;

    @Test
    public void testCase01() {
        P03_Landingpage landing = new P03_Landingpage(driver);
        softAssert = new SoftAssert();
        landing.goToSection();
        landing.getPrice();
        Assert.assertTrue(landing.checkPrice());




    }
}

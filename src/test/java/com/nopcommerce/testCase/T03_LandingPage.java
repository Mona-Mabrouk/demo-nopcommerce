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

        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, "landing");
        test.log(Status.INFO, "starting");
        test.assignCategory("P0");


        landing.goToSection();
//        landing.getPrice();
        softAssert.assertTrue(landing.checkPrice());

        softAssert.assertAll();


    }
}

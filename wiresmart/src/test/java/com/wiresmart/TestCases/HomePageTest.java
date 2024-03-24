package com.wiresmart.TestCases;

import com.wiresmart.Pages.BaseTest;
import com.wiresmart.Pages.HomePage;
import com.wiresmart.Pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initializeDriver();
        loginPage = new LoginPage();
        homePage = new HomePage();
        homePage=loginPage.enterCredentials();


    }

    @Test
    public void homePageTitleTest(){
        homePage.verifyHomePageTitle();

    }

    @Test
    public void clickOnHamburgerTest() throws Exception {

        System.out.println("Came Inside Test of Home Page :) ");

        homePage.clickOnHamburger();
        homePage.clickOnCrossIcon();

    }

    @Test
    public void selectDropDownvalueTest() throws InterruptedException {
        homePage.selectDropDownvalue();
        Thread.sleep(1000);

    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

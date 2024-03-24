package com.wiresmart.TestCases;

import com.wiresmart.Pages.BaseTest;
import com.wiresmart.Pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    public LoginPage loginPage ;
        //= new LoginPage();


    @BeforeMethod
    public void setUp() throws InterruptedException {
       /* log = LogManager.getLogger(this.getClass().toString());

        log.info("Initializing browser");

        String PT = Login.LoginPageTitle();
        log.info("Verifying the Title");
        System.out.println("PT is " + PT);
        System.out.println("Hi");*/
        BaseTest.initializeDriver();
        loginPage = new LoginPage();
        // homepage= new HomePage();
       // homepage = loginPage.enterCredentials();

    }


    @Test(priority = 2)
    public void loginPageTest() throws InterruptedException {

        loginPage.enterCredentials();
    }

    @Test(priority = 1)
    public void verifyLoginPageTitleTest(){

        String loginTitle=loginPage.LoginPageTitle();
        Assert.assertEquals(loginTitle,"Swag Labs");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

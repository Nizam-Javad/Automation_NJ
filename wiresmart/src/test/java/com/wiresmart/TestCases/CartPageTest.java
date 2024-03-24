package com.wiresmart.TestCases;

import com.wiresmart.Pages.BaseTest;
import com.wiresmart.Pages.CartPage;
import com.wiresmart.Pages.HomePage;
import com.wiresmart.Pages.LoginPage;
import org.testng.annotations.*;

public class CartPageTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;
    @BeforeMethod
    public void setUp() throws InterruptedException {

        initializeDriver();
        loginPage= new LoginPage();
        homePage = new HomePage();
        cartPage= new CartPage();
        homePage=loginPage.enterCredentials();
        Thread.sleep(1000);
        homePage.clickOnAddToCart();
        Thread.sleep(1000);
        cartPage=homePage.verifyItemsAddedToCart();

    }

    @Test
    public void verifyPageTitleTest(){
        cartPage.verifyPageTitle();
    }

    @Test
    public void clickingOnCOntinueShoppingTest() throws InterruptedException {
        Thread.sleep(1000);
        cartPage.clickingOnCOntinueShopping();
        Thread.sleep(1000);
    }

    @Test
    public void clickingOnCheckoutTest() throws InterruptedException {
        Thread.sleep(1000);

        cartPage.clickingOnCheckout();
        Thread.sleep(1000);
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}

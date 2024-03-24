package com.wiresmart.Pages;

import com.wiresmart.utilities.TestUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends BaseTest {
    @FindBy(xpath = "//div[@class='app_logo' and text()='Swag Labs']")
    WebElement homePageTitle;

    @FindBy(xpath = "//div[@class='inventory_item_name ' and text()='Sauce Labs Backpack']")
    WebElement homePageItem;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement shoppingCartLink;

    @FindBy(xpath = "//span[@class='title' and text()='Products']")
    WebElement pageTitle;
    @FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
    WebElement addToCartBackPack;

    @FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
    WebElement addToCartFleeceJacket;


    @FindBy(xpath="//div[@class='bm-burger-button']")
    WebElement hamburger;

    @FindBy(xpath="//button[@id='react-burger-cross-btn']")
    WebElement crossIcon;

    @FindBy(xpath="//select[@class='product_sort_container']")
    WebElement nameDropDown;

    @FindBy(xpath="//button[@class='btn btn_primary btn_small btn_inventory '][@name='add-to-cart-sauce-labs-backpack']")
    WebElement saucaLabsBackpackAddToCartBtn;


    public HomePage() {

        PageFactory.initElements(driver, this);
    }

   public void verifyHomePageTitle(){
        String homePageTitle=driver.getTitle();
       Assert.assertEquals(homePageTitle,"Swag Labs");
   }

    public void clickOnAddToCart() {

        //return pageTitle.isDisplayed();
        addToCartFleeceJacket.click();
        addToCartBackPack.click();

    }

    public CartPage verifyItemsAddedToCart(){

        shoppingCartLink.click();
        return new CartPage();


    }
    public void clickOnHamburger() throws InterruptedException {
        System.out.println("Came Inside Hamburger");

        hamburger.click();
        Thread.sleep(1000);

    }
    public void clickOnCrossIcon() throws InterruptedException {
        TestUtils.clickElement(crossIcon);
        Thread.sleep(1000);
    }

    public void selectDropDownvalue(){
        TestUtils.selectDropDownValue("hilo",nameDropDown);
        //Select select = new Select(nameDropDown);
        //select.selectByValue("hilo");
        //select.selectByIndex(2);
    }



}

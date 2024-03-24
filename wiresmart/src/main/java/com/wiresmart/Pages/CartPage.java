package com.wiresmart.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import static com.wiresmart.Pages.BaseTest.driver;

public class CartPage {

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//button[@id='checkout']")
    WebElement checkOutBtn;


    @FindBy(xpath="//button[@id='continue-shopping']")
    WebElement continueShoppingbtn;

    @FindBy(xpath = "//div[@class='cart_list']/div[@class='cart_item']")
    WebElement itemsAddedtoCart;

    @FindBy(xpath="//span[@class='title']")
    WebElement cartPageTitle;

    public void verifyPageTitle(){
        String pageTItle=driver.getTitle();
        Assert.assertEquals(pageTItle,"Swag Labs");
    }

    public void clickingOnCOntinueShopping(){
        continueShoppingbtn.click();
    }


    public void clickingOnCheckout(){
        checkOutBtn.click();
    }
}

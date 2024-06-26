package com.wiresmart.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.*;




public class LoginPage extends BaseTest {

   // LoginPage loginPage= new LoginPage();

    @FindBy(xpath = "//div[@class='login_logo' and text()='Swag Labs']")
    WebElement pageTitle;

    @FindBy(xpath = "//input[@id='user-name']")
    WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }




    public HomePage enterCredentials() {
        userName.sendKeys(properties.getProperty("username"));
        password.sendKeys(properties.getProperty("password"));
        // userName.sendKeys("standard_user");

        // password.sendKeys("secret_sauce");
        loginBtn.click();
        return new HomePage();

    }



    public  String LoginPageTitle(){
        return driver.getTitle();
    }



}

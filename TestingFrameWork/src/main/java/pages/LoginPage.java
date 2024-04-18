package pages;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath="//input[@name='username']")
    WebElement userName;

    @FindBy(xpath="//input[@name='password']")
    WebElement password;

    @FindBy(xpath="//button[@type='submit']")
    WebElement loginBtn;



    @FindBy(xpath="//p[@class='oxd-userdropdown-name' ]")
    WebElement user;

    public LoginPage(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    public void loginToHomePage(String username,String passWord) throws InterruptedException {
        userName.sendKeys(username);
        password.sendKeys(passWord);
        Thread.sleep(2000);
        loginBtn.click();
        Thread.sleep(2000);
    }

    public boolean verifyLoginIsSuccessful(){
        return user.isDisplayed();
    }
}

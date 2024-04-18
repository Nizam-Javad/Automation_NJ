package tests;

import dataprovider.LoginDP;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest1 extends BaseTest {
    LoginPage loginPage;

    @Test(dataProvider ="loginDP",dataProviderClass = LoginDP.class,priority = 2)
    public void login(String username,String passWord) throws InterruptedException {
        loginPage= new LoginPage();
        loginPage.loginToHomePage(username,passWord);
        Assert.assertTrue(loginPage.verifyLoginIsSuccessful());
    }
    @Test(priority = 1,enabled = false)
    public void verifyLoginPage(){
        loginPage=new LoginPage();
       // loginPage.verifyLoginPageHeader();
    }
}

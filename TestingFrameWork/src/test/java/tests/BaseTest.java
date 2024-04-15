package tests;

import driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public  class BaseTest {

    @BeforeMethod
    public void setUp(){
        Driver.initDriver();
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("This came inside After Method");
        Driver.quitDriver();
    }

}

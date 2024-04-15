package tests;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void test1(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("WWE",Keys.ENTER);

    }
    @Test
    public void test2(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("F1 Racing",Keys.ENTER);

    }
    @Test
    public void test3(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Cricket",Keys.ENTER);

    }
}

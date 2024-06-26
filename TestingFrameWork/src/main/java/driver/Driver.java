package driver;


import constants.FrameworkConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Objects;

public final class Driver{
    public static WebDriver driver;
    private Driver(){}

    public static void initDriver(){

        if(Objects.isNull(DriverManager.getDriver())){

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            DriverManager.setDriver(driver);
            DriverManager.getDriver().get(FrameworkConstants.getUrl());
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.getExplicitWait()));
        }

    }


public static void quitDriver() {
   if (Objects.nonNull(DriverManager.getDriver())) {
       System.out.println("This came inside Quit Driver  Method of Driver class");
       DriverManager.getDriver().quit();
       DriverManager.unload();
       //DriverManager.setDriver();
   }
}

}

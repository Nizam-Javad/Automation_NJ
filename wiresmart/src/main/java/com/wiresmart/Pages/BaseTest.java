package com.wiresmart.Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public static Properties properties = new Properties();
    ;
    public static WebDriver driver;

    private static Logger logger;

    public BaseTest() {
        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\Users\\MNR\\MNJ\\Mar\\Automation_NJ\\Automation_Test\\wiresmart\\src\\main\\java\\com\\wiresmart\\resources\\config.properties");
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger= LogManager.getLogger("com.wiresmart.Pages.BaseTest");
    }

    public static void initializeDriver() throws InterruptedException {
        // String browser = "chrome";
        // log = LogManager.getLogger(log.getClass().toString());
        // log.info("Getting the browser from the Config File");
        logger.info("Getting the browser from the Config File");
        String browser = properties.getProperty("browser");
        // logger.info("Initializing the browser" + browser);
        // log.info("Initialiing the browser"+browser);

        logger.info("Switching the Brwoser");
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        logger.info("Launching the URL");
        driver.get(properties.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }
}

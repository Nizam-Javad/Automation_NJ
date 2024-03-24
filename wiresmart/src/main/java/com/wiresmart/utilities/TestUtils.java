package com.wiresmart.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static com.wiresmart.Pages.BaseTest.driver;

public class TestUtils {


    static int smallWait = 5;

    static int longWait = 20;

    public void switchToFrame() {
        driver.switchTo().frame("");
    }

    public static String CaptureScreenshot(WebDriver driver) throws IOException {
        String FileSeparator = System.getProperty("file.separator");
        String Extent_report_path = "." + FileSeparator + "Reports";
        String ScreenshotPath = Extent_report_path + FileSeparator + "screenshots";

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotName = "screenshot" + Math.random() + ".png";
        String screenshotpath = ScreenshotPath + FileSeparator + screenshotName;

        FileUtils.copyFile(src, new File(screenshotpath));
        return "." + FileSeparator + "screenshots" + FileSeparator + screenshotName;

    }

    public static void shortImplicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(smallWait));
        ;
    }

    public static void longImplicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longWait));
        ;
    }

    public static void selectDropDownValue(String dropdown, WebElement element){
        Select select = new Select(element);
        select.selectByValue(dropdown);

    }

    public static void clickElement(WebElement element){
        element.click();

    }
}

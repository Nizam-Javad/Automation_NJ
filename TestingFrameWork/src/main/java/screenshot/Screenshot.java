package screenshot;

import driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshot {
    private Screenshot(){}

    public static String getScreenshot64(){
         String ss=((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64).toString();
         return ss;
    }
}

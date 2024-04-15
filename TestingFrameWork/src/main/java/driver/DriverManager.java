package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public final class DriverManager {
    static WebDriver driver;
    private DriverManager(){}
    private  static ThreadLocal<WebDriver> dr = new ThreadLocal<>();
    public static WebDriver getDriver(){
        return dr.get();
        //return null;
    }
    public static void setDriver(WebDriver driverRef){
        dr.set(driverRef);
        //return null;
    }
    public static void unload(){
        System.out.println("This came inside unload Method");
        dr.remove();
        //return null;
    }



}

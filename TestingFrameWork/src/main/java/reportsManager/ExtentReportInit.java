package reportsManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ExtentReportInit {
public static ExtentReports extentReports;
public static ExtentSparkReporter sparkReporter;
    public static void initializeExtentReports() throws IOException {
        extentReports = new ExtentReports();

        sparkReporter=new ExtentSparkReporter("C:\\Users\\DELL\\TestingFramework1\\Automation_NJ\\TestingFrameWork\\src\\reports\\index.html");
        File conf=new File("C:\\Users\\DELL\\TestingFramework1\\Automation_NJ\\TestingFrameWork\\src\\reports\\extentreportjsonconfig.json");
        sparkReporter.loadJSONConfig(conf);
        extentReports.attachReporter(sparkReporter);
    }

    public static void flushExtentReports(){
        extentReports.flush();
        try {
            Desktop.getDesktop().browse(new File("C:\\Users\\DELL\\TestingFramework1\\Automation_NJ\\TestingFrameWork\\src\\reports\\index.html").toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createExtentReportNode(String testCaseName){
        ExtentManager.setExtentTest(extentReports.createTest(testCaseName));

    }

//    public static void createExtentReportNode(String methodName) {
//    }
}

package Listeners;

import org.testng.*;
import reportsManager.ExtentLogger;
import reportsManager.ExtentReportInit;
import screenshot.Screenshot;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;

public class ListenerClass implements ISuiteListener, ITestListener {
    @Override
    public void onStart(ISuite suite) {
        try {
            ExtentReportInit.initializeExtentReports();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReportInit.flushExtentReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        //ExtentLogger.owner(result.getName());
        ExtentReportInit.createExtentReportNode(result.getMethod().getMethodName());
        ExtentLogger.info(Screenshot.getScreenshot64());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass("This Method is passed : "+result.getMethod().getMethodName());
        String encodedString = Base64.getEncoder().encodeToString(Screenshot.getScreenshot64().getBytes());
        System.out.println("Encoded String of " + Screenshot.getScreenshot64() + " is " + encodedString);

        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        System.out.println("Decoded String of " + encodedString + " is " + decodedString);
        ExtentLogger.info(decodedString);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail("This Method is Failed : "+result.getMethod().getMethodName());
        ExtentLogger.info(Screenshot.getScreenshot64());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip("This Method is Skipped : "+result.getMethod().getMethodName());
        ExtentLogger.info(Screenshot.getScreenshot64());

    }


}

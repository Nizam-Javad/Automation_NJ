package reportsManager;

public class ExtentLogger {
    private ExtentLogger(){}

    public static void pass(String message){
        ExtentManager.getExtentTest().pass(message);
    }
    public static void fail(String message){
        ExtentManager.getExtentTest().fail(message);
    }
    public static void skip(String message){
        ExtentManager.getExtentTest().skip(message);
    }

    public static void owner(String author){
        ExtentManager.getExtentTest().assignAuthor(author);
    }

    public static void info(String message){
        ExtentManager.getExtentTest().info(message);
    }

}

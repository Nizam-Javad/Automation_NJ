package constants;

public final class FrameworkConstants {
    private FrameworkConstants(){}

    private static final int explicitWait =10;

    private static final String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    public static String getReferencePath() {
        return referencePath;
    }

    public static String getUrl() {
        return url;
    }

    private static String referencePath="C:\\Users\\DELL\\TestingFramework1\\Automation_NJ\\TestingFrameWork\\";



    public static int getExplicitWait(){
        return explicitWait;
    }
}

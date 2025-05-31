package actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserActions
{
    private static WebDriver driver ;
    public static void initializeTheWebDriver (String browser)
    {
        try {
            if (browser==null || browser.isEmpty()){
                throw new IllegalArgumentException("Browser name can not be Null or Empty");
            }
            //IllegalArgumentException is thrown when an argument passed to a method is invalid
            //when the browser name is invalid (either null or an empty string).
            switch (browser.toLowerCase()){
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new UnsupportedOperationException("Un Supported Browser" + browser);
            }
        }catch (Exception e){
            System.out.println("Error while initializing WebDriver" + e.getMessage());
        }
    }


    public static WebDriver getDriver(){
        return driver;
    }
    public static void openUrl(String url){
        driver.get(url);
    }
    public static void maximizeWindow(){
        driver.manage().window().maximize();
    }
    public static void quitBrowser(){
        driver.quit();
    }

}

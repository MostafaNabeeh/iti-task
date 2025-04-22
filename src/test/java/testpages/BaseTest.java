package testpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BaseTest
{
    public WebDriver driver;

    @BeforeClass
    public void start()
    {
         driver = new ChromeDriver();
         driver.navigate().to("https://www.levelset.com/");
    }

    @BeforeClass
    public void teardown()
    {
        if (driver != null)
        {
            driver.quit();
        }
    }

}

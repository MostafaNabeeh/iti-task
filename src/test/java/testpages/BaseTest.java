package testpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

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
   public void teardown(){driver.quit();}
}

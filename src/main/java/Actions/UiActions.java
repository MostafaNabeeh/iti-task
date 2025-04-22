package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class UiActions
{
    public static WebDriver driver = new ChromeDriver();

    public boolean validatePageIsLoaded(By element)
    {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(element));
            return true;

        } catch (Exception e) {
            System.out.println("Page load failed: "+ e.getMessage());
        }
        return false;
    }
}

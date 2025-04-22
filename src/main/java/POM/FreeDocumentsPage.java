package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class FreeDocumentsPage
{
    WebDriver driver;
    WebDriverWait wait;

    public FreeDocumentsPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    String TextValue2 = "Free";
    String DynamicXpath2 = "//span[contains(text(),\"" + TextValue2 + "\")]";

    //Post_Validation
    public boolean validateFreeElementsCount(int ExpectedCount)
    {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DynamicXpath2)));
            List<WebElement> FreeElements = driver.findElements(By.xpath(DynamicXpath2));

            for (WebElement element:FreeElements)
            {
                System.out.println("Free Element text: " + element.getText());
            }
            if (FreeElements.size()==ExpectedCount)
            {
                System.out.println("Expected: " + ExpectedCount + ", Actual: " + FreeElements.size());
                return true;
            }else {
                System.out.println("Number Of Free Elements is not 2");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error while validating Free Elements count: "+e.getMessage());
            return false;
        }
    }



}

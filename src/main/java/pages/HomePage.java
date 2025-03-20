package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage
{

    WebDriver driver;
    WebDriverWait wait;
    public HomePage(WebDriver driver){
        this.driver = driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));;
    }

    //1-Write TestCase to make sure the count of free documents are 2 and validate their text

    String TestValue = "Get paid ";
    String DynamicXpath= "//a[text()='"+TestValue+"']";

    String TextValue2 = "Free";
    String DynamicXpath2 = "//span[contains(text(),\"" + TextValue2 + "\")]";


    //Pre-Validation
    public boolean validateHomePageIsLoaded()
    {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DynamicXpath)));
            return true;

        } catch (Exception e) {
            System.out.println("Home Page load failed: "+ e.getMessage());
        }
        return false;
    }

    public void ClickOnGetPaidBTN()
    {
        WebElement getPaidElement  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DynamicXpath)));
        Actions actions = new Actions(driver);
        actions.doubleClick(getPaidElement).perform();
    }

    //Post_Validation
    public boolean validateFreeElementsCount()
    {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DynamicXpath2)));
            List<WebElement> FreeElements = driver.findElements(By.xpath(DynamicXpath2));
            for (WebElement element:FreeElements)
            {
                System.out.println("Free Element text: " + element.getText());
            }
            if (FreeElements.size()==2)
            {
                System.out.println("Number Of Free Elements is 2");
                return true;
            }else {
                System.out.println("Number Of Free Elements is 2");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error while validating Free Elements count: "+e.getMessage());
            return false;
        }
    }

 /*  WebElement Element = driver.findElement(By.xpath(DynamicXpath));
     WebElement Element3 = driver.findElement(By.xpath(String.format("//a[text()='%s']",TestValue)));
     WebElement Element2 = driver.findElement(By.xpath(DynamicXpath2));
     span[text()='Free']/ancestor::div[@class="panel-heading left-right-pair"]//div[@class="left"]
     */

    //2-Test Case to get documents with price from 30 to 60$ validate count and document name
    String priceRange  = "//span[contains(@class,'price-amount') and " + "number(translate(text(),'$','')) >= %d and " +
                    "number(translate(text(),'$','')) <= %d]" + "/ancestor::div[@class='panel-heading left-right-pair']//div[@class='left']";

    public boolean validateDocumentsInPriceRange(int minPrice, int maxPrice) {
        try {
            String priceRangeXpath = String.format(priceRange, minPrice, maxPrice);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(priceRangeXpath)));
            List<WebElement> Range = driver.findElements(By.xpath(priceRangeXpath));

            for (WebElement element : Range) {
                System.out.println("Document in range: " + element.getText());
            }

            if (Range.size() > 0) {
                System.out.println("Documents found in price range $" + minPrice + " - $" + maxPrice);
                return true;
            } else {
                System.out.println("No documents found in the price range.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error validating documents in price range: " + e.getMessage());
            return false;
        }
    }

    //span[contains(@class,'price-amount') and contains(text(),'$')]/ancestor::div[@class="panel-heading left-right-pair"]//div[@class="left"]

}

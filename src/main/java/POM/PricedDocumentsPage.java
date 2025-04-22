package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

//2-Test Case to get documents with price from 30 to 60$ validate count and document name

public class PricedDocumentsPage
{
    WebDriver driver;
    WebDriverWait wait;

    public PricedDocumentsPage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    String priceRange  = "//span[contains(@class,'price-amount') and " + "number(translate(text(),'$','')) >= %d and " +
            "number(translate(text(),'$','')) <= %d]" + "/ancestor::div[@class='panel-heading left-right-pair']//div[@class='left']";

    public boolean validateDocumentsInPriceRange(int minPrice, int maxPrice)
    {
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

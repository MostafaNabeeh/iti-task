package POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Actions.UiActions;

import static Actions.UiActions.driver;


public class HomePage
{
    String TestValue = "Get paid ";
    String DynamicXpath= "//a[text()='"+TestValue+"']";
    UiActions fd  = new UiActions();

    public boolean navigationtohome()
    {
        return fd.validatePageIsLoaded(By.xpath(DynamicXpath));
    }


//    WebDriver driver;
//    WebDriverWait wait;
//    public HomePage(WebDriver driver)
//    {
//        this.driver = driver;
//       this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//    }

    //1-Write TestCase to make sure the count of free documents are 2 and validate their text


    //Pre-Validation
//    public boolean validateHomePageIsLoaded()
//    {
//        try {
//           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DynamicXpath)));
//            return true;
//
//        } catch (Exception e) {
//            System.out.println("Home Page load failed: "+ e.getMessage());
//        }
//        return false;
//    }

    public void ClickOnGetPaidBTN()
    {
        WebElement getPaidElement  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DynamicXpath)));
        Actions actions = new Actions(driver);
        actions.doubleClick(getPaidElement).perform();
    }


 /*  WebElement Element = driver.findElement(By.xpath(DynamicXpath));
     WebElement Element3 = driver.findElement(By.xpath(String.format("//a[text()='%s']",TestValue)));
     WebElement Element2 = driver.findElement(By.xpath(DynamicXpath2));
     span[text()='Free']/ancestor::div[@class="panel-heading left-right-pair"]//div[@class="left"]
     */

}

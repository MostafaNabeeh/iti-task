package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementActions
{
    protected final WebDriver driver;
    private final WebDriverWait wait;

    public ElementActions (WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    // Make Assertion By Visibility oF Element
    public ElementActions assertByVisibility(By Locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
            if (element == null || !element.isDisplayed()) {
                throw new AssertionError("Element located by " + Locator.toString() + " is not displayed.");
            }
        } catch (Exception e) {
            throw new AssertionError("Error while checking visibility of element located by " + Locator.toString(), e);
        }
        return this;
    }

    public ElementActions typeText(By Locator , String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locator)).sendKeys(text);
        return this;
    }

    public ElementActions clickElement(By Locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locator)).click();
        return this;
    }

    //Verifying Page Navigation
    public ElementActions assertCurrentUrlWhenMoveFromPageToAnotherPage(String ExpectedUrl){
       String CurrentUrl =  driver.getCurrentUrl();
       if(!CurrentUrl.equals(ExpectedUrl)){
           throw new AssertionError("Expected URL: " + ExpectedUrl + " but found: " + CurrentUrl);
       }
       return this;
    }

     /*
     public ElementActions assertByVisibility(By locator) {
        if (!wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed()) {
            throw new AssertionError("Element not visible: " + locator.toString());
        }
        return this;
    }
    */








}

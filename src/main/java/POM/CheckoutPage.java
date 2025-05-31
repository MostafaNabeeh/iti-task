package pom;

import actions.ElementActions;
import org.openqa.selenium.By;

public class CheckoutPage
{
    protected final ElementActions elementActions;
    public CheckoutPage(ElementActions elementActions){
        this.elementActions=elementActions;
    }

    private final By yourInformation = By.xpath("//*[text()=\"Checkout: Your Information\"]");
    private final By FirstName       = By.id("first-name");
    private final By LastName        = By.id("last-name");
    private final By PostalCode      = By.id("postal-code");
    private final By continueBTN     = By.xpath("//input[@type='submit']");

    public By getInfoText(){return yourInformation;}
    public By getFirstName(){return FirstName;}
    public By getLastName(){return LastName;}
    public By getPostalCode(){return PostalCode;}
    public By getContinueButton(){return continueBTN;}

}

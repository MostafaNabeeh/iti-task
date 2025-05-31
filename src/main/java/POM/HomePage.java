package pom;

import actions.ElementActions;
import org.openqa.selenium.By;

public class HomePage
{
    protected final ElementActions elementActions;
    public HomePage (ElementActions elementActions){this.elementActions=elementActions;}

    String productName = "Sauce Labs Backpack";
    private final By productLink = By.xpath("//*[text()='" + productName + "']");
    private final By HeaderLogo = By.className("app_logo");

    public By getProductLink(){return productLink;}
    public By getHeaderLogo(){return HeaderLogo;}

}

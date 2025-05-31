package pom;

import actions.ElementActions;
import org.openqa.selenium.By;

public class CartPage
{
    protected final ElementActions elementActions;
    public CartPage(ElementActions elementActions){this.elementActions=elementActions;}

    private final By yourChart = By.xpath("//*[text()=\"Your Cart\"]");
    private final By checkOutBtn = By.xpath("//*[text()=\"CHECKOUT\"]");

    public By getChartLogo(){return yourChart;}
    public By getCkeckoutBtn(){return checkOutBtn;}
}

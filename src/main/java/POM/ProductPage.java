package pom;

import actions.ElementActions;
import org.openqa.selenium.By;

public class ProductPage
{
    protected final ElementActions elementActions;
    public ProductPage(ElementActions elementActions){this.elementActions=elementActions;}

    String productName = "Sauce Labs Backpack";
    private final By productLink = By.xpath("//*[text()='" + productName + "']");
    private final By addToCartBtn = By.xpath("//button[text()='ADD TO CART']");
    private final By RemoveBtn = By.xpath("//button[text()='REMOVE']");
    private final By clickOnCartItems = By.xpath("//div[@id=\"shopping_cart_container\"]");

    public By getAddToCart(){return addToCartBtn;}
    public By getRemoveBtn(){return RemoveBtn;}
    public By getAddToCartBtn(){return clickOnCartItems;}
    public By getProductLink(){return productLink;}

}

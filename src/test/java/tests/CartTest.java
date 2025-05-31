package tests;

import org.testng.annotations.Test;
import pom.CartPage;
import pom.HomePage;
import pom.LoginPage;
import pom.ProductPage;

public class CartTest extends BaseTest
{
    protected CartPage cartPage = new CartPage(elementActions);
    String baserUR = "https://www.saucedemo.com/v1/";

    @Test
    public void assertCartPage(){
        new LoginPage(elementActions).login("standard_user", "secret_sauce");
        HomePage homePage = pageObjectManager.getHomePage();
        ProductPage productPage = pageObjectManager.getProductPage();
        elementActions
                .clickElement(homePage.getProductLink())
                .clickElement(productPage.getAddToCartBtn())
                .assertCurrentUrlWhenMoveFromPageToAnotherPage(baserUR+"cart.html")
                .assertByVisibility(cartPage.getChartLogo());
    }

    @Test(dependsOnMethods = "assertCartPage")
    public void clickOnCheckOutBtn(){
        elementActions.clickElement(cartPage.getCkeckoutBtn());
    }

}

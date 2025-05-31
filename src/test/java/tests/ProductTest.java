package tests;

import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;
import pom.ProductPage;

public class ProductTest extends BaseTest
{
    protected ProductPage productPage = new ProductPage(elementActions);
    String baserUR = "https://www.saucedemo.com/v1/";

    @Test
    public void assertProductPage()
    {
        new LoginPage(elementActions).login("standard_user", "secret_sauce");
        HomePage homePage = pageObjectManager.getHomePage();
        elementActions
                .assertByVisibility(homePage.getHeaderLogo())
                .clickElement(homePage.getProductLink())
                .assertCurrentUrlWhenMoveFromPageToAnotherPage(baserUR+"inventory-item.html?id=4");
        elementActions.assertByVisibility(productPage.getProductLink());
    }

    @Test(dependsOnMethods = "assertProductPage")
    public void addItemToCart(){
        productPage = pageObjectManager.getProductPage();
        elementActions
                .clickElement(productPage.getAddToCart())
                .assertByVisibility(productPage.getRemoveBtn())
                .clickElement(productPage.getAddToCartBtn());
    }



    /*
    ElementActions elementActions;
    HomePage homePage;
    ProductPage productPage;

    @BeforeMethod
    public void setUp() {
        elementActions = new ElementActions(BrowserActions.getDriver());
        homePage = new HomePage(elementActions);
        productPage =new ProductPage(elementActions);
    }


    @Test
    public void assertProductPage1(){
        new LoginPage(elementActions).login1("standard_user", "secret_sauce");
        elementActions
         .assertByVisibility(homePage.getHeaderLogo())
        .clickElement(homePage.getProductLink())
        .assertCurrentUrlWhenMoveFromPageToAnotherPage("https://www.saucedemo.com/v1/inventory-item.html?id=4")
        .assertByVisibility(productPage.getProductLink());

    }
*/


}

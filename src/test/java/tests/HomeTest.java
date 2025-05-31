package tests;

import actions.BrowserActions;
import actions.ElementActions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;

public class HomeTest extends BaseTest
{
    protected HomePage homePage =new HomePage(elementActions);
    String baserUR = "https://www.saucedemo.com/v1/";

    @Test
    public void assertHomePage(){
        homePage = new LoginPage(elementActions).login("standard_user", "secret_sauce");
        elementActions
                .assertByVisibility(homePage.getHeaderLogo())
                .assertCurrentUrlWhenMoveFromPageToAnotherPage( baserUR+"inventory.html");
    }

    @Test(dependsOnMethods = "assertHomePage")
    public void clickOnSelectedProduct(){
        elementActions.clickElement(homePage.getProductLink());
    }

}

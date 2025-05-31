package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pom.*;

public class CheckoutTest extends BaseTest
{
    protected CheckoutPage checkoutPage = new CheckoutPage(elementActions);
    Faker faker = new Faker();

    String FirstName=faker.name().firstName() ;
    String LastName= faker.name().lastName();
    String PostalName=faker.address().zipCode();
    String baserUR = "https://www.saucedemo.com/v1/";

    @Test
    public void assertCheckoutPage()
    {
        HomePage homePage = pageObjectManager.getHomePage();
        ProductPage productPage = pageObjectManager.getProductPage();
        CartPage cartPage = pageObjectManager.getCartPage();

        new LoginPage(elementActions).login("standard_user", "secret_sauce");
        elementActions
                .clickElement(homePage.getProductLink())
                .clickElement(productPage.getAddToCartBtn())
                .clickElement(cartPage.getCkeckoutBtn())
                .assertCurrentUrlWhenMoveFromPageToAnotherPage(baserUR+"checkout-step-one.html")
                .assertByVisibility(checkoutPage.getInfoText());
    }

    @Test(dependsOnMethods = "assertCheckoutPage")
    public void fillFieldsAndClickOnContinueButton(){
        elementActions
                .typeText(checkoutPage.getFirstName(),FirstName)
                .typeText(checkoutPage.getLastName(),LastName)
                .typeText(checkoutPage.getPostalCode(),PostalName)
                .clickElement(checkoutPage.getContinueButton());

    }




}

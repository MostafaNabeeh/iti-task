package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pom.*;

public class FinishTest extends BaseTest
{
    protected FinishPage finishPage = new FinishPage(elementActions);
    Faker faker = new Faker();

    String FirstName=faker.name().firstName() ;
    String LastName= faker.name().lastName();
    String PostalName=faker.address().zipCode();
    String baserUR = "https://www.saucedemo.com/v1/";

    @Test
    public void assertFinishPage(){
        HomePage homePage = pageObjectManager.getHomePage();
        ProductPage productPage = pageObjectManager.getProductPage();
        CartPage cartPage = pageObjectManager.getCartPage();
        CheckoutPage checkoutPage = pageObjectManager.getCheckoutPage();
        CheckoutOverviewPage checkoutOverviewPage = pageObjectManager.getCheckoutOverviewPage();

        new LoginPage(elementActions).login("standard_user", "secret_sauce");
        elementActions
                .clickElement(homePage.getProductLink())
                .clickElement(productPage.getAddToCartBtn())
                .clickElement(cartPage.getCkeckoutBtn())
                .typeText(checkoutPage.getFirstName(),FirstName)
                .typeText(checkoutPage.getLastName(),LastName)
                .typeText(checkoutPage.getPostalCode(),PostalName)
                .clickElement(checkoutPage.getContinueButton())
                .clickElement(checkoutOverviewPage.getFinishBtn())
                .assertCurrentUrlWhenMoveFromPageToAnotherPage(baserUR+"checkout-complete.html")
                .clickElement(finishPage.getThankyouHeader());
    }

}

package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pom.*;

public class CheckoutOverviewTest extends BaseTest
{
    protected CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(elementActions);
    Faker faker = new Faker();

    String FirstName=faker.name().firstName() ;
    String LastName= faker.name().lastName();
    String PostalName=faker.address().zipCode();
    String baserUR = "https://www.saucedemo.com/v1/";

    @Test
    public void assertCheckoutOverviewPage()
    {
        HomePage homePage = pageObjectManager.getHomePage();
        ProductPage productPage = pageObjectManager.getProductPage();
        CartPage cartPage = pageObjectManager.getCartPage();
        CheckoutPage checkoutPage = pageObjectManager.getCheckoutPage();

        new LoginPage(elementActions).login("standard_user", "secret_sauce");
        elementActions
                .clickElement(homePage.getProductLink())
                .clickElement(productPage.getAddToCartBtn())
                .clickElement(cartPage.getCkeckoutBtn())
                .typeText(checkoutPage.getFirstName(),FirstName)
                .typeText(checkoutPage.getLastName(),LastName)
                .typeText(checkoutPage.getPostalCode(),PostalName)
                .clickElement(checkoutPage.getContinueButton())
                .assertCurrentUrlWhenMoveFromPageToAnotherPage(baserUR+"checkout-step-two.html")
                .clickElement(checkoutOverviewPage.getOverViewLogo());
    }

    @Test(dependsOnMethods = "assertCheckoutOverviewPage")
    public void clickOnContinueBtnAndMoveToFinishPage(){
        elementActions.clickElement(checkoutOverviewPage.getFinishBtn());
    }

}




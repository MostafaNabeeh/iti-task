package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pom.LoginPage;

public class LoginTest extends BaseTest
{
    LoginPage loginPage = new LoginPage(elementActions);
    Faker faker = new Faker();

    String inValidUsername = faker.name().username();
    String inValidPassword = faker.internet().password();
    String baserUR = "https://www.saucedemo.com/v1/";

    @Test
    public void validLogin(){
        new LoginPage(elementActions).login("standard_user", "secret_sauce");
        elementActions.assertCurrentUrlWhenMoveFromPageToAnotherPage(baserUR);
    }

    @Test
    public void invalidLoginByInvalidUsername()
    {
        new LoginPage(elementActions).login(inValidUsername, "secret_sauce");
        elementActions.assertByVisibility(loginPage.getErrorMessage());
    }

    @Test
    public void invalidLoginByInvalidPassword()
    {
        new LoginPage(elementActions).login("standard_user", inValidPassword);
        elementActions.assertByVisibility(loginPage.getErrorMessage());
    }

    @Test
    public void invalidLoginWithInvalidUsernameAndPassword()
    {
        new LoginPage(elementActions).login(inValidUsername, inValidPassword);
        elementActions.assertByVisibility(loginPage.getErrorMessage());
    }
}


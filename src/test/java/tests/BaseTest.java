package tests;

import actions.BrowserActions;
import actions.ElementActions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pom.PageObjectManager;

public class BaseTest
{
    protected ElementActions elementActions;
    protected PageObjectManager pageObjectManager;

    @BeforeClass
    public void start()
    {
        BrowserActions.initializeTheWebDriver("chrome");
        BrowserActions.openUrl("https://www.saucedemo.com/v1/");
        BrowserActions.maximizeWindow();
    }

    @BeforeMethod
    public void setUp() {
        elementActions = new ElementActions(BrowserActions.getDriver());
        pageObjectManager = new PageObjectManager(elementActions);
    }

    @AfterClass
    public void tearDown() {
        BrowserActions.quitBrowser();
    }
}


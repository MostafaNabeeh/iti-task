package testpages;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;


public class HomeTest extends BaseTest {
    public HomePage homePage;

    @BeforeMethod
    public void setupPageAndNavigate()
    {
        homePage = new HomePage(driver);
        boolean isHomePageLoaded = homePage.validateHomePageIsLoaded();
        Assert.assertTrue(isHomePageLoaded,"Home page did not load Correctly");

        homePage.ClickOnGetPaidBTN();
    }

    @Test
    public void testFreeDocumentsCountAndTextValidation() {
        homePage = new HomePage(driver);
        boolean isFreeElementsCountValid = homePage.validateFreeElementsCount();
        Assert.assertTrue(isFreeElementsCountValid, " Free elements count validation failed");
    }


    @Test
    public void testValidateDocumentsInPriceRange() {
        boolean isDocsInRangeValid  = homePage.validateDocumentsInPriceRange(30,60);
        Assert.assertTrue(isDocsInRangeValid, "documents found in the price range 30,60");
    }
}

package testpages;

import POM.FreeDocumentsPage;
import POM.PricedDocumentsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import POM.HomePage;


public class HomeTest extends BaseTest
{
    public HomePage homePage;

    @BeforeMethod
    public void setupPageAndNavigate()
    {
        homePage = new HomePage();
        boolean isHomePageLoaded = homePage.navigationtohome();
        Assert.assertTrue(isHomePageLoaded,"Home page did not load Correctly");
        homePage.ClickOnGetPaidBTN();
    }


}

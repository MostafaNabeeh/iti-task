package testpages;
import POM.FreeDocumentsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FreeDocumentsTest extends BaseTest
{
    public FreeDocumentsPage freeDocumentsPage;

    @Test
    public void testFreeDocumentsCountAndTextValidation()
    {
        freeDocumentsPage = new FreeDocumentsPage(driver);
        boolean isFreeElementsCountValid = freeDocumentsPage.validateFreeElementsCount(2);
        Assert.assertTrue(isFreeElementsCountValid, " Free elements count validation failed");
    }

}

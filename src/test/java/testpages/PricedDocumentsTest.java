package testpages;
import POM.PricedDocumentsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PricedDocumentsTest
{
    public PricedDocumentsPage pricedDocumentsPage ;

    @Test
    public void testValidateDocumentsInPriceRange() {
        boolean isDocsInRangeValid  = pricedDocumentsPage.validateDocumentsInPriceRange(30,60);
        Assert.assertTrue(isDocsInRangeValid, "documents found in the price range 30,60");
    }

}

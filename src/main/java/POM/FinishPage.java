package pom;
import actions.ElementActions;
import org.openqa.selenium.By;

public class FinishPage
{
    protected final ElementActions elementActions;
    public FinishPage(ElementActions elementActions){
        this.elementActions=elementActions;
    }

    private By thankyouHeader = By.xpath("//*[text()=\"THANK YOU FOR YOUR ORDER\"]");
    public By getThankyouHeader() {return thankyouHeader;}

}

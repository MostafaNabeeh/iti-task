package pom;

import actions.ElementActions;
import org.openqa.selenium.By;

public class CheckoutOverviewPage
{
    protected final ElementActions elementActions;
    public CheckoutOverviewPage(ElementActions elementActions){
        this.elementActions=elementActions;
    }

    private final By overViewLogo = By.xpath("//*[text()='Checkout: Overview']");
    private final By finishBtn = By.xpath("//*[text()=\"FINISH\"]");

    public By getOverViewLogo(){return overViewLogo;}
    public By getFinishBtn(){return finishBtn;}

}

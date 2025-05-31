package pom;
import actions.ElementActions;
import org.openqa.selenium.By;

public class LoginPage
{
     protected final ElementActions elementActions;
     public LoginPage(ElementActions elementActions) {
        this.elementActions = elementActions;
    }

     private final  By userName =By.id("user-name");
     private final  By password =By.id("password");
     private final  By clickButton =By.id("login-button");
     private final By errorMessage = By.xpath("//h3[contains(., 'required') or contains(., 'do not match any user')]" + "//button[contains(@class, 'error-button')]");

     public By getUserName(){return userName;}
     public By getPassword(){return password;}
     public By getClickButton(){return clickButton;}
     public By getErrorMessage(){
         return errorMessage;
     }


     /***************************************************************************/
     public HomePage login(String username , String password){
            elementActions
                    .typeText(getUserName(), username)
                    .typeText(getPassword(), password)
                    .clickElement(getClickButton());
            return new HomePage(elementActions);
     }





    /***********************************************************************/
//    public By getErrorMessage() {
//         return By.xpath("//h3[contains(., 'Username is required')]");
//         return By.xpath("//h3[contains(., 'Password  is required')]");
//         return By.xpath("//h3[contains(., 'Username and password do not match any user in this service')]");
//    }

        /***************************Extra******************************/
//    public ElementActions login(ElementActions elementActions, String username, String password) {
//        return elementActions
//                .typeText(getUserName(), username)
//                .typeText(getPassword(), password)
//                .clickElement(getClickButton());
//    }
}

package pom;
import actions.ElementActions;

public class PageObjectManager
{
    private final ElementActions elementActions;
    private LoginPage loginPage;
    private HomePage homePage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private FinishPage finishPage;

    // Constructor initializes ElementActions
    public PageObjectManager(ElementActions elementActions) {
        this.elementActions = elementActions;
    }

    // Get HomePage (initialize only when needed)
    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(elementActions);
        }
        return loginPage;
    }

    // Get HomePage (initialize only when needed)
    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(elementActions);
        }
        return homePage;
    }

    // Get ProductPage (initialize only when needed)
    public ProductPage getProductPage() {
        if (productPage == null) {
            productPage = new ProductPage(elementActions);
        }
        return productPage;
    }

    //Get CartPage (initialize only when needed)
    public CartPage getCartPage(){
        if(cartPage==null){
            cartPage = new CartPage(elementActions);
        }
        return cartPage;
    }

    //Get CheckoutPage (initialize only when needed)
    public CheckoutPage getCheckoutPage(){
        if(checkoutPage==null){
            checkoutPage = new CheckoutPage(elementActions);
        }
        return checkoutPage;
    }

    //Get CheckoutOverviewPage (initialize only when needed)
    public CheckoutOverviewPage getCheckoutOverviewPage(){
        if(checkoutOverviewPage==null){
            checkoutOverviewPage = new CheckoutOverviewPage(elementActions);
        }
        return checkoutOverviewPage;
    }

    //Get FinishPage (initialize only when needed)
    public FinishPage getFinishPage(){
        if(finishPage==null){
            finishPage = new FinishPage(elementActions);
        }
        return finishPage;
    }
}

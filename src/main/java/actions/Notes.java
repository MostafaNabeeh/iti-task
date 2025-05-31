
/*
    1-public static WebDriver getDriver(){return driver;}

    2-@BeforeMethod
    public void setUp() {elementActions = new ElementActions(BrowserActions.getDriver());}

    3-private final ElementActions elementActions;
    public HomePage (ElementActions elementActions){this.elementActions=elementActions;}

    4-The approach you're following is known as "Fluent Interface" and "Factory Pattern" combined:
    5-why this pass
    @Test
    public void assertHomePage(){
        homePage = new LoginPage(elementActions).login("standard_user", "secret_sauce");
        elementActions.assertByVisibility(homePage.getHeaderLogo());
    }

    and this fail
    @Test
    public void assertHomePage(){
        new LoginPage(elementActions).login("standard_user", "secret_sauce");
        elementActions.assertByVisibility(homePage.getHeaderLogo());
    }

    6-public <T> T login(String username, String password, Class<T> pageType) {
        elementActions
            .typeText(getUserName(), username)
            .typeText(getPassword(), password)
            .clickElement(getClickButton());

        try {
            return pageType.getDeclaredConstructor(ElementActions.class).newInstance(elementActions);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize page: " + pageType.getName(), e);
        }
    }
                    **0 or *******************
    public <T> T login(String username, String password, Class<T> nextPage) {
        elementActions
            .typeText(getUserName(), username)
            .typeText(getPassword(), password)
            .clickElement(getClickButton());

        try {
            return nextPage.getDeclaredConstructor(ElementActions.class).newInstance(elementActions);
        } catch (Exception e) {
            throw new RuntimeException("Error creating page instance: " + e.getMessage());
        }
    }

    7- PageObjectManager IsMust
    8-@Test(dependsOnMethods = "")
*/






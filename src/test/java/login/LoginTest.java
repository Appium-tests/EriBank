package login;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.helpers.TestHelper;
import qa.pageobject.homeview.HomeView;
import qa.steps.LoginSteps;
import qa.testdataproviders.TestDataProviders;
import qa.utils.Credentials;


public class LoginTest extends BaseTest {

    private LoginSteps loginSteps;
    private TestHelper testHelper;

    @BeforeMethod
    public void create() {

        loginSteps = new LoginSteps(getDriver());
        testHelper = new TestHelper();
    }

    private void setCredentials(Credentials credentials) {

        loginSteps.setUsername(credentials.getUsername());
        loginSteps.setPassword(credentials.getPassword());
        loginSteps.tapLoginButton();
    }

    @Test(dataProvider = "CR_correct", dataProviderClass = TestDataProviders.class)
    public void correctCredentials(Credentials credentials) {

        setCredentials(credentials);
        HomeView homeView = new HomeView(getDriver());

        Assert.assertTrue(homeView.isDisplayed());
    }

    @Test(dataProvider = "CR_correctUsernameWithUppercase", dataProviderClass = TestDataProviders.class)
    public void correctUsernameWithUppercase(Credentials credentials) {

        setCredentials(credentials);
        testHelper.checkWhenDataIsIncorrect(loginSteps.getLoginView().getAlertFrame(),
                credentials.getTitle(), credentials.getMessage());
    }

    @Test(dataProvider = "CR_correctPasswordWithUppercase", dataProviderClass = TestDataProviders.class)
    public void correctPasswordWithUppercase(Credentials credentials) {

        setCredentials(credentials);
        testHelper.checkWhenDataIsIncorrect(loginSteps.getLoginView().getAlertFrame(),
                credentials.getTitle(), credentials.getMessage());
    }

    @Test(dataProvider = "CR_incorrectUsername", dataProviderClass = TestDataProviders.class)
    public void incorrectUsername(Credentials credentials) {

        setCredentials(credentials);
        testHelper.checkWhenDataIsIncorrect(loginSteps.getLoginView().getAlertFrame(),
                credentials.getTitle(), credentials.getMessage());
    }

    @Test(dataProvider = "CR_blankUsernameField", dataProviderClass = TestDataProviders.class)
    public void blankUsernameField(Credentials credentials) {

        setCredentials(credentials);
        testHelper.checkWhenDataIsIncorrect(loginSteps.getLoginView().getAlertFrame(),
                credentials.getTitle(), credentials.getMessage());
    }

    @Test(dataProvider = "CR_incorrectPassword", dataProviderClass = TestDataProviders.class)
    public void incorrectPassword(Credentials credentials) {

        setCredentials(credentials);
        testHelper.checkWhenDataIsIncorrect(loginSteps.getLoginView().getAlertFrame(),
                credentials.getTitle(), credentials.getMessage());
    }

    @Test(dataProvider = "CR_incorrectPassword", dataProviderClass = TestDataProviders.class)
    public void blankPasswordField(Credentials credentials) {

        setCredentials(credentials);
        testHelper.checkWhenDataIsIncorrect(loginSteps.getLoginView().getAlertFrame(),
                credentials.getTitle(), credentials.getMessage());
    }
}

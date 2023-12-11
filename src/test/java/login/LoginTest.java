package login;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.pageobject.homeview.HomeView;
import qa.pageobject.loginview.LoginView;
import qa.testdataproviders.TestDataProviders;
import qa.utils.Credentials;


public class LoginTest extends BaseTest {

    private LoginView loginView;

    @BeforeMethod
    public void create() {

        loginView = new LoginView(getDriver());
    }

    private void setCredentials(Credentials credentials) {

        loginView.setUsername(credentials.getUsername());
        loginView.setPassword(credentials.getPassword());
        loginView.tapLoginButton();
    }

    private void validateAlertFrame() {

        Assert.assertTrue(loginView.getAlertFrame().isDisplayed(), "The alert frame is not displayed");
        Assert.assertEquals(loginView.getAlertFrame().getTitle(), "Alert", "Incorrect title");
        Assert.assertEquals(loginView.getAlertFrame().getMessage(), "Invalid username or password!", "Incorrect message");
        Assert.assertTrue(loginView.getAlertFrame().isButtonDisplayed(), "The \"Close\" button is not displayed");
    }

    @Test(dataProvider = "CR_correct", dataProviderClass = TestDataProviders.class)
    public void correctCredentials(Credentials credentials) {

        setCredentials(credentials);
        HomeView homeView = new HomeView(getDriver());

        Assert.assertTrue(homeView.isDisplayed());
    }

    @Test(dataProvider = "CR_incorrectUsername", dataProviderClass = TestDataProviders.class)
    public void incorrectUsername(Credentials credentials) {

        setCredentials(credentials);
        validateAlertFrame();
        loginView.getAlertFrame().tapButton();
    }

    @Test(dataProvider = "CR_blankUsernameField", dataProviderClass = TestDataProviders.class)
    public void blankUsernameField(Credentials credentials) {

        setCredentials(credentials);
        validateAlertFrame();
        loginView.getAlertFrame().tapButton();
    }

    @Test(dataProvider = "CR_incorrectPassword", dataProviderClass = TestDataProviders.class)
    public void incorrectPassword(Credentials credentials) {

        setCredentials(credentials);
        validateAlertFrame();
        loginView.getAlertFrame().tapButton();
    }

    @Test(dataProvider = "CR_incorrectPassword", dataProviderClass = TestDataProviders.class)
    public void blankPasswordField(Credentials credentials) {

        setCredentials(credentials);
        validateAlertFrame();
        loginView.getAlertFrame().tapButton();
    }
}

package login;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.pageobject.homeview.HomeView;
import qa.pageobject.loginview.LoginView;
import qa.dataproviders.CredentialsDataProviders;
import qa.models.Credentials;
import qa.utils.DataProviderNames;

@Epic("E2E")
@Feature("Login")
public class LoginTest extends BaseTest {

    private LoginView loginView;
    private HomeView homeView;

    @BeforeMethod
    public void create() {

        loginView = new LoginView(getDriver());
        homeView = new HomeView(getDriver());
    }

    private void actions(Credentials credentials) {

        loginView.setUsername(credentials.getUsername());
        loginView.setPassword(credentials.getPassword());
        loginView.touchLoginButton();
    }

    @Test(dataProvider = DataProviderNames.CORRECT, dataProviderClass = CredentialsDataProviders.class)
    @QaseId(5)
    @QaseTitle("Login with correct credentials")
    @Description("Login with correct credentials")
    public void correctCredentials(Credentials credentials) {

        actions(credentials);
        Assert.assertTrue(homeView.isDisplayed(),
                "A user is not logged in");
    }


    @Test(dataProvider = DataProviderNames.USERNAME_WITH_UPPER_LETTERS, dataProviderClass = CredentialsDataProviders.class)
    @QaseId(6)
    @QaseTitle("Correct username with upper letters")
    @Description("Correct username with upper letters")
    public void correctUsernameWithUpperLetters(Credentials credentials) {

        actions(credentials);
        Assert.assertFalse(loginView.getALERT_FRAME().isDisplayed(), "The alert is displayed");
        Assert.assertTrue(homeView.isDisplayed(), "The home view is not opened");
    }

    @Test(dataProvider = DataProviderNames.PASSWORD_WITH_UPPER_LETTERS, dataProviderClass = CredentialsDataProviders.class)
    @QaseId(7)
    @QaseTitle("Correct password with upper letters")
    @Description("Correct password with upper letters")
    public void correctPasswordWithUpperLetters(Credentials credentials) {

        actions(credentials);
        Assert.assertTrue(loginView.getALERT_FRAME().isDisplayed(), "The alert is not displayed");
    }

    @Test(dataProvider = DataProviderNames.INCORRECT_USERNAME, dataProviderClass = CredentialsDataProviders.class)
    @QaseId(8)
    @QaseTitle("Incorrect username")
    @Description("Incorrect username")
    public void incorrectUsername(Credentials credentials) {

        actions(credentials);
        Assert.assertTrue(loginView.getALERT_FRAME().isDisplayed(), "The alert is not displayed");
    }

    @Test(dataProvider = DataProviderNames.BLANK_USERNAME_FIELD, dataProviderClass = CredentialsDataProviders.class)
    @QaseId(9)
    @QaseTitle("Blank the \"Username\" field")
    @Description("Blank the \"Username\" field")
    public void blankUsernameField(Credentials credentials) {

        loginView.setPassword(credentials.getPassword());
        loginView.touchLoginButton();
        Assert.assertTrue(loginView.getALERT_FRAME().isDisplayed(), "The alert is not displayed");
    }

    @Test(dataProvider = DataProviderNames.INCORRECT_PASSWORD, dataProviderClass = CredentialsDataProviders.class)
    @QaseId(10)
    @QaseTitle("Incorrect password")
    @Description("Incorrect password")
    public void incorrectPassword(Credentials credentials) {

        actions(credentials);
        Assert.assertTrue(loginView.getALERT_FRAME().isDisplayed(), "The alert is not displayed");
    }

    @Test(dataProvider = DataProviderNames.BLANK_PASSWORD_FIELD, dataProviderClass = CredentialsDataProviders.class)
    @QaseId(11)
    @QaseTitle("Blank the \"Password\" field")
    @Description("Blank the \"Password\" field")
    public void blankPasswordField(Credentials credentials) {

        loginView.setUsername(credentials.getUsername());
        loginView.touchLoginButton();
        Assert.assertTrue(loginView.getALERT_FRAME().isDisplayed(), "The alert is not displayed");
    }
}

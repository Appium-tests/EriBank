package login;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import qa.pageobject.homeview.HomeView;
import qa.pageobject.loginview.LoginView;
import qa.dataproviders.CredentialsDataProviders;
import qa.models.Credentials;
import qa.support.AllureAttachments;
import qa.support.DataProviderNames;

import java.io.IOException;

@Epic("E2E")
@Feature("Login to an account")
public class LoginTest extends BaseTest {

    private LoginView loginView;
    private HomeView homeView;

    @BeforeMethod
    public void prepare() {

        loginView = new LoginView(getDriver());
        homeView = new HomeView(getDriver());
    }

    private void actions(Credentials credentials) throws IOException {

        loginView
                .setUsername(credentials.getUsername())
                .setPassword(credentials.getPassword());

        AllureAttachments.takeScreenshot(getDriver(), "login");
        loginView.touchLoginButton();
    }

    @Test(priority = 3, dataProvider = DataProviderNames.CORRECT, dataProviderClass = CredentialsDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Login")
    @Tag("Credentials")
    @Owner("Paweł Aksman")
    @QaseId(5)
    @QaseTitle("Login with correct credentials")
    @Description("Login with correct credentials")
    public void correctCredentials(Credentials credentials) throws IOException {

        Allure.parameter("Username", credentials.getUsername());
        Allure.parameter("Password", credentials.getPassword());

        actions(credentials);

        try {
            homeView.waitForPaymentHomeView();
        } catch (Exception e) {
            Assert.fail("The home view is not opened");
        }
    }

    @Test(priority = 1, dataProvider = DataProviderNames.USERNAME_WITH_UPPER_LETTERS, dataProviderClass = CredentialsDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Login")
    @Tag("Credentials")
    @Owner("Paweł Aksman")
    @Description("Correct username with upper letters")
    @QaseId(6)
    @QaseTitle("Correct username with upper letters")
    public void correctUsernameWithUpperLetters(Credentials credentials) throws IOException {

        Allure.parameter("Username", credentials.getUsername());
        Allure.parameter("Password", credentials.getPassword());

        actions(credentials);
        Assert.assertTrue(loginView.getErrorMessageBox().isDisplayed(), "The alert is not displayed");
    }

    @Test(priority = 2, dataProvider = DataProviderNames.PASSWORD_WITH_UPPER_LETTERS, dataProviderClass = CredentialsDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Login")
    @Tag("Credentials")
    @Owner("Paweł Aksman")
    @Description("Correct password with upper letters")
    @QaseId(7)
    @QaseTitle("Correct password with upper letters")
    public void correctPasswordWithUpperLetters(Credentials credentials) throws IOException {

        Allure.parameter("Username", credentials.getUsername());
        Allure.parameter("Password", credentials.getPassword());

        actions(credentials);
        Assert.assertTrue(loginView.getErrorMessageBox().isDisplayed(), "The alert is not displayed");
    }

    @Test(priority = 4, dataProvider = DataProviderNames.INCORRECT_USERNAME, dataProviderClass = CredentialsDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Login")
    @Tag("Credentials")
    @Owner("Paweł Aksman")
    @Description("Incorrect username")
    @QaseId(8)
    @QaseTitle("Incorrect username")
    public void incorrectUsername(Credentials credentials) throws IOException {

        Allure.parameter("Username", credentials.getUsername());
        Allure.parameter("Password", credentials.getPassword());

        actions(credentials);
        Assert.assertTrue(loginView.getErrorMessageBox().isDisplayed(), "The alert is not displayed");
    }

    @Test(priority = 5, dataProvider = DataProviderNames.CORRECT, dataProviderClass = CredentialsDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Login")
    @Tag("Credentials")
    @Owner("Paweł Aksman")
    @Description("Blank the \"Username\" field")
    @QaseId(9)
    @QaseTitle("Blank the \"Username\" field")
    public void blankUsernameField(Credentials credentials) throws IOException {

        Allure.parameter("Password", credentials.getPassword());

        loginView.setPassword(credentials.getPassword());
        AllureAttachments.takeScreenshot(getDriver(), "blankUsernameField");
        loginView.touchLoginButton();
        Assert.assertTrue(loginView.getErrorMessageBox().isDisplayed(), "The alert is not displayed");
    }

    @Test(priority = 6, dataProvider = DataProviderNames.INCORRECT_PASSWORD, dataProviderClass = CredentialsDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Login")
    @Tag("Credentials")
    @Owner("Paweł Aksman")
    @Description("Incorrect password")
    @QaseId(10)
    @QaseTitle("Incorrect password")
    public void incorrectPassword(Credentials credentials) throws IOException {

        Allure.parameter("Username", credentials.getUsername());
        Allure.parameter("Password", credentials.getPassword());

        actions(credentials);
        Assert.assertTrue(loginView.getErrorMessageBox().isDisplayed(), "The alert is not displayed");
    }

    @Test(priority = 7, dataProvider = DataProviderNames.CORRECT, dataProviderClass = CredentialsDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Login")
    @Tag("Credentials")
    @Owner("Paweł Aksman")
    @Description("Blank the \"Password\" field")
    @QaseId(11)
    @QaseTitle("Blank the \"Password\" field")
    public void blankPasswordField(Credentials credentials) throws IOException {

        Allure.parameter("Username", credentials.getUsername());

        loginView.setUsername(credentials.getUsername());
        AllureAttachments.takeScreenshot(getDriver(), "blankPasswordField");
        loginView.touchLoginButton();
        Assert.assertTrue(loginView.getErrorMessageBox().isDisplayed(), "The alert is not displayed");
    }
}

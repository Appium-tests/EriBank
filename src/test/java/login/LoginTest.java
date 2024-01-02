package login;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.helpers.TestHelper;
import qa.pageobject.homeview.HomeView;
import qa.steps.LoginSteps;
import qa.testdataproviders.TestDataProviders;
import qa.utils.Credentials;

@Epic("E2E")
@Feature("Login")
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
    @Description("System verification when logging in using correct credentials")
    @Story("Logging in with correct credentials")
    public void correctCredentials(Credentials credentials) {

        setCredentials(credentials);
        HomeView homeView = new HomeView(getDriver());

        Assert.assertTrue(homeView.isDisplayed(),
                "The user is not logged in");
    }

    @Test(dataProvider = "CR_correctUsernameWithUppercase", dataProviderClass = TestDataProviders.class)
    @Description("System verification when logging in using a correct username with lowercase and uppercase letters")
    @Story("Logging in with correct username with lowercase and uppercase letters")
    public void correctUsernameWithUppercase(Credentials credentials) {

        setCredentials(credentials);
        testHelper.checkWhenDataIsIncorrect(loginSteps.getLoginView().getAlertFrame(),
                credentials.getTitle(), credentials.getMessage());
    }

    @Test(dataProvider = "CR_correctPasswordWithUppercase", dataProviderClass = TestDataProviders.class)
    @Description("System verification when logging in using a valid password with lowercase and uppercase letters")
    @Story("Logging in with correct password with lowercase and uppercase letters")
    public void correctPasswordWithUppercase(Credentials credentials) {

        setCredentials(credentials);
        testHelper.checkWhenDataIsIncorrect(loginSteps.getLoginView().getAlertFrame(),
                credentials.getTitle(), credentials.getMessage());
    }

    @Test(dataProvider = "CR_incorrectUsername", dataProviderClass = TestDataProviders.class)
    @Description("System verification when logging in using a valid username with incorrect username")
    @Story("Logging in with incorrect username")
    public void incorrectUsername(Credentials credentials) {

        setCredentials(credentials);
        testHelper.checkWhenDataIsIncorrect(loginSteps.getLoginView().getAlertFrame(),
                credentials.getTitle(), credentials.getMessage());
    }

    @Test(dataProvider = "CR_blankUsernameField", dataProviderClass = TestDataProviders.class)
    @Description("System verification when logging in using a valid username with blank username field")
    @Story("Logging in with blank username field")
    public void blankUsernameField(Credentials credentials) {

        setCredentials(credentials);
        testHelper.checkWhenDataIsIncorrect(loginSteps.getLoginView().getAlertFrame(),
                credentials.getTitle(), credentials.getMessage());
    }

    @Test(dataProvider = "CR_incorrectPassword", dataProviderClass = TestDataProviders.class)
    @Description("System verification when logging in using a valid username with incorrect password")
    @Story("Logging in with incorrect password")
    public void incorrectPassword(Credentials credentials) {

        setCredentials(credentials);
        testHelper.checkWhenDataIsIncorrect(loginSteps.getLoginView().getAlertFrame(),
                credentials.getTitle(), credentials.getMessage());
    }

    @Test(dataProvider = "CR_incorrectPassword", dataProviderClass = TestDataProviders.class)
    @Description("System verification when logging in using a valid username with blank password field")
    @Story("Logging in with blank password field")
    public void blankPasswordField(Credentials credentials) {

        setCredentials(credentials);
        testHelper.checkWhenDataIsIncorrect(loginSteps.getLoginView().getAlertFrame(),
                credentials.getTitle(), credentials.getMessage());
    }
}

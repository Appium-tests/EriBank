import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
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

    @Test(dataProvider = "CR_correct", dataProviderClass = TestDataProviders.class)
    public void correctCredentials(Credentials credentials) {

        setCredentials(credentials);
    }
}

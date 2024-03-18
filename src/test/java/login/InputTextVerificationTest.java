package login;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import qa.pageobject.loginview.LoginView;

@Epic("E2E")
@Feature("Login form input text verification")
public class InputTextVerificationTest extends BaseTest {

    private LoginView loginView;
    private final String TEXT = "This is the text!";
    private final String USERNAME_HINT = "Username";
    private final String PASSWORD_HINT = "Password";

    @BeforeMethod
    public void create() {

        loginView = new LoginView(getDriver());
    }

    @Test(priority = 1)
    @QaseId(1)
    @QaseTitle("Verification of the \"Username\" field text input\"")
    @Description("Verification of the \"Username\" field text input\"")
    public void usernameField() {

        loginView.setUsername(TEXT);
        Assert.assertEquals(loginView.getUsername(), TEXT, "Incorrect the \"Username\" field output");
    }

    @Test(priority = 2)
    @QaseId(2)
    @QaseTitle("Removing text from the \"Username\" field")
    @Description("Removing text from the \"Username\" field")
    public void removingTextFromUsernameField() {

        loginView.setUsername(TEXT);
        loginView.removeUsername();

        Assert.assertEquals(loginView.getUsername(), USERNAME_HINT, "The text is not deleted");
    }

    @Test(priority = 3)
    @QaseId(3)
    @QaseTitle("Verification of the \"Password\" field text input\"")
    @Description("Verification of the \"Password\" field text input\"")
    public void passwordField() {

        loginView.setPassword(TEXT);
        String expectedOutput = "•".repeat(TEXT.length());
        Assert.assertEquals(loginView.getPassword(), expectedOutput, "Incorrect the \"Password\" field output");
    }

    @Test(priority = 4)
    @QaseId(4)
    @QaseTitle("Removing text from the \"Password\" field")
    @Description("Removing text from the \"Password\" field")
    public void removingTextFromPasswordField() {

        loginView.setPassword(TEXT);
        loginView.removePassword();

        Assert.assertEquals(loginView.getPassword(), PASSWORD_HINT, "The text is not deleted");
    }
}

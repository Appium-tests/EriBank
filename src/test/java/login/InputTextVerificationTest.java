package login;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import qa.pageobject.loginview.LoginView;
import qa.support.AllureAttachments;

import java.io.IOException;

@Epic("E2E")
@Feature("Login form input text verification")
public class InputTextVerificationTest extends BaseTest {

    private LoginView loginView;
    private final String TEXT = "This is the text!";
    private final String USERNAME_HINT = "Username";
    private final String PASSWORD_HINT = "Password";

    @BeforeMethod
    public void prepare() {

        loginView = new LoginView(getDriver());
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Input")
    @Tag("Login")
    @Owner("Paweł Aksman")
    @Description("Verification of the \"Username\" field text input\"")
    @QaseId(1)
    @QaseTitle("Verification of the \"Username\" field text input\"")
    public void usernameField() throws IOException {

        Allure.parameter("Any text", TEXT);

        loginView.setUsername(TEXT);
        AllureAttachments.takeScreenshot(getDriver(), "usernameField");
        Assert.assertEquals(loginView.getUsername(), TEXT, "Incorrect the \"Username\" field output");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Input")
    @Tag("Login")
    @Owner("Paweł Aksman")
    @Description("Removing text from the \"Username\" field")
    @QaseId(2)
    @QaseTitle("Removing text from the \"Username\" field")
    public void removingTextFromUsernameField() throws IOException {

        Allure.parameter("Any text", TEXT);

        loginView.setUsername(TEXT);
        loginView.removeUsername();
        AllureAttachments.takeScreenshot(getDriver(), "blankUsernameField");
        Assert.assertEquals(loginView.getUsername(), USERNAME_HINT, "The text is not deleted");
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Input")
    @Tag("Login")
    @Owner("Paweł Aksman")
    @Description("Verification of the \"Password\" field text input\"")
    @QaseId(3)
    @QaseTitle("Verification of the \"Password\" field text input\"")
    public void passwordField() throws IOException {

        Allure.parameter("Any text", TEXT);

        loginView.setPassword(TEXT);
        AllureAttachments.takeScreenshot(getDriver(), "passwordField");
        String expectedOutput = "•".repeat(TEXT.length());
        Assert.assertEquals(loginView.getPassword(), expectedOutput, "Incorrect the \"Password\" field output");
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Input")
    @Tag("Login")
    @Owner("Paweł Aksman")
    @Description("Removing text from the \"Password\" field")
    @QaseId(4)
    @QaseTitle("Removing text from the \"Password\" field")
    public void removingTextFromPasswordField() throws IOException {

        Allure.parameter("Any text", TEXT);

        loginView.setPassword(TEXT);
        loginView.removePassword();
        AllureAttachments.takeScreenshot(getDriver(), "blankPasswordField");
        Assert.assertEquals(loginView.getPassword(), PASSWORD_HINT, "The text is not deleted");
    }
}

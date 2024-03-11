package qa.pageobject.loginview;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import qa.base.BaseView;

import java.util.List;

public class LoginView extends BaseView {

    @Getter
    private final AlertFrame ALERT_FRAME;

    public LoginView(AndroidDriver driver) {

        super(driver);
        ALERT_FRAME = new AlertFrame(driver);
    }

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/loginView")
    List<WebElement> parent;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/usernameTextField")
    WebElement usernameField;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/passwordTextField")
    WebElement passwordField;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/loginButton")
    WebElement loginButton;

    public boolean isDisplayed() {

        return !parent.isEmpty();
    }

    @io.qameta.allure.Step("Enter an username")
    @io.qase.api.annotation.Step("Enter an username")
    public void setUsername(CharSequence... keys) {

        usernameField.sendKeys(keys);
    }

    @io.qameta.allure.Step("Enter a password")
    @io.qase.api.annotation.Step("Enter a password")
    public void setPassword(String password) {

        passwordField.sendKeys(password);
    }

    @io.qameta.allure.Step("Remove the username")
    @io.qase.api.annotation.Step("Remove the username")
    public void removeUsername() {

        usernameField.clear();
    }

    @io.qameta.allure.Step("Remove the password")
    @io.qase.api.annotation.Step("Remove the password")
    public void removePassword() {

        passwordField.clear();
    }

    public String getUsername() {

        return usernameField.getText();
    }

    public String getPassword() {

        return passwordField.getText();
    }

    @io.qameta.allure.Step("Touch the \"Login\" button")
    @io.qase.api.annotation.Step("Touch the \"Login\" button")
    public void touchLoginButton() {

        loginButton.click();
    }
}

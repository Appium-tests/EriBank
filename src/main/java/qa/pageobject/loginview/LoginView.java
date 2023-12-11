package qa.pageobject.loginview;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import qa.base.BaseView;

public class LoginView extends BaseView {

    private final AlertFrame alertFrame;

    public LoginView(AndroidDriver driver) {

        super(driver);
        alertFrame = new AlertFrame(driver);
    }

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/usernameTextField")
    WebElement usernameField;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/passwordTextField")
    WebElement passwordField;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/loginButton")
    WebElement loginButton;

    public void setUsername(String username) {

        usernameField.sendKeys(username);
    }

    public void setPassword(String password) {

        passwordField.sendKeys(password);
    }

    public void tapLoginButton() {

        loginButton.click();
    }

    public AlertFrame getAlertFrame() {

        return alertFrame;
    }
}

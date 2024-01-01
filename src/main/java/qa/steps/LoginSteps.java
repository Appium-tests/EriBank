package qa.steps;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import qa.pageobject.loginview.LoginView;

public class LoginSteps {

    private final LoginView loginView;

    public LoginSteps(AndroidDriver driver) {

        loginView = new LoginView(driver);
    }

    @Step("Set username")
    public void setUsername(String username) {

        loginView.setUsername(username);
    }

    @Step("Set password")
    public void setPassword(String password) {

        loginView.setPassword(password);
    }

    @Step("Tap \"Login\" button")
    public void tapLoginButton() {

        loginView.tapLoginButton();
    }


    public LoginView getLoginView() {

        return loginView;
    }
}

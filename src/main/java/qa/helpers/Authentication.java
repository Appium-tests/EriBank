package qa.helpers;

import io.appium.java_client.android.AndroidDriver;
import qa.pageobject.loginview.LoginView;

public class Authentication {

    public static void perform(AndroidDriver driver) {

        LoginView loginView = new LoginView(driver);
        loginView.setUsername("company");
        loginView.setPassword("company");
        loginView.tapLoginButton();
    }
}

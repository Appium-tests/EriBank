package qa.helpers;

import io.appium.java_client.android.AndroidDriver;
import qa.json.JSONReader;
import qa.pageobject.loginview.LoginView;
import qa.utils.Credentials;

public class Authentication {

    public static void perform(AndroidDriver driver) {

        Credentials[] credentials = JSONReader.getCredentials("correct");

        LoginView loginView = new LoginView(driver);
        loginView.setUsername(credentials[0].getUsername());
        loginView.setPassword(credentials[0].getPassword());
        loginView.tapLoginButton();
    }
}

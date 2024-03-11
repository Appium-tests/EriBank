package qa.helpers;

import io.appium.java_client.android.AndroidDriver;
import qa.dataproviders.CredentialsDataProviders;
import qa.pageobject.loginview.LoginView;
import qa.models.Credentials;

public class Authentication {

    public static void perform(AndroidDriver driver) {

        CredentialsDataProviders dataProviders = new CredentialsDataProviders();
        Credentials[] credentials = (Credentials[]) dataProviders.correct();

        LoginView loginView = new LoginView(driver);
        loginView.setUsername(credentials[0].getUsername());
        loginView.setPassword(credentials[0].getPassword());
        loginView.touchLoginButton();
    }
}

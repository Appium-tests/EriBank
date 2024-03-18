package qa.support;

import io.appium.java_client.android.AndroidDriver;
import qa.pageobject.loginview.LoginView;
import qa.models.Credentials;

public class Authentication {

    public static void perform(AndroidDriver driver) {

        String source = FileReader.loadCredentials();
        Credentials[] credentials = TestDataLoader.getCredentialsFromSource(source, DataProviderNames.CORRECT);

        LoginView loginView = new LoginView(driver);
        loginView.setUsername(credentials[0].getUsername());
        loginView.setPassword(credentials[0].getPassword());
        loginView.touchLoginButton();
    }
}

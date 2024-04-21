package qa.support;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.appium.java_client.android.AndroidDriver;
import qa.pageobject.loginview.LoginView;
import qa.models.Credentials;

public class Authentication {

    public static void perform(AndroidDriver driver) throws JsonProcessingException {

        String source = FileReader.loadCredentials();
        Credentials[] credentials = TestDataLoader.getCredentialsFromSource(source, DataProviderNames.CORRECT);

        LoginView loginView = new LoginView(driver);
        loginView.setUsername(credentials[0].getUsername());
        loginView.setPassword(credentials[0].getPassword());
        loginView.touchLoginButton();
    }
}

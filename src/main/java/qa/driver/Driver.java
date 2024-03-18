package qa.driver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URI;

public class Driver {
    private static final String AUTOMATION_NAME = "uiautomator2";
    private static final String UDID = "emulator-5554";
    private static final String PLATFORM_NAME = "Android";
    private static final String PLATFORM_VERSION = "11";
    private static final String APP_PACKAGE = "com.experitest.ExperiBank";
    private static final String APP_ACTIVITY = ".LoginActivity";
    private static final URI uri = URI.create("http://127.0.0.1:4724/");

    private static DesiredCapabilities getCapabilities() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", AUTOMATION_NAME);
        capabilities.setCapability("deviceName", UDID);
        capabilities.setCapability("platformName", PLATFORM_NAME);
        capabilities.setCapability("platformVersion", PLATFORM_VERSION);
        capabilities.setCapability("appPackage", APP_PACKAGE);
        capabilities.setCapability("appActivity", APP_ACTIVITY);
        capabilities.setCapability("appium:autoGrantPermission", true);

        return capabilities;
    }

    public static AndroidDriver createDriver() throws MalformedURLException {

        return new AndroidDriver(uri.toURL(), getCapabilities());
    }
}

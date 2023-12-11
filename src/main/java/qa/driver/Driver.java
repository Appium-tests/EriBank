package qa.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URI;


public class Driver {

    private static final URI uri = URI.create("http://127.0.0.1:4723/");

    private static DesiredCapabilities getCapabilities() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.UDID, "UDID");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        capabilities.setCapability("appium:autoGrantPermission", true);

        return capabilities;
    }

    public static AndroidDriver createDriver() throws MalformedURLException {

        return new AndroidDriver(uri.toURL(), getCapabilities());
    }
}

package qa.environmentinfo;

import io.appium.java_client.android.AndroidDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnvironmentInfo {

    private static final Logger logger = LoggerFactory.getLogger(EnvironmentInfo.class);
    public static void logInfo(AndroidDriver driver) {

        logger.info("Device name: " + driver.getCapabilities().getCapability("deviceName"));
        logger.info("Device time: " + driver.getCapabilities().getCapability("deviceTime"));
        logger.info("Battery state: " + driver.getBatteryInfo().getState().name());
        logger.info("Battery level: " + driver.getBatteryInfo().getLevel());
        logger.info("Platform name: " + driver.getCapabilities().getCapability("platformName"));
        logger.info("Platform version: " + driver.getCapabilities().getCapability("platformVersion"));
    }
}

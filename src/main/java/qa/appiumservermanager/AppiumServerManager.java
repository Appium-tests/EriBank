package qa.appiumservermanager;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import java.io.File;
import java.time.Duration;

public class AppiumServerManager {
    private static AppiumDriverLocalService appiumDriverLocalService;

    private static final String IP_ADDRESS = "127.0.0.1";
    private static final String APPIUM_JS = "C:/Users/48608/AppData/Roaming/npm/node_modules/appium/build/lib/main.js";
    private static final String DRIVER_EXECUTABLE_PATH = "C:/Program Files/nodejs/node.exe";
    private static final int PORT = 4723;
    private static final int DURATION = 100;

    public static void run() {

        AppiumServiceBuilder builder = new AppiumServiceBuilder();

        builder
                .withIPAddress(IP_ADDRESS)
                .withAppiumJS(new File(APPIUM_JS))
                .withTimeout(Duration.ofSeconds(DURATION))
                .usingDriverExecutable(new File(DRIVER_EXECUTABLE_PATH))
                .usingPort(PORT);

        /*builder.withIPAddress(IP_ADDRESS);
        builder.withAppiumJS(new File(APPIUM_JS));
        builder.usingDriverExecutable(new File(DRIVER_EXECUTABLE_PATH);
        builder.usingPort(PORT);
        builder.withTimeout(Duration.ofSeconds(DURATION));*/

        appiumDriverLocalService = AppiumDriverLocalService.buildService(builder);
        appiumDriverLocalService.start();
    }

    public static void shutDown() {

        appiumDriverLocalService.stop();
    }
}

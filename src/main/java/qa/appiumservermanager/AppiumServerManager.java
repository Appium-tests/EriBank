package qa.appiumservermanager;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import java.io.File;
import java.time.Duration;

public class AppiumServerManager {
    private static AppiumDriverLocalService appiumDriverLocalService;

    private static final String IP_ADDRESS = "127.0.0.1";
    private static final String APPIUM_JS = "/home/pawelaksman/node_modules/appium/build/lib/main.js";
    private static final String DRIVER_EXECUTABLE_PATH = "/home/pawelaksman/.nvm/versions/node/v20.11.0/bin/node";
    private static final int PORT = 4724;
    private static final int DURATION = 200;

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

package qa.support;

import java.io.IOException;

public class AdbUninstallUIAutomator {

    public static void uninstall() {

        try {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("adb uninstall io.appium.uiautomator2.server");
            runtime.exec("adb uninstall io.appium.uiautomator2.server.test");
        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
        }
    }
}

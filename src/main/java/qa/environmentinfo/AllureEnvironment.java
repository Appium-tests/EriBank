package qa.environmentinfo;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class AllureEnvironment {

    private static ImmutableMap<String, String> map;

    public static void setEnvironment(AndroidDriver driver) {

        if (map == null) {

            map = ImmutableMap.<String, String>builder()
                    .put("Desktop available processors (core)", String.valueOf(Runtime.getRuntime().availableProcessors()))
                    .put("Desktop maximum memory", String.valueOf(Runtime.getRuntime().maxMemory()))
                    .put("Desktop total memory", String.valueOf(Runtime.getRuntime().totalMemory()))
                    .put("Desktop free memory", String.valueOf(Runtime.getRuntime().freeMemory()))
                    .put("Desktop operating system", System.getProperty("os.name") + " " + System.getProperty("os.arch"))
                    .put("Java runtime version", System.getProperty("java.runtime.version"))
                    .put("Mobile device name", driver.getCapabilities().getCapability("deviceName").toString())
                    .put("Mobile platform name", driver.getCapabilities().getCapability("platformName").toString())
                    .put("Mobile platform version", driver.getCapabilities().getCapability("platformVersion").toString())
                    .put("Mobile battery state", driver.getBatteryInfo().getState().toString())
                    .put("Mobile battery level", String.valueOf(driver.getBatteryInfo().getLevel()))
                    .build();
        }

        /*allureEnvironmentWriter(

                ImmutableMap.<String, String>builder()
                        .put("Desktop available processors (core)", String.valueOf(Runtime.getRuntime().availableProcessors()))
                        .put("Desktop maximum memory", String.valueOf(Runtime.getRuntime().maxMemory()))
                        .put("Desktop total memory", String.valueOf(Runtime.getRuntime().totalMemory()))
                        .put("Desktop free memory", String.valueOf(Runtime.getRuntime().freeMemory()))
                        .put("Desktop operating system", System.getProperty("os.name") + " " + System.getProperty("os.arch"))
                        .put("Java runtime version", System.getProperty("java.runtime.version"))
                        .put("Mobile platform: ", "Android 12")
                        .build()
        );*/
    }

    public static void write() {

        allureEnvironmentWriter(map);
    }
}

package qa.environmentinfo;

import com.google.common.collect.ImmutableMap;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class AllureEnvironment {

    public static void setEnvironment() {

        allureEnvironmentWriter(

                ImmutableMap.<String, String>builder()
                        .put("Desktop available processors (core)", String.valueOf(Runtime.getRuntime().availableProcessors()))
                        .put("Desktop maximum memory", String.valueOf(Runtime.getRuntime().maxMemory()))
                        .put("Desktop total memory", String.valueOf(Runtime.getRuntime().totalMemory()))
                        .put("Desktop free memory", String.valueOf(Runtime.getRuntime().freeMemory()))
                        .put("Desktop operating system", System.getProperty("os.name") + " " + System.getProperty("os.arch"))
                        .put("Java runtime version", System.getProperty("java.runtime.version"))
                        .put("Mobile platform: ", "Android 12")
                        .build()
        );
    }
}

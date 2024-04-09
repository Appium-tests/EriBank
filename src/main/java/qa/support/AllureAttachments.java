package qa.support;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class AllureAttachments {

    public static void takeScreenshot(AndroidDriver driver, String fileName) throws IOException {

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Allure.attachment(fileName + ".png", FileUtils.openInputStream(file));
    }
}

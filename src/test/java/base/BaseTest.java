package base;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;
import qa.appiumservermanager.AppiumServerManager;
import qa.driver.Driver;
import qa.environmentinfo.AllureEnvironment;
import qa.environmentinfo.EnvironmentInfo;
import qa.support.AdbUninstallUIAutomator;
import qa.support.TestDataLoader;
import qa.support.FileReader;

import java.io.IOException;
import java.net.MalformedURLException;


public class BaseTest {

    private AndroidDriver driver;

    @Parameters({"fileName"})
    @BeforeSuite
    public void start(@Optional("noFile")String fileName) throws IOException {

        if (!fileName.equals("noFile")) {
            FileReader.load(fileName);
        }

        AdbUninstallUIAutomator.uninstall();
        AppiumServerManager.run();
        TestDataLoader.read();
    }

    @AfterSuite
    public void quit() {

        AppiumServerManager.shutDown();
        AllureEnvironment.write();
    }

    @BeforeMethod
    public void setUp() throws MalformedURLException {

        driver = Driver.createDriver();

        EnvironmentInfo.logInfo(driver);
        AllureEnvironment.setEnvironment(driver);
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

    protected AndroidDriver getDriver() {

        return driver;
    }
}

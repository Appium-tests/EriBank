package base;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;
import qa.appiumservermanager.AppiumServerManager;
import qa.driver.Driver;
import qa.environmentinfo.AllureEnvironment;
import qa.environmentinfo.EnvironmentInfo;
import qa.support.AdbUninstallUIAutomator;
import qa.support.FileReader;

import java.net.MalformedURLException;


public class BaseTest {

    private AndroidDriver driver;


    @BeforeSuite
    public void start() {

        AdbUninstallUIAutomator.uninstall();
        AppiumServerManager.run();
    }

    @Parameters({"fileName"})
    @BeforeClass
    public void loadTestData(@Optional("noFile")String fileName) {

        if (!fileName.equals("noFile")) {
            FileReader.load(fileName);
        }
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

package qa.base;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import qa.driver.Driver;
import qa.json.JSONReader;
import java.io.IOException;
import java.net.MalformedURLException;


public class BaseTest {

    private AndroidDriver driver;

    @BeforeClass
    public void readJSON() throws IOException {

        JSONReader.read();
    }

    @BeforeMethod
    public void setUp() throws MalformedURLException {

        driver = Driver.createDriver();
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

    protected AndroidDriver getDriver() {

        return driver;
    }
}

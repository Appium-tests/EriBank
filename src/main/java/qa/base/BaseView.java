package qa.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BaseView {

    private final AndroidDriver driver;

    public BaseView(AndroidDriver driver) {
        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public AndroidDriver getDriver() {
        return driver;
    }
}

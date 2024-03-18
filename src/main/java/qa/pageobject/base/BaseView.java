package qa.pageobject.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public class BaseView {

    private final AndroidDriver DRIVER;
    private final WebDriverWait WEB_DRIVER_WAIT;

    public BaseView(AndroidDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.DRIVER = driver;
        WEB_DRIVER_WAIT = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
}

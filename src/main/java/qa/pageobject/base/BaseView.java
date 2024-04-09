package qa.pageobject.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public class BaseView {

    private final AndroidDriver driver;
    private final WebDriverWait webDriverWait;

    public BaseView(AndroidDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
}

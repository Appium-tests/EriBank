package qa.pageobject.base;

import io.appium.java_client.AppiumBy;
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

    @io.qameta.allure.Step("Swipe to desired element")
    @io.qase.api.annotation.Step("Swipe to desired element")
    public void swipeToElement(String name) {

        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""
                + name + "\"))"));
    }
}

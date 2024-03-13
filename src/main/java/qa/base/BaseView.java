package qa.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.support.PageFactory;

@Getter
public class BaseView {

    private final AndroidDriver DRIVER;

    public BaseView(AndroidDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.DRIVER = driver;
    }
}

package qa.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BaseView {

    public BaseView(AndroidDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}

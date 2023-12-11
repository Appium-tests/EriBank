package qa.pageobject.beforetesting;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import qa.base.BaseView;

public class AndroidOldVersionWarningFrame extends BaseView {
    public AndroidOldVersionWarningFrame(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "android:id/button1")
    WebElement buttonOK;

    public void tapButtonOK() {
        buttonOK.click();
    }
}

package qa.pageobject.beforetesting;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import qa.base.BaseView;

public class AccessPermissionsFrame extends BaseView {

    public AccessPermissionsFrame(AndroidDriver driver) {

        super(driver);
    }

    @AndroidFindBy(id = "android:id/switch_widget")
    WebElement switchButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/continue_button")
    WebElement continueButton;

    public boolean isSwitchButtonOn() {

        return switchButton.getAttribute("checked").equals("true");
    }

    public void tapSwitchButton() {

        switchButton.click();
    }

    public void tapContinueButton() {

        continueButton.click();
    }
}

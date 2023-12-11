package qa.pageobject.beforetesting;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import qa.base.BaseView;

public class PasswordSavingAdviceFrame extends BaseView {

    public PasswordSavingAdviceFrame(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "android:id/autofill_dialog_no")
    WebElement buttonNO;

    public void tapButtonNO() {
        buttonNO.click();
    }
}

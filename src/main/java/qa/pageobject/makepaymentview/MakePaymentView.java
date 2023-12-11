package qa.pageobject.makepaymentview;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import qa.base.BaseView;

import java.util.List;

public class MakePaymentView extends BaseView {

    public MakePaymentView(AndroidDriver driver) {

        super(driver);
    }

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/makePaymentView")
    List<WebElement> parent;

    public boolean isDisplayed() {

        return !parent.isEmpty();
    }
}

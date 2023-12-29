package qa.pageobject.advancedactionsview;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import qa.base.BaseView;

import java.util.List;

public class AdvancedActionsView extends BaseView {

    public AdvancedActionsView(AndroidDriver driver) {

        super(driver);
    }

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/RecordAudioutton")
    List<WebElement> sendVoidRequestButton;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/OpenBrowserButton")
    List<WebElement> eriBankBrowserButton;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/BackButton")
    List<WebElement> backButton;

    public void tapSendVoidRequestButton() {

        sendVoidRequestButton.get(0).click();
    }

    public void tapEriBankBrowserButton() {

        eriBankBrowserButton.get(0).click();
    }

    public void tapBackButton() {

        backButton.get(0).click();
    }

    public boolean isDisplayed() {

        return !sendVoidRequestButton.isEmpty() && !eriBankBrowserButton.isEmpty() && !backButton.isEmpty();
    }
}

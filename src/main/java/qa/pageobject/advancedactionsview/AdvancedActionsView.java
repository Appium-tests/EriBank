package qa.pageobject.advancedactionsview;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import qa.pageobject.base.BaseView;

import java.util.List;

public class AdvancedActionsView extends BaseView {

    public AdvancedActionsView(AndroidDriver driver) {

        super(driver);
    }

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/RecordAudioutton")
    List<WebElement> sendVoidRequestButton;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/BackButton")
    List<WebElement> backButton;

    @io.qameta.allure.Step("Touch the \"Send Void Request\" button")
    @io.qase.api.annotation.Step("Touch the \"Send Void Request\" button")
    public void touchSendVoidRequestButton() {

        sendVoidRequestButton.get(0).click();
    }

    @io.qameta.allure.Step("Touch the \"Back\" button")
    @io.qase.api.annotation.Step("Touch the \"Back\" button")
    public void touchBackButton() {

        backButton.get(0).click();
    }

    public boolean isDisplayed() {

        return !sendVoidRequestButton.isEmpty() && !backButton.isEmpty();
    }
}

package qa.pageobject.sendvoidrequestview;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import qa.pageobject.base.BaseView;

import java.util.List;

public class SendVoidRequestView extends BaseView {

    public SendVoidRequestView(AndroidDriver driver) {

        super(driver);
    }

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/recordButton")
    List<WebElement> recordButton;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/stopButton")
    List<WebElement> stopButton;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/playButton")
    List<WebElement> playButton;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/sendButton")
    List<WebElement> sendButton;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/BackButton")
    List<WebElement> backButton;

    public boolean isDisplayed() {

        return !recordButton.isEmpty() &&
               !stopButton.isEmpty() &&
               !playButton.isEmpty() &&
               !sendButton.isEmpty() &&
               !backButton.isEmpty();
    }
}

package qa.pageobject.makepaymentview;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.pageobject.base.BaseView;

import java.util.List;

public class QuestionFrame extends BaseView {

    public QuestionFrame(AndroidDriver driver) {

        super(driver);
    }

    @AndroidFindBy(className = "android.widget.FrameLayout")
    List<WebElement> parentPanel;

    @AndroidFindBy(id = "android:id/alertTitle")
    WebElement title;

    @AndroidFindBy(id = "android:id/message")
    WebElement message;

    @AndroidFindBy(id = "android:id/button1")
    WebElement buttonYES;

    @AndroidFindBy(id = "android:id/button2")
    WebElement buttonNO;

    public boolean isDisplayed() {

        return !parentPanel.isEmpty();
    }

    public String getTitle() {

        return title.getText();
    }

    public String getMessage() {

        return message.getText();
    }

    @io.qameta.allure.Step("Touch the \"Yes\" button")
    @io.qase.api.annotation.Step("Touch the \"Yes\" button")
    public void touchButtonYES() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(buttonYES)).click();
    }

    @io.qameta.allure.Step("Touch the \"No\" button")
    @io.qase.api.annotation.Step("Touch the \"No\" button")
    public void touchButtonNO() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(buttonNO)).click();
    }
}

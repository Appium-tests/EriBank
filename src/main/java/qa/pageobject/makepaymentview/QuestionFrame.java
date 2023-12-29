package qa.pageobject.makepaymentview;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import qa.base.BaseView;

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
    List<WebElement> buttonYES;

    @AndroidFindBy(id = "android:id/button2")
    List<WebElement> buttonNO;

    public boolean isDisplayed() {

        return !parentPanel.isEmpty();
    }

    public boolean isButtonYESDisplayed() {

        return !buttonYES.isEmpty();
    }

    public boolean isButtonNODisplayed() {

        return !buttonNO.isEmpty();
    }

    public String getTitle() {

        return title.getText();
    }

    public String getMessage() {

        return message.getText();
    }

    public void tapButtonYES() {

        buttonYES.get(0).click();
    }

    public void tapButtonNO() {

        buttonNO.get(0).click();
    }
}

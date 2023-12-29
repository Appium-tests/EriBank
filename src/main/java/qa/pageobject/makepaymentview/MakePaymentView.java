package qa.pageobject.makepaymentview;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import qa.base.BaseView;
import qa.pageobject.loginview.AlertFrame;

import java.util.List;

public class MakePaymentView extends BaseView {

    public final QuestionFrame questionFrame;
    public final AlertFrame alertFrame;

    public MakePaymentView(AndroidDriver driver) {

        super(driver);

        questionFrame = new QuestionFrame(driver);
        alertFrame = new AlertFrame(driver);
    }

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/makePaymentView")
    List<WebElement> parent;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/phoneTextField")
    WebElement phoneField;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/nameTextField")
    WebElement nameField;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/amountTextField")
    WebElement amountField;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/countryTextField")
    WebElement countryField;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/sendPaymentButton")
    WebElement sendPaymentButton;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/cancelButton")
    WebElement cancelButton;

    public void setPhone(String phone) {

        phoneField.sendKeys(phone);
    }

    public void setName(String name) {

        nameField.sendKeys(name);
    }

    public void setAmount(String amount) {

        amountField.sendKeys(amount);
    }

    public void setCountry(String country) {

        countryField.sendKeys(country);
    }

    public boolean isSendPaymentButtonEnabled() {

        return sendPaymentButton.isEnabled();
    }

    public void tapSendPaymentButton() {

        sendPaymentButton.click();
    }

    public void tapCancelButton() {

        cancelButton.click();
    }

    public boolean isDisplayed() {

        return !parent.isEmpty();
    }

    public QuestionFrame getQuestionFrame() {

        return questionFrame;
    }

    public AlertFrame getAlertFrame() {

        return alertFrame;
    }
}

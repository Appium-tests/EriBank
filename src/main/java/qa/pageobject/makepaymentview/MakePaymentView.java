package qa.pageobject.makepaymentview;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import qa.base.BaseView;
import qa.pageobject.loginview.AlertFrame;

import java.util.List;

public class MakePaymentView extends BaseView {

    @Getter
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

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/countryButton")
    WebElement selectButton;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/countryTextField")
    WebElement countryField;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/sendPaymentButton")
    WebElement sendPaymentButton;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/cancelButton")
    WebElement cancelButton;

    @io.qameta.allure.Step("Enter a phone")
    @io.qase.api.annotation.Step("Enter a phone")
    public void setPhone(String phone) {

        phoneField.sendKeys(phone);
    }

    @io.qameta.allure.Step("Enter a name")
    @io.qase.api.annotation.Step("Enter a name")
    public void setName(String name) {

        nameField.sendKeys(name);
    }

    @io.qameta.allure.Step("Enter an amount")
    @io.qase.api.annotation.Step("Enter an amount")
    public void setAmount(String amount) {

        amountField.sendKeys(amount);
    }

    @io.qameta.allure.Step("Enter a country")
    @io.qase.api.annotation.Step("Enter a country")
    public void setCountry(String country) {

        countryField.sendKeys(country);
    }

    public boolean isSendPaymentButtonEnabled() {

        return sendPaymentButton.isEnabled();
    }

    @io.qameta.allure.Step("Touch the \"Select\" button")
    @io.qase.api.annotation.Step("Touch the \"Select\" button")
    public void touchSelectButton() {

        selectButton.click();
    }

    @io.qameta.allure.Step("Touch the \"Send Payment\" button")
    @io.qase.api.annotation.Step("Touch the \"Send Payment\" button")
    public void touchSendPaymentButton() {

        sendPaymentButton.click();
    }

    @io.qameta.allure.Step("Touch the \"Cancel\" button")
    @io.qase.api.annotation.Step("Touch the \"Cancel\" button")
    public void touchCancelButton() {

        cancelButton.click();
    }

    public String getCountryNameFromCountryField() {

        return countryField.getText();
    }

    public boolean isDisplayed() {

        return !parent.isEmpty();
    }

    public AlertFrame getAlertFrame() {

        return alertFrame;
    }
}

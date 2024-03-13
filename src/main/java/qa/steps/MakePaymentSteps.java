package qa.steps;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import lombok.Getter;
import qa.pageobject.makepaymentview.MakePaymentView;

@Getter
public class MakePaymentSteps {

    private final MakePaymentView makePaymentView;

    public MakePaymentSteps(AndroidDriver driver) {

        makePaymentView = new MakePaymentView(driver);
    }

    @Step("Set phone")
    public void setPhone(String phone) {

        makePaymentView.setPhone(phone);
    }

    @Step("Set name")
    public void setName(String name) {

        makePaymentView.setName(name);
    }

    @Step("Set amount")
    public void setAmount(String amount) {

        makePaymentView.setAmount(amount);
    }

    @Step("Tap the \"Select\" button")
    public void tapSelectButton() {

        makePaymentView.touchSelectButton();
    }

    @Step("Set country")
    public void setCountry(String country) {

        makePaymentView.setCountry(country);
    }

    @Step("Tap the \"Send payment\" button")
    public void tapSendPaymentButton() {

        makePaymentView.touchSendPaymentButton();
    }

    @Step("Tap the \"Cancel\" button")
    public void tapCancelButton() {

        makePaymentView.touchCancelButton();
    }

}

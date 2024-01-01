package qa.steps;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import qa.pageobject.mortagerequest.MortageRequestView;

public class MortageRequestSteps {

    private final MortageRequestView mortageRequestView;

    public MortageRequestSteps(AndroidDriver driver) {

        mortageRequestView = new MortageRequestView(driver);
    }

    @Step("Set first name")
    public void setFirstName(String firstName) {

        mortageRequestView.setFirstName(firstName);
    }

    @Step("Set last name")
    public void setLastName(String lastName) {

        mortageRequestView.setLastName(lastName);
    }

    @Step("Set age")
    public void setAge(String age) {

        mortageRequestView.setAge(age);
    }

    @Step("Set address")
    public void setAddress(String address) {

        mortageRequestView.setAddress1(address);
    }

    @Step("Fill the second address field")
    public void fillSecondAddressField(String address) {

        mortageRequestView.setAddress2(address);
    }

    @Step("Set country")
    public void setCountry(String country) {

        mortageRequestView.setCountry(country);
    }

    @Step("Tap the\"Next\" button")
    public void tapButtonNext() {

        mortageRequestView.tapButtonNext();
    }

    @Step("Tap the \"Cancel\" button")
    public void tapButtonCancel() {

        mortageRequestView.tapButtonCancel();
    }

    public MortageRequestView getMortageRequestView() {

        return mortageRequestView;
    }
}

package qa.steps;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import qa.pageobject.mortgagerequest.MortgageRequestView;

public class MortgageRequestSteps {

    private final MortgageRequestView mortgageRequestView;

    public MortgageRequestSteps(AndroidDriver driver) {

        mortgageRequestView = new MortgageRequestView(driver);
    }

    @Step("Set first name")
    public void setFirstName(String firstName) {

        mortgageRequestView.setFirstName(firstName);
    }

    @Step("Set last name")
    public void setLastName(String lastName) {

        mortgageRequestView.setLastName(lastName);
    }

    @Step("Set age")
    public void setAge(String age) {

        mortgageRequestView.setAge(age);
    }

    @Step("Set address")
    public void setAddress(String address) {

        mortgageRequestView.setAddress1(address);
    }

    @Step("Fill the second address field")
    public void fillSecondAddressField(String address) {

        mortgageRequestView.setAddress2(address);
    }

    @Step("Set country")
    public void setCountry(String country) {

        mortgageRequestView.setCountry(country);
    }

    @Step("Tap the\"Next\" button")
    public void tapButtonNext() {

        mortgageRequestView.tapButtonNext();
    }

    @Step("Tap the \"Cancel\" button")
    public void tapButtonCancel() {

        mortgageRequestView.tapButtonCancel();
    }

    public MortgageRequestView getMortgageRequestView() {

        return mortgageRequestView;
    }
}

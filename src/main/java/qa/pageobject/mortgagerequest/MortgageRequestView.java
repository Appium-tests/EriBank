package qa.pageobject.mortgagerequest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.pageobject.base.BaseView;
import qa.pageobject.loginview.AlertFrame;

import java.util.List;

public class MortgageRequestView extends BaseView {

    @Getter
    private final AlertFrame alertFrame;

    public MortgageRequestView(AndroidDriver driver) {

        super(driver);

        alertFrame = new AlertFrame(driver);
    }

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/makePaymentView")
    List<WebElement> parent;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/nameTextField")
    WebElement firstNameField;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/lastNameTextField")
    WebElement lastNameField;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/ageTextField")
    WebElement ageField;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/addressOneTextField")
    WebElement addressField1;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/addressTwoTextField")
    WebElement addressField2;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/countryButton")
    WebElement selectButton;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/countryTextField")
    WebElement countryField;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/nextButton")
    WebElement nextButton;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/cancelButton")
    WebElement cancelButton;

    @io.qameta.allure.Step("Enter a first name")
    @io.qase.api.annotation.Step("Enter a first name")
    public MortgageRequestView setFirstName(String firstName) {

        getWEB_DRIVER_WAIT().until(ExpectedConditions.visibilityOf(firstNameField)).sendKeys(firstName);
        return this;
    }

    @io.qameta.allure.Step("Enter a last name")
    @io.qase.api.annotation.Step("Enter a last name")
    public MortgageRequestView setLastName(String lastName) {

        getWEB_DRIVER_WAIT().until(ExpectedConditions.visibilityOf(lastNameField)).sendKeys(lastName);
        return this;
    }

    @io.qameta.allure.Step("Enter an age")
    @io.qase.api.annotation.Step("Enter an age")
    public MortgageRequestView setAge(String age) {

        getWEB_DRIVER_WAIT().until(ExpectedConditions.visibilityOf(ageField)).sendKeys(age);
        return this;
    }

    @io.qameta.allure.Step("Enter an address 1")
    @io.qase.api.annotation.Step("Enter an address 1")
    public MortgageRequestView setAddress1(String address) {

        getWEB_DRIVER_WAIT().until(ExpectedConditions.visibilityOf(addressField1)).sendKeys(address);
        return this;
    }

    @io.qameta.allure.Step("Enter an address 2")
    @io.qase.api.annotation.Step("Enter an address 2")
    public MortgageRequestView setAddress2(String address) {

        getWEB_DRIVER_WAIT().until(ExpectedConditions.visibilityOf(addressField2)).sendKeys(address);
        return this;
    }

    @io.qameta.allure.Step("Enter a country")
    @io.qase.api.annotation.Step("Enter a country")
    public MortgageRequestView setCountry(String country) {

        getWEB_DRIVER_WAIT().until(ExpectedConditions.visibilityOf(countryField)).sendKeys(country);
        return this;
    }

    @io.qameta.allure.Step("Touch the \"Select\" button")
    @io.qase.api.annotation.Step("Touch the \"Select\" button")
    public MortgageRequestView touchSelectButton() {

        getWEB_DRIVER_WAIT().until(ExpectedConditions.elementToBeClickable(selectButton)).click();
        return this;
    }

    @io.qameta.allure.Step("Touch the \"Next\" button")
    @io.qase.api.annotation.Step("Touch the \"Next\" button")
    public MortgageRequestView touchNextButton() {

        getWEB_DRIVER_WAIT().until(ExpectedConditions.elementToBeClickable(nextButton)).click();
        return this;
    }

    public boolean isNextButtonEnabled() {

        return nextButton.isEnabled();
    }

    public void touchCancelButton() {

        getWEB_DRIVER_WAIT().until(ExpectedConditions.elementToBeClickable(cancelButton)).click();
    }

    public String getCountryNameFromCountryField() {

        return countryField.getText();
    }

    public boolean isDisplayed() {

        return !parent.isEmpty();
    }
}

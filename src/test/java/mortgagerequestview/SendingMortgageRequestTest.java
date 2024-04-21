package mortgagerequestview;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import qa.enums.View;
import qa.support.Authentication;
import qa.support.HomeViewManager;
import qa.pageobject.mortgagerequest.MortgageRequestView;
import qa.pageobject.mortgagesummaryview.MortgageSummaryView;
import qa.dataproviders.MortgageRequestDataProviders;
import qa.models.MortgageRequest;
import qa.support.DataProviderNames;

@Epic("E2E")
@Feature("Sending Mortgage Request")
public class SendingMortgageRequestTest extends BaseTest {

    private MortgageRequestView mortgageRequestView;

    @BeforeMethod
    public void create() throws JsonProcessingException {

        Authentication.perform(getDriver());
        HomeViewManager.open(getDriver(), View.MORTGAGE_REQUEST);
        mortgageRequestView = new MortgageRequestView(getDriver());
    }

    private void setAllureParameters(MortgageRequest mortgageRequest) {

        Allure.parameter("First name", mortgageRequest.getFirstName());
        Allure.parameter("Last name", mortgageRequest.getLastName());
        Allure.parameter("Age", mortgageRequest.getAge());
        Allure.parameter("Address 1", mortgageRequest.getAddress1());
        Allure.parameter("Address 2", mortgageRequest.getAddress2());
        Allure.parameter("Country", mortgageRequest.getCountry());
    }

    private void fill(MortgageRequest mortgageRequest) {

        mortgageRequestView
                .setFirstName(mortgageRequest.getFirstName())
                .setLastName(mortgageRequest.getLastName())
                .setAge(mortgageRequest.getAge())
                .setAddress1(mortgageRequest.getAddress1())
                .setAddress2(mortgageRequest.getAddress2())
                .setCountry(mortgageRequest.getCountry());
    }

    @io.qameta.allure.Step("Check the \"Next\" button status")
    @io.qase.api.annotation.Step("Check the \"Next\" button status")
    private void checkNextButtonStatus(boolean expectedStatus) {

        Assert.assertEquals(mortgageRequestView.isNextButtonEnabled(), expectedStatus, "Incorrect the \"Next\" button status");
    }

    private void checkAlertFrame(String expectedMessage) {

        Assert.assertTrue(mortgageRequestView.getErrorMessageBox().isDisplayed(), "The alert is not displayed");
        Assert.assertEquals(mortgageRequestView.getErrorMessageBox().getMessage(), expectedMessage, "Incorrect message content");
    }

    @Test(priority = 1, dataProvider = DataProviderNames.CORRECT, dataProviderClass = MortgageRequestDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Correct data")
    @QaseId(34)
    @QaseTitle("Correct data")
    public void correct(MortgageRequest mortgageRequest) {

        setAllureParameters(mortgageRequest);

        fill(mortgageRequest);
        checkNextButtonStatus(true);
        mortgageRequestView.touchNextButton();

        MortgageSummaryView mortgageSummaryView = new MortgageSummaryView(getDriver());

        try {
            mortgageSummaryView.waitForTypeOfLoanSectionListView();
        } catch (Exception e) {
            Assert.fail("The \"Mortgage summary view\" is not opened");
        }
    }

    @Test(priority = 2, dataProvider = DataProviderNames.INCORRECT_FIRST_NAME, dataProviderClass = MortgageRequestDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Incorrect first name")
    @QaseId(35)
    @QaseTitle("Incorrect first name")
    public void incorrectFirstName(MortgageRequest mortgageRequest) {

        setAllureParameters(mortgageRequest);

        fill(mortgageRequest);
        checkNextButtonStatus(true);
        mortgageRequestView.touchNextButton();
        checkAlertFrame("Incorrect first name");
    }

    @Test(priority = 3, dataProvider = DataProviderNames.CORRECT, dataProviderClass = MortgageRequestDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Blank the \"First Name\" field")
    @QaseId(36)
    @QaseTitle("Blank the \"First Name\" field")
    public void blankFirstNameField(MortgageRequest mortgageRequest) {

        setAllureParameters(mortgageRequest);

        mortgageRequestView
                .setLastName(mortgageRequest.getLastName())
                .setAge(mortgageRequest.getAge())
                .setAddress1(mortgageRequest.getAddress1())
                .setAddress2(mortgageRequest.getAddress2())
                .setCountry(mortgageRequest.getCountry());

        checkNextButtonStatus(false);
    }

    @Test(priority = 4, dataProvider = DataProviderNames.INCORRECT_LAST_NAME, dataProviderClass = MortgageRequestDataProviders.class)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Incorrect last name")
    @QaseId(37)
    @QaseTitle("Incorrect last name")
    public void incorrectLastName(MortgageRequest mortgageRequest) {

        setAllureParameters(mortgageRequest);

        fill(mortgageRequest);
        checkNextButtonStatus(true);
        mortgageRequestView.touchNextButton();
        checkAlertFrame("Incorrect last name");
    }

    @Test(priority = 5, dataProvider = DataProviderNames.CORRECT, dataProviderClass = MortgageRequestDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Blank the \"Last Name\" field")
    @QaseId(38)
    @QaseTitle("Blank the \"Last Name\" field")
    public void blankLastNameField(MortgageRequest mortgageRequest) {

        setAllureParameters(mortgageRequest);

        mortgageRequestView
                .setFirstName(mortgageRequest.getFirstName())
                .setAge(mortgageRequest.getAge())
                .setAddress1(mortgageRequest.getAddress1())
                .setAddress2(mortgageRequest.getAddress2())
                .setCountry(mortgageRequest.getCountry());

        checkNextButtonStatus(false);
    }

    @Test(priority = 8, dataProvider = DataProviderNames.INCORRECT_AGE, dataProviderClass = MortgageRequestDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Incorrect age")
    @QaseId(39)
    @QaseTitle("Incorrect age")
    public void incorrectAge(MortgageRequest mortgageRequest) {

        setAllureParameters(mortgageRequest);

        fill(mortgageRequest);
        checkNextButtonStatus(true);
        mortgageRequestView.touchNextButton();
        checkAlertFrame("Incorrect age");
    }

    @Test(priority = 9, dataProvider = DataProviderNames.CORRECT, dataProviderClass = MortgageRequestDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Blank the \"Age\" field")
    @QaseId(40)
    @QaseTitle("Blank the \"Age\" field")
    public void blankAgeField(MortgageRequest mortgageRequest) {

        setAllureParameters(mortgageRequest);

        mortgageRequestView
                .setFirstName(mortgageRequest.getFirstName())
                .setAge(mortgageRequest.getAge())
                .setAddress1(mortgageRequest.getAddress1())
                .setAddress2(mortgageRequest.getAddress2())
                .setCountry(mortgageRequest.getCountry());

        checkNextButtonStatus(false);
    }

    @Test(priority = 6, dataProvider = DataProviderNames.INCORRECT_ADDRESS_1, dataProviderClass = MortgageRequestDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Blank the \"Age\" field")
    @QaseId(41)
    @QaseTitle("Incorrect address 1")
    public void incorrectAddress1(MortgageRequest mortgageRequest) {

        setAllureParameters(mortgageRequest);

        fill(mortgageRequest);
        checkNextButtonStatus(true);
        mortgageRequestView.touchNextButton();
        checkAlertFrame("Incorrect address 1");
    }

    @Test(priority = 7, dataProvider = DataProviderNames.CORRECT, dataProviderClass = MortgageRequestDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Blank the \"Address 1\" field")
    @QaseId(42)
    @QaseTitle("Blank the \"Address 1\" field")

    public void blankAddress1Field(MortgageRequest mortgageRequest) {

        setAllureParameters(mortgageRequest);

        mortgageRequestView
                .setFirstName(mortgageRequest.getFirstName())
                .setLastName(mortgageRequest.getLastName())
                .setAge(mortgageRequest.getAge())
                .setAddress2(mortgageRequest.getAddress2())
                .setCountry(mortgageRequest.getCountry());

        checkNextButtonStatus(false);
    }

    @Test(priority = 12, dataProvider = DataProviderNames.INCORRECT_ADDRESS_2, dataProviderClass = MortgageRequestDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Incorrect address 2")
    @QaseId(43)
    @QaseTitle("Incorrect address 2")
    public void incorrectAddress2(MortgageRequest mortgageRequest) {

        setAllureParameters(mortgageRequest);

        fill(mortgageRequest);
        checkNextButtonStatus(true);
        mortgageRequestView.touchNextButton();
        checkAlertFrame("Incorrect address 2");
    }

    @Test(priority = 13, dataProvider = DataProviderNames.CORRECT, dataProviderClass = MortgageRequestDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Blank the \"Address 2\" field")
    @QaseId(44)
    @QaseTitle("Blank the \"Address 2\" field")
    public void blankAddress2Field(MortgageRequest mortgageRequest) {

        setAllureParameters(mortgageRequest);

        mortgageRequestView
                .setFirstName(mortgageRequest.getFirstName())
                .setLastName(mortgageRequest.getLastName())
                .setAge(mortgageRequest.getAge())
                .setAddress1(mortgageRequest.getAddress1())
                .setCountry(mortgageRequest.getCountry());

        checkNextButtonStatus(false);
    }

    @Test(priority = 10, dataProvider = DataProviderNames.INCORRECT_COUNTRY, dataProviderClass = MortgageRequestDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Incorrect country")
    @QaseId(45)
    @QaseTitle("Incorrect country")
    public void incorrectCountry(MortgageRequest mortgageRequest) {

        setAllureParameters(mortgageRequest);

        fill(mortgageRequest);
        checkNextButtonStatus(true);
        mortgageRequestView.touchNextButton();
        checkAlertFrame("Incorrect country");
    }

    @Test(priority = 11, dataProvider = DataProviderNames.CORRECT, dataProviderClass = MortgageRequestDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Blank the \"Country\" field")
    @QaseId(46)
    @QaseTitle("Blank the \"Country\" field")
    public void blankCountryField(MortgageRequest mortgageRequest) {

        setAllureParameters(mortgageRequest);

        mortgageRequestView
                .setFirstName(mortgageRequest.getFirstName())
                .setLastName(mortgageRequest.getLastName())
                .setAge(mortgageRequest.getAge())
                .setAddress1(mortgageRequest.getAddress1())
                .setAddress2(mortgageRequest.getAddress2());

        checkNextButtonStatus(false);
    }
}

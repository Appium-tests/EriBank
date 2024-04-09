package mortgagerequestview;

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
@Feature("Mortgage Request functionalities")
public class MortgageRequestViewTest extends BaseTest {

    private MortgageRequestView mortgageRequestView;

    @BeforeMethod
    public void create() {

        Authentication.perform(getDriver());
        HomeViewManager.open(getDriver(), View.MORTGAGE_REQUEST);

        mortgageRequestView = new MortgageRequestView(getDriver());
    }

    private void fill(MortgageRequest mortgageRequest) {

        mortgageRequestView.setFirstName(mortgageRequest.getFirstName());
        mortgageRequestView.setLastName(mortgageRequest.getLastName());
        mortgageRequestView.setAge(mortgageRequest.getAge());
        mortgageRequestView.setAddress1(mortgageRequest.getAddress1());
        mortgageRequestView.setAddress2(mortgageRequest.getAddress2());
        mortgageRequestView.setCountry(mortgageRequest.getCountry());
    }

    private void setAllureParameters(MortgageRequest mortgageRequest) {

        Allure.parameter("First name", mortgageRequest.getFirstName());
        Allure.parameter("Last name", mortgageRequest.getLastName());
        Allure.parameter("Age", mortgageRequest.getAge());
        Allure.parameter("Address 1", mortgageRequest.getAddress1());
        Allure.parameter("Address 2", mortgageRequest.getAddress2());
        Allure.parameter("Country", mortgageRequest.getCountry());
    }

    @io.qameta.allure.Step("Check the \"Next\" button status")
    @io.qase.api.annotation.Step("Check the \"Next\" button status")
    private void checkNextButtonStatus(boolean expectedStatus) {

        Assert.assertEquals(mortgageRequestView.isNextButtonEnabled(), expectedStatus, "Incorrect the \"Next\" button status");
    }

    private void checkAlertFrame(String expectedMessage) {

        Assert.assertTrue(mortgageRequestView.getAlertFrame().isDisplayed(), "The alert is not displayed");
        Assert.assertEquals(mortgageRequestView.getAlertFrame().getMessage(), expectedMessage, "Incorrect message content");
    }

    @Test(dataProvider = DataProviderNames.CORRECT, dataProviderClass = MortgageRequestDataProviders.class)
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
        Assert.assertTrue(mortgageSummaryView.isDisplayed(), "The \"Mortgage summary view\" is not opened");

    }

    @Test(dataProvider = DataProviderNames.INCORRECT_FIRST_NAME, dataProviderClass = MortgageRequestDataProviders.class)
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

    @Test(dataProvider = DataProviderNames.CORRECT, dataProviderClass = MortgageRequestDataProviders.class)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Blank the \"First Name\" field")
    @QaseId(36)
    @QaseTitle("Blank the \"First Name\" field")
    public void blankFirstNameField(MortgageRequest mortgageRequest) {

        setAllureParameters(mortgageRequest);

        mortgageRequestView.setLastName(mortgageRequest.getLastName());
        mortgageRequestView.setAge(mortgageRequest.getAge());
        mortgageRequestView.setAddress1(mortgageRequest.getAddress1());
        mortgageRequestView.setAddress2(mortgageRequest.getAddress2());
        mortgageRequestView.setCountry(mortgageRequest.getCountry());
        checkNextButtonStatus(false);
    }

    @Test(dataProvider = DataProviderNames.INCORRECT_LAST_NAME, dataProviderClass = MortgageRequestDataProviders.class)
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

    @Test(dataProvider = DataProviderNames.CORRECT, dataProviderClass = MortgageRequestDataProviders.class)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Blank the \"Last Name\" field")
    @QaseId(38)
    @QaseTitle("Blank the \"Last Name\" field")
    public void blankLastNameField(MortgageRequest mortgageRequest) {

        setAllureParameters(mortgageRequest);

        mortgageRequestView.setFirstName(mortgageRequest.getFirstName());
        mortgageRequestView.setAge(mortgageRequest.getAge());
        mortgageRequestView.setAddress1(mortgageRequest.getAddress1());
        mortgageRequestView.setAddress2(mortgageRequest.getAddress2());
        mortgageRequestView.setCountry(mortgageRequest.getCountry());
        checkNextButtonStatus(false);
    }

    @Test(dataProvider = DataProviderNames.INCORRECT_AGE, dataProviderClass = MortgageRequestDataProviders.class)
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

    @Test(dataProvider = DataProviderNames.CORRECT, dataProviderClass = MortgageRequestDataProviders.class)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Blank the \"Age\" field")
    @QaseId(40)
    @QaseTitle("Blank the \"Age\" field")
    public void blankAgeField(MortgageRequest mortgageRequest) {

        setAllureParameters(mortgageRequest);

        mortgageRequestView.setFirstName(mortgageRequest.getFirstName());
        mortgageRequestView.setAge(mortgageRequest.getAge());
        mortgageRequestView.setAddress1(mortgageRequest.getAddress1());
        mortgageRequestView.setAddress2(mortgageRequest.getAddress2());
        mortgageRequestView.setCountry(mortgageRequest.getCountry());
        checkNextButtonStatus(false);
    }

    @Test(dataProvider = DataProviderNames.INCORRECT_ADDRESS_1, dataProviderClass = MortgageRequestDataProviders.class)
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

    @Test(dataProvider = DataProviderNames.CORRECT, dataProviderClass = MortgageRequestDataProviders.class)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Blank the \"Address 1\" field")
    @QaseId(42)
    @QaseTitle("Blank the \"Address 1\" field")

    public void blankAddress1Field(MortgageRequest mortgageRequest) {

        setAllureParameters(mortgageRequest);

        mortgageRequestView.setFirstName(mortgageRequest.getFirstName());
        mortgageRequestView.setLastName(mortgageRequest.getLastName());
        mortgageRequestView.setAge(mortgageRequest.getAge());
        mortgageRequestView.setAddress2(mortgageRequest.getAddress2());
        mortgageRequestView.setCountry(mortgageRequest.getCountry());
        checkNextButtonStatus(false);
    }

    @Test(dataProvider = DataProviderNames.INCORRECT_ADDRESS_2, dataProviderClass = MortgageRequestDataProviders.class)
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

    @Test(dataProvider = DataProviderNames.CORRECT, dataProviderClass = MortgageRequestDataProviders.class)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Blank the \"Address 2\" field")
    @QaseId(44)
    @QaseTitle("Blank the \"Address 2\" field")
    public void blankAddress2Field(MortgageRequest mortgageRequest) {

        setAllureParameters(mortgageRequest);

        mortgageRequestView.setFirstName(mortgageRequest.getFirstName());
        mortgageRequestView.setLastName(mortgageRequest.getLastName());
        mortgageRequestView.setAge(mortgageRequest.getAge());
        mortgageRequestView.setAddress1(mortgageRequest.getAddress1());
        mortgageRequestView.setCountry(mortgageRequest.getCountry());
        checkNextButtonStatus(false);
    }

    @Test(dataProvider = DataProviderNames.INCORRECT_COUNTRY, dataProviderClass = MortgageRequestDataProviders.class)
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

    @Test(dataProvider = DataProviderNames.CORRECT, dataProviderClass = MortgageRequestDataProviders.class)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Blank the \"Country\" field")
    @QaseId(46)
    @QaseTitle("Blank the \"Country\" field")
    public void blankCountryField(MortgageRequest mortgageRequest) {

        setAllureParameters(mortgageRequest);

        mortgageRequestView.setFirstName(mortgageRequest.getFirstName());
        mortgageRequestView.setLastName(mortgageRequest.getLastName());
        mortgageRequestView.setAge(mortgageRequest.getAge());
        mortgageRequestView.setAddress1(mortgageRequest.getAddress1());
        mortgageRequestView.setAddress2(mortgageRequest.getAddress2());
        checkNextButtonStatus(false);
    }
}

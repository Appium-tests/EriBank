package mortgagerequestview;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
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
import qa.pageobject.mortgagerequest.MortgageSummaryView;
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
    @QaseId(34)
    @QaseTitle("Correct data")
    @Description("Correct data")
    public void correct(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        checkNextButtonStatus(true);
        mortgageRequestView.touchNextButton();

        MortgageSummaryView mortgageSummaryView = new MortgageSummaryView(getDriver());
        Assert.assertTrue(mortgageSummaryView.isDisplayed(), "The \"Mortgage summary view\" is not opened");

    }

    @Test(dataProvider = DataProviderNames.INCORRECT_FIRST_NAME, dataProviderClass = MortgageRequestDataProviders.class)
    @QaseId(35)
    @QaseTitle("Incorrect first name")
    @Description("Incorrect first name")
    public void incorrectFirstName(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        checkNextButtonStatus(true);
        mortgageRequestView.touchNextButton();
        checkAlertFrame("Incorrect first name");
    }

    @Test(dataProvider = DataProviderNames.CORRECT, dataProviderClass = MortgageRequestDataProviders.class)
    @QaseId(36)
    @QaseTitle("Blank the \"First Name\" field")
    @Description("Blank the \"First Name\" field")
    public void blankFirstNameField(MortgageRequest mortgageRequest) {

        mortgageRequestView.setLastName(mortgageRequest.getLastName());
        mortgageRequestView.setAge(mortgageRequest.getAge());
        mortgageRequestView.setAddress1(mortgageRequest.getAddress1());
        mortgageRequestView.setAddress2(mortgageRequest.getAddress2());
        mortgageRequestView.setCountry(mortgageRequest.getCountry());
        checkNextButtonStatus(false);
    }

    @Test(dataProvider = DataProviderNames.INCORRECT_LAST_NAME, dataProviderClass = MortgageRequestDataProviders.class)
    @QaseId(37)
    @QaseTitle("Incorrect last name")
    @Description("Incorrect last name")
    public void incorrectLastName(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        checkNextButtonStatus(true);
        mortgageRequestView.touchNextButton();
        checkAlertFrame("Incorrect last name");
    }

    @Test(dataProvider = DataProviderNames.CORRECT, dataProviderClass = MortgageRequestDataProviders.class)
    @QaseId(38)
    @QaseTitle("Blank the \"Last Name\" field")
    @Description("Blank the \"Last Name\" field")
    public void blankLastNameField(MortgageRequest mortgageRequest) {

        mortgageRequestView.setFirstName(mortgageRequest.getFirstName());
        mortgageRequestView.setAge(mortgageRequest.getAge());
        mortgageRequestView.setAddress1(mortgageRequest.getAddress1());
        mortgageRequestView.setAddress2(mortgageRequest.getAddress2());
        mortgageRequestView.setCountry(mortgageRequest.getCountry());
        checkNextButtonStatus(false);
    }

    @Test(dataProvider = DataProviderNames.INCORRECT_AGE, dataProviderClass = MortgageRequestDataProviders.class)
    @QaseId(39)
    @QaseTitle("Incorrect age")
    @Description("Incorrect age")
    public void incorrectAge(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        checkNextButtonStatus(true);
        mortgageRequestView.touchNextButton();
        checkAlertFrame("Incorrect age");
    }

    @Test(dataProvider = DataProviderNames.CORRECT, dataProviderClass = MortgageRequestDataProviders.class)
    @QaseId(40)
    @QaseTitle("Blank the \"Age\" field")
    @Description("Blank the \"Age\" field")
    public void blankAgeField(MortgageRequest mortgageRequest) {

        mortgageRequestView.setFirstName(mortgageRequest.getFirstName());
        mortgageRequestView.setAge(mortgageRequest.getAge());
        mortgageRequestView.setAddress1(mortgageRequest.getAddress1());
        mortgageRequestView.setAddress2(mortgageRequest.getAddress2());
        mortgageRequestView.setCountry(mortgageRequest.getCountry());
        checkNextButtonStatus(false);
    }

    @Test(dataProvider = DataProviderNames.INCORRECT_ADDRESS_1, dataProviderClass = MortgageRequestDataProviders.class)
    @QaseId(41)
    @QaseTitle("Incorrect address 1")
    @Description("Incorrect address 1")
    public void incorrectAddress1(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        checkNextButtonStatus(true);
        mortgageRequestView.touchNextButton();
        checkAlertFrame("Incorrect address 1");
    }

    @Test(dataProvider = DataProviderNames.CORRECT, dataProviderClass = MortgageRequestDataProviders.class)
    @QaseId(42)
    @QaseTitle("Blank the \"Address 1\" field")
    @Description("Blank the \"Address 1\" field")
    public void blankAddress1Field(MortgageRequest mortgageRequest) {

        mortgageRequestView.setFirstName(mortgageRequest.getFirstName());
        mortgageRequestView.setLastName(mortgageRequest.getLastName());
        mortgageRequestView.setAge(mortgageRequest.getAge());
        mortgageRequestView.setAddress2(mortgageRequest.getAddress2());
        mortgageRequestView.setCountry(mortgageRequest.getCountry());
        checkNextButtonStatus(false);
    }

    @Test(dataProvider = DataProviderNames.INCORRECT_ADDRESS_2, dataProviderClass = MortgageRequestDataProviders.class)
    @QaseId(43)
    @QaseTitle("Incorrect address 2")
    @Description("Incorrect address 2")
    public void incorrectAddress2(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        checkNextButtonStatus(true);
        mortgageRequestView.touchNextButton();
        checkAlertFrame("Incorrect address 2");
    }

    @Test(dataProvider = DataProviderNames.CORRECT, dataProviderClass = MortgageRequestDataProviders.class)
    @QaseId(44)
    @QaseTitle("Blank the \"Address 2\" field")
    @Description("Blank the \"Address 2\" field")
    public void blankAddress2Field(MortgageRequest mortgageRequest) {

        mortgageRequestView.setFirstName(mortgageRequest.getFirstName());
        mortgageRequestView.setLastName(mortgageRequest.getLastName());
        mortgageRequestView.setAge(mortgageRequest.getAge());
        mortgageRequestView.setAddress1(mortgageRequest.getAddress1());
        mortgageRequestView.setCountry(mortgageRequest.getCountry());
        checkNextButtonStatus(false);
    }

    @Test(dataProvider = DataProviderNames.INCORRECT_COUNTRY, dataProviderClass = MortgageRequestDataProviders.class)
    @QaseId(45)
    @QaseTitle("Incorrect country")
    @Description("Incorrect country")
    public void incorrectCountry(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        checkNextButtonStatus(true);
        mortgageRequestView.touchNextButton();
        checkAlertFrame("Incorrect country");
    }

    @Test(dataProvider = DataProviderNames.CORRECT, dataProviderClass = MortgageRequestDataProviders.class)
    @QaseId(46)
    @QaseTitle("Blank the \"Country\" field")
    @Description("Blank the \"Country\" field")
    public void blankCountryField(MortgageRequest mortgageRequest) {

        mortgageRequestView.setFirstName(mortgageRequest.getFirstName());
        mortgageRequestView.setLastName(mortgageRequest.getLastName());
        mortgageRequestView.setAge(mortgageRequest.getAge());
        mortgageRequestView.setAddress1(mortgageRequest.getAddress1());
        mortgageRequestView.setAddress2(mortgageRequest.getAddress2());
        checkNextButtonStatus(false);
    }
}

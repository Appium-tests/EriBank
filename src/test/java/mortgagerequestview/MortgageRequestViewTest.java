package mortgagerequestview;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.View;
import qa.helpers.Authentication;
import qa.helpers.TestHelper;
import qa.homeviewmanager.HomeViewManager;
import qa.pageobject.homeview.HomeView;
import qa.pageobject.mortgagerequest.MortgageSummaryView;
import qa.steps.MortgageRequestSteps;
import qa.testdataproviders.TestDataProviders;
import qa.utils.MortgageRequest;

@Epic("E2E")
@Feature("Mortgage Request functionalities")
public class MortgageRequestViewTest extends BaseTest {

    private MortgageRequestSteps mortgageRequestSteps;
    private TestHelper testHelper;

    @BeforeMethod
    public void create() {

        Authentication.perform(getDriver());
        HomeViewManager.open(getDriver(), View.MORTGAGE_REQUEST);

        mortgageRequestSteps = new MortgageRequestSteps(getDriver());
        testHelper = new TestHelper();
    }

    private void fill(MortgageRequest mortgageRequest) {

        mortgageRequestSteps.setFirstName(mortgageRequest.getFirstName());
        mortgageRequestSteps.setLastName(mortgageRequest.getLastName());
        mortgageRequestSteps.setAge(mortgageRequest.getAge());
        mortgageRequestSteps.setAddress(mortgageRequest.getAddress1());
        mortgageRequestSteps.fillSecondAddressField(mortgageRequest.getAddress2());
        mortgageRequestSteps.setCountry(mortgageRequest.getCountry());
    }

    private void checkWhenDataIsCorrect() {

        MortgageSummaryView mortgageSummaryView = new MortgageSummaryView(getDriver());

        Assert.assertTrue(mortgageSummaryView.isDisplayed(),
                "The summary view is not opened");
    }

    @Test(dataProvider = "MR_correct", dataProviderClass = TestDataProviders.class)
    @Description("Checking whether the mortgage loan application containing the correct data has been sent")
    @Story("Sending correct data")
    public void correct(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        mortgageRequestSteps.tapNextButton();
        checkWhenDataIsCorrect();
    }

    @Test(dataProvider = "MR_blankSecondAddressField", dataProviderClass = TestDataProviders.class)
    @Description("Checking whether a mortgage loan application containing a blank \"Address 2\" field has been sent")
    @Story("Blank \"Address 2\" field")
    public void blankSecondAddressField(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        mortgageRequestSteps.tapNextButton();
        checkWhenDataIsCorrect();
    }

    @Test(dataProvider = "MR_incorrectFirstName", dataProviderClass = TestDataProviders.class)
    @Description("Checking whether a mortgage loan application containing an incorrect first name has been sent")
    @Story("Incorrect first name")
    public void incorrectFirstName(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        mortgageRequestSteps.tapNextButton();
        testHelper.checkWhenDataIsIncorrect(mortgageRequestSteps.getMortgageRequestView().getAlertFrame(),
                mortgageRequest.getTitle(), mortgageRequest.getMessage());
    }

    @Test(dataProvider = "MR_blankFirstNameField", dataProviderClass = TestDataProviders.class)
    @Description("Checking whether a mortgage loan application containing a blank \"First name\" field has been sent")
    @Story("Blank \"First name\" field")
    public void blankFirstNameField(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        testHelper.checkWhenFieldIsBlank(mortgageRequestSteps.getMortgageRequestView().isNextButtonEnabled(),
                "Next");
    }

    @Test(dataProvider = "MR_incorrectLastName", dataProviderClass = TestDataProviders.class)
    @Description("Checking whether a mortgage loan application containing an incorrect last name has been sent")
    @Story("Incorrect last name")
    public void incorrectLastName(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        mortgageRequestSteps.tapNextButton();
        testHelper.checkWhenDataIsIncorrect(mortgageRequestSteps.getMortgageRequestView().getAlertFrame(),
                mortgageRequest.getTitle(), mortgageRequest.getMessage());
    }

    @Test(dataProvider = "MR_blankLastNameField", dataProviderClass = TestDataProviders.class)
    @Description("Checking whether a mortgage loan application containing a blank \"Last name\" field has been sent")
    @Story("Blank \"Last name\" field")
    public void blankLastNameField(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        testHelper.checkWhenFieldIsBlank(mortgageRequestSteps.getMortgageRequestView().isNextButtonEnabled(),
                "Next");
    }

    @Test(dataProvider = "MR_incorrectAge", dataProviderClass = TestDataProviders.class)
    @Description("Checking whether a mortgage loan application containing an incorrect age has been sent")
    @Story("Incorrect age")
    public void incorrectAge(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        mortgageRequestSteps.tapNextButton();
        testHelper.checkWhenDataIsIncorrect(mortgageRequestSteps.getMortgageRequestView().getAlertFrame(),
                mortgageRequest.getTitle(), mortgageRequest.getMessage());
    }

    @Test(dataProvider = "MR_blankAgeField", dataProviderClass = TestDataProviders.class)
    @Description("Checking whether a mortgage loan application containing a blank \"Age\" field has been sent")
    @Story("Blank \"Age\" field")
    public void blankAgeField(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        testHelper.checkWhenFieldIsBlank(mortgageRequestSteps.getMortgageRequestView().isNextButtonEnabled(),
                "Next");
    }

    @Test(dataProvider = "MR_incorrectAddress", dataProviderClass = TestDataProviders.class)
    @Description("Checking whether a mortgage loan application containing an incorrect address has been sent")
    @Story("Incorrect address")
    public void incorrectAddress(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        mortgageRequestSteps.tapNextButton();
        testHelper.checkWhenDataIsIncorrect(mortgageRequestSteps.getMortgageRequestView().getAlertFrame(),
                mortgageRequest.getTitle(), mortgageRequest.getMessage());
    }

    @Test(dataProvider = "MR_blankAddressField", dataProviderClass = TestDataProviders.class)
    @Description("Checking whether a mortgage loan application containing a blank \"Address 1\" field has been sent")
    @Story("Blank \"Address 1\" field")
    public void blankAddressField(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        testHelper.checkWhenFieldIsBlank(mortgageRequestSteps.getMortgageRequestView().isNextButtonEnabled(),
                "Next");
    }

    @Test(dataProvider = "MR_incorrectCountry", dataProviderClass = TestDataProviders.class)
    @Description("Checking whether a mortgage loan application containing an incorrect country has been sent")
    @Story("Incorrect country")
    public void incorrectCountry(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        mortgageRequestSteps.tapNextButton();
        testHelper.checkWhenDataIsIncorrect(mortgageRequestSteps.getMortgageRequestView().getAlertFrame(),
                mortgageRequest.getTitle(), mortgageRequest.getMessage());
    }

    @Test(dataProvider = "MR_blankCountryField", dataProviderClass = TestDataProviders.class)
    @Description("Checking whether a mortgage loan application containing a blank \"Country\" field has been sent")
    @Story("Blank \"Country\" field")
    public void blankCountryField(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        testHelper.checkWhenFieldIsBlank(mortgageRequestSteps.getMortgageRequestView().isNextButtonEnabled(),
                "Next");
    }

    @Test
    @Description("Verify that the \"Mortgage Request\" view is closed after touching the \"Cancel\" button")
    @Story("Touching the \"Cancel\" button")
    public void closingView() {

        mortgageRequestSteps.tapCancelButton();

        HomeView homeView = new HomeView(getDriver());

        Assert.assertTrue(homeView.isDisplayed(),
                "The view is not closed");
    }
}

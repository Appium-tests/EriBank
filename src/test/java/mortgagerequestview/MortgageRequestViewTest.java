package mortgagerequestview;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.helpers.Authentication;
import qa.helpers.TestHelper;
import qa.pageobject.homeview.HomeView;
import qa.pageobject.mortgagerequest.MortgageSummaryView;
import qa.steps.MortgageRequestSteps;
import qa.testdataproviders.TestDataProviders;
import qa.utils.MortgageRequest;

public class MortgageRequestViewTest extends BaseTest {

    private MortgageRequestSteps mortgageRequestSteps;
    private TestHelper testHelper;

    @BeforeMethod
    public void create() {

        Authentication.perform(getDriver());
        HomeView homeView = new HomeView(getDriver());
        homeView.tapMortageRequestButton();

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

        Assert.assertTrue(mortgageSummaryView.isDisplayed());
    }

    @Test(dataProvider = "MR_correct", dataProviderClass = TestDataProviders.class)
    public void correct(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        mortgageRequestSteps.tapNextButton();
        checkWhenDataIsCorrect();
    }

    @Test(dataProvider = "MR_blankSecondAddressField", dataProviderClass = TestDataProviders.class)
    public void blankSecondAddressField(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        mortgageRequestSteps.tapNextButton();
        checkWhenDataIsCorrect();
    }

    @Test(dataProvider = "MR_incorrectFirstName", dataProviderClass = TestDataProviders.class)
    public void incorrectFirstName(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        mortgageRequestSteps.tapNextButton();
        testHelper.checkWhenDataIsIncorrect(mortgageRequestSteps.getMortgageRequestView().getAlertFrame(),
                mortgageRequest.getTitle(), mortgageRequest.getMessage());
    }

    @Test(dataProvider = "MR_blankFirstNameField", dataProviderClass = TestDataProviders.class)
    public void blankFirstNameField(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        testHelper.checkWhenFieldIsBlank(mortgageRequestSteps.getMortgageRequestView().isNextButtonEnabled(),
                "Next");
    }

    @Test(dataProvider = "MR_incorrectLastName", dataProviderClass = TestDataProviders.class)
    public void incorrectLastName(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        mortgageRequestSteps.tapNextButton();
        testHelper.checkWhenDataIsIncorrect(mortgageRequestSteps.getMortgageRequestView().getAlertFrame(),
                mortgageRequest.getTitle(), mortgageRequest.getMessage());
    }

    @Test(dataProvider = "MR_blankLastNameField", dataProviderClass = TestDataProviders.class)
    public void blankBlankNameField(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        testHelper.checkWhenFieldIsBlank(mortgageRequestSteps.getMortgageRequestView().isNextButtonEnabled(),
                "Next");
    }

    @Test(dataProvider = "MR_incorrectAge", dataProviderClass = TestDataProviders.class)
    public void incorrectAge(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        mortgageRequestSteps.tapNextButton();
        testHelper.checkWhenDataIsIncorrect(mortgageRequestSteps.getMortgageRequestView().getAlertFrame(),
                mortgageRequest.getTitle(), mortgageRequest.getMessage());
    }

    @Test(dataProvider = "MR_blankAgeField", dataProviderClass = TestDataProviders.class)
    public void blankAgeField(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        testHelper.checkWhenFieldIsBlank(mortgageRequestSteps.getMortgageRequestView().isNextButtonEnabled(),
                "Next");
    }

    @Test(dataProvider = "MR_incorrectAddress", dataProviderClass = TestDataProviders.class)
    public void incorrectAddress(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        mortgageRequestSteps.tapNextButton();
        testHelper.checkWhenDataIsIncorrect(mortgageRequestSteps.getMortgageRequestView().getAlertFrame(),
                mortgageRequest.getTitle(), mortgageRequest.getMessage());
    }

    @Test(dataProvider = "MR_blankAddressField", dataProviderClass = TestDataProviders.class)
    public void blankAddressField(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        testHelper.checkWhenFieldIsBlank(mortgageRequestSteps.getMortgageRequestView().isNextButtonEnabled(),
                "Next");
    }

    @Test(dataProvider = "MR_incorrectCountry", dataProviderClass = TestDataProviders.class)
    public void incorrectCountry(MortgageRequest mortgageRequest) {

        fill(mortgageRequest);
        mortgageRequestSteps.tapNextButton();
        testHelper.checkWhenDataIsIncorrect(mortgageRequestSteps.getMortgageRequestView().getAlertFrame(),
                mortgageRequest.getTitle(), mortgageRequest.getMessage());
    }

    @Test(dataProvider = "MR_blankCountryField", dataProviderClass = TestDataProviders.class)
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

package mortagerequestview;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.helpers.Authentication;
import qa.helpers.TestHelper;
import qa.pageobject.homeview.HomeView;
import qa.pageobject.mortagerequest.MortageSummaryView;
import qa.steps.MortageRequestSteps;
import qa.testdataproviders.TestDataProviders;
import qa.utils.MortageRequest;

public class MortageRequestViewTest extends BaseTest {

    private MortageRequestSteps mortageRequestSteps;
    private TestHelper testHelper;

    @BeforeMethod
    public void create() {

        Authentication.perform(getDriver());
        HomeView homeView = new HomeView(getDriver());
        homeView.tapMortageRequestButton();

        mortageRequestSteps = new MortageRequestSteps(getDriver());
        testHelper = new TestHelper();
    }

    private void fill(MortageRequest mortageRequest) {

        mortageRequestSteps.setFirstName(mortageRequest.getFirstName());
        mortageRequestSteps.setLastName(mortageRequest.getLastName());
        mortageRequestSteps.setAge(mortageRequest.getAge());
        mortageRequestSteps.setAddress(mortageRequest.getAddress1());
        mortageRequestSteps.fillSecondAddressField(mortageRequest.getAddress2());
        mortageRequestSteps.setCountry(mortageRequest.getCountry());
    }

    private void checkWhenDataIsCorrect() {

        MortageSummaryView mortageSummaryView = new MortageSummaryView(getDriver());

        Assert.assertTrue(mortageSummaryView.isDisplayed());
    }

    @Test(dataProvider = "MR_correct", dataProviderClass = TestDataProviders.class)
    public void correct(MortageRequest mortageRequest) {

        fill(mortageRequest);
        mortageRequestSteps.tapButtonNext();
        checkWhenDataIsCorrect();
    }

    @Test(dataProvider = "MR_blankSecondAddressField", dataProviderClass = TestDataProviders.class)
    public void blankSecondAddressField(MortageRequest mortageRequest) {

        fill(mortageRequest);
        mortageRequestSteps.tapButtonNext();
        checkWhenDataIsCorrect();
    }

    @Test(dataProvider = "MR_incorrectFirstName", dataProviderClass = TestDataProviders.class)
    public void incorrectFirstName(MortageRequest mortageRequest) {

        fill(mortageRequest);
        mortageRequestSteps.tapButtonNext();
        testHelper.checkWhenDataIsIncorrect(mortageRequestSteps.getMortageRequestView().getAlertFrame(),
                mortageRequest.getTitle(), mortageRequest.getMessage());
    }

    @Test(dataProvider = "MR_blankFirstNameField", dataProviderClass = TestDataProviders.class)
    public void blankFirstNameField(MortageRequest mortageRequest) {

        fill(mortageRequest);
        testHelper.checkWhenFieldIsBlank(mortageRequestSteps.getMortageRequestView().isButtonNextEnabled(),
                "Next");
    }

    @Test(dataProvider = "MR_incorrectLastName", dataProviderClass = TestDataProviders.class)
    public void incorrectLastName(MortageRequest mortageRequest) {

        fill(mortageRequest);
        mortageRequestSteps.tapButtonNext();
        testHelper.checkWhenDataIsIncorrect(mortageRequestSteps.getMortageRequestView().getAlertFrame(),
                mortageRequest.getTitle(), mortageRequest.getMessage());
    }

    @Test(dataProvider = "MR_blankLastNameField", dataProviderClass = TestDataProviders.class)
    public void blankBlankNameField(MortageRequest mortageRequest) {

        fill(mortageRequest);
        testHelper.checkWhenFieldIsBlank(mortageRequestSteps.getMortageRequestView().isButtonNextEnabled(),
                "Next");
    }

    @Test(dataProvider = "MR_incorrectAge", dataProviderClass = TestDataProviders.class)
    public void incorrectAge(MortageRequest mortageRequest) {

        fill(mortageRequest);
        mortageRequestSteps.tapButtonNext();
        testHelper.checkWhenDataIsIncorrect(mortageRequestSteps.getMortageRequestView().getAlertFrame(),
                mortageRequest.getTitle(), mortageRequest.getMessage());
    }

    @Test(dataProvider = "MR_blankAgeField", dataProviderClass = TestDataProviders.class)
    public void blankAgeField(MortageRequest mortageRequest) {

        fill(mortageRequest);
        testHelper.checkWhenFieldIsBlank(mortageRequestSteps.getMortageRequestView().isButtonNextEnabled(),
                "Next");
    }

    @Test(dataProvider = "MR_incorrectAddress", dataProviderClass = TestDataProviders.class)
    public void incorrectAddress(MortageRequest mortageRequest) {

        fill(mortageRequest);
        mortageRequestSteps.tapButtonNext();
        testHelper.checkWhenDataIsIncorrect(mortageRequestSteps.getMortageRequestView().getAlertFrame(),
                mortageRequest.getTitle(), mortageRequest.getMessage());
    }

    @Test(dataProvider = "MR_blankAddressField", dataProviderClass = TestDataProviders.class)
    public void blankAddressField(MortageRequest mortageRequest) {

        fill(mortageRequest);
        testHelper.checkWhenFieldIsBlank(mortageRequestSteps.getMortageRequestView().isButtonNextEnabled(),
                "Next");
    }

    @Test(dataProvider = "MR_incorrectCountry", dataProviderClass = TestDataProviders.class)
    public void incorrectCountry(MortageRequest mortageRequest) {

        fill(mortageRequest);
        mortageRequestSteps.tapButtonNext();
        testHelper.checkWhenDataIsIncorrect(mortageRequestSteps.getMortageRequestView().getAlertFrame(),
                mortageRequest.getTitle(), mortageRequest.getMessage());
    }

    @Test(dataProvider = "MR_blankCountryField", dataProviderClass = TestDataProviders.class)
    public void blankCountryField(MortageRequest mortageRequest) {

        fill(mortageRequest);
        testHelper.checkWhenFieldIsBlank(mortageRequestSteps.getMortageRequestView().isButtonNextEnabled(),
                "Next");
    }

    @Test
    public void quitView() {

        mortageRequestSteps.tapButtonCancel();

        HomeView homeView = new HomeView(getDriver());

        Assert.assertTrue(homeView.isDisplayed(),
                "The home view is not displayed");
    }
}

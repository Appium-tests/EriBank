package makepaymentview;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.helpers.Authentication;
import qa.helpers.TestHelper;
import qa.pageobject.homeview.HomeView;
import qa.steps.MakePaymentSteps;
import qa.testdataproviders.TestDataProviders;
import qa.utils.Payment;

public class MakePaymentViewTest extends BaseTest {

    private MakePaymentSteps makePaymentSteps;
    private TestHelper testHelper;

    @BeforeMethod
    public void create() {

        Authentication.perform(getDriver());
        HomeView homeView = new HomeView(getDriver());
        homeView.tapMakePaymentButton();

        makePaymentSteps = new MakePaymentSteps(getDriver());
        testHelper = new TestHelper();
    }

    public void fill(Payment payment) {

        makePaymentSteps.setPhone(payment.getPhone());
        makePaymentSteps.setName(payment.getName());
        makePaymentSteps.setAmount(payment.getAmount());
        makePaymentSteps.setCountry(payment.getCountry());
    }

    @Test(dataProvider = "PM_correct", dataProviderClass = TestDataProviders.class)
    public void sendPaymentButtonStatusWhenDataIsCorrect(Payment payment) {

        fill(payment);

        Assert.assertTrue(makePaymentSteps.getMakePaymentView().isSendPaymentButtonEnabled(),
                "The \"Make payment\" button is disabled");
    }

    @Test(dataProvider = "PM_correct", dataProviderClass = TestDataProviders.class)
    public void questionFrameVisibility(Payment payment) {

        fill(payment);
        makePaymentSteps.tapSendPaymentButton();
        testHelper.checkQuestionMessage(makePaymentSteps.getMakePaymentView().getQuestionFrame(),
                payment.getQuestion());
    }

    @Test(dataProvider = "PM_correct", dataProviderClass = TestDataProviders.class)
    public void correct(Payment payment) {

        fill(payment);
        makePaymentSteps.getMakePaymentView().tapSendPaymentButton();
        makePaymentSteps.getMakePaymentView().getQuestionFrame().tapButtonYES();

        HomeView homeView = new HomeView(getDriver());

        Assert.assertTrue(homeView.isDisplayed(),
                "The home view is not displayed");
    }

    @Test(dataProvider = "PM_correct", dataProviderClass = TestDataProviders.class)
    public void cancellation(Payment payment) {

        fill(payment);

        makePaymentSteps.getMakePaymentView().tapSendPaymentButton();
        makePaymentSteps.getMakePaymentView().getQuestionFrame().tapButtonNO();

        HomeView homeView = new HomeView(getDriver());

        Assert.assertFalse(homeView.isDisplayed(),
                "The home view is displayed");
    }

    @Test(dataProvider = "PM_incorrectPhone", dataProviderClass = TestDataProviders.class)
    public void incorrectPhone(Payment payment) {

        fill(payment);
        makePaymentSteps.getMakePaymentView().tapSendPaymentButton();
        testHelper.checkWhenDataIsIncorrect(makePaymentSteps.getMakePaymentView().getAlertFrame(),
                payment.getTitle(), payment.getMessage());
    }

    @Test(dataProvider = "PM_blankPhoneField", dataProviderClass = TestDataProviders.class)
    public void blankPhoneField(Payment payment) {

        fill(payment);
        testHelper.checkWhenFieldIsBlank(makePaymentSteps.getMakePaymentView().isSendPaymentButtonEnabled(),
                "Make payment");
    }

    @Test(dataProvider = "PM_incorrectName", dataProviderClass = TestDataProviders.class)
    public void incorrectName(Payment payment) {

        fill(payment);
        testHelper.checkWhenDataIsIncorrect(makePaymentSteps.getMakePaymentView().getAlertFrame(),
                payment.getTitle(), payment.getMessage());
    }

    @Test(dataProvider = "PM_blankNameField", dataProviderClass = TestDataProviders.class)
    public void blankNameField(Payment payment) {

        fill(payment);
        testHelper.checkWhenFieldIsBlank(makePaymentSteps.getMakePaymentView().isSendPaymentButtonEnabled(),
                "Make payment");
    }

    @Test(dataProvider = "PM_incorrectAmount", dataProviderClass = TestDataProviders.class)
    public void incorrectAmount(Payment payment) {

        fill(payment);
        testHelper.checkWhenDataIsIncorrect(makePaymentSteps.getMakePaymentView().getAlertFrame(),
                payment.getTitle(), payment.getMessage());
    }

    @Test(dataProvider = "PM_blankAmountField", dataProviderClass = TestDataProviders.class)
    public void blankAmountField(Payment payment) {

        fill(payment);
        testHelper.checkWhenFieldIsBlank(makePaymentSteps.getMakePaymentView().isSendPaymentButtonEnabled(),
                "Make payment");
    }

    @Test(dataProvider = "PM_incorrectCountry", dataProviderClass = TestDataProviders.class)
    public void incorrectCountry(Payment payment) {

        fill(payment);
        testHelper.checkWhenDataIsIncorrect(makePaymentSteps.getMakePaymentView().getAlertFrame(),
                payment.getTitle(), payment.getMessage());
    }

    @Test(dataProvider = "PM_blankCountryField", dataProviderClass = TestDataProviders.class)
    public void blankCountryField(Payment payment) {

        fill(payment);
        testHelper.checkWhenFieldIsBlank(makePaymentSteps.getMakePaymentView().isSendPaymentButtonEnabled(),
                "Make payment");
    }
}

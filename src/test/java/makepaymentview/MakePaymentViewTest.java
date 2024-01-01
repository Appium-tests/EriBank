package makepaymentview;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
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

@Epic("E2E")
@Feature("Payment functionalities")
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
    @Description("Checking that the \"Send payment\" button is enabled when the details are correct")
    @Story("The \"Send payment\" button state")
    public void sendPaymentButtonStatusWhenDataIsCorrect(Payment payment) {

        fill(payment);

        Assert.assertTrue(makePaymentSteps.getMakePaymentView().isSendPaymentButtonEnabled(),
                "The \"Make payment\" button is disabled");
    }

    @Test(dataProvider = "PM_correct", dataProviderClass = TestDataProviders.class)
    @Description("Checking that the payment confirmation message is visible after touching the \"Send payment\" button")
    @Story("The payment confirmation message visibility")
    public void questionFrameVisibility(Payment payment) {

        fill(payment);
        makePaymentSteps.tapSendPaymentButton();
        testHelper.checkQuestionMessage(makePaymentSteps.getMakePaymentView().getQuestionFrame(),
                payment.getQuestion());
    }

    @Test(dataProvider = "PM_correct", dataProviderClass = TestDataProviders.class)
    @Description("Verify that the payment has been sent when the details are correct")
    @Story("Sending payment with the correct details")
    public void correct(Payment payment) {

        fill(payment);
        makePaymentSteps.getMakePaymentView().tapSendPaymentButton();
        makePaymentSteps.getMakePaymentView().getQuestionFrame().tapButtonYES();

        HomeView homeView = new HomeView(getDriver());

        Assert.assertTrue(homeView.isDisplayed(),
                "The home view is not displayed");
    }

    @Test(dataProvider = "PM_correct", dataProviderClass = TestDataProviders.class)
    @Description("Verify that the payment has been sent after touching the \"Cancel\" button")
    @Story("Touching the \"Cancel\" button")
    public void cancellation(Payment payment) {

        fill(payment);

        makePaymentSteps.getMakePaymentView().tapSendPaymentButton();
        makePaymentSteps.getMakePaymentView().getQuestionFrame().tapButtonNO();

        HomeView homeView = new HomeView(getDriver());

        Assert.assertFalse(homeView.isDisplayed(),
                "The home view is displayed");
    }

    @Test(dataProvider = "PM_incorrectPhone", dataProviderClass = TestDataProviders.class)
    @Description("Verify that the payment has been sent when the phone number is incorrect")
    @Story("Incorrect phone number")
    public void incorrectPhone(Payment payment) {

        fill(payment);
        makePaymentSteps.getMakePaymentView().tapSendPaymentButton();
        testHelper.checkWhenDataIsIncorrect(makePaymentSteps.getMakePaymentView().getAlertFrame(),
                payment.getTitle(), payment.getMessage());
    }

    @Test(dataProvider = "PM_blankPhoneField", dataProviderClass = TestDataProviders.class)
    @Description("Verify that the payment has been sent when the phone field is blank")
    @Story("Blank phone field")
    public void blankPhoneField(Payment payment) {

        fill(payment);
        testHelper.checkWhenFieldIsBlank(makePaymentSteps.getMakePaymentView().isSendPaymentButtonEnabled(),
                "Make payment");
    }

    @Test(dataProvider = "PM_incorrectName", dataProviderClass = TestDataProviders.class)
    @Description("Verify that the payment has been sent when the name is incorrect")
    @Story("Incorrect name")
    public void incorrectName(Payment payment) {

        fill(payment);
        testHelper.checkWhenDataIsIncorrect(makePaymentSteps.getMakePaymentView().getAlertFrame(),
                payment.getTitle(), payment.getMessage());
    }

    @Test(dataProvider = "PM_blankNameField", dataProviderClass = TestDataProviders.class)
    @Description("Verify that the payment has been sent when the name field is blank")
    @Story("Blank name field")
    public void blankNameField(Payment payment) {

        fill(payment);
        testHelper.checkWhenFieldIsBlank(makePaymentSteps.getMakePaymentView().isSendPaymentButtonEnabled(),
                "Make payment");
    }

    @Test(dataProvider = "PM_incorrectAmount", dataProviderClass = TestDataProviders.class)
    @Description("Verify that the payment has been sent when the amount is incorrect")
    @Story("Incorrect amount")
    public void incorrectAmount(Payment payment) {

        fill(payment);
        testHelper.checkWhenDataIsIncorrect(makePaymentSteps.getMakePaymentView().getAlertFrame(),
                payment.getTitle(), payment.getMessage());
    }

    @Test(dataProvider = "PM_blankAmountField", dataProviderClass = TestDataProviders.class)
    @Description("Verify that the payment has been sent when the amount field is blank")
    @Story("Blank amount field")
    public void blankAmountField(Payment payment) {

        fill(payment);
        testHelper.checkWhenFieldIsBlank(makePaymentSteps.getMakePaymentView().isSendPaymentButtonEnabled(),
                "Make payment");
    }

    @Test(dataProvider = "PM_incorrectCountry", dataProviderClass = TestDataProviders.class)
    @Description("Verify that the payment has been sent when the country name is incorrect")
    @Story("Incorrect country name")
    public void incorrectCountry(Payment payment) {

        fill(payment);
        testHelper.checkWhenDataIsIncorrect(makePaymentSteps.getMakePaymentView().getAlertFrame(),
                payment.getTitle(), payment.getMessage());
    }

    @Test(dataProvider = "PM_blankCountryField", dataProviderClass = TestDataProviders.class)
    @Description("Verify that the payment has been sent when the country field is blank")
    @Story("Blank country field")
    public void blankCountryField(Payment payment) {

        fill(payment);
        testHelper.checkWhenFieldIsBlank(makePaymentSteps.getMakePaymentView().isSendPaymentButtonEnabled(),
                "Make payment");
    }

    @Test
    @Description("Verify that the \"Make Payment\" view is closed after touching the \"Cancel\" button")
    @Story("Touching the \"Cancel\" button")
    public void closingView() {

        makePaymentSteps.tapCancelButton();

        HomeView homeView = new HomeView(getDriver());

        Assert.assertTrue(homeView.isDisplayed(),
                "The \"Make Payment\" view is not closed");
    }
}

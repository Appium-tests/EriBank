package makepaymentview;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.helpers.Authentication;
import qa.helpers.TestHelper;
import qa.pageobject.homeview.HomeView;
import qa.pageobject.makepaymentview.MakePaymentView;
import qa.testdataproviders.TestDataProviders;
import qa.utils.Payment;

public class MakePaymentViewTest extends BaseTest {

    private TestHelper testHelper;
    private MakePaymentView makePaymentView;

    @BeforeMethod
    public void create() {

        Authentication.perform(getDriver());
        HomeView homeView = new HomeView(getDriver());
        homeView.tapMakePaymentButton();

        makePaymentView = new MakePaymentView(getDriver());
        testHelper = new TestHelper();
    }

    public void fill(Payment payment) {

        makePaymentView.setPhone(payment.getPhone());
        makePaymentView.setName(payment.getName());
        makePaymentView.setAmount(payment.getAmount());
        makePaymentView.setCountry(payment.getCountry());
    }

    private void checkIfDataIsCorrect() {

        HomeView homeView = new HomeView(getDriver());

        Assert.assertTrue(homeView.isDisplayed(),
                "The home view is not displayed");
    }

    @Test(dataProvider = "PM_correct", dataProviderClass = TestDataProviders.class)
    public void sendPaymentButtonStatusWhenDataIsCorrect(Payment payment) {

        fill(payment);

        Assert.assertTrue(makePaymentView.isSendPaymentButtonEnabled(),
                "The \"Make payment\" button is disabled");
    }

    @Test(dataProvider = "PM_correct", dataProviderClass = TestDataProviders.class)
    public void questionFrameVisibility(Payment payment) {

        fill(payment);

        makePaymentView.tapSendPaymentButton();

        Assert.assertTrue(makePaymentView.getQuestionFrame().isDisplayed(),
                "The question frame is not displayed");
        Assert.assertTrue(makePaymentView.getQuestionFrame().isButtonYESDisplayed(),
                "The 'Yes' button is not displayed");
        Assert.assertTrue(makePaymentView.getQuestionFrame().isButtonNODisplayed(),
                "The 'No' button is not displayed");
        Assert.assertEquals(makePaymentView.getQuestionFrame().getTitle(), "EriBank",
                "Incorrect title");
        Assert.assertEquals(makePaymentView.questionFrame.getMessage(), "Are you sure you want to send payment?",
                "Incorrect message content");
    }

    @Test(dataProvider = "PM_correct", dataProviderClass = TestDataProviders.class)
    public void correct(Payment payment) {

        fill(payment);
        makePaymentView.tapSendPaymentButton();
        makePaymentView.getQuestionFrame().tapButtonYES();
        checkIfDataIsCorrect();
    }

    @Test(dataProvider = "PM_correct", dataProviderClass = TestDataProviders.class)
    public void cancellation(Payment payment) {

        fill(payment);

        makePaymentView.tapSendPaymentButton();
        makePaymentView.getQuestionFrame().tapButtonNO();

        HomeView homeView = new HomeView(getDriver());

        Assert.assertFalse(homeView.isDisplayed(),
                "The home view is displayed");
    }

    @Test(dataProvider = "PM_incorrectPhone", dataProviderClass = TestDataProviders.class)
    public void incorrectPhone(Payment payment) {

        fill(payment);
        makePaymentView.tapSendPaymentButton();
        testHelper.checkWhenDataIsIncorrect(makePaymentView.getAlertFrame(), payment.getTitle(), payment.getMessage());
    }

    @Test(dataProvider = "PM_blankPhoneField", dataProviderClass = TestDataProviders.class)
    public void blankPhoneField(Payment payment) {

        fill(payment);
        testHelper.checkWhenFieldIsBlank(makePaymentView.isSendPaymentButtonEnabled(), "Make payment");
    }

    @Test(dataProvider = "PM_incorrectName", dataProviderClass = TestDataProviders.class)
    public void incorrectName(Payment payment) {

        fill(payment);
        testHelper.checkWhenDataIsIncorrect(makePaymentView.getAlertFrame(), payment.getTitle(), payment.getMessage());
    }

    @Test(dataProvider = "PM_blankNameField", dataProviderClass = TestDataProviders.class)
    public void blankNameField(Payment payment) {

        fill(payment);
        testHelper.checkWhenFieldIsBlank(makePaymentView.isSendPaymentButtonEnabled(), "Make payment");
    }

    @Test(dataProvider = "PM_incorrectAmount", dataProviderClass = TestDataProviders.class)
    public void incorrectAmount(Payment payment) {

        fill(payment);
        testHelper.checkWhenDataIsIncorrect(makePaymentView.getAlertFrame(), payment.getTitle(), payment.getMessage());
    }

    @Test(dataProvider = "PM_blankAmountField", dataProviderClass = TestDataProviders.class)
    public void blankAmountField(Payment payment) {

        fill(payment);
        testHelper.checkWhenFieldIsBlank(makePaymentView.isSendPaymentButtonEnabled(), "Make payment");
    }

    @Test(dataProvider = "PM_incorrectCountry", dataProviderClass = TestDataProviders.class)
    public void incorrectCountry(Payment payment) {

        fill(payment);
        testHelper.checkWhenDataIsIncorrect(makePaymentView.getAlertFrame(), payment.getTitle(), payment.getMessage());
    }

    @Test(dataProvider = "PM_blankCountryField", dataProviderClass = TestDataProviders.class)
    public void blankCountryField(Payment payment) {

        fill(payment);
        testHelper.checkWhenFieldIsBlank(makePaymentView.isSendPaymentButtonEnabled(), "Make payment");
    }
}

package makepaymentview;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.helpers.Authentication;
import qa.pageobject.homeview.HomeView;
import qa.pageobject.makepaymentview.MakePaymentView;
import qa.testdataproviders.TestDataProviders;
import qa.utils.Payment;

public class MakePaymentViewTest extends BaseTest {

    private MakePaymentView makePaymentView;

    @BeforeMethod
    public void create() {

        Authentication.perform(getDriver());
        HomeView homeView = new HomeView(getDriver());
        homeView.tapMakePaymentButton();

        makePaymentView = new MakePaymentView(getDriver());
    }

    public void fill(Payment payment) {

        makePaymentView.setPhone(payment.getPhone());
        makePaymentView.setName(payment.getName());
        makePaymentView.setAmount(payment.getAmount());
        makePaymentView.setCountry(payment.getCountry());
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

        HomeView homeView = new HomeView(getDriver());

        Assert.assertTrue(homeView.isDisplayed(),
                "The home view is not displayed");
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

        Assert.assertTrue(makePaymentView.getAlertFrame().isDisplayed(),
                "The alert frame is not displayed");
        Assert.assertEquals(makePaymentView.getQuestionFrame().getTitle(), "Alert",
                "Incorrect title");
        Assert.assertEquals(makePaymentView.getAlertFrame().getMessage(),
                "Invalid phone number!", "Incorrect message content");
        Assert.assertTrue(makePaymentView.getAlertFrame().isButtonDisplayed(),
                "The \"Close\" button is not displayed");
    }

    @Test(dataProvider = "PM_blankPhoneField", dataProviderClass = TestDataProviders.class)
    public void blankPhoneField(Payment payment) {

        fill(payment);

        Assert.assertFalse(makePaymentView.isSendPaymentButtonEnabled(),
                "The 'Send payment' button is enabled");
    }
}

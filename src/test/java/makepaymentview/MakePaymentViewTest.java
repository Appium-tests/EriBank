package makepaymentview;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import qa.dataproviders.MakePaymentDataProviders;
import qa.enums.View;
import qa.support.Authentication;
import qa.support.HomeViewManager;
import qa.pageobject.homeview.HomeView;
import qa.pageobject.makepaymentview.MakePaymentView;
import qa.dataproviders.MortgageRequestDataProviders;
import qa.models.Payment;
import qa.support.DataProviderNames;

@Epic("E2E")
@Feature("Sending payment")
public class MakePaymentViewTest extends BaseTest {

    private MakePaymentView makePaymentView;

    @BeforeMethod
    public void create() {

        Authentication.perform(getDriver());
        HomeViewManager.open(getDriver(), View.MAKE_PAYMENT);

        makePaymentView = new MakePaymentView(getDriver());
    }

    public void fill(Payment payment) {

        makePaymentView.setPhone(payment.getPhone());
        makePaymentView.setName(payment.getName());
        makePaymentView.setAmount(payment.getAmount());
        makePaymentView.setCountry(payment.getCountry());
    }

    @io.qameta.allure.Step("Check the \"Send Payment\" button status")
    @io.qase.api.annotation.Step("Check the \"Send Payment\" button status")
    private void checkSendPaymentButtonStatus(boolean expectedStatus) {

        Assert.assertEquals(makePaymentView.isSendPaymentButtonEnabled(), expectedStatus, "Incorrect the \"Make Payment\" button status");
    }

    private void checkAlertFrame(String expectedMessage) {

        Assert.assertTrue(makePaymentView.getAlertFrame().isDisplayed(), "The alert is not displayed");
        Assert.assertEquals(makePaymentView.getAlertFrame().getMessage(), expectedMessage, "Incorrect message content");
    }

    @Test(priority = 1, dataProvider = DataProviderNames.CORRECT, dataProviderClass = MakePaymentDataProviders.class)
    @QaseId(20)
    @QaseTitle("Correct user data")
    @Description("Correct user data")
    public void correct(Payment payment) {

        fill(payment);
        checkSendPaymentButtonStatus(true);
        makePaymentView.touchSendPaymentButton();
        makePaymentView.getQuestionFrame().touchButtonYES();

        HomeView homeView = new HomeView(getDriver());

        Assert.assertTrue(homeView.isDisplayed(),"The home view is not displayed");
    }

    @Test(priority = 2, dataProvider = DataProviderNames.INCORRECT_PHONE, dataProviderClass = MakePaymentDataProviders.class)
    @QaseId(21)
    @QaseTitle("Incorrect phone")
    @Description("Incorrect phone")
    public void incorrectPhone(Payment payment) {

        fill(payment);
        checkSendPaymentButtonStatus(true);
        makePaymentView.touchSendPaymentButton();
        checkAlertFrame("Invalid phone");
    }


    @Test(priority = 3, dataProvider = DataProviderNames.CORRECT, dataProviderClass = MakePaymentDataProviders.class)
    @QaseId(22)
    @QaseTitle("Blank the \"Phone\" field")
    @Description("Blank the \"Phone\" field")
    public void blankPhoneField(Payment payment) {

        makePaymentView.setName(payment.getName());
        makePaymentView.setAmount(payment.getAmount());
        makePaymentView.setCountry(payment.getCountry());
        checkSendPaymentButtonStatus(false);
    }

    @Test(priority = 4, dataProvider = DataProviderNames.INCORRECT_NAME, dataProviderClass = MakePaymentDataProviders.class)
    @QaseId(23)
    @QaseTitle("Incorrect name")
    @Description("Incorrect name")
    public void incorrectName(Payment payment) {

        fill(payment);
        checkSendPaymentButtonStatus(true);
        makePaymentView.touchSendPaymentButton();
        checkAlertFrame("Invalid name");
    }

    @Test(priority = 5, dataProvider = DataProviderNames.CORRECT, dataProviderClass = MakePaymentDataProviders.class)
    @QaseId(24)
    @QaseTitle("Blank the \"Name\" field")
    @Description("Blank the \"Name\" field")
    public void blankNameField(Payment payment) {

        makePaymentView.setPhone(payment.getPhone());
        makePaymentView.setAmount(payment.getAmount());
        makePaymentView.setCountry(payment.getCountry());
        checkSendPaymentButtonStatus(false);
    }

    @Test(priority = 6, dataProvider = DataProviderNames.INCORRECT_AMOUNT, dataProviderClass = MakePaymentDataProviders.class)
    @QaseId(25)
    @QaseTitle("Incorrect amount")
    @Description("Incorrect amount")
    public void incorrectAmount(Payment payment) {

        fill(payment);
        checkSendPaymentButtonStatus(true);
        makePaymentView.touchSendPaymentButton();
        checkAlertFrame("Invalid amount");
    }

    @Test(priority = 7, dataProvider = DataProviderNames.CORRECT, dataProviderClass = MakePaymentDataProviders.class)
    @QaseId(26)
    @QaseTitle("Blank the \"Amount\" field")
    @Description("Blank the \"Amount\" field")
    public void blankAmountField(Payment payment) {

        makePaymentView.setPhone(payment.getPhone());
        makePaymentView.setName(payment.getName());
        makePaymentView.setCountry(payment.getCountry());
        checkSendPaymentButtonStatus(false);
    }

    @Test(priority = 8, dataProvider = DataProviderNames.INCORRECT_COUNTRY, dataProviderClass = MortgageRequestDataProviders.class)
    @QaseId(27)
    @QaseTitle("Incorrect country name")
    @Description("Incorrect country name")
    public void incorrectCountry(Payment payment) {

        fill(payment);
        checkSendPaymentButtonStatus(true);
        makePaymentView.touchSendPaymentButton();
        checkAlertFrame("Invalid country");
    }

    @Test(priority = 9, dataProvider = DataProviderNames.CORRECT, dataProviderClass = MakePaymentDataProviders.class)
    @QaseId(28)
    @QaseTitle("Blank the \"Country\" field")
    @Description("Blank the \"Country\" field")
    public void blankCountryField(Payment payment) {

        makePaymentView.setPhone(payment.getPhone());
        makePaymentView.setName(payment.getName());
        makePaymentView.setAmount(payment.getAmount());
        checkSendPaymentButtonStatus(false);
    }

    @Test(priority = 10, dataProvider = DataProviderNames.CORRECT, dataProviderClass = MakePaymentDataProviders.class)
    @QaseId(29)
    @QaseTitle("Cancelling the transaction")
    @Description("Cancelling the transaction")
    public void cancellingTransaction(Payment payment) {

        fill(payment);
        checkSendPaymentButtonStatus(true);
        makePaymentView.touchSendPaymentButton();
        makePaymentView.getQuestionFrame().touchButtonNO();

        Assert.assertTrue(makePaymentView.isDisplayed(), "The \"Make Payment\" view is not displayed");

    }

    @Test(priority = 11)
    @QaseId(30)
    @QaseTitle("The \"Cancel\" button")
    @Description("The \"Cancel\" button")
    public void cancelButton() {

        makePaymentView.touchCancelButton();

        HomeView homeView = new HomeView(getDriver());

        Assert.assertTrue(homeView.isDisplayed(),"The home view is not displayed");
    }
}

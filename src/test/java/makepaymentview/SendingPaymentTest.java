package makepaymentview;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
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
import qa.models.Payment;
import qa.support.DataProviderNames;

@Epic("E2E")
@Feature("Sending payment")
public class SendingPaymentTest extends BaseTest {

    private MakePaymentView makePaymentView;

    @BeforeMethod
    public void prepare() throws JsonProcessingException {

        Authentication.perform(getDriver());
        HomeViewManager.open(getDriver(), View.MAKE_PAYMENT);

        makePaymentView = new MakePaymentView(getDriver());
    }

    private void setAllureParameters(Payment payment) {

        Allure.parameter("Phone", payment.getPhone());
        Allure.parameter("Name", payment.getName());
        Allure.parameter("Amount", payment.getAmount());
        Allure.parameter("Country", payment.getCountry());
    }

    public void fill(Payment payment) {

        makePaymentView
                .setPhone(payment.getPhone())
                .setName(payment.getName())
                .setAmount(payment.getAmount())
                .setCountry(payment.getCountry());
    }

    @io.qameta.allure.Step("Check the \"Send Payment\" button status")
    @io.qase.api.annotation.Step("Check the \"Send Payment\" button status")
    private void checkSendPaymentButtonStatus(boolean expectedStatus) {

        Assert.assertEquals(makePaymentView.isSendPaymentButtonEnabled(), expectedStatus, "Incorrect the \"Make Payment\" button status");
    }

    private void checkAlertFrame(String expectedMessage) {

        Assert.assertTrue(makePaymentView.getErrorMessageBox().isDisplayed(), "The alert is not displayed");
        Assert.assertEquals(makePaymentView.getErrorMessageBox().getMessage(), expectedMessage, "Incorrect message content");
    }

    @Test(priority = 1, dataProvider = DataProviderNames.CORRECT, dataProviderClass = MakePaymentDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Correct user data")
    @QaseId(20)
    @QaseTitle("Correct user data")
    public void correct(Payment payment) {

        setAllureParameters(payment);

        fill(payment);
        checkSendPaymentButtonStatus(true);

        makePaymentView
                .touchSendPaymentButton()
                .getQuestionFrame().touchButtonYES();

        HomeView homeView = new HomeView(getDriver());

        try {
            homeView.waitForPaymentHomeView();
        } catch (Exception e) {
            Assert.fail("The home view is not opened");
        }
    }

    @Test(priority = 4, dataProvider = DataProviderNames.INCORRECT_PHONE, dataProviderClass = MakePaymentDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Incorrect phone")
    @QaseId(21)
    @QaseTitle("Incorrect phone")
    public void incorrectPhone(Payment payment) {

        setAllureParameters(payment);

        fill(payment);
        checkSendPaymentButtonStatus(true);
        makePaymentView.touchSendPaymentButton();
        checkAlertFrame("Invalid phone");
    }


    @Test(priority = 8, dataProvider = DataProviderNames.CORRECT, dataProviderClass = MakePaymentDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Blank the \"Phone\" field")
    @QaseId(22)
    @QaseTitle("Blank the \"Phone\" field")
    public void blankPhoneField(Payment payment) {

        setAllureParameters(payment);

        makePaymentView
                .setName(payment.getName())
                .setAmount(payment.getAmount())
                .setCountry(payment.getCountry());

        checkSendPaymentButtonStatus(false);
    }

    @Test(priority = 3, dataProvider = DataProviderNames.INCORRECT_NAME, dataProviderClass = MakePaymentDataProviders.class)
    @Severity(SeverityLevel.NORMAL)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Incorrect name")
    @QaseId(23)
    @QaseTitle("Incorrect name")
    public void incorrectName(Payment payment) {

        setAllureParameters(payment);

        fill(payment);
        checkSendPaymentButtonStatus(true);
        makePaymentView.touchSendPaymentButton();
        checkAlertFrame("Invalid name");
    }

    @Test(priority = 7, dataProvider = DataProviderNames.CORRECT, dataProviderClass = MakePaymentDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Blank the \"Name\" field")
    @QaseId(24)
    @QaseTitle("Blank the \"Name\" field")
    public void blankNameField(Payment payment) {

        setAllureParameters(payment);
        Allure.parameter("Country", payment.getCountry());

        makePaymentView
                .setPhone(payment.getPhone())
                .setAmount(payment.getAmount())
                .setCountry(payment.getCountry());

        checkSendPaymentButtonStatus(false);
    }

    @Test(priority = 2, dataProvider = DataProviderNames.INCORRECT_AMOUNT, dataProviderClass = MakePaymentDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Incorrect amount")
    @QaseId(25)
    @QaseTitle("Incorrect amount")
    public void incorrectAmount(Payment payment) {

        setAllureParameters(payment);

        fill(payment);
        checkSendPaymentButtonStatus(true);
        makePaymentView.touchSendPaymentButton();
        checkAlertFrame("Invalid amount");
    }

    @Test(priority = 6, dataProvider = DataProviderNames.CORRECT, dataProviderClass = MakePaymentDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Blank the \"Amount\" field")
    @QaseId(26)
    @QaseTitle("Blank the \"Amount\" field")
    public void blankAmountField(Payment payment) {

        setAllureParameters(payment);

        makePaymentView
                .setPhone(payment.getPhone())
                .setName(payment.getName())
                .setCountry(payment.getCountry());

        checkSendPaymentButtonStatus(false);
    }

    @Test(priority = 5, dataProvider = DataProviderNames.INCORRECT_COUNTRY, dataProviderClass = MakePaymentDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Incorrect country name")
    @QaseId(27)
    @QaseTitle("Incorrect country name")
    public void incorrectCountry(Payment payment) {

        setAllureParameters(payment);

        fill(payment);
        checkSendPaymentButtonStatus(true);
        makePaymentView.touchSendPaymentButton();
        checkAlertFrame("Invalid country");
    }

    @Test(priority = 9, dataProvider = DataProviderNames.CORRECT, dataProviderClass = MakePaymentDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Blank the \"Country\" field")
    @QaseId(28)
    @QaseTitle("Blank the \"Country\" field")
    public void blankCountryField(Payment payment) {

        setAllureParameters(payment);

        makePaymentView
                .setPhone(payment.getPhone())
                .setName(payment.getName())
                .setAmount(payment.getAmount());

        checkSendPaymentButtonStatus(false);
    }

    @Test(priority = 10, dataProvider = DataProviderNames.CORRECT, dataProviderClass = MakePaymentDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Cancelling the transaction")
    @QaseId(29)
    @QaseTitle("Cancelling the transaction")
    public void cancellingTransaction(Payment payment) {

        setAllureParameters(payment);

        fill(payment);
        checkSendPaymentButtonStatus(true);

        makePaymentView
                .touchSendPaymentButton()
                .getQuestionFrame().touchButtonNO();

        Assert.assertTrue(makePaymentView.isDisplayed(), "The \"Make Payment\" view is not displayed");

    }
}

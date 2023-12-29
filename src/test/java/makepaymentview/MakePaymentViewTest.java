package makepaymentview;

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
    public void  correct(Payment payment) {

        fill(payment);

        makePaymentView.tapSendPaymentButton();
    }
}

package makepaymentview;

import base.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.homeview.HomeView;
import qa.pageobject.makepaymentview.MakePaymentView;
import qa.support.Authentication;

@Epic("E2E")
@Feature("The \"Cancel\" button")
public class CancelButtonTest extends BaseTest {

    private MakePaymentView makePaymentView;

    @BeforeMethod
    public void create() throws JsonProcessingException {

        Authentication.perform(getDriver());
        HomeView homeView = new HomeView(getDriver());
        homeView.touchMakePaymentButton();
        makePaymentView = new MakePaymentView(getDriver());
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("The \"Cancel\" button")
    @QaseId(30)
    @QaseTitle("The \"Cancel\" button")
    public void closingPage() {

        makePaymentView.touchCancelButton();
        HomeView homeView = new HomeView(getDriver());

        try {
            homeView.waitForPaymentHomeView();
        } catch (Exception e) {
            Assert.fail("The home view is not opened");
        };
    }
}

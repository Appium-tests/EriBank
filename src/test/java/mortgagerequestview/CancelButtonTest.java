package mortgagerequestview;

import base.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.enums.View;
import qa.pageobject.homeview.HomeView;
import qa.pageobject.mortgagerequest.MortgageRequestView;
import qa.support.Authentication;
import qa.support.HomeViewManager;

public class CancelButtonTest extends BaseTest {

    private MortgageRequestView mortgageRequestView;

    @BeforeMethod
    public void prepare() throws JsonProcessingException {

        Authentication.perform(getDriver());
        HomeViewManager.open(getDriver(), View.MORTGAGE_REQUEST);
        mortgageRequestView = new MortgageRequestView(getDriver());
    }

    @Test(groups = "default")
    @Severity(SeverityLevel.NORMAL)
    @Tag("View")
    @Tag("Button")
    @Owner("Paweł Aksman")
    @Description("The \"Cancel\" button")
    @QaseId(47)
    @QaseTitle("The \"Cancel\" button")
    public void closingPage() {

        mortgageRequestView.touchCancelButton();
        HomeView homeView = new HomeView(getDriver());

        try {
            homeView.waitForPaymentHomeView();
        } catch (Exception e) {
            Assert.fail("The home view is not opened");
        }
    }
}

package advancedactionsview;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import qa.enums.View;
import qa.pageobject.advancedactionsview.AdvancedActionsView;
import qa.support.Authentication;
import qa.support.HomeViewManager;
import qa.pageobject.homeview.HomeView;
import qa.pageobject.sendvoidrequestview.SendVoidRequestView;


@Epic("E2E")
@Feature("Advanced Actions view buttons")
public class AdvancedActionsViewTest extends BaseTest {

    private AdvancedActionsView advancedActionsView;

    @BeforeMethod
    public void prepare() throws JsonProcessingException {

        Authentication.perform(getDriver());
        HomeViewManager.open(getDriver(), View.ADVANCED_ACTIONS);
        advancedActionsView = new AdvancedActionsView(getDriver());
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Tag("View")
    @Tag("Buttons")
    @Description("The \"Send Void Request\" button")
    @QaseId(58)
    @QaseTitle("The \"Send Void Request\" button")
    public void sendVoidRequestButton() {

        advancedActionsView.touchSendVoidRequestButton();
        SendVoidRequestView sendVoidRequestView = new SendVoidRequestView(getDriver());

        Assert.assertTrue(sendVoidRequestView.isDisplayed(),"The \"Send Void Request\" view is not displayed");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Tag("View")
    @Tag("Buttons")
    @Description("The \"Back\" button")
    @QaseId(59)
    @QaseTitle("The \"Back\" button")
    public void closingView() {

        advancedActionsView.touchBackButton();
        HomeView homeView = new HomeView(getDriver());

        try {
            homeView.waitForPaymentHomeView();
        } catch (Exception e) {
            Assert.fail("The home view is not opened");
        }
    }
}

package advancedactionsview;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
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
@Feature("Advanced Actions buttons")
public class AdvancedActionsViewTest extends BaseTest {

    private AdvancedActionsView advancedActionsView;

    @BeforeMethod
    public void create() throws JsonProcessingException {

        Authentication.perform(getDriver());
        HomeViewManager.open(getDriver(), View.ADVANCED_ACTIONS);
        advancedActionsView = new AdvancedActionsView(getDriver());
    }

    @Test
    @Description("Checking whether the \"Send Void Request\" view opens after touching the \"Send Void Request\" button.")
    @Story("Touching the \"Send Void Request\" button")
    public void sendVoidRequestButton() {

        advancedActionsView.touchSendVoidRequestButton();
        SendVoidRequestView sendVoidRequestView = new SendVoidRequestView(getDriver());

        Assert.assertTrue(sendVoidRequestView.isDisplayed(),
                "The \"Send Void Request\" view is not displayed");
    }

    @Test
    @Description("Verify that the \"Advanced Actions\" view is closed after touching the \"Back\" button")
    @Story("Touching the \"Back\" button")
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

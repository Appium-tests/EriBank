package advancedactionsview;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import qa.enums.View;
import qa.enums.WebViewContext;
import qa.support.Authentication;
import qa.support.HomeViewManager;
import qa.pageobject.homeview.HomeView;
import qa.pageobject.sendvoidrequestview.SendVoidRequestView;
import qa.steps.AdvancedActionsSteps;

@Epic("E2E")
@Feature("Advanced Actions buttons")
public class AdvancedActionsViewTest extends BaseTest {

    private AdvancedActionsSteps advancedActionsSteps;

    @BeforeMethod
    public void create() {

        Authentication.perform(getDriver());
        HomeViewManager.open(getDriver(), View.ADVANCED_ACTIONS);

        advancedActionsSteps = new AdvancedActionsSteps(getDriver());
    }

    @Test
    @Description("Checking whether the \"Send Void Request\" view opens after touching the \"Send Void Request\" button.")
    @Story("Touching the \"Send Void Request\" button")
    public void sendVoidRequestButton() {

        advancedActionsSteps.tapSendVoidRequestButton();
        SendVoidRequestView sendVoidRequestView = new SendVoidRequestView(getDriver());

        Assert.assertTrue(sendVoidRequestView.isDisplayed(),
                "The \"Send Void Request\" view is not displayed");
    }

    @Test
    @Description("Checking whether the \"https://digital.ai...\" website opens after touching the \"EriBank Browser\" button.")
    @Story("Touching the \"EriBank Browser\" button")
    public void eriBankBrowserButton() {

        advancedActionsSteps.tapEriBankBrowserButton();

        String expectedUrl = "https://digital.ai";
        getDriver().context(WebViewContext.CHROME.getName());

        Assert.assertTrue(getDriver().getCurrentUrl().contains(expectedUrl),
                "Incorrect url");
    }

    @Test
    @Description("Verify that the \"Advanced Actions\" view is closed after touching the \"Back\" button")
    @Story("Touching the \"Back\" button")
    public void closingView() {

        advancedActionsSteps.tapBackButton();
        HomeView homeView = new HomeView(getDriver());

        try {
            homeView.waitForPaymentHomeView();
        } catch (Exception e) {
            Assert.fail("The home view is not opened");
        }
    }
}

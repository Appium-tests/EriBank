package qa.steps;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import qa.pageobject.advancedactionsview.AdvancedActionsView;

public class AdvancedActionsSteps {

    private final AdvancedActionsView advancedActionsView;

    public AdvancedActionsSteps(AndroidDriver driver) {

        advancedActionsView = new AdvancedActionsView(driver);
    }

    @Step("Tap the \"Send Void Request\" button")
    public void tapSendVoidRequestButton() {

        advancedActionsView.tapSendVoidRequestButton();
    }

    @Step("Tap the \"EriBank Browser\" button")
    public void tapEriBankBrowserButton() {

        advancedActionsView.tapEriBankBrowserButton();
    }

    @Step("Tap the \"Back\" button")
    public void tapBackButton() {

        advancedActionsView.tapBackButton();
    }

    public AdvancedActionsView getAdvancedActionsView() {

        return advancedActionsView;
    }
}

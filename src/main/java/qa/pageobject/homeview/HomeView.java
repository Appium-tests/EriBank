package qa.pageobject.homeview;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.pageobject.base.BaseView;

import java.util.List;

public class HomeView extends BaseView {

    public HomeView(AndroidDriver driver) {

        super(driver);
    }

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/paymentHomeView")
    List<WebElement> paymentHomeView;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/makePaymentButton")
    WebElement makePaymentButton;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/mortageRequestButton")
    WebElement mortageRequestButton;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/expenseReportButton")
    WebElement expenseReportButton;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/AdvancedActionsButton")
    WebElement advancedActionsButton;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/logoutButton")
    WebElement logoutButton;

    public boolean isDisplayed() {

        return !paymentHomeView.isEmpty();
    }

    @io.qameta.allure.Step("Touch the \"Make Payment\" button")
    @io.qase.api.annotation.Step("Touch the \"Make Payment\" button")
    public void touchMakePaymentButton() {

        getWEB_DRIVER_WAIT().until(ExpectedConditions.elementToBeClickable(makePaymentButton)).click();
    }

    @io.qameta.allure.Step("Touch the \"Mortgage Request\" button")
    @io.qase.api.annotation.Step("Touch the \"Mortgage Request\" button")
    public void touchMortgageRequestButton() {

        getWEB_DRIVER_WAIT().until(ExpectedConditions.elementToBeClickable(mortageRequestButton)).click();
    }

    @io.qameta.allure.Step("Touch the \"Expense Report\" button")
    @io.qase.api.annotation.Step("Touch the \"Expense Report\" button")
    public void touchExpenseReportButton() {

        getWEB_DRIVER_WAIT().until(ExpectedConditions.elementToBeClickable(expenseReportButton)).click();
    }

    @io.qameta.allure.Step("Touch the \"Advanced Actions\" button")
    @io.qase.api.annotation.Step("Touch the \"Advanced Actions\" button")
    public void touchAdvancedActionsButton() {

        getWEB_DRIVER_WAIT().until(ExpectedConditions.elementToBeClickable(advancedActionsButton)).click();
    }

    @io.qameta.allure.Step("Touch the \"Logout\" button")
    @io.qase.api.annotation.Step("Touch the \"Logout\" button")
    public void touchLogoutButton() {

        getWEB_DRIVER_WAIT().until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }
}

package qa.pageobject.homeview;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.pageobject.base.BaseView;

public class HomeView extends BaseView {

    private final By paymentHomeView;

    public HomeView(AndroidDriver driver) {

        super(driver);

        paymentHomeView = By.id("com.experitest.ExperiBank:id/paymentHomeView");
    }

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

    public void waitForPaymentHomeView() {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(paymentHomeView));
    }

    @io.qameta.allure.Step("Touch the \"Make Payment\" button")
    @io.qase.api.annotation.Step("Touch the \"Make Payment\" button")
    public void touchMakePaymentButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(makePaymentButton)).click();
    }

    @io.qameta.allure.Step("Touch the \"Mortgage Request\" button")
    @io.qase.api.annotation.Step("Touch the \"Mortgage Request\" button")
    public void touchMortgageRequestButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(mortageRequestButton)).click();
    }

    @io.qameta.allure.Step("Touch the \"Expense Report\" button")
    @io.qase.api.annotation.Step("Touch the \"Expense Report\" button")
    public void touchExpenseReportButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(expenseReportButton)).click();
    }

    @io.qameta.allure.Step("Touch the \"Advanced Actions\" button")
    @io.qase.api.annotation.Step("Touch the \"Advanced Actions\" button")
    public void touchAdvancedActionsButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(advancedActionsButton)).click();
    }

    @io.qameta.allure.Step("Touch the \"Logout\" button")
    @io.qase.api.annotation.Step("Touch the \"Logout\" button")
    public void touchLogoutButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }
}

package expensereportview;

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
import qa.pageobject.expensereportview.ExpenseReportView;
import qa.pageobject.homeview.HomeView;
import qa.support.Authentication;
import qa.support.HomeViewManager;

public class BackButtonTest extends BaseTest {

    private ExpenseReportView expenseReportView;

    @BeforeMethod
    public void create() throws JsonProcessingException {

        Authentication.perform(getDriver());
        HomeViewManager.open(getDriver(), View.EXPENSE_REPORT);
        expenseReportView = new ExpenseReportView(getDriver());
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Tag("View")
    @Tag("Buttons")
    @Owner("Paweł Aksman")
    @Description("The \"Back\" button")
    @QaseId(57)
    @QaseTitle("The \"Back\" button")
    public void backButton() {

        expenseReportView.touchBackButton();
        HomeView homeView = new HomeView(getDriver());

        try {
            homeView.waitForPaymentHomeView();
        } catch (Exception e) {
            Assert.fail("The home view is not opened");
        }
    }
}

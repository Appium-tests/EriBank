package homeview;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import qa.support.Authentication;
import qa.pageobject.advancedactionsview.AdvancedActionsView;
import qa.pageobject.expensereportview.ExpenseReportView;
import qa.pageobject.homeview.HomeView;
import qa.pageobject.loginview.LoginView;
import qa.pageobject.makepaymentview.MakePaymentView;
import qa.pageobject.mortgagerequest.MortgageRequestView;

@Epic("E2E")
@Feature("The home view")
public class HomeViewTest extends BaseTest {

    private HomeView homeView;

    @BeforeMethod
    public void create() {

        Authentication.perform(getDriver());
        homeView = new HomeView(getDriver());
    }

    @Test(priority = 1)
    @QaseId(12)
    @QaseTitle("The \"Make Payment\" button")
    @Description("The \"Make Payment\" button")
    public void makePaymentButton() {

        homeView.touchMakePaymentButton();
        MakePaymentView makePaymentView = new MakePaymentView(getDriver());

        Assert.assertTrue(makePaymentView.isDisplayed(),
                "The \"Make payment\" view is not displayed");
    }

    @Test(priority = 2)
    @QaseId(13)
    @QaseTitle("The \"Mortgage Request\" button")
    @Description("The \"Mortgage Request\" button")
    public void mortgageRequestButton() {

        homeView.touchMortgageRequestButton();
        MortgageRequestView mortgageRequestView = new MortgageRequestView(getDriver());

        Assert.assertTrue(mortgageRequestView.isDisplayed(),
                "The \"Mortgage request\" view is not displayed");
    }

    @Test(priority = 3)
    @QaseId(14)
    @QaseTitle("The \"Expense Report\" button")
    @Description("The \"Expense Report\" button")
    public void expenseReportButton() {

        homeView.touchExpenseReportButton();
        ExpenseReportView expenseReportView = new ExpenseReportView(getDriver());

        Assert.assertTrue(expenseReportView.isDisplayed(),
                "The \"Expense report\" view is not displayed");
    }

    @Test(priority = 4)
    @QaseId(15)
    @QaseTitle("The \"Advanced Actions\" button")
    @Description("The \"Advanced Actions\" button")
    public void advancedActionsButton() {

        homeView.touchAdvancedActionsButton();
        AdvancedActionsView advancedActionsView = new AdvancedActionsView(getDriver());

        Assert.assertTrue(advancedActionsView.isDisplayed(),
                "The \"Advanced Actions\" view is not displayed");
    }

    @Test(priority = 5)
    @QaseId(16)
    @QaseTitle("The \"Logout\" button")
    @Description("The \"Logout\" button")
    public void logoutButton() {

        homeView.touchLogoutButton();
        LoginView loginView = new LoginView(getDriver());

        Assert.assertTrue(loginView.isDisplayed(),
                "The user is not logged out");
    }
}

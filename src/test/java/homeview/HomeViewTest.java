package homeview;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.helpers.Authentication;
import qa.pageobject.advancedactionsview.AdvancedActionsView;
import qa.pageobject.expensereportview.ExpenseReportView;
import qa.pageobject.homeview.HomeView;
import qa.pageobject.loginview.LoginView;
import qa.pageobject.makepaymentview.MakePaymentView;
import qa.pageobject.mortgagerequest.MortgageRequestView;

@Epic("E2E")
@Feature("Home view buttons")
public class HomeViewTest extends BaseTest {

    private HomeView homeView;

    @BeforeMethod
    public void create() {

        Authentication.perform(getDriver());
        homeView = new HomeView(getDriver());
    }

    @Test
    @Description("Checking whether the \"Make Payment\" view opens after touching the \"Make Payment\" button.")
    @Story("Touching the \"Make Payment\" button")
    public void makePaymentButton() {

        homeView.tapMakePaymentButton();
        MakePaymentView makePaymentView = new MakePaymentView(getDriver());

        Assert.assertTrue(makePaymentView.isDisplayed(),
                "The \"Make payment\" view is not displayed");
    }

    @Test
    @Description("Checking whether the \"Mortgage Request\" view opens after touching the \"Mortgage Request\" button.")
    @Story("Touching the \"Mortgage Request\" button")
    public void mortageRequestButton() {

        homeView.tapMortageRequestButton();
        MortgageRequestView mortgageRequestView = new MortgageRequestView(getDriver());

        Assert.assertTrue(mortgageRequestView.isDisplayed(),
                "The \"Mortgage request\" view is not displayed");
    }

    @Test
    @Description("Checking whether the \"Expense Report\" view opens after touching the \"Expense Report\" button.")
    @Story("Touching the \"Expense Report\" button")
    public void expenseReportButton() {

        homeView.tapExpenseReportButton();
        ExpenseReportView expenseReportView = new ExpenseReportView(getDriver());

        Assert.assertTrue(expenseReportView.isDisplayed(),
                "The \"Expense report\" view is not displayed");
    }

    @Test
    @Description("Checking whether the \"Advanced Actions\" view opens after touching the \"Advanced Actions\" button.")
    @Story("Touching the \"Advanced Actions\" button")
    public void advancedActionsButton() {

        homeView.tapAdvancedActionsButton();
        AdvancedActionsView advancedActionsView = new AdvancedActionsView(getDriver());

        Assert.assertTrue(advancedActionsView.isDisplayed(),
                "The \"Advanced Actions\" view is not displayed");
    }

    @Test
    @Description("Checking whether the user is logged out after touching the \"Logout\" button.")
    @Story("Touching the \"Logout\" button")
    public void logoutButton() {

        homeView.tapLogoutButton();
        LoginView loginView = new LoginView(getDriver());

        Assert.assertTrue(loginView.isDisplayed(),
                "The user is not logged out");
    }
}

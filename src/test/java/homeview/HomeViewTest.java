package homeview;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.helpers.Authentication;
import qa.pageobject.expensereportview.ExpenseReportView;
import qa.pageobject.homeview.HomeView;
import qa.pageobject.loginview.LoginView;
import qa.pageobject.makepaymentview.MakePaymentView;
import qa.pageobject.mortagerequest.MortageRequestView;

public class HomeViewTest extends BaseTest {

    private HomeView homeView;

    @BeforeMethod
    public void create() {

        Authentication.perform(getDriver());
        homeView = new HomeView(getDriver());
    }

    @Test
    public void makePaymentButton() {

        homeView.tapMakePaymentButton();
        MakePaymentView makePaymentView = new MakePaymentView(getDriver());

        Assert.assertTrue(makePaymentView.isDisplayed(), "The \"Make payment\" view is not displayed");
    }

    @Test
    public void mortageRequestButton() {

        homeView.tapMortageRequestButton();
        MortageRequestView mortageRequestView = new MortageRequestView(getDriver());

        Assert.assertTrue(mortageRequestView.isDisplayed(), "The \"Mortage request\" view is not displayed");
    }

    @Test
    public void expenseReportButton() {

        homeView.tapExpenseReportButton();
        ExpenseReportView expenseReportView = new ExpenseReportView(getDriver());

        Assert.assertTrue(expenseReportView.isDisplayed(), "The \"Expense report\" view is not displayed");
    }

    @Test
    public void logoutButton() {

        homeView.tapLogoutButton();
        LoginView loginView = new LoginView(getDriver());

        Assert.assertTrue(loginView.isDisplayed());
    }
}

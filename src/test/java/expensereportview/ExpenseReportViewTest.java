package expensereportview;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import qa.enums.View;
import qa.support.Authentication;
import qa.support.DynamicList;
import qa.support.HomeViewManager;
import qa.pageobject.homeview.HomeView;
import qa.steps.ExpenseReportSteps;

@Epic("E2E")
@Feature("Expense Report functionalities")
public class ExpenseReportViewTest extends BaseTest {

    private ExpenseReportSteps expenseReportSteps;

    @BeforeMethod
    public void create() {

        Authentication.perform(getDriver());
        HomeViewManager.open(getDriver(), View.EXPENSE_REPORT);

        expenseReportSteps = new ExpenseReportSteps(getDriver());
    }

    @Test
    @Description("Checking whether a row is added after touching the \"Add\" button")
    @Story("Touching the \"Add\" button")
    public void addingRow() {

        int currentCount = expenseReportSteps.getExpenseReportView().getCount();
        int expectedCount = currentCount + 1;

        expenseReportSteps.tapAddButton();

        Assert.assertTrue(expenseReportSteps.getExpenseReportView().getCount() > currentCount,
                "The row has not been added");
        Assert.assertEquals(expenseReportSteps.getExpenseReportView().getCount(), expectedCount,
                "Incorrect number of rows");
    }

    @Test
    @Description("Checking whether a row is removed after touching on the row")
    @Story("Touching on the row")
    public void removingRow() {

        int numberOfRows = 2;

        DynamicList.addRows(expenseReportSteps.getExpenseReportView(), numberOfRows);

        int currentCount = expenseReportSteps.getExpenseReportView().getCount();
        int expectedCount = currentCount - 1;

        expenseReportSteps.tapOnRow(1);

        Assert.assertTrue(expenseReportSteps.getExpenseReportView().getCount() < currentCount,
                "The row has not been removed");
        Assert.assertEquals(expenseReportSteps.getExpenseReportView().getCount(), expectedCount,
                "Incorrect number of rows");
    }

    @Test
    @Description("Verify that the \"Expense Report\" view is closed after touching the \"Back\" button")
    @Story("Touching the \"Back\" button")
    public void closingView() {

        expenseReportSteps.tapBackButton();

        HomeView homeView = new HomeView(getDriver());

        Assert.assertTrue(homeView.isDisplayed(),
                "The \"Expense Report\" view is not closed");
    }
}

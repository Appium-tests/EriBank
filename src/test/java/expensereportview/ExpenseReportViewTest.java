package expensereportview;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import qa.enums.View;
import qa.pageobject.expensereportview.ExpenseReportView;
import qa.pageobject.homeview.HomeView;
import qa.support.Authentication;
import qa.support.HomeViewManager;
import qa.support.RandomValue;

@Epic("E2E")
@Feature("Expense Report functionalities")
public class ExpenseReportViewTest extends BaseTest {

    private ExpenseReportView expenseReportView;
    private int maxElementsToAdd;
    private int maxElementsToRemove;


    @BeforeMethod(onlyForGroups = "withoutAddedElements")
    public void prepare() throws JsonProcessingException {

        initialize();
        maxElementsToAdd = RandomValue.get(2, 5);
    }

    @BeforeMethod(onlyForGroups = {"withAddedElements"})
    public void prepareWithAddedElements() throws JsonProcessingException {

        initialize();
        maxElementsToAdd = RandomValue.get(2, 5);
        addRows();
        maxElementsToRemove = RandomValue.get(1, expenseReportView.getCount() - 2);
    }

    private void initialize() throws JsonProcessingException {

        Authentication.perform(getDriver());
        HomeViewManager.open(getDriver(), View.EXPENSE_REPORT);
        expenseReportView = new ExpenseReportView(getDriver());
    }

    private void addRows() {

        for (int i = 0; i < maxElementsToAdd; i++) {
            expenseReportView.touchAddButton();
        }
    }

    @Test(groups = "withoutAddedElements")
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Adding an element")
    public void addingElements() {

        addRows();
        Assert.assertEquals(expenseReportView.getCount(), maxElementsToAdd + 1,"Incorrect number of elements");
    }

    @Test(groups = "withAddedElements")
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Removing an element")
    public void removingElements() {

        int previousSize = expenseReportView.getCount();

        for (int i = expenseReportView.getCount() - 1; i > maxElementsToRemove; i--) {
            expenseReportView.touchElement(i);
        }

        Assert.assertTrue(expenseReportView.getCount() < previousSize ,"The actual number of elements is not less than previous number");
    }

    @Test(groups = "withoutAddedElements")
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("The \"Back\" button")
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

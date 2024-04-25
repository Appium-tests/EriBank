package expensereportview;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import qa.enums.View;
import qa.pageobject.expensereportview.ExpenseReportView;
import qa.support.Authentication;
import qa.support.HomeViewManager;
import qa.support.RandomValue;

@Epic("E2E")
@Feature("Adding and removing expenses")
public class ExpenseReportViewTest extends BaseTest {

    private ExpenseReportView expenseReportView;
    private int maxElementsToAdd;
    private int maxElementsToRemove;

    public ExpenseReportViewTest() { }

    public ExpenseReportViewTest(int maxElementsToAdd) {

        this.maxElementsToAdd = maxElementsToAdd;
    }

    @BeforeMethod(onlyForGroups = "withoutAddedElements")
    public void prepare() throws JsonProcessingException {

        initialize();
        maxElementsToAdd = RandomValue.get(2, 5);
    }

    @BeforeMethod(onlyForGroups = {"withAddedElements"})
    public void prepareWithAddedElements() throws JsonProcessingException {

        initialize();
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

    @Test(priority = 1, groups = "withoutAddedElements")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("View")
    @Tag("Adding")
    @Owner("Paweł Aksman")
    @Description("Adding an expense")
    @QaseId(55)
    @QaseTitle("Adding an expense")
    public void addingElements() {

        addRows();
        Assert.assertEquals(expenseReportView.getCount(), maxElementsToAdd + 1,"Incorrect number of elements");
    }

    @Test(priority = 2, groups = "withAddedElements")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("View")
    @Tag("Removing")
    @Owner("Paweł Aksman")
    @Description("Removing an expense")
    @QaseId(56)
    @QaseTitle("Removing an expense")
    public void removingElements() {

        int previousSize = expenseReportView.getCount();

        for (int i = expenseReportView.getCount() - 1; i > maxElementsToRemove; i--) {
            expenseReportView.touchElement(i);
        }

        Assert.assertTrue(expenseReportView.getCount() < previousSize ,"The actual number of elements is not less than previous number");
    }
}

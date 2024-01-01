package qa.steps;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import qa.pageobject.expensereportview.ExpenseReportView;

public class ExpenseReportSteps {

    private final ExpenseReportView expenseReportView;

    public ExpenseReportSteps(AndroidDriver driver) {

        expenseReportView = new ExpenseReportView(driver);
    }

    @Step("Tap the \"Add\" button")
    public void tapAddButton() {

        expenseReportView.tapAddButton();
    }

    @Step("Tap on row")
    public void tapOnRow(int index) {

        expenseReportView.tapOnRow(index);
    }

    @Step("Tap the \"Back\" button")
    public void tapBackButton() {

        expenseReportView.tapBackButton();
    }

    public ExpenseReportView getExpenseReportView() {

        return expenseReportView;
    }
}

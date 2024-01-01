package qa.helpers;

import qa.pageobject.expensereportview.ExpenseReportView;

public class DynamicList {

    public static void addRows(ExpenseReportView expenseReportView, int number) {

        for (int i = 0; i < number; i++) {

            expenseReportView.tapAddButton();
        }
    }
}

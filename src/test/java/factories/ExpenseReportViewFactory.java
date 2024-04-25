package factories;

import expensereportview.ExpenseReportViewTest;
import org.testng.annotations.Factory;
import qa.support.RandomValue;

public class ExpenseReportViewFactory {

    @Factory
    public Object[] createInstance() {

        int maxElementsToAdd = RandomValue.get(2, 5);
        return new Object[] { new ExpenseReportViewTest(maxElementsToAdd) };
    }
}

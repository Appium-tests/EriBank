package qa.pageobject.expensereportview;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import qa.pageobject.base.BaseView;

import java.util.List;

public class ExpenseReportView extends BaseView {

    public ExpenseReportView(AndroidDriver driver) {

        super(driver);
    }

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/makePaymentView")
    List<WebElement> parent;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/addButton")
    WebElement addButton;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/backButton")
    WebElement backButton;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/titleTextView")
    List<WebElement> expenseTitles;

    public void tapAddButton() {

        addButton.click();
    }

    public void tapBackButton() {

        backButton.click();
    }

    public int getCount() {

        return expenseTitles.size();
    }

    public void tapOnRow(int row) {

        expenseTitles.get(row).click();
    }

    public boolean isDisplayed() {

        return !parent.isEmpty();
    }
}

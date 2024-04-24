package qa.pageobject.expensereportview;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    @io.qameta.allure.Step("Touch the \"Add\" button")
    @io.qase.api.annotation.Step("Touch the \"Add\" button")
    public void touchAddButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(addButton)).click();
    }

    @io.qameta.allure.Step("Touch the \"Add\" button")
    @io.qase.api.annotation.Step("Touch the \"Add\" button")
    public void touchBackButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(backButton)).click();
    }

    public int getCount() {

        return expenseTitles.size();
    }

    @io.qameta.allure.Step("Touch the element")
    @io.qase.api.annotation.Step("Touch the element")
    public void touchElement(int index) {

        expenseTitles.get(index).click();
    }

    public boolean isDisplayed() {

        return !parent.isEmpty();
    }
}

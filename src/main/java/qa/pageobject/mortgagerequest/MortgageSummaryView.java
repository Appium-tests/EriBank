package qa.pageobject.mortgagerequest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import qa.pageobject.base.BaseView;

import java.util.List;

public class MortgageSummaryView extends BaseView {

    public MortgageSummaryView(AndroidDriver driver) {

        super(driver);
    }

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/typeOfLoanListView")
    List<WebElement> typeOfLoanListView;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/numberOfYearsListView")
    List<WebElement> numberOfYearsListView;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/typeOfOccupationListView")
    List<WebElement> typeOfOccupationListView;

    public boolean isDisplayed() {

        return !typeOfLoanListView.isEmpty() &&
               !numberOfYearsListView.isEmpty() &&
               !typeOfOccupationListView.isEmpty();
    }
}

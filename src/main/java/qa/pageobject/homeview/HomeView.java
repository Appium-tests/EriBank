package qa.pageobject.homeview;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import qa.base.BaseView;

import java.util.List;

public class HomeView extends BaseView {

    public HomeView(AndroidDriver driver) {

        super(driver);
    }

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/paymentHomeView")
    List<WebElement> paymentHomeView;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/makePaymentButton")
    WebElement makePaymentButton;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/mortageRequestButton")
    WebElement mortageRequestButton;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/expenseReportButton")
    WebElement expenseReportButton;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/AdvancedActionsButton")
    WebElement advancedActionsButton;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/logoutButton")
    WebElement logoutButton;

    public boolean isDisplayed() {

        return !paymentHomeView.isEmpty();
    }

    public void tapMakePaymentButton() {

        makePaymentButton.click();
    }

    public void tapMortageRequestButton() {

        mortageRequestButton.click();
    }

    public void tapExpenseReportButton() {

        expenseReportButton.click();
    }

    public void tapAdvancedActionsButton() {

        advancedActionsButton.click();
    }

    public void tapLogoutButton() {

        logoutButton.click();
    }
}

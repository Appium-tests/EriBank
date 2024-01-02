package qa.homeviewmanager;

import io.appium.java_client.android.AndroidDriver;
import qa.enums.View;
import qa.pageobject.homeview.HomeView;

public class HomeViewManager {

    public static void open(AndroidDriver driver, View view) {

        HomeView homeView = new HomeView(driver);

        switch (view) {
            case MAKE_PAYMENT -> homeView.tapMakePaymentButton();
            case MORTGAGE_REQUEST -> homeView.tapMortageRequestButton();
            case EXPENSE_REPORT -> homeView.tapExpenseReportButton();
            case ADVANCED_ACTIONS -> homeView.tapAdvancedActionsButton();
        }
    }
}

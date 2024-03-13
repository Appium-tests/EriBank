package qa.homeviewmanager;

import io.appium.java_client.android.AndroidDriver;
import qa.enums.View;
import qa.pageobject.homeview.HomeView;

public class HomeViewManager {

    public static void open(AndroidDriver driver, View view) {

        HomeView homeView = new HomeView(driver);

        switch (view) {
            case MAKE_PAYMENT -> homeView.touchMakePaymentButton();
            case MORTGAGE_REQUEST -> homeView.touchMortgageRequestButton();
            case EXPENSE_REPORT -> homeView.touchExpenseReportButton();
            case ADVANCED_ACTIONS -> homeView.touchAdvancedActionsButton();
        }
    }
}

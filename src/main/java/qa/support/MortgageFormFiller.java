package qa.support;

import io.appium.java_client.android.AndroidDriver;
import qa.enums.View;
import qa.pageobject.mortgagerequest.MortgageRequestView;

public class MortgageFormFiller {

    public static void perform(AndroidDriver driver) {

        HomeViewManager.open(driver, View.MORTGAGE_REQUEST);
        MortgageRequestView mortgageRequestView = new MortgageRequestView(driver);

        mortgageRequestView
                .setFirstName("John")
                .setLastName("Doe")
                .setAge("35")
                .setAddress1("Address 1")
                .setAddress2("Address 2")
                .setCountry("Germany")
                .touchNextButton();
    }
}

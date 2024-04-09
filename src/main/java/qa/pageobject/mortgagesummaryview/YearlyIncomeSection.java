package qa.pageobject.mortgagesummaryview;

import io.appium.java_client.android.AndroidDriver;

public class YearlyIncomeSection extends BaseSection {

    public YearlyIncomeSection(AndroidDriver driver) {

        super(driver, "com.experitest.ExperiBank:id/yearlyIncomeListView",
                "//android.widget.CheckedTextView[@resource-id='com.experitest.ExperiBank:id/rowTextView' and @text='");
    }
}

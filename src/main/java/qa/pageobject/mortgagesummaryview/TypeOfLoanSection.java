package qa.pageobject.mortgagesummaryview;

import io.appium.java_client.android.AndroidDriver;

public class TypeOfLoanSection extends BaseSection {

    public TypeOfLoanSection(AndroidDriver driver) {

        super(driver,"//android.widget.CheckedTextView[@resource-id='com.experitest.ExperiBank:id/rowTextView' and @text='");
    }
}

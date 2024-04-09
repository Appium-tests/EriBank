package qa.pageobject.mortgagesummaryview;

import io.appium.java_client.android.AndroidDriver;

public class TypeOfOccupationSection extends BaseSection {

    public TypeOfOccupationSection(AndroidDriver driver) {

        super(driver, "com.experitest.ExperiBank:id/typeOfOccupationListView",
                "//android.widget.CheckedTextView[@resource-id='com.experitest.ExperiBank:id/rowTextView' and @text='"
        );
    }
}

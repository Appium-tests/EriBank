package qa.beforetesting;

import io.appium.java_client.android.AndroidDriver;
import qa.pageobject.beforetesting.AccessPermissionsFrame;
import qa.pageobject.beforetesting.AndroidOldVersionWarningFrame;
import qa.pageobject.beforetesting.PasswordSavingAdviceFrame;

public class ActionsBeforeTesting {

    public static void perform(AndroidDriver driver) {

        AccessPermissionsFrame accessPermissionsFrame = new AccessPermissionsFrame(driver);
        AndroidOldVersionWarningFrame oldVersionWarningFrame = new AndroidOldVersionWarningFrame(driver);

        if (!accessPermissionsFrame.isSwitchButtonOn()) {

            accessPermissionsFrame.tapSwitchButton();
        }

        accessPermissionsFrame.tapContinueButton();
        oldVersionWarningFrame.tapButtonOK();
    }
}

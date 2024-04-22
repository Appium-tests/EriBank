package qa.pageobject.mortgagesummaryview;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.pageobject.base.BaseView;

public class BaseSection extends BaseView {

    @lombok.Getter
    private final By listView;
    private final String itemXPath;
    private final String partialUiAutomatorString = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"";

    public BaseSection(AndroidDriver driver, String itemXPath) {

        super(driver);

        listView = By.className("android.widget.ListView");
        this.itemXPath = itemXPath;
    }

    @io.qameta.allure.Step("Swipe to desired element")
    @io.qase.api.annotation.Step("Swipe to desired element")
    public void swipeToDesiredItem(String name) {

        String uiAutomatorString = partialUiAutomatorString + name + "\"))";
        getDriver().findElement(new AppiumBy.ByAndroidUIAutomator(uiAutomatorString));
    }

    public boolean isItemVisible(String name) {

        return getWebDriverWait().until(ExpectedConditions.elementToBeClickable(
                getDriver().findElement(By.xpath(itemXPath + name + "']"))
        )).isDisplayed();
    }

    @io.qameta.allure.Step("Touch the item")
    @io.qase.api.annotation.Step("Touch the item")
    public void touchItem(String name) {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(
                getDriver().findElement(By.xpath(itemXPath + name + "']"))
        )).click();
    }

    public String getItemCheckedStatus(String name) {

        return getDriver().findElement(By.xpath(itemXPath + name + "']")).getAttribute("checked");
    }
}

package qa.pageobject.countrylist;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.pageobject.base.BaseView;

import java.util.List;

public class CountryList extends BaseView {

    @Getter
    private String countryName = "";
    private final String partialUiAutomatorString = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"";
    private final String partialXPath = "//android.widget.TextView[@resource-id='com.experitest.ExperiBank:id/rowTextView' and @text='";


    public CountryList(AndroidDriver driver) {

        super(driver);
    }

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/countryList")
    List<WebElement> parent;


    @io.qameta.allure.Step("Swipe to desired element")
    @io.qase.api.annotation.Step("Swipe to desired element")
    public void swipeToDesiredItem(String countryName) {

        String uiAutomatorString = partialUiAutomatorString + countryName + "\"))";
        getDriver().findElement(new AppiumBy.ByAndroidUIAutomator(uiAutomatorString));
    }

    @io.qameta.allure.Step("Select a country")
    @io.qase.api.annotation.Step("Select a country")
    public void selectCountry(String country) {

        WebElement element = getWebDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath(partialXPath + country + "']")));
        countryName = element.getText();
        element.click();
    }

    public boolean isItemVisible(String country) {

        return getWebDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath(partialXPath + country + "']"))).isDisplayed();
    }

    public boolean isDisplayed() {

        return !parent.isEmpty();
    }
}

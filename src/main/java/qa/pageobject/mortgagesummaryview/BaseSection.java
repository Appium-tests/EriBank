package qa.pageobject.mortgagesummaryview;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.pageobject.base.BaseView;

public class BaseSection extends BaseView {

    private final By parent;
    private final String itemXPath;

    public BaseSection(AndroidDriver driver, String parentXPath, String itemXPath) {

        super(driver);

        parent = By.xpath(parentXPath);
        this.itemXPath = itemXPath;
    }

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/saveButton")
    WebElement saveButton;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/backButton")
    WebElement backButton;

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

    public WebElement getParent() {

        return getDriver().findElement(parent);
    }

    @io.qameta.allure.Step("Touch the \"Save\" button")
    @io.qase.api.annotation.Step("Touch the \"Save\" button")
    public void touchSaveButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

    @io.qameta.allure.Step("Touch the \"Back\" button")
    @io.qase.api.annotation.Step("Touch the \"Back\" button")
    public void touchBackButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(backButton)).click();
    }
}

package qa.pageobject.mortgagesummaryview;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.pageobject.base.BaseView;
import qa.support.SwipingHelper;

import java.util.List;
import java.util.Optional;

public class MortgageSummaryView extends BaseView {

    @Getter
    private final TypeOfLoanSection typeOfLoanSection;
    @Getter
    private final NumberOfYearsSection numberOfYearsSection;
    @Getter
    private final TypeOfOccupationSection typeOfOccupationSection;
    @Getter
    private final YearlyIncomeSection yearlyIncomeSection;

    public MortgageSummaryView(AndroidDriver driver) {

        super(driver);

        this.typeOfLoanSection = new TypeOfLoanSection(getDriver());
        this.numberOfYearsSection = new NumberOfYearsSection(getDriver());
        this.typeOfOccupationSection = new TypeOfOccupationSection(getDriver());
        this.yearlyIncomeSection = new YearlyIncomeSection(getDriver());
    }

    @AndroidFindBy(className = "android.widget.CheckedTextView")
    List<WebElement> itemsList;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/saveButton")
    WebElement saveButton;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/backButton")
    WebElement backButton;

    public boolean isDisplayed() {

        return !typeOfLoanSection.getParent().isDisplayed() &&
               !numberOfYearsSection.getParent().isDisplayed() &&
               !typeOfOccupationSection.getParent().isDisplayed() &&
               !yearlyIncomeSection.getParent().isDisplayed();
    }

    public void swipeDown() {

        Point to = itemsList.get(0).getLocation();
        Point from = itemsList.get(itemsList.size() - 1).getLocation();
        SwipingHelper.swipe(from, to, getDriver());
    }

    public void swipeUp() {

        Optional<WebElement> from = itemsList.stream().filter(WebElement::isDisplayed).findFirst();
        Point to = itemsList.get(itemsList.size() - 1).getLocation();
        from.ifPresent(webElement -> SwipingHelper.swipe(webElement.getLocation(), to, getDriver()));
    }

    public boolean isFirstItemVisible() {

        return itemsList.get(0).getText().equals("Home");
    }

    public boolean isLastItemVisible() {

        return itemsList.get(itemsList.size() - 1).getText().equals("More");
    }

    @io.qameta.allure.Step("Click the \"Save\" button")
    @io.qase.api.annotation.Step("Click the \"Save\" button")
    public void clickSaveButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

    @io.qameta.allure.Step("Click the \"Back\" button")
    @io.qase.api.annotation.Step("Click the \"Back\" button")
    public void clickBackButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(backButton)).click();
    }
}

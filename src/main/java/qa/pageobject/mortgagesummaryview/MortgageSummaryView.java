package qa.pageobject.mortgagesummaryview;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.pageobject.base.BaseView;

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

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/saveButton")
    WebElement saveButton;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/backButton")
    WebElement backButton;


    public void waitForTypeOfLoanSectionListView() {

        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(typeOfLoanSection.getListView()));
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

package qa.pageobject.mortgagesummaryview;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
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

        this.typeOfLoanSection = new TypeOfLoanSection(getDRIVER());
        this.numberOfYearsSection = new NumberOfYearsSection(getDRIVER());
        this.typeOfOccupationSection = new TypeOfOccupationSection(getDRIVER());
        this.yearlyIncomeSection = new YearlyIncomeSection(getDRIVER());
    }

    @AndroidFindBy(className = "android.widget.CheckedTextView")
    List<WebElement> itemsList;

    public boolean isDisplayed() {

        return !typeOfLoanSection.getParent().isDisplayed() &&
               !numberOfYearsSection.getParent().isDisplayed() &&
               !typeOfOccupationSection.getParent().isDisplayed() &&
               !yearlyIncomeSection.getParent().isDisplayed();
    }

    public void swipeDown() {

        Point to = itemsList.get(0).getLocation();
        Point from = itemsList.get(itemsList.size() - 1).getLocation();
        SwipingHelper.swipe(from, to, getDRIVER());
    }

    public void swipeUp() {

        Optional<WebElement> from = itemsList.stream().filter(WebElement::isDisplayed).findFirst();
        Point to = itemsList.get(itemsList.size() - 1).getLocation();
        from.ifPresent(webElement -> SwipingHelper.swipe(webElement.getLocation(), to, getDRIVER()));
    }

    public boolean isFirstItemVisible() {

        return itemsList.get(0).getText().equals("Home");
    }

    public boolean isLastItemVisible() {

        return itemsList.get(itemsList.size() - 1).getText().equals("More");
    }
}

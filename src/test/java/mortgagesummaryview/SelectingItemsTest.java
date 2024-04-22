package mortgagesummaryview;

import base.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataproviders.SectionsDataProvider;
import qa.pageobject.mortgagesummaryview.MortgageSummaryView;
import qa.support.Authentication;
import qa.support.DataProviderNames;
import qa.support.MortgageFormFiller;

@Epic("E2E")
@Feature("Touching items")
public class SelectingItemsTest extends BaseTest {

    private MortgageSummaryView mortgageSummaryView;

    @BeforeMethod
    public void create() throws JsonProcessingException {

        Authentication.perform(getDriver());
        MortgageFormFiller.perform(getDriver());
        mortgageSummaryView = new MortgageSummaryView(getDriver());
    }

    @Test(priority = 1, dataProvider = DataProviderNames.TYPE_OF_LOAN, dataProviderClass = SectionsDataProvider.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("View")
    @Tag("List")
    @Tag("Item")
    @Owner("Paweł Aksman")
    @Description("Swiping the view")
    @QaseId(49)
    @QaseTitle("Touching the \"Type Of Loan\" items")
    public void selectingTypeOfLoanSectionItems(String itemName) {

        Allure.parameter("Item", itemName);

        mortgageSummaryView.getTypeOfLoanSection().touchItem(itemName);
        Assert.assertEquals(mortgageSummaryView.getTypeOfLoanSection().getItemCheckedStatus(itemName), "true",
                "The + \"" + itemName + "\" item is not checked");
    }

    @Test(priority = 2, dataProvider = DataProviderNames.NUMBER_OF_YEARS, dataProviderClass = SectionsDataProvider.class)
    @Tag("View")
    @Tag("List")
    @Tag("Item")
    @Owner("Paweł Aksman")
    @Description("Swiping the view")
    @QaseId(50)
    @QaseTitle("Touching the \"Number Of Years\" items")
    public void selectingNumberOfYearsSectionItems(String itemName) {

        Allure.parameter("Item", itemName);

        mortgageSummaryView.getNumberOfYearsSection().touchItem(itemName);
        Assert.assertEquals(mortgageSummaryView.getNumberOfYearsSection().getItemCheckedStatus(itemName), "true",
                "The + \"" + itemName + "\" item is not checked");
    }

    @Test(priority = 3, dataProvider = DataProviderNames.TYPE_OF_OCCUPATION, dataProviderClass = SectionsDataProvider.class)
    @Tag("View")
    @Tag("List")
    @Tag("Item")
    @Owner("Paweł Aksman")
    @Description("Swiping the view")
    @QaseId(51)
    @QaseTitle("Touching the \"Type Of Occupation\" items")
    public void selectingTypeOfOccupationSectionItems(String itemName) {

        Allure.parameter("Item", itemName);

        mortgageSummaryView.getTypeOfOccupationSection().swipeToDesiredItem(itemName);
        mortgageSummaryView.getTypeOfOccupationSection().touchItem(itemName);
        Assert.assertEquals(mortgageSummaryView.getTypeOfOccupationSection().getItemCheckedStatus(itemName), "true",
                "The + \"" + itemName + "\" item is not checked");
    }

    @Test(priority = 4, dataProvider = DataProviderNames.YEARLY_INCOME, dataProviderClass = SectionsDataProvider.class)
    @Tag("View")
    @Tag("List")
    @Tag("Item")
    @Owner("Paweł Aksman")
    @Description("Swiping the view")
    @QaseId(52)
    @QaseTitle("Touching the \"Yearly Income\" items")
    public void selectingYearlyIncomeSectionItems(String itemName) {

        Allure.parameter("Item", itemName);

        mortgageSummaryView.getYearlyIncomeSection().swipeToDesiredItem(itemName);
        mortgageSummaryView.getYearlyIncomeSection().touchItem(itemName);
        Assert.assertEquals(mortgageSummaryView.getYearlyIncomeSection().getItemCheckedStatus(itemName), "true",
                "The + \"" + itemName + "\" item is not checked");
    }
}

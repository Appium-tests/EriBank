package mortgagesummaryview;

import base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
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

public class SelectingItemsTest extends BaseTest {

    private MortgageSummaryView mortgageSummaryView;

    @BeforeMethod
    public void create() {

        Authentication.perform(getDriver());
        MortgageFormFiller.perform(getDriver());
        mortgageSummaryView = new MortgageSummaryView(getDriver());
    }

    @Test(dataProvider = DataProviderNames.TYPE_OF_LOAN, dataProviderClass = SectionsDataProvider.class)
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

    @Test(dataProvider = DataProviderNames.NUMBER_OF_YEARS, dataProviderClass = SectionsDataProvider.class)
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

    @Test(dataProvider = DataProviderNames.TYPE_OF_OCCUPATION, dataProviderClass = SectionsDataProvider.class)
    @Tag("Item")
    @Owner("Paweł Aksman")
    @Description("Swiping the view")
    @QaseId(51)
    @QaseTitle("Touching the \"Type Of Occupation\" items")
    public void selectingTypeOfOccupationSectionItems(String itemName) {

        Allure.parameter("Item", itemName);

        mortgageSummaryView.swipeDown();
        mortgageSummaryView.getTypeOfOccupationSection().touchItem(itemName);
        Assert.assertEquals(mortgageSummaryView.getTypeOfOccupationSection().getItemCheckedStatus(itemName), "true",
                "The + \"" + itemName + "\" item is not checked");
    }

    @Test(dataProvider = DataProviderNames.YEARLY_INCOME, dataProviderClass = SectionsDataProvider.class)
    @Tag("Item")
    @Owner("Paweł Aksman")
    @Description("Swiping the view")
    @QaseId(52)
    @QaseTitle("Touching the \"Yearly Income\" items")
    public void selectingYearlyIncomeSectionItems(String itemName) {

        Allure.parameter("Item", itemName);

        mortgageSummaryView.swipeDown();
        mortgageSummaryView.getYearlyIncomeSection().touchItem(itemName);
        Assert.assertEquals(mortgageSummaryView.getYearlyIncomeSection().getItemCheckedStatus(itemName), "true",
                "The + \"" + itemName + "\" item is not checked");
    }
}

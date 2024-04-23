package mortgagesummaryview;

import base.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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

public class SwipingTest extends BaseTest {

    private MortgageSummaryView mortgageSummaryView;

    @BeforeMethod
    public void create() throws JsonProcessingException {

        Authentication.perform(getDriver());
        MortgageFormFiller.perform(getDriver());
        mortgageSummaryView = new MortgageSummaryView(getDriver());
    }

    @Test(dataProvider = DataProviderNames.YEARLY_INCOME, dataProviderClass = SectionsDataProvider.class)
    @Tag("List")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Paweł Aksman")
    @Description("Swiping the list")
    @QaseId(48)
    @QaseTitle("Swiping the list")
    public void example(String itemName) {

        mortgageSummaryView.getYearlyIncomeSection().swipeToElement(itemName);
        Assert.assertTrue(mortgageSummaryView.getYearlyIncomeSection().isItemVisible(itemName), "Unable to swipe up the list");
    }
}

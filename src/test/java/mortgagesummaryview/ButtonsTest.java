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
import qa.pageobject.mortgagerequest.MortgageRequestView;
import qa.pageobject.mortgagesummaryview.MortgageSummaryView;
import qa.support.Authentication;
import qa.support.MortgageFormFiller;

public class ButtonsTest extends BaseTest {

    private MortgageRequestView mortgageRequestView;
    private MortgageSummaryView mortgageSummaryView;
    private final String itemName;

    public ButtonsTest(String itemName) {

        this.itemName = itemName;
    }

    @BeforeMethod
    public void create() throws JsonProcessingException {

        Authentication.perform(getDriver());
        MortgageFormFiller.perform(getDriver());
        mortgageRequestView = new MortgageRequestView(getDriver());
        mortgageSummaryView = new MortgageSummaryView(getDriver());
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("View")
    @Tag("List")
    @Tag("Button")
    @Owner("Paweł Aksman")
    @Description("The \"Save\" button")
    @QaseId(53)
    @QaseTitle("Touching the \"Save\" items")
    public void saveButton() {

        mortgageSummaryView.getYearlyIncomeSection().swipeToDesiredItem(itemName);
        mortgageSummaryView.clickSaveButton();
        Assert.assertTrue(mortgageRequestView.isDisplayed(), "The mortgage request view is not visible");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("View")
    @Tag("List")
    @Tag("Button")
    @Owner("Paweł Aksman")
    @Description("The \"Bsck\" button")
    @QaseId(54)
    @QaseTitle("Touching the \"Back\" items")
    public void backButton() {

        mortgageSummaryView.getYearlyIncomeSection().swipeToDesiredItem(itemName);
        mortgageSummaryView.clickBackButton();
        Assert.assertTrue(mortgageRequestView.isDisplayed(), "The home view is not visible");
    }
}

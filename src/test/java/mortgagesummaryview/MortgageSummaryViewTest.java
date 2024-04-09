package mortgagesummaryview;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.mortgagesummaryview.MortgageSummaryView;
import qa.support.Authentication;
import qa.support.MortgageFormFiller;

public class MortgageSummaryViewTest extends BaseTest {

    private MortgageSummaryView mortgageSummaryView;

    @BeforeMethod
    public void create() {

        Authentication.perform(getDriver());
        MortgageFormFiller.perform(getDriver());
        mortgageSummaryView = new MortgageSummaryView(getDriver());
    }

    @Test
    @Tag("View")
    @Owner("Paweł Aksman")
    @Description("Swiping the view")
    @QaseId(48)
    @QaseTitle("Swiping the view")
    public void example() {

        mortgageSummaryView.swipeDown();
        Assert.assertTrue(mortgageSummaryView.isLastItemVisible(), "Unable to swipe down the list");
        mortgageSummaryView.swipeUp();
        Assert.assertTrue(mortgageSummaryView.isFirstItemVisible(), "Unable to swipe up the list");
    }
}

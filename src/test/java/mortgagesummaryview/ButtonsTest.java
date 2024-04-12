package mortgagesummaryview;

import base.BaseTest;
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

    @BeforeMethod
    public void create() {

        Authentication.perform(getDriver());
        MortgageFormFiller.perform(getDriver());
        mortgageRequestView = new MortgageRequestView(getDriver());
        mortgageSummaryView = new MortgageSummaryView(getDriver());
    }

    @Test
    public void saveButton() {

        mortgageSummaryView.clickSaveButton();
        Assert.assertTrue(mortgageRequestView.isDisplayed(), "The mortgage request view is not visible");
    }

    @Test
    public void backButton() {

        mortgageSummaryView.clickSaveButton();
        Assert.assertTrue(mortgageRequestView.isDisplayed(), "The mortgage request view is not visible");
    }
}

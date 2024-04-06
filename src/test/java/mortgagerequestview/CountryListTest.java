package mortgagerequestview;

import base.CountryListBaseTest;
import io.qameta.allure.Description;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataproviders.RandomIndexesDataProvider;
import qa.enums.View;
import qa.pageobject.mortgagerequest.MortgageRequestView;
import qa.support.Authentication;
import qa.support.DataProviderNames;
import qa.support.HomeViewManager;

public class CountryListTest extends CountryListBaseTest {

    private MortgageRequestView mortgageRequestView;

    @BeforeMethod(onlyForGroups = {"closed", "opened"})
    public void create() {

        Authentication.perform(getDriver());
        HomeViewManager.open(getDriver(), View.MORTGAGE_REQUEST);
        mortgageRequestView = new MortgageRequestView(getDriver());
    }

    @BeforeMethod(onlyForGroups = "opened")
    public void forOpened() {

        mortgageRequestView.touchSelectButton();
    }

    @Test(priority = 1, groups = "closed")
    @QaseId(31)
    @QaseTitle("The \"Select\" button")
    @Description("The \"Select\" button")
    public void selectButton() {

        mortgageRequestView.touchSelectButton();
        baseSelectButton();
    }

    @Test(priority = 2, groups = "opened")
    @QaseId(32)
    @QaseTitle("Swiping the list")
    @Description("Swiping the list")
    public void swiping() {

        baseSwiping();
    }

    @Test(priority = 3, groups = "opened", dataProvider = DataProviderNames.RANDOM_INDEXES, dataProviderClass = RandomIndexesDataProvider.class)
    @QaseId(33)
    @QaseTitle("Selecting a country")
    @Description("Selecting a country")
    public void selectingCountry(int index) {

        baseSelectingCountry(index);

        Assert.assertEquals(mortgageRequestView.getCountryNameFromCountryField(), getCountryList().getCountryName(),"Incorrect country in the country field");
    }
}

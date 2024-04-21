package mortgagerequestview;

import base.CountryListBaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataproviders.CountriesDataProvider;
import qa.enums.View;
import qa.pageobject.mortgagerequest.MortgageRequestView;
import qa.support.Authentication;
import qa.support.DataProviderNames;
import qa.support.HomeViewManager;

@Epic("E2E")
@Feature("The country list")
public class CountryListTest extends CountryListBaseTest {

    private MortgageRequestView mortgageRequestView;

    @BeforeMethod(onlyForGroups = {"closed", "opened"})
    public void create() throws JsonProcessingException {

        Authentication.perform(getDriver());
        HomeViewManager.open(getDriver(), View.MORTGAGE_REQUEST);
        mortgageRequestView = new MortgageRequestView(getDriver());
    }

    @BeforeMethod(onlyForGroups = "opened")
    public void forOpened() {

        mortgageRequestView.touchSelectButton();
    }

    @Test(priority = 1, groups = "closed")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("List")
    @Owner("Paweł Aksman")
    @Description("The \"Select\" button")
    @QaseId(31)
    @QaseTitle("The \"Select\" button")
    public void selectButton() {

        mortgageRequestView.touchSelectButton();
        baseSelectButton();
    }

    @Test(priority = 2, groups = "opened", dataProvider = DataProviderNames.SCROLLABLE_COUNTRIES, dataProviderClass = CountriesDataProvider.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("List")
    @Owner("Paweł Aksman")
    @Description("Swiping the list")
    @QaseId(32)
    @QaseTitle("Swiping the list")
    public void swiping(String country) {

        baseSwiping(country);
    }

    @Test(priority = 3, groups = "opened", dataProvider = DataProviderNames.COUNTRIES, dataProviderClass = CountriesDataProvider.class)
    @Severity(SeverityLevel.CRITICAL)
    @Tag("List")
    @Owner("Paweł Aksman")
    @Description("Selecting a country")
    @QaseId(33)
    @QaseTitle("Selecting a country")
    public void selectingCountry(String country) {

        baseSelectingCountry(country);
        Assert.assertEquals(mortgageRequestView.getCountryNameFromCountryField(), getCountryList().getCountryName(),"Incorrect country in the country field");
    }
}

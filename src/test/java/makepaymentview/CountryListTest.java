package makepaymentview;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.helpers.Authentication;
import qa.pageobject.countrylist.CountryList;
import qa.pageobject.homeview.HomeView;
import qa.pageobject.makepaymentview.MakePaymentView;
import qa.steps.CountryListSteps;
import qa.steps.MakePaymentSteps;
import qa.dataproviders.TestDataProviders;
import qa.utils.Country;

@Epic("E2E")
@Feature("Country list")
public class CountryListTest extends BaseTest {

    private CountryListSteps countryListSteps;
    private CountryList countryList;

    @BeforeMethod
    public void create() {

        Authentication.perform(getDriver());
        HomeView homeView = new HomeView(getDriver());
        homeView.touchMakePaymentButton();

        countryListSteps = new CountryListSteps(getDriver());
        countryList = new CountryList(getDriver());
    }

    @Test
    public void swiping() {

        MakePaymentSteps makePaymentSteps = new MakePaymentSteps(getDriver());
        makePaymentSteps.tapSelectButton();

        countryList.swipeDown();
        Assert.assertTrue(countryList.isLastItemDisplayed(), "Unable to swipe down the list");
        countryList.swipeUp();
        Assert.assertTrue(countryList.isFirstItemDisplayed(), "Unable to swipe up the list");
    }

    @Test
    @QaseId(17)
    @QaseTitle("The \"Select\" button")
    @Description("The \"Select\" button")
    public void selectButton() {

        MakePaymentView makePaymentView = new MakePaymentView(getDriver());
        makePaymentView.touchSelectButton();

        Assert.assertTrue(countryListSteps.getCountryList().isDisplayed(),
                "The country list is not displayed");
    }

    @Test(dataProvider = "countries", dataProviderClass = TestDataProviders.class)
    @QaseId(18)
    @QaseTitle("Selecting a country")
    @Description("Selecting a country")
    public void selectingCountry(Country country) {

        MakePaymentSteps makePaymentSteps = new MakePaymentSteps(getDriver());
        makePaymentSteps.tapSelectButton();

        countryListSteps.tapCountryButton(country.getIndex());

        Assert.assertTrue(makePaymentSteps.getMakePaymentView().isDisplayed(),
                "The \"Make Payment\" view is not displayed");
        Assert.assertEquals(makePaymentSteps.getMakePaymentView().getCountryNameFromCountryField(), country.getName(),
                "Incorrect country in the country field");
    }
}

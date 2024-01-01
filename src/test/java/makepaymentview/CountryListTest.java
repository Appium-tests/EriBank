package makepaymentview;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.helpers.Authentication;
import qa.pageobject.homeview.HomeView;
import qa.steps.CountryListSteps;
import qa.steps.MakePaymentSteps;
import qa.testdataproviders.TestDataProviders;
import qa.utils.Country;

@Epic("E2E")
@Feature("Country list")
public class CountryListTest extends BaseTest {

    private CountryListSteps countryListSteps;

    @BeforeMethod
    public void create() {

        Authentication.perform(getDriver());
        HomeView homeView = new HomeView(getDriver());
        homeView.tapMakePaymentButton();

        countryListSteps = new CountryListSteps(getDriver());
    }

    @Test
    @Description("Checking whether the country list is displayed after touching the \"Select\" button")
    @Story("Touching the \"Select\" button")
    public void selectButton() {

        MakePaymentSteps makePaymentSteps = new MakePaymentSteps(getDriver());
        makePaymentSteps.tapSelectButton();

        Assert.assertTrue(countryListSteps.getCountryList().isDisplayed(),
                "The country list is not displayed");
    }

    @Test(dataProvider = "countries", dataProviderClass = TestDataProviders.class)
    @Description("Checking whether the country name in the country field is correct after selecting a country from the list")
    @Story("Selecting a country from the list")
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

package makepaymentview;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import qa.dataproviders.RandomIndexesDataProvider;
import qa.support.Authentication;
import qa.pageobject.countrylist.CountryList;
import qa.pageobject.homeview.HomeView;
import qa.pageobject.makepaymentview.MakePaymentView;
import qa.support.DataProviderNames;

@Epic("E2E")
@Feature("Country list")
public class CountryListTest extends BaseTest {

    private MakePaymentView makePaymentView;
    private CountryList countryList;

    @BeforeMethod
    public void create() {

        Authentication.perform(getDriver());
        HomeView homeView = new HomeView(getDriver());
        homeView.touchMakePaymentButton();
        makePaymentView = new MakePaymentView(getDriver());
        makePaymentView.touchSelectButton();
        countryList = new CountryList(getDriver());
    }

    @Test(priority = 1)
    public void swiping() {

        countryList.swipeDown();
        Assert.assertTrue(countryList.isLastItemDisplayed(), "Unable to swipe down the list");
        countryList.swipeUp();
        Assert.assertTrue(countryList.isFirstItemDisplayed(), "Unable to swipe up the list");
    }

    @Test(priority = 2)
    @QaseId(17)
    @QaseTitle("The \"Select\" button")
    @Description("The \"Select\" button")
    public void selectButton() {

        Assert.assertTrue(countryList.isDisplayed(),
                "The country list is not displayed");
    }

    @Test(priority = 3, dataProvider = DataProviderNames.RANDOM_INDEXES, dataProviderClass = RandomIndexesDataProvider.class)
    @QaseId(18)
    @QaseTitle("Selecting a country")
    @Description("Selecting a country")
    public void selectingCountry(int index) {

        countryList.selectCountry(index);

        Assert.assertEquals(makePaymentView.getCountryNameFromCountryField(), countryList.getCountryName(),"Incorrect country in the country field");
    }
}

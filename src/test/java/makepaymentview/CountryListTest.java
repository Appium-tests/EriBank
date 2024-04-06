package makepaymentview;

import base.CountryListBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataproviders.RandomIndexesDataProvider;
import qa.support.Authentication;
import qa.pageobject.homeview.HomeView;
import qa.pageobject.makepaymentview.MakePaymentView;
import qa.support.DataProviderNames;

@Epic("E2E")
@Feature("Country list")
public class CountryListTest extends CountryListBaseTest {

    private MakePaymentView makePaymentView;

    @BeforeMethod(groups = {"closed", "opened"})
    public void create() {

        Authentication.perform(getDriver());
        HomeView homeView = new HomeView(getDriver());
        homeView.touchMakePaymentButton();
        makePaymentView = new MakePaymentView(getDriver());
    }

    @BeforeMethod(groups = "opened")
    public void forOpened() {

        makePaymentView.touchSelectButton();
    }

    @Test(priority = 2, groups = "closed")
    @QaseId(17)
    @QaseTitle("The \"Select\" button")
    @Description("The \"Select\" button")
    public void selectButton() {

        baseSelectButton();
    }

    @Test(priority = 1, groups = "opened")
    @QaseId(18)
    @QaseTitle("Swiping the list")
    @Description("Swiping the list")
    public void swiping() {

        baseSwiping();
    }

    @Test(priority = 3, groups = "opened", dataProvider = DataProviderNames.RANDOM_INDEXES, dataProviderClass = RandomIndexesDataProvider.class)
    @QaseId(19)
    @QaseTitle("Selecting a country")
    @Description("Selecting a country")
    public void selectingCountry(int index) {

        baseSelectingCountry(index);

        Assert.assertEquals(makePaymentView.getCountryNameFromCountryField(), getCountryList().getCountryName(),"Incorrect country in the country field");
    }
}

package makepaymentview;

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
import qa.pageobject.makepaymentview.MakePaymentView;
import qa.support.Authentication;
import qa.support.DataProviderNames;
import qa.support.HomeViewManager;

@Epic("E2E")
@Feature("Country list")
public class CountryListTest extends CountryListBaseTest {

    private MakePaymentView makePaymentView;

    @BeforeMethod(onlyForGroups = {"closed", "opened"})
    public void create() throws JsonProcessingException {

        Authentication.perform(getDriver());
        HomeViewManager.open(getDriver(), View.MAKE_PAYMENT);
        makePaymentView = new MakePaymentView(getDriver());
    }

    @BeforeMethod(onlyForGroups = "opened")
    public void forOpened() {

        makePaymentView.touchSelectButton();
    }

    @Test(priority = 1, groups = "closed")
    @Severity(SeverityLevel.NORMAL)
    @Tag("List")
    @Owner("Paweł Aksman")
    @Description("The \"Select\" button")
    @QaseId(17)
    @QaseTitle("The \"Select\" button")
    public void selectButton() {

        makePaymentView.touchSelectButton();
        baseSelectButton();
    }

    @Test(priority = 2, groups = "opened", dataProvider = DataProviderNames.SCROLLABLE_COUNTRIES, dataProviderClass = CountriesDataProvider.class)
    @Severity(SeverityLevel.NORMAL)
    @Tag("List")
    @Owner("Paweł Aksman")
    @Description("Swiping the list")
    @QaseId(18)
    @QaseTitle("Swiping the list")
    public void swiping(String country) {

        baseSwiping(country);
    }

    @Test(priority = 3, groups = "opened", dataProvider = DataProviderNames.COUNTRIES, dataProviderClass = CountriesDataProvider.class)
    @Severity(SeverityLevel.NORMAL)
    @Tag("List")
    @Owner("Paweł Aksman")
    @Description("Selecting a country")
    @QaseId(19)
    @QaseTitle("Selecting a country")
    public void selectingCountry(String country) {

        baseSelectingCountry(country);
        Assert.assertEquals(makePaymentView.getCountryNameFromCountryField(), getCountryList().getCountryName(),"Incorrect country in the country field");
    }
}

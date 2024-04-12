package makepaymentview;

import base.CountryListBaseTest;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
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

    @Test(priority = 1, groups = "closed")
    @Severity(SeverityLevel.NORMAL)
    @Tag("List")
    @Owner("Paweł Aksman")
    @Description("The \"Select\" button")
    @QaseId(17)
    @QaseTitle("The \"Select\" button")
    public void selectButton() {

        baseSelectButton();
    }

    @Test(priority = 2, groups = "opened")
    @Severity(SeverityLevel.NORMAL)
    @Tag("List")
    @Owner("Paweł Aksman")
    @Description("Swiping the list")
    @QaseId(18)
    @QaseTitle("Swiping the list")
    public void swiping() {

        baseSwiping();
    }

    @Test(priority = 3, groups = "opened", dataProvider = DataProviderNames.RANDOM_INDEXES, dataProviderClass = RandomIndexesDataProvider.class)
    @Severity(SeverityLevel.NORMAL)
    @Tag("List")
    @Owner("Paweł Aksman")
    @Description("Selecting a country")
    @QaseId(19)
    @QaseTitle("Selecting a country")
    public void selectingCountry(int index) {

        Allure.parameter("List index", index);

        baseSelectingCountry(index);

        Assert.assertEquals(makePaymentView.getCountryNameFromCountryField(), getCountryList().getCountryName(),"Incorrect country in the country field");
    }
}

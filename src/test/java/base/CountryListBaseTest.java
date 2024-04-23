package base;

import lombok.Getter;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import qa.pageobject.countrylist.CountryList;

@Getter
public class CountryListBaseTest extends BaseTest {

    private CountryList countryList;

    @BeforeMethod
    public void baseCreate() {

        countryList = new CountryList(getDriver());
    }

    protected void baseSelectButton() {

        Assert.assertTrue(countryList.isDisplayed(),
                "The country list is not displayed");
    }

    protected void baseSwiping(String country) {

        countryList.swipeToElement(country);
        Assert.assertTrue(countryList.isItemVisible(country), "The \"" + country + "\" item is not visible");
    }

    protected void baseSelectingCountry(String country) {

        countryList.swipeToElement(country);
        countryList.selectCountry(country);
    }
}

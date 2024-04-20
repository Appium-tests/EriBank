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

    protected void baseSwiping() {

        countryList.swipeDown();
        Assert.assertTrue(countryList.isLastItemDisplayed(), "Unable to swipe down the list");
        countryList.swipeUp();
        Assert.assertTrue(countryList.isFirstItemDisplayed(), "Unable to swipe up the list");
    }

    protected void baseSelectingCountry(String countryName) {

        countryList.swipeToDesiredItem(countryName);
        countryList.selectCountry(countryName);
    }
}

package qa.steps;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import qa.pageobject.countrylist.CountryList;

public class CountryListSteps {

    private final CountryList countryList;

    public CountryListSteps(AndroidDriver driver) {

        countryList = new CountryList(driver);
    }

    @Step("Tap country button")
    public void tapCountryButton(int index) {

        countryList.selectCountry(index);
    }

    public CountryList getCountryList() {

        return countryList;
    }
}

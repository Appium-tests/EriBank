package qa.dataproviders;

import org.testng.annotations.DataProvider;
import qa.support.TestDataLoader;
import qa.support.DataProviderNames;

public class CountriesDataProvider {

    @DataProvider(name = DataProviderNames.COUNTRIES)
    public Object[] getCountries() {

        return TestDataLoader.getStringArray(DataProviderNames.COUNTRIES, 0);
    }

    @DataProvider(name = DataProviderNames.SCROLLABLE_COUNTRIES)
    public Object[] getScrollableCountries() {

        return TestDataLoader.getStringArray(DataProviderNames.COUNTRIES, 6);
    }
}

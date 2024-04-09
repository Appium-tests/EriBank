package qa.dataproviders;

import org.testng.annotations.DataProvider;
import qa.support.DataProviderNames;
import qa.support.TestDataLoader;

public class SectionsDataProvider {

    @DataProvider(name = DataProviderNames.TYPE_OF_LOAN)
    public Object[] typeOfLoan() {

        return TestDataLoader.getStringArray(DataProviderNames.TYPE_OF_LOAN);
    }

    @DataProvider(name = DataProviderNames.NUMBER_OF_YEARS)
    public Object[] numberOfYears() {

        return TestDataLoader.getStringArray(DataProviderNames.NUMBER_OF_YEARS);
    }

    @DataProvider(name = DataProviderNames.TYPE_OF_OCCUPATION)
    public Object[] typeOfOccupation() {

        return TestDataLoader.getStringArray(DataProviderNames.TYPE_OF_OCCUPATION);
    }

    @DataProvider(name = DataProviderNames.YEARLY_INCOME)
    public Object[] yearlyIncome() {

        return TestDataLoader.getStringArray(DataProviderNames.YEARLY_INCOME);
    }
}

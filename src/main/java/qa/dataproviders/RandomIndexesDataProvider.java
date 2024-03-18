package qa.dataproviders;

import org.testng.annotations.DataProvider;
import qa.support.TestDataLoader;
import qa.support.DataProviderNames;

public class RandomIndexesDataProvider {

    @DataProvider(name = DataProviderNames.RANDOM_INDEXES)
    public Object[] getIndexes() {

        return TestDataLoader.getIndexes();
    }
}

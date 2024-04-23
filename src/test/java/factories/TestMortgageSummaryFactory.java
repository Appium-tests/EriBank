package factories;

import mortgagesummaryview.ButtonsTest;
import org.testng.annotations.Factory;
import qa.dataproviders.SectionsDataProvider;
import qa.support.DataProviderNames;
import qa.support.FileReader;

public class TestMortgageSummaryFactory {

    public TestMortgageSummaryFactory() {

        FileReader.load("EB_Sections.json");
    }

    @Factory(dataProvider = DataProviderNames.YEARLY_INCOME, dataProviderClass = SectionsDataProvider.class, indices = { 3 })
    public Object[] createInstance(String itemName) {

        return new Object[] {new ButtonsTest(itemName)};
    }
}

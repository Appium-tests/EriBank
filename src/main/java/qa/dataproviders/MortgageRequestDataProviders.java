package qa.dataproviders;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.DataProvider;
import qa.support.TestDataLoader;
import qa.support.DataProviderNames;

public class MortgageRequestDataProviders {

    @DataProvider(name = DataProviderNames.CORRECT)
    public Object[] correct() throws JsonProcessingException {

        return TestDataLoader.getMortgageRequests(DataProviderNames.CORRECT);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_FIRST_NAME)
    public Object[] incorrectFirstName() throws JsonProcessingException {

        return TestDataLoader.getMortgageRequests(DataProviderNames.INCORRECT_FIRST_NAME);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_LAST_NAME)
    public Object[] incorrectLastName() throws JsonProcessingException {

        return TestDataLoader.getMortgageRequests(DataProviderNames.INCORRECT_LAST_NAME);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_AGE)
    public Object[] incorrectAge() throws JsonProcessingException {

        return TestDataLoader.getMortgageRequests(DataProviderNames.INCORRECT_AGE);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_ADDRESS_1)
    public Object[] incorrectAddress1() throws JsonProcessingException {

        return TestDataLoader.getMortgageRequests(DataProviderNames.INCORRECT_ADDRESS_1);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_ADDRESS_2)
    public Object[] incorrectAddress2() throws JsonProcessingException {

        return TestDataLoader.getMortgageRequests(DataProviderNames.INCORRECT_ADDRESS_2);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_COUNTRY)
    public Object[] incorrectCountry() throws JsonProcessingException {

        return TestDataLoader.getMortgageRequests(DataProviderNames.INCORRECT_COUNTRY);
    }
}

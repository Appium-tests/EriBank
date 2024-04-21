package qa.dataproviders;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.DataProvider;
import qa.support.TestDataLoader;
import qa.support.DataProviderNames;

public class MakePaymentDataProviders {

    @DataProvider(name = DataProviderNames.CORRECT)
    public Object[] correct() throws JsonProcessingException {

        return TestDataLoader.getPayments(DataProviderNames.CORRECT);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_PHONE)
    public Object[] incorrectPhone() throws JsonProcessingException {

        return TestDataLoader.getPayments(DataProviderNames.INCORRECT_PHONE);
    }

    @DataProvider(name = DataProviderNames.BLANK_PHONE_FIELD)
    public Object[] blankPhoneField() throws JsonProcessingException {

        return TestDataLoader.getPayments(DataProviderNames.BLANK_PHONE_FIELD);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_NAME)
    public Object[] incorrectName() throws JsonProcessingException {

        return TestDataLoader.getPayments(DataProviderNames.INCORRECT_NAME);
    }

    @DataProvider(name = DataProviderNames.BLANK_NAME_FIELD)
    public Object[] blankNameField() throws JsonProcessingException {

        return TestDataLoader.getPayments(DataProviderNames.BLANK_NAME_FIELD);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_AMOUNT)
    public Object[] incorrectAmount() throws JsonProcessingException {

        return TestDataLoader.getPayments(DataProviderNames.INCORRECT_AMOUNT);
    }

    @DataProvider(name = DataProviderNames.BLANK_AMOUNT_FIELD)
    public Object[] blankAmountField() throws JsonProcessingException {

        return TestDataLoader.getPayments(DataProviderNames.BLANK_AMOUNT_FIELD);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_COUNTRY)
    public Object[] incorrectCountry() throws JsonProcessingException {

        return TestDataLoader.getPayments(DataProviderNames.INCORRECT_COUNTRY);
    }

    @DataProvider(name = DataProviderNames.BLANK_COUNTRY_FIELD)
    public Object[] blankCountryField() throws JsonProcessingException {

        return TestDataLoader.getPayments(DataProviderNames.BLANK_COUNTRY_FIELD);
    }
}

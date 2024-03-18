package qa.dataproviders;

import org.testng.annotations.DataProvider;
import qa.json.TestDataLoader;
import qa.utils.DataProviderNames;

public class MakePaymentDataProviders {

    @DataProvider(name = DataProviderNames.CORRECT)
    public Object[] correct() {

        return TestDataLoader.getPayments(DataProviderNames.CORRECT);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_PHONE)
    public Object[] incorrectPhone() {

        return TestDataLoader.getPayments(DataProviderNames.INCORRECT_PHONE);
    }

    @DataProvider(name = DataProviderNames.BLANK_PHONE_FIELD)
    public Object[] blankPhoneField() {

        return TestDataLoader.getPayments(DataProviderNames.BLANK_PHONE_FIELD);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_NAME)
    public Object[] incorrectName() {

        return TestDataLoader.getPayments(DataProviderNames.INCORRECT_NAME);
    }

    @DataProvider(name = DataProviderNames.BLANK_NAME_FIELD)
    public Object[] blankNameField() {

        return TestDataLoader.getPayments(DataProviderNames.BLANK_NAME_FIELD);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_AMOUNT)
    public Object[] incorrectAmount() {

        return TestDataLoader.getPayments(DataProviderNames.INCORRECT_AMOUNT);
    }

    @DataProvider(name = DataProviderNames.BLANK_AMOUNT_FIELD)
    public Object[] blankAmountField() {

        return TestDataLoader.getPayments(DataProviderNames.BLANK_AMOUNT_FIELD);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_COUNTRY)
    public Object[] incorrectCountry() {

        return TestDataLoader.getPayments(DataProviderNames.INCORRECT_COUNTRY);
    }

    @DataProvider(name = DataProviderNames.BLANK_COUNTRY_FIELD)
    public Object[] blankCountryField() {

        return TestDataLoader.getPayments(DataProviderNames.BLANK_COUNTRY_FIELD);
    }
}

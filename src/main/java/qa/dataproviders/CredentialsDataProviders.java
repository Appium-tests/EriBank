package qa.dataproviders;

import org.testng.annotations.DataProvider;
import qa.json.TestDataLoader;
import qa.utils.DataProviderNames;

public class CredentialsDataProviders {

    @DataProvider(name = DataProviderNames.CORRECT)
    public Object[] correct() {

        return TestDataLoader.getCredentials(DataProviderNames.CORRECT);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_USERNAME)
    public Object[] incorrectUsername() {

        return TestDataLoader.getCredentials(DataProviderNames.INCORRECT_USERNAME);
    }

    @DataProvider(name = DataProviderNames.USERNAME_WITH_UPPER_LETTERS)
    public Object[] usernameWithUpperLetters() {

        return TestDataLoader.getCredentials(DataProviderNames.USERNAME_WITH_UPPER_LETTERS);
    }

    @DataProvider(name = DataProviderNames.PASSWORD_WITH_UPPER_LETTERS)
    public Object[] PasswordWithUpperLetters() {

        return TestDataLoader.getCredentials(DataProviderNames.PASSWORD_WITH_UPPER_LETTERS);
    }

    @DataProvider(name = DataProviderNames.BLANK_USERNAME_FIELD)
    public Object[] blankUsernameField() {

        return TestDataLoader.getCredentials(DataProviderNames.BLANK_USERNAME_FIELD);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_PASSWORD)
    public Object[] incorrectPassword() {

        return TestDataLoader.getCredentials(DataProviderNames.INCORRECT_PASSWORD);
    }

    @DataProvider(name = DataProviderNames.BLANK_PASSWORD_FIELD)
    public Object[] blankPasswordField() {

        return TestDataLoader.getCredentials(DataProviderNames.BLANK_USERNAME_FIELD);
    }
}

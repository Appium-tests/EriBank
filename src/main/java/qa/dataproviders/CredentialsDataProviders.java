package qa.dataproviders;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.DataProvider;
import qa.support.TestDataLoader;
import qa.support.DataProviderNames;

public class CredentialsDataProviders {

    @DataProvider(name = DataProviderNames.CORRECT)
    public Object[] correct() throws JsonProcessingException {

        return TestDataLoader.getCredentials(DataProviderNames.CORRECT);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_USERNAME)
    public Object[] incorrectUsername() throws JsonProcessingException {

        return TestDataLoader.getCredentials(DataProviderNames.INCORRECT_USERNAME);
    }

    @DataProvider(name = DataProviderNames.USERNAME_WITH_UPPER_LETTERS)
    public Object[] usernameWithUpperLetters() throws JsonProcessingException {

        return TestDataLoader.getCredentials(DataProviderNames.USERNAME_WITH_UPPER_LETTERS);
    }

    @DataProvider(name = DataProviderNames.PASSWORD_WITH_UPPER_LETTERS)
    public Object[] PasswordWithUpperLetters() throws JsonProcessingException {

        return TestDataLoader.getCredentials(DataProviderNames.PASSWORD_WITH_UPPER_LETTERS);
    }

    @DataProvider(name = DataProviderNames.BLANK_USERNAME_FIELD)
    public Object[] blankUsernameField() throws JsonProcessingException {

        return TestDataLoader.getCredentials(DataProviderNames.BLANK_USERNAME_FIELD);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_PASSWORD)
    public Object[] incorrectPassword() throws JsonProcessingException {

        return TestDataLoader.getCredentials(DataProviderNames.INCORRECT_PASSWORD);
    }

    @DataProvider(name = DataProviderNames.BLANK_PASSWORD_FIELD)
    public Object[] blankPasswordField() throws JsonProcessingException {

        return TestDataLoader.getCredentials(DataProviderNames.BLANK_USERNAME_FIELD);
    }
}

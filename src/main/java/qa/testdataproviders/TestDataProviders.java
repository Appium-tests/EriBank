package qa.testdataproviders;

import org.testng.annotations.DataProvider;
import qa.json.JSONReader;

public class TestDataProviders {

    @DataProvider(name = "CR_correct")
    public Object[] CR_correct() {

        return JSONReader.getCredentials("correct");
    }

    @DataProvider(name = "CR_incorrectUsername")
    public Object[] CR_incorrectUsername() {

        return JSONReader.getCredentials("incorrectUsername");
    }

    @DataProvider(name = "CR_correctUsernameWithUppercase")
    public Object[] CR_correctUsernameWithUppercase() {

        return JSONReader.getCredentials("correctUsernameWithUppercase");
    }

    @DataProvider(name = "CR_correctPasswordWithUppercase")
    public Object[] CR_correctPasswordWithUppercase() {

        return JSONReader.getCredentials("correctPasswordWithUppercase");
    }

    @DataProvider(name = "CR_blankUsernameField")
    public Object[] CR_blankUsernameField() {

        return JSONReader.getCredentials("blankUsernameField");
    }

    @DataProvider(name = "CR_incorrectPassword")
    public Object[] CR_incorrectPassword() {

        return JSONReader.getCredentials("incorrectPassword");
    }

    @DataProvider(name = "CR_blankPasswordField")
    public Object[] CR_blankPasswordField() {

        return JSONReader.getCredentials("blankPasswordField");
    }
}

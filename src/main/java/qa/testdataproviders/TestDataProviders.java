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

    @DataProvider(name = "PM_correct")
    public Object[] PM_correct() {

        return JSONReader.getPayments("correct");
    }

    @DataProvider(name = "PM_incorrectPhone")
    public Object[] CR_incorrectPhone() {

        return JSONReader.getPayments("incorrectPhone");
    }

    @DataProvider(name = "PM_blankPhoneField")
    public Object[] CR_blankPhoneField() {

        return JSONReader.getPayments("blankPhoneField");
    }

    @DataProvider(name = "PM_incorrectName")
    public Object[] CR_incorrectName() {

        return JSONReader.getPayments("incorrectName");
    }

    @DataProvider(name = "PM_blankNameField")
    public Object[] CR_blankNameField() {

        return JSONReader.getPayments("blankNameField");
    }

    @DataProvider(name = "PM_incorrectAmount")
    public Object[] CR_incorrectAmount() {

        return JSONReader.getPayments("incorrectAmount");
    }

    @DataProvider(name = "PM_blankAmountField")
    public Object[] CR_blankAmountField() {

        return JSONReader.getPayments("blankAmountField");
    }

    @DataProvider(name = "PM_incorrectCountry")
    public Object[] CR_incorrectCountry() {

        return JSONReader.getPayments("incorrectCountry");
    }

    @DataProvider(name = "PM_blankCountryField")
    public Object[] CR_blankCountryField() {

        return JSONReader.getPayments("blankCountryField");
    }

    @DataProvider(name = "MR_correct")
    public Object[] MR_correct() {

        return JSONReader.getMortgageRequests("correct");
    }

    @DataProvider(name = "MR_blankSecondAddressField")
    public Object[] MR_blankSecondAddressField() {

        return JSONReader.getMortgageRequests("blankSecondAddressField");
    }

    @DataProvider(name = "MR_incorrectFirstName")
    public Object[] MR_incorrectFirstName() {

        return JSONReader.getMortgageRequests("incorrectFirstName");
    }

    @DataProvider(name = "MR_blankFirstNameField")
    public Object[] MR_blankFirstNameField() {

        return JSONReader.getMortgageRequests("blankFirstNameField");
    }

    @DataProvider(name = "MR_incorrectLastName")
    public Object[] MR_incorrectLastName() {

        return JSONReader.getMortgageRequests("incorrectLastName");
    }

    @DataProvider(name = "MR_blankLastNameField")
    public Object[] MR_blankLastNameField() {

        return JSONReader.getMortgageRequests("blankLastNameField");
    }

    @DataProvider(name = "MR_incorrectAge")
    public Object[] MR_incorrectAge() {

        return JSONReader.getMortgageRequests("incorrectAge");
    }

    @DataProvider(name = "MR_blankAgeField")
    public Object[] MR_blankAgeField() {

        return JSONReader.getMortgageRequests("blankAgeField");
    }

    @DataProvider(name = "MR_incorrectAddress")
    public Object[] MR_incorrectAddress() {

        return JSONReader.getMortgageRequests("incorrectAddress");
    }

    @DataProvider(name = "MR_blankAddressField")
    public Object[] MR_blankAddressField() {

        return JSONReader.getMortgageRequests("blankAddressField");
    }

    @DataProvider(name = "MR_incorrectCountry")
    public Object[] MR_incorrectCountry() {

        return JSONReader.getMortgageRequests("incorrectCountry");
    }

    @DataProvider(name = "MR_blankCountryField")
    public Object[] MR_blankCountryField() {

        return JSONReader.getMortgageRequests("blankCountryField");
    }
}

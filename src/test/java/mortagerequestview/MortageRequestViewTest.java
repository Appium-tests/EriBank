package mortagerequestview;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.helpers.Authentication;
import qa.pageobject.homeview.HomeView;
import qa.pageobject.mortagerequest.MortageRequestView;
import qa.testdataproviders.TestDataProviders;
import qa.utils.MortageRequest;

public class MortageRequestViewTest extends BaseTest {

    private MortageRequestView mortageRequestView;

    @BeforeMethod
    public void create() {

        Authentication.perform(getDriver());
        HomeView homeView = new HomeView(getDriver());
        homeView.tapMortageRequestButton();
    }

    private void fill(MortageRequest mortageRequest) {

        mortageRequestView.setFirstName(mortageRequest.getFirstName());
        mortageRequestView.setLastName(mortageRequest.getLastName());
        mortageRequestView.setAge(mortageRequest.getAge());
        mortageRequestView.setAddress1(mortageRequest.getAddress1());
        mortageRequestView.setAddress2(mortageRequest.getAddress2());
        mortageRequestView.setCountry(mortageRequest.getCountry());
    }

    @Test(dataProvider = "MR_correct", dataProviderClass = TestDataProviders.class)
    public void correct(MortageRequest mortageRequest) {


    }
}

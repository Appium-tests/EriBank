package qa.pageobject.countrylist;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import qa.base.BaseView;

import java.util.List;

public class CountryList extends BaseView {

    public CountryList(AndroidDriver driver) {

        super(driver);
    }

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/countryList")
    List<WebElement> parent;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/rowTextView")
    List<WebElement> countries;

    public void selectCountry(int index) {

        countries.get(index).click();
    }

    public boolean isDisplayed() {

        return !parent.isEmpty();
    }
}

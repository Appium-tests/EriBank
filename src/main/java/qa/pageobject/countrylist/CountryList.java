package qa.pageobject.countrylist;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import qa.base.BaseView;
import qa.utils.SwipingHelper;

import java.util.List;
import java.util.Optional;

public class CountryList extends BaseView {

    public CountryList(AndroidDriver driver) {

        super(driver);
    }

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/countryList")
    List<WebElement> parent;

    @AndroidFindBy(id = "com.experitest.ExperiBank:id/rowTextView")
    List<WebElement> countries;

    @io.qameta.allure.Step("Touch the last visible list element and swipe to the first element")
    @io.qase.api.annotation.Step("Touch the last visible list element and swipe to the first element")
    public void swipeDown() {

        Point to = countries.get(0).getLocation();
        Optional<WebElement> from = countries.stream().filter(WebElement::isDisplayed).reduce((first, second) -> second);
        from.ifPresent(element -> SwipingHelper.swipe(element.getLocation(), to, getDRIVER()));
    }

    @io.qameta.allure.Step("Touch the first visible list element and swipe to the last element")
    @io.qase.api.annotation.Step("Touch the first visible list element and swipe to the last element")
    public void swipeUp() {

        Point to = countries.get(countries.size() - 1).getLocation();
        Optional<WebElement> from = countries.stream().filter(WebElement::isDisplayed).findFirst();
        from.ifPresent(element -> SwipingHelper.swipe(element.getLocation(), to, getDRIVER()));
    }

    @io.qameta.allure.Step("Touch the list element")
    @io.qase.api.annotation.Step("Touch the list element")
    public void selectCountry(int index) {

        countries.get(index).click();
    }

    public boolean isFirstItemDisplayed() {

        return countries.get(0).isDisplayed();
    }

    public boolean isLastItemDisplayed() {

        return countries.get(countries.size() - 1).isDisplayed();
    }

    public boolean isDisplayed() {

        return !parent.isEmpty();
    }
}

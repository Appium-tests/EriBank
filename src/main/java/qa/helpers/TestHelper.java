package qa.helpers;

import org.testng.Assert;
import qa.pageobject.loginview.AlertFrame;
import qa.pageobject.makepaymentview.QuestionFrame;

public class TestHelper {

    public TestHelper() { }

    public void checkWhenDataIsIncorrect(AlertFrame alertFrame, String title, String message) {

        Assert.assertTrue(alertFrame.isDisplayed(),
                "The alert is not displayed");
        Assert.assertEquals(alertFrame.getTitle(), title,
                "Incorrect title");
        Assert.assertEquals(alertFrame.getMessage(), message,
                "Incorrect message content");
        Assert.assertTrue(alertFrame.isButtonDisplayed(),
                "The \"Close\" button is not displayed");
    }

    public void checkWhenFieldIsBlank(boolean condition, String buttonName) {

        Assert.assertFalse(condition,
                "The button \"" + buttonName + "\" is enabled");
    }

    public void checkQuestionMessage(QuestionFrame questionFrame, String question) {

        Assert.assertTrue(questionFrame.isDisplayed(),
                "The question frame is not displayed");
        Assert.assertTrue(questionFrame.isButtonYESDisplayed(),
                "The 'Yes' button is not displayed");
        Assert.assertTrue(questionFrame.isButtonNODisplayed(),
                "The 'No' button is not displayed");
        Assert.assertEquals(questionFrame.getTitle(), "EriBank",
                "Incorrect title");
        Assert.assertEquals(questionFrame.getMessage(), question,
                "Incorrect message content");
    }
}

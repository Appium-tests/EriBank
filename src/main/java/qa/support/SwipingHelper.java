package qa.support;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;

public class SwipingHelper {

    private static final int DURATION = 600;
    public static void swipe(Point from, Point to, AndroidDriver driver) {

        PointerInput pointerInput = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence sequence = new Sequence(pointerInput, 0);
        sequence.addAction(pointerInput.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), from));
        sequence.addAction(pointerInput.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence.addAction(new Pause(pointerInput, Duration.ofMillis(DURATION)));
        sequence.addAction(pointerInput.createPointerMove(Duration.ofMillis(DURATION), PointerInput.Origin.viewport(), to));
        sequence.addAction(pointerInput.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(sequence));
    }
}

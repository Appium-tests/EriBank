package qa.support;

import java.util.Random;

public class RandomValue {

    public static int get(int min, int max) {

        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}

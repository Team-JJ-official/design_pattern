package _09_bridge;

import java.util.Random;

public class RandomDisplay extends CountDisplay {
    public RandomDisplay(DisplayImpl impl) {
        super(impl);
    }
    public void randomDisplay(int times) {
        int count = new Random().nextInt(times);
        multiDisplay(count);
    }
}

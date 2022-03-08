package _09_bridge;

public class TriangleDisplay extends CountDisplay {
    public TriangleDisplay(DisplayImpl impl) {
        super(impl);
    }
    public void triangleDisplay(int size) {
        for(int i = 0; i < size; i++) {
            multiDisplay(i);
        }
    }
}

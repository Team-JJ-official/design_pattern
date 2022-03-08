package _09_bridge;

public class BracketDisplayImpl extends DisplayImpl {
    private String begin, middle, end;

    public BracketDisplayImpl(String begin, String middle, String end) {
        this.begin = begin;
        this.middle = middle;
        this.end = end;
    }

    @Override
    public void rawOpen() {
        System.out.print(begin);
    }
    @Override
    public void rawPrint() {
        System.out.print(middle);
    }
    @Override
    public void rawClose() {
        System.out.println(end);
    }
}

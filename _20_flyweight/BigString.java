package _20_flyweight;

public class BigString {
    private BigChar[] bigchars;

    public BigString(String string) {
        init(string, true);
    }
    public BigString(String string, boolean shared) {
        init(string, shared);
    }
    private void init(String string, boolean shared) {
        bigchars = new BigChar[string.length()];
        BigCharFactory factory = BigCharFactory.getInstance();
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i] = shared ? factory.getBigChar(string.charAt(i)) : new BigChar(string.charAt(i));
        }
    }
    public void print() {
        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < bigchars.length; i++) {
                bigchars[i].printLine(j);
            }
            System.out.println("");
        }
    }
}

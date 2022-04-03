package _20_flyweight;

import java.util.HashMap;

public class BigCharFactory {
    private HashMap<String, BigChar> pool = new HashMap<String, BigChar>();
    private static BigCharFactory singleton  = new BigCharFactory();

    private BigCharFactory() {}
    public static BigCharFactory getInstance() {
        return singleton;
    }
    public synchronized BigChar getBigChar(char charname) {
        BigChar bc = pool.get("" + charname);
        if (bc == null) {
            bc = new BigChar(charname);
            pool.put("" + charname, bc);
        }
        return bc;
    }
}

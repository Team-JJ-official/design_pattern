package _05_singleton.practice.p2;
import java.util.*;

public class Triple {
    // private static Triple[] d = new Triple[3];
    private static List<Triple> d = new ArrayList<Triple>();
    private int id;
    static {
        System.out.println("static init");
        for (int i = 0; i < 3; i++) {
            d.add(new Triple());
        }
    }
    {
        id = 0;
        System.out.println("init");
    }
    private Triple() {
        System.out.println("constractor");
    }
    public static Triple getInstance(int id) {
        return d.get(id);
    }
}

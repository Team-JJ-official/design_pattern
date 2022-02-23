package _04_factory_method;

import _04_factory_method.framework.*;
import _04_factory_method.idcard.*;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("TeamJJ");
        Product card2 = factory.create("JOJU DESU");
        Product card3 = factory.create("JJJJJJ");
        // Product card4 = new IDCard("a");
        card1.use();
        card2.use();
        card3.use();
        System.out.println(((IDCardFactory)factory).getOwners());
        // 匿名クラス
        Product p = new Product(){
            {
                System.out.println("init");
            }
            public void use() {
                System.out.println("used");
            }
        };
        Product p2 = new IDCard(){
            public void use() {
                System.out.println("used 2");
            }
        };
        System.out.println(p.getClass());
        System.out.println(p2.getClass());
        p.use();
        p2.use();
    }
}

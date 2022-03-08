package _09_bridge;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Display d1 = new Display(new StringDisplayImpl("Hello Japan!"));
        Display d2 = new CountDisplay(new StringDisplayImpl("Hello World!"));
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello Universe!"));
        RandomDisplay d4 = new RandomDisplay(new StringDisplayImpl("Hello TEAM JJ!"));
        Display d5 = new Display(new FileDisplayImpl("_09_bridge/jj.txt"));

        TriangleDisplay d6 = new TriangleDisplay(new BracketDisplayImpl("<", "*", ">"));
        TriangleDisplay d7 = new TriangleDisplay(new BracketDisplayImpl("|", "##", "-"));

        d1.display();
        d2.display();
        // d2.multiDisplay(5);
        d3.display();
        d3.multiDisplay(5);

        d4.randomDisplay(10);

        d5.display();

        d6.triangleDisplay(4);
        d7.triangleDisplay(6);
    }
}

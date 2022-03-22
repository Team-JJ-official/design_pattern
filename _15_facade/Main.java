package _15_facade;

import _15_facade.pagemaker.PageMaker;

@FunctionalInterface
interface Lambda <JJ> {
    void func(JJ x);
    default void func2(JJ x) {};
}

public class Main {
    public static void main(String[] args) {
        PageMaker.makeWelcomePage("jj@team-jj.com", "_15_facade/welcomeJJ.html");
        PageMaker.makeLinkPage("_15_facade/linkpage.html");

        Lambda<String> l = (String a) -> System.out.println("name: " + a);
        l.func("jj");
    }
}

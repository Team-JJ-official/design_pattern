package _05_singleton.practice.p2;

public class Main {
    public static void main(String[] args) {
        System.out.println(Triple.getInstance(0) == Triple.getInstance(0));
        System.out.println(Triple.getInstance(0) == Triple.getInstance(1));
        System.out.println(Triple.getInstance(0) == Triple.getInstance(2));
        System.out.println(Triple.getInstance(0));
    }
}

package _05_singleton.practice.p1;

public class Main {
    public static void main(String[] args) {   
        // TicketMaker tm = new TicketMaker();
        for (int i = 0; i < 10; i++) {
            System.out.println(TicketMaker.getNextTicketnumber());
        }
    }
}

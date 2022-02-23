package _05_singleton.practice.p1;

public final class TicketMaker {
    private int ticket = 1000;
    private static TicketMaker tm = new TicketMaker();
    private TicketMaker() {}
    public static int getNextTicketnumber() {
        return tm.ticket++;
    }
}

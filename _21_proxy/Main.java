package _21_proxy;

public class Main {
    public static void main(String[] args) {
        Printable p = new PrinterProxy("Alice", Printer.class);
        System.out.println("名前は現在" + p.getPrinterName() + "です。");
        p.setPrinterName("JJ");
        System.out.println("名前は現在" + p.getPrinterName() + "です。");
        p.print("Hello world.");
    }
}

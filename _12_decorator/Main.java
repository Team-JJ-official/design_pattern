package _12_decorator;

public class Main {
    public static void main(String[] args) {
        Display b1 = new StringDisplay("Hello Team JJ!");
        Display b2 = new UpDownBorder(b1, '-');
        Display b3 = new SideBorder(b2, '*');
        b1.show();
        b2.show();
        b3.show();
        Display b4 = new FullBorder(new UpDownBorder(new SideBorder(new UpDownBorder(new SideBorder(new StringDisplay("こんにちは！"), '*'), '='), '|'), '/'));
        // SideBorder(new UpDownBorder(new FullBorder(new UpDownBorder(new FullBorder(new StringDisplay("こんにちは！")), '*'), )), '/');
        b4.show();

        MultiStringDisplay md = new MultiStringDisplay();
        md.add("おはよーござんす");
        md.add("こんにちは！");
        md.add("おやすみなさい，また明日！！！！！！！");
        md.show();
        
        Display d1 = new SideBorder(md, '#');
        d1.show();

        Display d2 = new FullBorder(md);
        d2.show();
    }
}

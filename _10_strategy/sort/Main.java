package _10_strategy.sort;

public class Main {
    public static void main(String[] args) {
        String[] data = {
            "Dumpty", "JJ", "Bowman", "Carroll", "JJ", "Elfland", "Alice",
        };
        System.out.println(data[0] + data[1]);
        QuickSorter.swap(data, 0, 1);
        System.out.println(data[0] + data[1]);
        SortAndPrint sap = new SortAndPrint(data, new QuickSorter());
        sap.execute();
    }
}

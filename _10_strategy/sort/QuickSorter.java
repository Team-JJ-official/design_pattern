package _10_strategy.sort;

public class QuickSorter implements Sorter {

    public static void swap(Object[] data, int a, int b) {
        Object tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }

    private void irekae(Comparable[] data, int l, int r) { //[l, r)
        if (l + 1 >= r) {
            return;
        }
        int p = l, li = l + 1, ri = r - 1;
        while (true) {
            while (li <= ri && data[p].compareTo(data[li]) >= 0) {
                li++;
            }
            while (li <= ri && data[ri].compareTo(data[p]) > 0) {
                ri--;
            }
            if (li > ri){
                break;
            }
            swap(data, li, ri);
        }
        swap(data, p, ri);
        irekae(data, l, ri);
        irekae(data, li, r);
    }

    @Override
    public void sort(Comparable[] data) {
        irekae(data, 0, data.length);
    }
}

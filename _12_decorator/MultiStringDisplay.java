package _12_decorator;

import java.util.ArrayList;
import java.lang.Math;

public class MultiStringDisplay extends Display {
    private int col = 0;
    private ArrayList<String> s;
    public MultiStringDisplay() {
        s = new ArrayList<String>();
    }
    @Override
    public int getColumns() {
        return col;
    }
    @Override
    public int getRows() {
        return s.size();
    }
    @Override
    public String getRowText(int row) {
        if (row < s.size())
            return s.get(row) + makeLine(' ', col - s.get(row).getBytes().length);
        else
            return null;
    }
    public void add(String line) {
        s.add(line);
        col = Math.max(col, line.getBytes().length);
    }
    private String makeLine(char ch, int count) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buf.append(ch);
        }
        return buf.toString();
    }
}

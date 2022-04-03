package _20_flyweight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BigChar {
    private char charname;
    private String fontdata;
    public BigChar(char charname) {
        System.out.println("new BigChar:" + charname);
        this.charname = charname;
        try {
            BufferedReader reader = new BufferedReader(
                new FileReader("_20_flyweight/big_chars/big" + this.charname + ".txt")
            );
            String line;
            StringBuffer buf = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                buf.append(line.replace(".", " "));
                // buf.append("\n");
            }
            reader.close();
            this.fontdata = buf.toString();
        } catch (IOException e) {
            this.fontdata = charname + "?";
        }
    }
    public void print() {
        System.out.print(fontdata);
    }
    public void printLine(int i) {
        System.out.print(fontdata.substring(i * 7, (i + 1) * 7));
    }
}

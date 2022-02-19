package _02_adapter.practice.p2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        FileIO f = new FileProperties();
        try {
            f.readFromFile("./02_adapter/practice/p2/file.txt");
            f.setValue("year", "2004");
            f.setValue("month", "4");
            f.setValue("day", "21");
            f.writeToFile("./02_adapter/practice/p2/newfile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
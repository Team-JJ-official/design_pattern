package _07_builder;

import java.io.*;

public class MDBuilder extends Builder {
    private String filename;
    private PrintWriter writer;

    @Override
    public void createTitle(String title) {
        filename = "_07_builder/" + title + ".md";
        try {
            writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.println("# " + title);
    }
    @Override
    public void createString(String str) {
        writer.println("*" + str + "*");
    }
    @Override
    public void createItems(String[] items) {
        for (int i = 0; i < items.length; i++) {
            writer.println("- " + items[i]);
        }
    }
    @Override
    public void internalClose() {
        writer.close();
    }
    public String getResult() {
        return filename;
    }
}

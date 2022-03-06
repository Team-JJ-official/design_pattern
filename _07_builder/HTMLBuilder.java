package _07_builder;

import java.io.*;

public class HTMLBuilder extends Builder {
    private String filename;
    private PrintWriter writer;
    @Override
    public void createTitle(String title) {
        filename = "_07_builder/" + title + ".html";
        try {
            writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.println("<html><head><title>" + title + "</title></head><body>");
        writer.println("<h1>" + title + "</h1>");
    }
    @Override
    public void createString(String str) {
        writer.println("<p>" + str + "</p>");
    }
    @Override
    public void createItems(String[] items) {
        writer.println("<ul>");
        for (int i = 0; i < items.length; i++) {
            writer.println("<li>" + items[i] + "</li>");
        }
        writer.println("</ul>");
    }
    @Override
    public void internalClose() {
        writer.println("</body></html>");
        writer.close();
    }
    public String getResult() {
        return filename;
    }
}

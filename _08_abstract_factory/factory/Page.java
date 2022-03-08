package _08_abstract_factory.factory;
import java.io.*;
import java.util.ArrayList;

public abstract class Page {
    protected String title;
    protected String auther;
    protected ArrayList<Item> content = new ArrayList<Item>();

    public Page(String title, String auther) {
        this.title = title;
        this.auther = auther;
    }
    public void add(Item... items) {
        for (Item item : items) {
            content.add(item);
        }
    }
    public void output() {
        try {
            String filename = "_08_abstract_factory/" + title + ".html";
            Writer writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf8"));
            writer.write(this.makeHTML());
            writer.close();
            System.out.println(filename + "を作成しました！");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public abstract String makeHTML();
}

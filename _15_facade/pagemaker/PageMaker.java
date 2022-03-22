package _15_facade.pagemaker;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Properties;

public class PageMaker {
    private PageMaker() {}
    public static void makeWelcomePage(String mailaddr, String filename) {
        try {
            Properties mailprop = Database.getProperties("maildata");
            String username = mailprop.getProperty(mailaddr);
            HtmlWriter writer = new HtmlWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf8"));
            writer.title("welcome to " + username + "'s page!");
            writer.paragraph(username + "のページへようこそ！");
            writer.paragraph("メール待っていますね。");
            writer.mailto(mailaddr, username);
            writer.close();
            System.out.println(String.format("%s is created for %s (%s)", filename, mailaddr, username));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void makeLinkPage(String filename) {
        try {
            Properties mailprop = Database.getProperties("maildata");
            HtmlWriter writer = new HtmlWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf8"));
            writer.title("Link Page");
            mailprop.forEach((Object mailaddr, Object username) -> {
                try {
                    writer.mailto((String)mailaddr, (String)username);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

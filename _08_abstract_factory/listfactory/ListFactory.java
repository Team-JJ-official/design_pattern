package _08_abstract_factory.listfactory;

import _08_abstract_factory.factory.*;

public class ListFactory extends Factory {
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }
    public Page createPage(String title, String auther) {
        return new ListPage(title, auther);
    }
}

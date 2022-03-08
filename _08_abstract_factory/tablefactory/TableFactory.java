package _08_abstract_factory.tablefactory;

import _08_abstract_factory.factory.*;

public class TableFactory extends Factory {
    public Link createLink(String caption, String url) {
        return new TableLink(caption, url);
    }
    public Tray createTray(String caption) {
        return new TableTray(caption);
    }
    public Page createPage(String title, String auther) {
        return new TablePage(title, auther);
    }
}

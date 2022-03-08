package _08_abstract_factory.listfactory;

import _08_abstract_factory.factory.*;
import java.util.Iterator;

public class ListPage extends Page {
    public ListPage(String title, String auther) {
        super(title, auther);
    }
    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(String.format("<html><head><title>%s</title></head>\n", title));
        buffer.append("<body>\n");
        buffer.append(String.format("<h1>%s<h1>", title));
        buffer.append("<ul>\n");
        Iterator<Item> it = content.iterator();
        while(it.hasNext()) {
            Item item = (Item)it.next();
            buffer.append(item.makeHTML());
        }
        buffer.append("</ul>\n");
        buffer.append(String.format("<hr><address>%s</address>", auther));
        buffer.append("</body>\n");
        return buffer.toString();
    }
}

package _08_abstract_factory.tablefactory;

import _08_abstract_factory.factory.*;
import java.util.Iterator;

public class TablePage extends Page {
    public TablePage(String title, String auther) {
        super(title, auther);
    }

    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(String.format("<html><head><title>%s</title></head>\n", title));
        buffer.append("<body>\n");
        buffer.append(String.format("<h1>%s</h1>\n", title));
        buffer.append("<table width=\"80%\" border=\"3\">");
        Iterator<Item> it = content.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            buffer.append(String.format("<tr>%s</tr>\n", item.makeHTML()));
        }
        buffer.append("</table>\n");
        buffer.append("<hr><address>" + auther + "</address>");
        buffer.append("</body></html>\n");
        return buffer.toString();
    }
}

package _08_abstract_factory.tablefactory;

import _08_abstract_factory.factory.*;

public class TableLink extends Link {
    public TableLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return String.format("<td><a href=\"%s\">%s</a></td>", url, caption);
    }
}

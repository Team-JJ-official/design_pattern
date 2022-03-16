package _13_visitor;

import java.util.Iterator;
import java.util.ArrayList;

public class ElementArrayList extends ArrayList<Entry> implements Element {
    @Override
    public void accept(Visitor v) {
        Iterator<Entry> it = iterator();
        while (it.hasNext()) {
            Entry entry = it.next();
            // if (entry instanceof File) {
            //     v.visit((File)entry);
            // } else {
            //     v.visit((Directory)entry);
            // }
            entry.accept(v);
        }
    }
}

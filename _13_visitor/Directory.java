package _13_visitor;

import java.util.Iterator;
import java.util.ArrayList;

public class Directory extends Entry {
    private String name;
    private ArrayList<Entry> dir = new ArrayList<Entry>();

    public Directory(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getSize() {
        // int size = 0;
        // Iterator<Entry> it = dir.iterator();
        // while (it.hasNext()) {
        //     Entry entry = (Entry)it.next();
        //     size += entry.getSize();
        // }
        // return size;
        SizeVisitor v = new SizeVisitor();
        v.visit(this);
        return v.getSize();
    }
    @Override
    public Entry add(Entry... entries) throws FileTreatmentException {
        for (Entry entry : entries) {
            dir.add(entry);
        }
        return this;
    }
    @Override
    public Iterator<Entry> iterator() throws FileTreatmentException {
        return dir.iterator();
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

package _13_visitor;

import java.util.Iterator;
import java.util.ArrayList;

public class FileFindVisitor extends Visitor {
    private ArrayList<File> files;
    private String ext;
    public FileFindVisitor(String ext) {
        this.ext = ext;
        files = new ArrayList<File>();
    }
    @Override
    public void visit(File file) {
        if (file.getName().endsWith(ext)) {
            files.add(file);
        }
    }
    @Override
    public void visit(Directory directory) {
        Iterator<Entry> it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry)it.next();
            entry.accept(this);
        }
    }
    public Iterator<File> getFoundFiles() {
        return files.iterator();
    }
}

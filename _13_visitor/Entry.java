package _13_visitor;

import java.util.Iterator;

public abstract class Entry implements Element {
    public abstract String getName();
    public abstract int getSize();
    public Entry add(Entry... entries) throws FileTreatmentException {
        throw new FileTreatmentException();
    }
    public Iterator<Entry> iterator() throws FileTreatmentException {
        throw new FileTreatmentException();
    }
    public String toString() {
        return getName() + " (" + getSize() + ") ";
    }}
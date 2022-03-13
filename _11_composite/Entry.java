package _11_composite;

public abstract class Entry {
    public abstract String getName();
    public abstract int getSize();
    private Entry parent; 
    public Entry getParent() {
        return this.parent;
    };
    protected void setParent(Entry parent) {
        this.parent = parent;
    };
    
    private void absolute(int x) {
        Entry p = getParent();
        if (p != null) {
            p.absolute(x);
        }
        System.out.print("/" + getName());
    }
    public void absolute() {
        absolute(1);
        System.out.println("");
    }
    public Entry add(Entry... entries) throws FileTreatmentException {
        throw new FileTreatmentException();
    }
    public void printList() {
        printList("");
    }
    protected abstract void printList(String prefix);
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }

}

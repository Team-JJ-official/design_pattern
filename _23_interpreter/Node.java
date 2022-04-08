package _23_interpreter;

import java.util.Iterator;

public abstract class Node {
    public abstract void parse(Context context) throws ParseException;
    public abstract Iterator<Node> iterator();
    public void accept(Visitor v) {
        v.visit(this);
    }
}
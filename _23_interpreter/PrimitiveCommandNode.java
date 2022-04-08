package _23_interpreter;

import java.util.ArrayList;
import java.util.Iterator;

public class PrimitiveCommandNode extends Node {
    private String name;

    @Override
    public void parse(Context context) throws ParseException {
        name = context.currentToken();
        context.skipToken(name);
        if (!name.equals("go") && !name.equals("right") && !name.equals("left")) {
            throw new ParseException(name + " is undefined");
        }
    }
    @Override
    public String toString() {
        return name;
    }
    @Override
    public Iterator<Node> iterator() {
        ArrayList<Node> l = new ArrayList<Node>();
        l.add(this);
        return l.iterator();
    }
}

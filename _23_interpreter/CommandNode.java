package _23_interpreter;

import java.util.ArrayList;
import java.util.Iterator;

public class CommandNode extends Node {
    private Node node;

    @Override
    public void parse(Context context) throws ParseException {
        if (context.currentToken().equals("repeat")) {
            node = new RepeatCommandNode();
            node.parse(context);
        }
        else {
            node = new PrimitiveCommandNode();
            node.parse(context);
        }
    }
    @Override
    public String toString() {
        return node.toString();
    }
    public Iterator<Node> iterator() {
        ArrayList<Node> l = new ArrayList<Node>();
        l.add(node);
        return l.iterator();
    }
}

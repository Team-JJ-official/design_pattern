package _23_interpreter;

import java.util.ArrayList;
import java.util.Iterator;

public class ProgramNode extends Node {
    private Node commandListNode;

    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("program");
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }
    public String toString() {
        return String.format("[program %s ]", commandListNode);
    }
    @Override
    public Iterator<Node> iterator() {
        ArrayList<Node> l = new ArrayList<Node>();
        l.add(commandListNode);
        return l.iterator();
    }
}

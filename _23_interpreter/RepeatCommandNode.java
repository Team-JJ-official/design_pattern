package _23_interpreter;

import java.util.ArrayList;
import java.util.Iterator;

public class RepeatCommandNode extends Node {
    private int number;
    private Node commandListNode;
	@Override
	public void parse(Context context) throws ParseException {
        context.skipToken("repeat");
        number = context.currentNumber();
        context.nextToken();
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
	}
    public String toString() {
        return "[repeat " + number + " " + commandListNode + "]";
    }
    public Iterator<Node> iterator() {
        ArrayList<Node> l = new ArrayList<Node>();
        for (int i = 0; i < number; i++) {
            l.add(commandListNode);
        }
        return l.iterator();
    }
}

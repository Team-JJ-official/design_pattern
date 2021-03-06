package _23_interpreter;

import java.util.ArrayList;
import java.util.Iterator;

public class CommandListNode extends Node {
    private ArrayList<Node> list = new ArrayList<Node>();

	@Override
	public void parse(Context context) throws ParseException {
        while (true) {
            if (context.currentToken() == null) {
                throw new ParseException("Missing 'end'");
            } else if (context.currentToken().equals("end")) {
                context.skipToken("end");
                break;
            } else {
                Node commandNode = new CommandNode();
                commandNode.parse(context);
                list.add(commandNode);
            }
        }
		
	}

    public String toString() {
        return list.toString();
    }
    public Iterator<Node> iterator() {
        return list.iterator();
    }
    
}

package _23_interpreter;

import java.util.Iterator;

class Point {
    int x = 0, y = 0;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    void add(Point p) {
        this.x += p.x;
        this.y += p.y;
    }
}

public class PrintVisitor implements Visitor {
    private Point p;
    private int dir = 0;
    private Point[] dxy = {
        new Point(0, 1),
        new Point(1, 0),
        new Point(0, -1),
        new Point(-1, 0)
    };
    @Override
    public void visit(Node node) {
        Iterator<Node> it = node.iterator();
        while (it.hasNext()) {
            Node n = it.next();
            if (n instanceof PrimitiveCommandNode) {
                String name = n.toString();
                if (name == "go") {
                    go();
                } else if (name == "right") {
                    right();
                } else if (name == "left") {
                    left();
                }
            } else {
                n.accept(this);
            }
        }
    }
    
    private void go() {
        p.add(dxy[dir]);
    }
    private void left() {
        dir--;
        if (dir < 0)
            dir += 4;
    }
    private void right() {
        dir++;
        dir %= 4;
    }
}

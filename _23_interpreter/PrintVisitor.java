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
    public String toString() {
        return String.format("x: %d, y: %d", x, y);
    }
}

public class PrintVisitor implements Visitor {
    private Point p = new Point(0, 0);
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
                // System.out.println(name);
                if (name.equals("go")) {
                    go();
                } else if (name.equals("right")) {
                    right();
                } else if (name.equals("left")) {
                    left();
                }
                printCurrent();
            } else {
                n.accept(this);
            }
        }
    }

    public void printCurrent() {
        System.out.println(String.format("now: %s, dir: %s", p, dxy[dir]));
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

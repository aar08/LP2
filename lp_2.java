import java.util.*;

class AStar {

    static class Node {
        int x, y, g;
        Node p;

        Node(int x, int y, int g, Node p) {
            this.x = x;
            this.y = y;
            this.g = g;
            this.p = p;
        }
    }

    static int h(int x, int y, int gx, int gy) {
        return Math.abs(x - gx) + Math.abs(y - gy);
    }

    static void aStar() {
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> (a.g + h(a.x,a.y,4,4)) - (b.g + h(b.x,b.y,4,4))
        );

        boolean[][] v = new boolean[5][5];
        pq.add(new Node(0, 0, 0, null));

        while (!pq.isEmpty()) {
            Node c = pq.poll();

            if (v[c.x][c.y]) continue;
            v[c.x][c.y] = true;

            if (c.x == 4 && c.y == 4) {
                print(c);
                return;
            }

            if (c.x+1<5) pq.add(new Node(c.x+1,c.y,c.g+1,c));
            if (c.y+1<5) pq.add(new Node(c.x,c.y+1,c.g+1,c));
        }
    }

    static void print(Node n) {
        if (n == null) return;
        print(n.p);
        System.out.print("(" + n.x + "," + n.y + ") ");
    }

    public static void main(String[] args) {
        aStar();
    }
}
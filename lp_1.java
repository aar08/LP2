import java.util.*;

public class GraphEasy {
    static ArrayList<Integer>[] graph;

    // Add edge (undirected)
    static void addEdge(int u, int v) {
        graph[u].add(v);
        graph[v].add(u);
    }

    // -------- DFS (Recursive) --------
    static void dfs(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int n : graph[node]) {
            if (!visited[n]) {
                dfs(n, visited);
            }
        }
    }

    // -------- BFS (Recursive) --------
    static void bfsRec(Queue<Integer> q, boolean[] visited) {
        if (q.isEmpty()) return;

        int node = q.poll();
        System.out.print(node + " ");

        for (int n : graph[node]) {
            if (!visited[n]) {
                visited[n] = true;
                q.add(n);
            }
        }

        bfsRec(q, visited); // recursive call
    }

    public static void main(String[] args) {
        int V = 5;
        graph = new ArrayList[V];

        for (int i = 0; i < V; i++)
            graph[i] = new ArrayList<>();

        // edges
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 3);
        addEdge(1, 4);

        // DFS
        System.out.print("DFS: ");
        dfs(0, new boolean[V]);

        // BFS (recursive)
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;

        System.out.print("\nBFS: ");
        bfsRec(q, visited);
    }
}
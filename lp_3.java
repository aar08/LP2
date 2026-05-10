class SelectionSort {
    public static void main(String[] args) {
        int a[] = {5, 3, 1, 4, 2};

        for (int i = 0; i < a.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) min = j;
            }

            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }

        for (int x : a) System.out.print(x + " ");
    }
}

******************************************************************************

import java.util.*;

public class Prims {
    public static void main(String[] args) {
        int graph[][] = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        int n = 5;
        int key[] = new int[n];
        boolean mst[] = new boolean[n];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = -1, min = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (!mst[j] && key[j] < min) {
                    min = key[j];
                    u = j;
                }
            }

            mst[u] = true;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !mst[v] &&
                    graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                }
            }
        }

        System.out.println("Minimum cost:");
        int sum = 0;
        for (int k : key) sum += k;
        System.out.println(sum);
    }
}

******************************************************************************

import java.util.*;

class Dijkstra {
    public static void main(String[] args) {
        int graph[][] = {
            {0, 1, 4},
            {1, 0, 2},
            {4, 2, 0}
        };

        int dist[] = {0, 999, 999};
        boolean visited[] = new boolean[3];

        for (int i = 0; i < 3; i++) {
            int u = -1;

            for (int j = 0; j < 3; j++)
                if (!visited[j] && (u == -1 || dist[j] < dist[u]))
                    u = j;

            visited[u] = true;

            for (int v = 0; v < 3; v++) {
                if (graph[u][v] != 0)
                    dist[v] = Math.min(dist[v], dist[u] + graph[u][v]);
            }
        }

        for (int d : dist)
            System.out.print(d + " ");
    }
}
package DSA;
 import java.util.*;
 public class PrimMST {
    private static final int INF = Integer.MAX_VALUE;
    private int V;
    public PrimMST(int v) {
        V = v;
    }
    private int minKey(int[] key, boolean[] mstSet) {
        int min_val = INF;
        int min_index = -1;
        for (int v = 0; v < V; v++) {
            if (mstSet[v] == false && key[v] < min_val) {
                min_val = key[v];
                min_index = v;
            }
        }
        return min_index;
    }
    private void printMST(int[] parent, int[][] graph) {
        long totalCost = 0;
        System.out.println("\nEdge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + " \t" + 
graph[i][parent[i]]);
            totalCost += graph[i][parent[i]];
        }
        System.out.println("----------------------");
        System.out.println("Total cost of MST: " + totalCost);
    }
    public void primMST(int[][] graph) {
        int[] key = new int[V];
        boolean[] mstSet = new boolean[V];
        int[] parent = new int[V];
        Arrays.fill(key, INF);
        Arrays.fill(mstSet, false);
        Arrays.fill(parent, -1);
        key[0] = 0;
        for (int count = 0; count < V; count++) {
            int u = minKey(key, mstSet);
            if (u == -1) break;
            mstSet[u] = true;
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v])
 {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
        printMST(parent, graph);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V;
        System.out.print("Enter the number of vertices (V): ");
        if (scanner.hasNextInt()) {
            V = scanner.nextInt();
        } else {
            System.out.println("Invalid input for number of vertices.");
            scanner.close();
            return;
        }
        int[][] graph = new int[V][V];
        System.out.println("Enter the adjacency matrix (0 for no edge or 
self-loop):\n");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print("Enter weight for edge " + i + "-" + j + ": ");
                if (scanner.hasNextInt()) {
                    graph[i][j] = scanner.nextInt();
                } else {
                    System.out.println("Invalid input. Exiting.");
                    scanner.close();
                    return;
                }
                if (i == j) {
                    graph[i][j] = 0;
                }
            }
        }
        scanner.close();
        PrimMST t = new PrimMST(V);
        t.primMST(graph);
    }
 }
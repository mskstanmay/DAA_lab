import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        
        int INF = 10000000;
        int[][] dist = new int[V][V];
        
        for (int i = 0; i < V; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            dist[u][v] = w;
            dist[v][u] = w;
        }
        
        System.out.println("Original matrix");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF");
                } else {
                    System.out.print(dist[i][j]);
                }
                if (j < V - 1) System.out.print(" ");
            }
            System.out.println();
        }
        
        int[][] shortest = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                shortest[i][j] = dist[i][j];
            }
        }
        
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (shortest[i][k] + shortest[k][j] < shortest[i][j]) {
                        shortest[i][j] = shortest[i][k] + shortest[k][j];
                    }
                }
            }
        }
        
        System.out.println("Shortest path matrix");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (shortest[i][j] == INF) {
                    System.out.print("INF");
                } else {
                    System.out.print(shortest[i][j]);
                }
                if (j < V - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
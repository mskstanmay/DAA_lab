import java.util.*;

public class Main {
    static int[][] capacity;
    static int n;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        int m = sc.nextInt();
        
        capacity = new int[n][n];
        
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int c = sc.nextInt();
            capacity[u][v] = c;
        }
        
        int maxFlow = maxFlow(0, n - 1);
        System.out.println(maxFlow + " units");
    }
    
    static int maxFlow(int source, int sink) {
        int[][] residual = new int[n][n];
        for (int i = 0; i < n; i++) {
            residual[i] = capacity[i].clone();
        }
        
        int[] parent = new int[n];
        int maxFlow = 0;
        
        while (bfs(residual, source, sink, parent)) {
            int pathFlow = Integer.MAX_VALUE;
            
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, residual[u][v]);
            }
            
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                residual[u][v] -= pathFlow;
                residual[v][u] += pathFlow;
            }
            
            maxFlow += pathFlow;
        }
        
        return maxFlow;
    }
    
    static boolean bfs(int[][] residual, int source, int sink, int[] parent) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(source);
        visited[source] = true;
        parent[source] = -1;
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            
            for (int v = 0; v < n; v++) {
                if (!visited[v] && residual[u][v] > 0) {
                    visited[v] = true;
                    parent[v] = u;
                    queue.add(v);
                    
                    if (v == sink) return true;
                }
            }
        }
        
        return false;
    }
}
import java.util.*;

public class Main {
    static final int MAX_NODES = 16;
    static int[][] graph = new int[MAX_NODES][MAX_NODES];
    static int[] parent = new int[MAX_NODES];
    static boolean[] visited = new boolean[MAX_NODES];
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int c = sc.nextInt();
            graph[u][v] = c;
        }
        
        int maxFlow = fordFulkerson(0, n - 1);
        System.out.println("Maximum amount of electricity: " + maxFlow);
    }
    
    static int fordFulkerson(int source, int sink) {
        int maxFlow = 0;
        
        while (bfs(source, sink)) {
            int pathFlow = Integer.MAX_VALUE;
            
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, graph[u][v]);
            }
            
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                graph[u][v] -= pathFlow;
                graph[v][u] += pathFlow;
            }
            
            maxFlow += pathFlow;
        }
        
        return maxFlow;
    }
    
    static boolean bfs(int source, int sink) {
        Arrays.fill(visited, false);
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(source);
        visited[source] = true;
        parent[source] = -1;
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            
            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] > 0) {
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
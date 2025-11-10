import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph.get(u).add(new int[]{v, w});
        }
        
        int S = sc.nextInt();
        
        int[] dist = new int[N];
        int[] parent = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        dist[S] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{S, 0});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], d = curr[1];
            
            if (d > dist[u]) continue;
            
            for (int[] edge : graph.get(u)) {
                int v = edge[0], w = edge[1];
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    parent[v] = u;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            if (i != S) {
                if (dist[i] == Integer.MAX_VALUE) {
                    continue;
                } else {
                    List<Integer> path = new ArrayList<>();
                    int cur = i;
                    while (cur != -1) {
                        path.add(cur);
                        cur = parent[cur];
                    }
                    Collections.reverse(path);
                    System.out.print(dist[i] + " ");
                    for (int j = 0; j < path.size(); j++) {
                        System.out.print(path.get(j));
                        if (j < path.size() - 1) System.out.print(" -> ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
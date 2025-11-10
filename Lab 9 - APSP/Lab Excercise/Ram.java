import java.util.*;

class Ram {
    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // number of routers
        int M = sc.nextInt(); // number of links

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w)); // undirected
        }

        int source = sc.nextInt();
        int dest = sc.nextInt(); // (not directly needed, but part of input)

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[] { source, 0 });

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], d = cur[1];

            if (d > dist[u])
                continue;

            for (Edge e : graph.get(u)) {
                if (dist[e.to] > dist[u] + e.weight) {
                    dist[e.to] = dist[u] + e.weight;
                    pq.offer(new int[] { e.to, dist[e.to] });
                }
            }
        }

        // print distances
        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println(i + " " + -1); // unreachable router
            } else {
                System.out.println(i + " " + dist[i]);
            }
        }
    }
}
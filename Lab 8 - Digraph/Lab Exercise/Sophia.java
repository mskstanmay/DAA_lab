import java.util.*;

public class Sophia {
    static List<List<Integer>> graph, reverseGraph;
    static boolean[] visited;
    static Stack<Integer> stack;
    static int[] cmp;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new ArrayList<>();
        reverseGraph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            reverseGraph.get(v).add(u);
        }

        // Kosaraju's Algorithm to find SCCs
        visited = new boolean[n + 1];
        stack = new Stack<>();
        for (int i = 1; i <= n; i++)
            if (!visited[i])
                dfs1(i);

        cmp = new int[n + 1];
        Arrays.fill(cmp, -1);
        int cid = 0;
        visited = new boolean[n + 1];
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (!visited[u]) {
                dfs2(u, cid++);
            }
        }

        // If only one component, no edges needed
        if (cid == 1) {
            System.out.println(0);
            return;
        }

        int[] indeg = new int[cid];
        int[] outdeg = new int[cid];
        for (int u = 1; u <= n; u++) {
            for (int v : graph.get(u)) {
                if (cmp[u] != cmp[v]) {
                    outdeg[cmp[u]]++;
                    indeg[cmp[v]]++;
                }
            }
        }

        int sources = 0, sinks = 0;
        for (int i = 0; i < cid; i++) {
            if (indeg[i] == 0)
                sources++;
            if (outdeg[i] == 0)
                sinks++;
        }

        System.out.println(Math.max(sources, sinks));
    }

    static void dfs1(int u) {
        visited[u] = true;
        for (int v : graph.get(u))
            if (!visited[v])
                dfs1(v);
        stack.push(u);
    }

    static void dfs2(int u, int cid) {
        visited[u] = true;
        cmp[u] = cid;
        for (int v : reverseGraph.get(u))
            if (!visited[v])
                dfs2(v, cid);
    }
}
import java.util.*;

public class One {
    static int time = 0;
    static int[] disc, low;
    static boolean[] stackMember;
    static Stack<Integer> st;
    static List<List<Integer>> graph;
    static Set<Integer> townsSeen = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of roads

        graph = new ArrayList<>();
        List<int[]> edges = new ArrayList<>();
        int maxTown = -1;

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            edges.add(new int[] { a, b });
            maxTown = Math.max(maxTown, Math.max(a, b));
        }

        // initialize graph
        for (int i = 0; i <= maxTown; i++) {
            graph.add(new ArrayList<>());
        }

        // build graph
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            townsSeen.add(e[0]);
            townsSeen.add(e[1]);
        }

        int totalTowns = maxTown + 1;
        disc = new int[totalTowns];
        low = new int[totalTowns];
        stackMember = new boolean[totalTowns];
        st = new Stack<>();

        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);

        // print isolated towns (not in townsSeen)
        for (int i = 0; i < totalTowns; i++) {
            if (!townsSeen.contains(i)) {
                System.out.println(i);
            }
        }

        // run Tarjan for each unvisited town
        for (int i = 0; i < totalTowns; i++) {
            if (disc[i] == -1 && townsSeen.contains(i)) {
                tarjan(i);
            }
        }
    }

    static void tarjan(int u) {
        disc[u] = low[u] = ++time;
        st.push(u);
        stackMember[u] = true;

        for (int v : graph.get(u)) {
            if (disc[v] == -1) {
                tarjan(v);
                low[u] = Math.min(low[u], low[v]);
            } else if (stackMember[v]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        // If u is head of SCC
        if (low[u] == disc[u]) {
            List<Integer> scc = new ArrayList<>();
            while (true) {
                int w = st.pop();
                stackMember[w] = false;
                scc.add(w);
                if (w == u)
                    break;
            }
            // print SCC
            for (int node : scc) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}
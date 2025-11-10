/*
Problem Statement



You are a civil engineer working on optimizing water distribution through a network of interconnected pipelines to ensure efficient water flow between a main reservoir and various supply stations. 



Your goal is to design a program that determines the maximum amount of water that can be delivered through the pipeline network without exceeding the capacity of any pipeline.

Input format :
The first line of input consists of an integer N representing the number of junctions (nodes) in the network.

The second line consists of an integer E representing the number of pipelines (edges).

The next E lines each contain three space-separated integers U, V and C, where:

U is the starting junction of a pipeline.

V is the ending junction of a pipeline.

C is the capacity (maximum water flow) of the pipeline.

Output format :
The output displays the "Maximum Flow: X" where X is the maximum amount of water that can flow from the main reservoir (junction 0) to the final supply station (last junction N-1).



Refer to the sample output for the formatting specifications.

Code constraints :
The given test cases fall under the following specifications:

2 ≤ N ≤ 10

0 ≤ M ≤ 10

0 ≤ capacity ≤ 100

Sample test cases :
Input 1 :
5
5
0 1 5
1 2 10
1 3 15
2 3 20
2 4 10
Output 1 :
Maximum Flow: 5
Input 2 :
4
5
0 1 10
0 2 5
1 3 10
2 1 5
2 3 10
Output 2 :
Maximum Flow: 15

*/


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int E = sc.nextInt();
        
        int[][] graph = new int[N][N];
        
        for (int i = 0; i < E; i++) {
            int U = sc.nextInt();
            int V = sc.nextInt();
            int C = sc.nextInt();
            graph[U][V] = C;
        }
        
        int source = 0;
        int sink = N - 1;
        
        int maxFlow = fordFulkerson(graph, source, sink, N);
        System.out.println("Maximum Flow: " + maxFlow);
    }
    
    static int fordFulkerson(int[][] graph, int source, int sink, int N) {
        int[][] residual = new int[N][N];
        for (int i = 0; i < N; i++) {
            residual[i] = graph[i].clone();
        }
        
        int[] parent = new int[N];
        int maxFlow = 0;
        
        while (bfs(residual, source, sink, parent, N)) {
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
    
    static boolean bfs(int[][] residual, int source, int sink, int[] parent, int N) {
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(source);
        visited[source] = true;
        parent[source] = -1;
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            
            for (int v = 0; v < N; v++) {
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

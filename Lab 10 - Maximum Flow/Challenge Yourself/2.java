/*
Problem Statement



In a bustling metropolis, a city-wide network infrastructure upgrade is underway to ensure efficient communication between different devices and support the increasing demands of modern technology.



As part of this upgrade, engineers are tasked with optimizing the flow of data through the communication network to maximize its capacity and reliability. 



You are a network engineer responsible for optimizing the data flow in the city's communication network.



Your goal is to calculate the maximum amount of data that can be transferred through the network to ensure efficient communication between different devices, using the maximum flow problem.

Input format :
The first line of the input is a space-separated integer values v and e, specifying the number of vertices and edges.

The next e lines of input consists of space-separated integer values, specifying the source, destination and capacity of each edge.

The last line of the input consists of space-separated integer values, specifying the source and sink.

Output format :
The output prints: "Maximum flow from source to sink is: " followed by an integer value specifying the maximum flow from source to sink.



Refer to sample input for formatting specifications.

Code constraints :
The given test cases fall under the following specifications:

0 ≤ vertices, edge ≤ 10

0 ≤ capacity ≤ 100

Sample test cases :
Input 1 :
3 3
0 1 5
0 2 7 
1 2 3
0 2
Output 1 :
Maximum flow from source to sink is: 10
Input 2 :
4 5
0 1 10
0 2 15
1 3 10
2 1 5
2 3 10
0 3
Output 2 :
Maximum flow from source to sink is: 20

*/


import java.util.*;

public class Main {

    // Function to check if there is a path from source to sink using BFS
    static boolean bfs(int[][] rGraph, int s, int t, int[] parent, int V) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        parent[s] = -1;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v = 0; v < V; v++) {
                if (!visited[v] && rGraph[u][v] > 0) {
                    q.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
        return visited[t];
    }

    // Edmonds-Karp implementation of Ford-Fulkerson
    static int fordFulkerson(int[][] graph, int s, int t, int V) {
        int[][] rGraph = new int[V][V]; // residual graph
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                rGraph[i][j] = graph[i][j];

        int[] parent = new int[V];
        int max_flow = 0;

        while (bfs(rGraph, s, t, parent, V)) {
            int path_flow = Integer.MAX_VALUE;
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                path_flow = Math.min(path_flow, rGraph[u][v]);
            }

            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
            }

            max_flow += path_flow;
        }

        return max_flow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(); // number of vertices
        int E = sc.nextInt(); // number of edges

        int[][] graph = new int[V][V];

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int capacity = sc.nextInt();
            graph[u][v] = capacity;
        }

        int source = sc.nextInt();
        int sink = sc.nextInt();

        int maxFlow = fordFulkerson(graph, source, sink, V);

        System.out.println("Maximum flow from source to sink is: " + maxFlow);
    }
}

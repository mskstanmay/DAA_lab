Problem Statement



Olivia, a software engineer, is analyzing a directed graph of interconnected systems. She needs to identify Strongly Connected Components (SCCs) using Tarjan’s Algorithm, which efficiently finds all SCCs in a graph. An SCC is a group of vertices where every vertex can reach every other vertex in the same SCC. 



Help Olivia determine and print all SCCs in the given directed graph.

Input format :
The first line of input consists of two integers V and E, where V is the number of vertices and E is the number of directed edges.

The next E lines each contain two integers u and v, representing a directed edge from u to v.

Output format :
The output prints each Strongly Connected Component (SCC) in a separate line.



Refer to the sample output for formatting specifications.

Code constraints :
The given test cases fall under the following specifications:

1 ≤ V ≤10

0 ≤ E ≤ 20

0 ≤ u, v < V

Sample test cases :
Input 1 :
5 5
1 0
0 2
2 1
0 3
3 4
Output 1 :
4
3
1 2 0
Input 2 :
4 3
0 1
1 2
2 3
Output 2 :
3
2
1
0

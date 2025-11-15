Problem Statement

Sophia, a network architect, is given a directed network of n routers and m one-way connections. She needs to determine the minimum number of additional connections required to make the entire network strongly connected, ensuring every router can reach every other router.

Help Sophia find the minimum edges needed to achieve strong connectivity.

Note: In a directed graph, a Strongly Connected Component is a subset of vertices where every vertex in the subset is reachable from every other vertex in the same subset by traversing the directed edges.

Input format :
The first line of input consists of an integer n, representing the number of routers (vertices).

The second line consists of an integer m, representing the number of directed connections (edges).

The next m lines each contain two integers u and v, representing a directed connection from router u to router v.

Output format :
The output prints a single integer representing the minimum number of additional edges required to make the graph strongly connected.

Refer to the sample output for formatting specifications.

Code constraints :
The given test cases fall under the following specifications:

1 ≤ n ≤ 10

1 ≤ m ≤ 10

0 ≤ u, v ≤ n

Sample test cases :
Input 1 :
5
5
1 2
3 2
1 3
3 4
4 5
Output 1 :
2
Input 2 :
3
2
1 2  
2 3
Output 2 :
1

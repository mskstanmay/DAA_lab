Problem Statement

Lena, a transportation planner, is tasked with improving the connectivity of a city's road network. The city has n intersections and m one-way streets connecting them. Lena needs to determine the minimum number of new streets required to ensure that every intersection is reachable from every other intersection.

Help Lena find the minimum number of new streets required to make the city's road network strongly connected.

Note: In a directed graph, a Strongly Connected Component (SCC) is a subset of intersections where every intersection in the subset can reach every other intersection in the same subset through the one-way streets.

Input format :
The first line contains an integer n, representing the number of intersections (vertices).

The second line contains an integer m, representing the number of one-way streets (edges).

The next m lines each contain two integers u and v, representing a one-way street from intersection u to intersection v.

Output format :
The output prints an integer, the minimum number of additional streets required to make the network strongly connected.

Refer to the sample output for formatting specifications.

Code constraints :
The given test cases fall under the following specifications:

1 ≤ n ≤ 10

1 ≤ m ≤ 10

0 ≤ u, v ≤ n

Sample test cases :
Input 1 :
3
3
1 2
2 3
3 1
Output 1 :
0
Input 2 :
4
3
1 2
2 3
3 4
Output 2 :
1

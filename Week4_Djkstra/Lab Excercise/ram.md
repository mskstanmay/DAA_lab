Ram is tasked with finding the shortest path between two routers in a network represented by a collection of routers connected by links, each with a certain weight. He will input the number of routers, the number of links, and the details of the connections between routers. 

The program will then use Dijkstra’s algorithm to find and print the shortest path from a specified source router to a destination router.

Input format :
The first line contains an integer N, representing the number of routers.
The second line contains an integer M, representing the number of links.
The next M lines each contain three space-separated integers: r1, r2, and w, representing a link between routers r1 and r2 with the given w.
The next line contains an integer, s, representing the source router.
The last line contains an integer d, representing the destination router.

Output format :
The output prints the shortest distances from the source router to all other routers in the network.
Each line should contain two integers separated by a space, representing the router and its distance from the source.

Refer to the sample output for the formatting specifications.
Code constraints :
The given test cases fall under the following specifications:

2 ≤ N ≤ 8

1≤ M ≤ 12

0 ≤ w ≤ 7

Sample test cases :
Input 1 :
4
5
0 1 1
0 2 3
1 2 1
1 3 4
2 3 1
0
3
Output 1 :
0 0
1 1
2 2
3 3
Input 2 :
3
3
0 1 2
0 2 4
1 2 1
0
2
Output 2 :
0 0
1 2
2 3
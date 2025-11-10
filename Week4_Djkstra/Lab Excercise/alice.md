Alice is working on a delivery system for an e-commerce platform. The system uses a network of delivery hubs (routers) connected by roads (links), each with a certain time required for a delivery. 



Alice needs to find the fastest route for a package from a source hub to a destination hub. She will input the number of hubs, the number of roads, and the details of the roads connecting the hubs. 



The program will then use Dijkstra's algorithm to find and print the shortest delivery time between the source hub and the destination hub.

Input format :
The first line contains an integer N, representing the number of delivery hubs (routers).

The second line contains an integer M, representing the number of roads (links) between hubs.

The next M lines each contain three space-separated integers: r1, r2, and t, representing a road between hubs r1 and r2 with a delivery time t (in minutes).

The next line contains an integer s, representing the source delivery hub (from where the package starts).

The last line contains an integer d, representing the destination delivery hub (where the package needs to be delivered).

Output format :
The output prints the shortest delivery times from the source hub to all other hubs in the network.

Each line should contain two integers separated by a space, representing the hub and its shortest delivery time from the source.

Each line should contain two integers separated by a space, representing the router and its distance from the source.



Refer to the sample output for the formatting specifications.

Code constraints :
The given test cases fall under the following specifications:

2 ≤ N ≤ 10

1 ≤ M ≤ 15

0 ≤ t ≤ 10

Sample test cases :
Input 1 :
3
3
0 1 2
0 2 4
1 2 1
0
2
Output 1 :
0 0
1 2
2 3
Input 2 :
4
5
0 1 2
0 2 1
1 3 3
2 3 4
1 2 1
0
3
Output 2 :
0 0
1 2
2 1
3 5
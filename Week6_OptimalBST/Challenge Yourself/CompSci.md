Computer science students are exploring the concept of Optimal Binary Search Trees (OBSTs) and have been assigned a problem related to it.



Your task is to develop a program that allows students to efficiently remove a key from an OBST and compute the updated cost of the OBST after deletion.



An OBST is a binary search tree designed to minimize the average search time based on given key frequencies.



Given a set of keys and their respective frequencies, implement a program that deletes a specified key from the OBST and determines the resulting cost of the tree.

Input format :
The first line contains an integer n, representing the number of keys in the OBST.

The second line contains n space-separated integers, representing the keys in the OBST.

The third line contains n space-separated integers, representing the frequencies of the corresponding keys.

The fourth line contains an integer r, representing the key to be deleted from the OBST.

Output format :
The output displays one of the following:

If the specified key is found in the OBST, output a single line containing the cost of the OBST after deleting the key.

Otherwise, the output is "Key not found in the OBST."



Refer to the sample output for the formatting specifications.

Code constraints :
1 <= n <= 10

1 <= keys <= 100

1 <= frequency <= 100

1 <= r <= 100

Sample test cases :
Input 1 :
4
10 12 20 9
34 8 50 18
9
Output 1 :
Cost of Optimal BST after deleting the key is 142
Input 2 :
5
10 20 30 40 50
4 2 6 3 1
60
Output 2 :
Key not found in the OBST.

You are tasked with implementing a program that finds whether a given key exists in an Optimal Binary Search Tree (OBST) using Dynamic programming. An OBST is a binary search tree that is constructed to minimize the average search time for a set of keys with given frequencies.

Input format :
The first consists of an integer n, representing the number of keys and frequencies in the OBST.

The next n lines contain two integers, key [i] and freq [i]. These represent the keys and their corresponding frequencies, separated by a space.

The last line consists of the integer m, representing the key to search in the OBST.

Output format :
The output should consist of the following single line:

If the key is found in the OBST, print "Key <m> found in the OBST."

If the key is not found in the OBST, print "Key <m> not found in the OBST."

Refer to the sample output for the exact format.

Code constraints :
1 ≤ n ≤ 10

1 ≤ key[i] ≤ 100

1 ≤ freq[i] ≤ 100

1 ≤ m ≤ 100

Sample test cases :
Input 1 :
3
1 3
2 5
3 7
2
Output 1 :
Key 2 found in the OBST.
Input 2 :
2
1 4
2 5
3
Output 2 :
Key 3 not found in the OBST.

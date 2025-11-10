Problem Statement

For a given array with N elements, you need to find the length of the longest subsequence from the array such that all the elements of the subsequence are sorted in strictly increasing order using dynamic programming.

A strictly increasing sequence is when each term in the sequence is larger than the preceding term.

Example: [1,2,3,4] is a strictly increasing array, while [2,1,4,3] is not.

Input format :
The first line of the input contains an integer 'N', representing the size of the array.

The second line of the input contains 'N' space-separated integers, representing the elements of the array.

Output format :
The output prints "Length of the longest increasing subsequence: " followed by the length of the longest increasing subsequence.

Refer to the sample output for the formatting specifications.

Code constraints :
1 ≤ N ≤ 337

1 ≤ Elements ≤ 105

Sample test cases :
Input 1 :
6
5 4 11 1 16 8
Output 1 :
Length of the longest increasing subsequence: 3
Input 2 :
3
1 2 2
Output 2 :
Length of the longest increasing subsequence: 2
N

Problem Statement

You are an art curator at a prestigious museum known for its unique and diverse art collection. Each piece of artwork in the museum is associated with a positive integer representing its artistic value. As the curator, you want to create an exhibition that showcases the finest selection of artwork in a way that emphasizes its increasing artistic value.

Given the artistic values of N artworks for multiple test cases, your task is to determine the length of the longest increasing sequence that can be formed for each exhibition. In other words, you need to find the maximum number of artworks you can display in a way that highlights their increasing artistic value.

Design an efficient algorithm to solve this problem and determine the length of the longest increasing sequence of artworks for each exhibition.

Note: Artworks cannot be rearranged once they are chosen, and the order of display matters.

Input format :
The first line consists of an integer T representing the number of test cases.

For each test case:

The first line contains an integer N, the number of artworks.

The second line contains N space-separated positive integers, representing the artistic values of the artworks.

Output format :
For each test case, the output prints the length of the longest increasing sequence of artworks that can be formed for the exhibition in each line.

Code constraints :
1 ≤ T ≤ 100

1 ≤ N ≤ 105

Sample test cases :
Input 1 :
2
7
5 3 8 10 2 6 12
4
1 2 3 4
Output 1 :
4
4

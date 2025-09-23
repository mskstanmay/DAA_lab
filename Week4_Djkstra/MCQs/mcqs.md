*1. Which of the following is not a step in Dijkstra's algorithm?*
👉 *Remove the chosen vertex from the graph*

---

*2. Which data structure modification can help improve Dijkstra's algorithm performance on dense graphs?*
👉 *Using a Fibonacci heap instead of a binary heap*

---

*3. How does Dijkstra's algorithm handle cycles in a graph?*
👉 *Works correctly if edge weights are non-negative*

---

*4. Which of the following is a common way to implement the priority queue in Dijkstra's algorithm for better efficiency?*
👉 *Using a binary heap*

---

*5. What is the initial tentative distance assigned to the source vertex in Dijkstra's algorithm?*
👉 *Zero*

---

*6. After the execution of Dijkstra's algorithm, what information do we get for each vertex?*
👉 *The shortest distance from the source vertex and the path taken*

---

*7. What does Dijkstra's algorithm use to make its decisions at each step of the process?*
👉 *Greedy approach*

---

*8. In Dijkstra's algorithm, what is the name of the data structure used to keep track of the shortest path to each vertex?*
👉 *Priority Queue*

---

*9. Which of these graph representations is most suitable for implementing Dijkstra's algorithm efficiently?*
👉 *Adjacency list*
(especially with a priority queue, gives O(E log V))

---

*10. Which of the following algorithms can be used to handle graphs with negative edge weights where Dijkstra's algorithm fails?*
👉 *Bellman-Ford algorithm*

---

*11. If a graph contains negative weight edges, what will happen when running Dijkstra's algorithm?*
👉 *It may fail to compute correct shortest paths*

---

*12. What is the role of the "visited" or "finalized" set in Dijkstra's algorithm?*
👉 *To keep track of nodes whose shortest distance is finalized*

---

*13. In Dijkstra's algorithm, what happens when a shorter path to a neighboring vertex is found?*
👉 *The tentative distance of the neighbor vertex is updated*

---

*14. In Dijkstra's algorithm, what type of edge weights are allowed?*
👉 *Positive and zero edge weights*
(negative not allowed)

---

*15. What is the time complexity of Dijkstra's algorithm for finding the shortest path in a graph with V vertices and E edges?*
👉 *O(E log V)* (using min-priority queue with binary heap + adjacency list)

---

✅ So the final answers are:
1–Remove the chosen vertex from the graph
2–Fibonacci heap
3–Works correctly if edge weights are non-negative
4–Binary heap
5–Zero
6–Shortest distance + path taken
7–Greedy approach
8–Priority Queue
9–Adjacency list
10–Bellman-Ford
11–May fail to compute correct shortest paths
12–To keep track of finalized nodes
13–Tentative distance updated
14–Positive and zero weights
15–O(E log V)

---
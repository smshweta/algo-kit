/* In depth-first search (DFS) we start from a particular vertex and explore as far as possible along each branch 
   before retracing back (backtracking).
   Graphs can contain cycle hence we keep track of visited vertices.
   
   Application: 
   topological sorting of graphs
   finding connected components
   Used to detect cycles in a graph

   
   Time Complexity: O(V + E) V-> number of vertices, E-> number of edges
   Space Complexity: O(V)
   */

import java.util.*;

public class DfsGraph {

    public void dfs(int startNode, Map<Integer, List<Integer>> adjList) {
        Set<Integer> visited = new HashSet<>();
        dfsUntil(startNode, adjList, visited);
    }

    private void dfsUntil(int currentNode, Map<Integer, List<Integer>> adjList, Set<Integer> visited) {
        System.out.print(currentNode + " ");
        visited.add(currentNode);

        for (int neighbor : adjList.getOrDefault(currentNode, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsUntil(neighbor, adjList, visited);
            }
        }
    }

    public static void main(String[] args) {
        DfsGraph graph = new DfsGraph();

        // Example graph represented as an adjacency list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        adjList.put(0, Arrays.asList(1, 2));
        adjList.put(1, Arrays.asList(3, 4));
        adjList.put(2, Collections.singletonList(5));

        int startNode = 0;
        System.out.println("DFS Traversal starting from node " + startNode + ":");
        graph.dfs(startNode, adjList);
    }
}







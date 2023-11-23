/* In breadth-first search (BFS), we start at a particular vertex and explore all of its neighbours at the 
   present depth before moving on to the vertices in the next level.
   Graphs can contain cycle hence we keep track of visited vertices.
   
   Application: Used to determine the shortest paths and minimum spanning trees.
   
   Time Complexity: O(V + E) V-> number of vertices, E-> number of edges
   Space Complexity: O(V)
   */



import java.util.*;

public class BfsGraph {

    public void bfs(int startNode, Map<Integer, List<Integer>> adjList) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.print(currentNode + " ");

            for (int neighbor : adjList.getOrDefault(currentNode, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        BfsGraph graph = new BfsGraph();

        // Example graph represented as an adjacency list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        adjList.put(0, Arrays.asList(1, 2));
        adjList.put(1, Arrays.asList(3, 4));
        adjList.put(2, Collections.singletonList(5));

        int startNode = 0;
        System.out.println("BFS Traversal starting from node " + startNode + ":");
        graph.bfs(startNode, adjList);
    }
}

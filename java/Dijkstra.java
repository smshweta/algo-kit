/*  Dijkstra's Algorithm
    - Single Source Shortest Path Algorithm
    - Works for both directed and undirected graphs
    - Doesn't work for graphs with negative weight edges
    - Time Complexity: O(E log V)
    - Space Complexity: O(V)
*/  



import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra{

    public static void dijkstra(int[][] graph, int source) {
        int vertices = graph.length;
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.distance, b.distance));
        minHeap.add(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node current = minHeap.poll();
            int u = current.vertex;

            for (int v = 0; v < vertices; v++) {
                if (graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE && distance[u] + graph[u][v] < distance[v]) {
                    distance[v] = distance[u] + graph[u][v];
                    minHeap.add(new Node(v, distance[v]));
                }
            }
        }

        // Print the shortest distances
        System.out.println("Shortest Distances from Source Node:");
        for (int i = 0; i < vertices; i++) {
            System.out.println("To Node " + i + ": " + distance[i]);
        }
    }

    public static class Node {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        int source = 0;
        dijkstra(graph, source);
    }
}


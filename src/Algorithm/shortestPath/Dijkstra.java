package Algorithm.shortestPath;

import java.util.*;

public class Dijkstra {
    static class Edge implements Comparable<Edge> {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(weight, o.weight);
        }
    }

    public static Map<Integer, List<Edge>> buildAdjacencyList(int[][] graph) {
        Map<Integer, List<Edge>> adjacencyList = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            List<Edge> edges = new ArrayList<>();
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] > 0) {
                    edges.add(new Edge(j, graph[i][j]));
                }
            }
            adjacencyList.put(i, edges);
        }
        return adjacencyList;
    }

    public static void dijkstra(Map<Integer, List<Edge>> adjacencyList, int source) {
        int numVertices = adjacencyList.size();
        int[] distances = new int[numVertices];
        int[] path = new int[numVertices];
        boolean[] visited = new boolean[numVertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(source, 0));
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentId = current.to;
            if (visited[currentId]) {
                continue;
            }
            visited[currentId] = true;
            List<Edge> edges = adjacencyList.get(currentId);
            if (edges != null) {
                for (Edge edge : edges) {
                    int dest = edge.to;
                    int weight = edge.weight;
                    if (distances[currentId] + weight < distances[dest]) {
                        distances[dest] = distances[currentId] + weight;
                        path[dest]=currentId;
                        pq.add(new Edge(dest, distances[dest]));
                    }
                }
            }
        }
        System.out.println(Arrays.toString(distances));
        System.out.println(Arrays.toString(path));
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 2, 3, 0, 0},
                {2, 0, 1, 4, 0},
                {3, 1, 0, 2, 0},
                {0, 4, 2, 0, 5},
                {0, 0, 0, 5, 0}};
        Map<Integer, List<Edge>> adjacencyList = buildAdjacencyList(graph);
         dijkstra(adjacencyList, 0);
    }

}

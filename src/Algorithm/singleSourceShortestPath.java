package Algorithm;

import java.util.*;
public class singleSourceShortestPath {
    public void bfs(List<List<Integer>> graph, int start) {

        int[] distance = new int[graph.size()];
        int[] path = new int[graph.size()];
        Arrays.fill(distance, -1);
        Queue<Integer> queue = new LinkedList<>();
        distance[start] = 0;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int V = queue.poll();
            for (int W : graph.get(V)) {
                if (distance[W]==-1) {
                    distance[W] = distance[V] + 1;
                    path[W] = V;
                    queue.offer(W);
                }
            }
        }
        // print out shortest distance to each node
        for (int i = 0; i < distance.length; i++) {
            System.out.println("Shortest distance from node " + start + " to node " + i + " is " + distance[i]);
        }
        System.out.println(Arrays.toString(path));
    }

    public static void main(String[] args) {
        // sample graph represented by adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(Arrays.asList(1, 3));
        graph.add(Arrays.asList(0, 2, 3));
        graph.add(Arrays.asList(1, 4));
        graph.add(Arrays.asList(0, 1, 4));
        graph.add(Arrays.asList(2, 3));
        singleSourceShortestPath sp = new singleSourceShortestPath();
        sp.bfs(graph, 0);
    }

}

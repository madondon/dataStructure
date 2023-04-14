package Algorithm.MST;

import java.util.*;

class Kruskal {
    static class Edge implements Comparable<Edge> {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(weight, o.weight);
        }
    }

    public static void kruskal(int[][] matrix, int n) {
        ArrayList<Edge> result = new ArrayList<Edge>();
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        PriorityQueue<Edge> qp = new PriorityQueue<Edge>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (matrix[i][j] != 0) {
                    qp.offer(new Edge(i,j,matrix[i][j]));
                }
            }
        }
        while(!qp.isEmpty()&&result.size()<n-1)
        {
            Edge current=qp.poll();
            int x = find(parent, current.start);
            int y = find(parent, current.end);
            if (x != y) {
                result.add(current);
                union(parent, x, y);
            }
        }
        for (Edge edge : result) {
            System.out.println(edge.start + " - " + edge.end + ": " + edge.weight);
        }
    }
    public static int find(int[] parent, int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }
    public static void union(int[] parent, int x, int y) {
        int setX = find(parent, x);
        int setY = find(parent, y);
        parent[setX] = setY;
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 6, 1, 5, 0, 0},
                {6, 0, 5, 0, 3, 0},
                {1, 5, 0, 5, 6, 4},
                {5, 0, 5, 0, 0, 2},
                {0, 3, 6, 0, 0, 6},
                {0, 0, 4, 2, 6, 0}
        };
        kruskal(matrix, 6);
    }

}

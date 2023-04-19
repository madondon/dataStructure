package Algorithm.Sort;

import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
    public static void main(String[] args) {
        int[][] graph = {{}, {2, 3}, {4}, {4, 5}, {5}, {}};
        int[] indegree = {0, 0, 1, 1, 2, 2};
        topologicalSort(graph, indegree);

    }

    public static void topologicalSort(int[][] graph, int[] indegree) {
        LinkedList<Integer> result = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        //入度为0的节点入队
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            //将该节点的所有出边删除，并将连接的节点入度减1
            for (int next : graph[node]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        if(result.size() != indegree.length)
            System.out.println("图中有回路");
        else {
            for (Object i : result) {
                System.out.print(i + " ");
            }
        }
    }
}

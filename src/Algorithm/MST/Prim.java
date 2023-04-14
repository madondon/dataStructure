package Algorithm.MST;

import java.util.*;

public class Prim {

        static int INF = 1000000000; // 用一个极大值表示正无穷
        static int n; // 节点数
        static int[][] adj; // 邻接矩阵

        static class Edge implements Comparable<Edge> {
            int to, cost;

            Edge(int to, int cost) {
                this.to = to;
                this.cost = cost;
            }

            public int compareTo(Edge e) {
                return cost - e.cost;
            }
        }
        public static void main(String[] args) {
            // 初始化n和adj
            n = 5;
            adj = new int[][] {
                    {0, 2, 3, INF, INF},
                    {2, 0, 1, 4, INF},
                    {3, 1, 0, 2, INF},
                    {INF, 4, 2, 0, 5},
                    {INF, INF, INF, 5, 0}
            };
            prim(); // 输出最小生成树的权值和
        }

        static void prim() {
            int[] d = new int[n]; // d[i]表示节点i与当前生成树的距离
            boolean[] used = new boolean[n]; // used[i]表示节点i是否已经加入生成树
            int[] pre = new int[n]; // pre[i]存储每个节点在生成树中的父节点
            Arrays.fill(d, INF);
            Arrays.fill(pre, -1);
            d[0] = 0; // 从节点0开始构建生成树
            int res = 0;

            PriorityQueue<Edge> qp = new PriorityQueue<Edge>();
            qp.offer(new Edge(0, 0));

            while (!qp.isEmpty()) {
                Edge e = qp.poll();
                if (used[e.to]) {
                    continue;
                }
                used[e.to] = true;
                res += e.cost;
                for (int u = 0; u < n; u++) {
                    if (!used[u] && d[u]> adj[e.to][u]) {
                        d[u] = adj[e.to][u];
                        pre[u]=e.to;
                        qp.offer(new Edge(u, adj[e.to][u]));
                    }
                }
            }
        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.toString(pre));
    }
}

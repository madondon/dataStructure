package Structure.Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class adjListGraph {
        private final int V;
        private final LinkedList<Integer>[] adj;
        boolean visited[] ;
        public adjListGraph(int V) {
            this.V = V;
            adj = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new LinkedList<>();
            }
            visited= new boolean[V];
        }

        public void addEdge(int v, int w) {
            if(!adj[v].contains(w)||!adj[w].contains(v)){
                adj[v].add(w);
                adj[w].add(v);
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < V; i++) {
                sb.append(i).append(": ");
                for (int j = 0; j < adj[i].size(); j++) {
                    sb.append(adj[i].get(j)).append(" ");
                }
                sb.append("\n");
            }
            return sb.toString();
        }

        void DFS(int v) {
            visited[v] = true;
            System.out.print(v+" ");

            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n])
                    DFS(n);
            }
        }

//        void DFS(int v) {
//            boolean[] visited = new boolean[V];
//            Stack<Integer> stack = new Stack<>();
//            visited[v] = true;
//            stack.push(v);
//            while (!stack.isEmpty()) {
//                v = stack.peek();
//                System.out.print(v + " ");
//                stack.pop();
//                Iterator<Integer> i = adj[v].listIterator();
//                while (i.hasNext()) {
//                    int n = i.next();
//                    if (!visited[n]) {
//                        visited[n] = true;
//                        stack.push(n);
//                    }
//                }
//            }
//        }

    void BFS(int s) {
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }



    public static void main(String[] args) {
            adjListGraph g = new adjListGraph(5);
            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(1, 2);
            g.addEdge(2, 3);
            g.addEdge(4, 1);
            System.out.println(g);
            g.DFS(0);
            System.out.println();
            g.BFS(0);
        }
    }


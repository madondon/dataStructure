package Algorithm.ShortestPath;

public class Floyd {
    public static final int INF = Integer.MAX_VALUE;

    public static void floyd(int[][] graph) {
        int n = graph.length;
        int[][] dist = new int[n][n];
        int[][] path = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
                path[i][j] = -1;
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j] && i!=j && i!=k && k!=j) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j] = k;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF" + "\t");
                } else {
                    System.out.print(dist[i][j] + " \t");
                }
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (path[i][j] == INF) {
                    System.out.print("INF" + "\t");
                } else {
                    System.out.print(path[i][j] + " \t");
                }
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               printPath(i,j,path);
                System.out.println();
            }
        }
    }

    public static void printPath(int i,int j,int[][] path){
                if (path[i][j] == -1) {
                    System.out.print(i+"\t"+ j + "\t");
                } else {
                    int mid=path[i][j];
                    printPath(i,mid,path);
                    printPath(mid,j,path);
                }

    }
    public static void main(String[] args) {
        int[][] graph = {
                {0, 2, 6, 4},
                {INF, 0, 3, INF},
                {7, INF, 0, 1},
                {5, INF, 12, 0}
        };
        Floyd.floyd(graph);
    }

}

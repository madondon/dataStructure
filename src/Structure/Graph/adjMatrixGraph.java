package Structure.Graph;

class adjMatrixGraph {
    private boolean[][] adjMatrix;
    private int numVertices; //顶点数量

    public adjMatrixGraph(int numVertices) {
        this.numVertices = numVertices;
        this.adjMatrix = new boolean[numVertices][numVertices];
    }

    public void addEdge(int i, int j) {
        this.adjMatrix[i][j] = true;
        this.adjMatrix[j][i] = true;
    }

    public void removeEdge(int i, int j) {
        this.adjMatrix[i][j] = false;
        this.adjMatrix[j][i] = false;
    }

    public boolean hasEdge(int i, int j) {
        return this.adjMatrix[i][j];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.numVertices; i++) {
            sb.append(i).append(": ");
            for (int j = 0; j < this.numVertices; j++) {
                sb.append(this.adjMatrix[i][j] ? 1 : 0).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        adjMatrixGraph g = new adjMatrixGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        System.out.println(g);
    }

}
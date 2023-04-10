package Structure;

import sun.java2d.windows.GDIWindowSurfaceData;

public class Set {
        private int[] parent;
        private int[] data;
        private int size;
        public Set(int n) {
            parent = new int[n];
            data = new int[n];
            size=n;
        }
//        public int find(int value) {
//            int i;
//            for (i = 0; i < size&&data[i]!=value; i++);
//            if(i>=size) return -99;
//            for (;parent[i]>=0;i=parent[i]);
//            return i;
//        }
        public int find(int p) {
            if(parent[p]<0)
                return p;
            else
                return parent[p]=find(parent[p]);
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if(rootQ==-99||rootP==-99)
            {
                System.out.println("元素不存在");
                return;
            }
            if (rootP == rootQ) {
                return;
            }

            if (rootQ < rootP) {
                parent[rootQ] += parent[rootP];
                parent[rootP] = rootQ;

            } else {
                parent[rootP] += parent[rootQ];
                parent[rootQ] = rootP;

            }
        }

        public void display(){
            for (int i = 0; i < size; i++) {
                System.out.print(data[i]+" ");
                System.out.println(parent[i]);
            }
        }
    public static void main(String[] args) {
        int n = 10;
        Set set = new Set(n);
        set.parent= new int[]{-4, 0, -3, 0, 2, -3, 0, 2, 5, 5};
        set.data=new int[]{1,2,3,4,5,6,7,8,9,10};

        set.display();
        set.union(0, 2);
        set.display();

    }

}

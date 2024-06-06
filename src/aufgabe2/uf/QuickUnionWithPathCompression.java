package aufgabe2.uf;

public class QuickUnionWithPathCompression extends WeightedQuickUnion {

    public QuickUnionWithPathCompression(int n) {
        super(n);
    }

    @Override
    public int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]]; // path compression
            p = id[p];
        }
        return p;
//        int root = p;
//        while (root != id[root])
//            root = id[root];
//        while (p != root) {
//            int newp = id[p];
//            id[p] = root;
//            p = newp;
//        }
//        return root;
    }

}

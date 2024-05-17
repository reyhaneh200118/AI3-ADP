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
    }

}

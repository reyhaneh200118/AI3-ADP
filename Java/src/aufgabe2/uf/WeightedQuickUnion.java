package aufgabe2.uf;

public class WeightedQuickUnion extends QuickUnion {

    private int[] sz; // Verwaltet die Größe des Baumes für die Wurzel des Baumes
    public WeightedQuickUnion(int n){
        super(n);
        sz = new int[n];
        for (int i =0; i <n; i++) {
            sz[i]=1;
        }
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot){
            return;
        }
        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        count--;
    }

}

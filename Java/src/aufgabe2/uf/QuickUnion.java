package aufgabe2.uf;

public class QuickUnion extends UFBase {

    public QuickUnion(int n) {
       super(n);
    }

    @Override
    // Sucht die Komponente von p.
    // Verfolgt dazu die Referenzen in id[] bis zur Wurzel des Baumes.
    // Die Komponente ist die Wurzel des Baumes, von dem p ein Knoten ist.
    // Die Wurzel eines Baumes zeigt auf sich selbst.
    public int find(int p) {
        //int node = p;
        while (p !=id[p]) {
            p = id[p];
        }
        return p;
    }

    @Override
    // Verbindet zwei Komponenten, indem die Wurzel des Baumes von q zur Wurzel des Baumes von p wird.
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot != qRoot) { id[pRoot] = qRoot; count--;}
    }

}

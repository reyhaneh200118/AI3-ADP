package aufgabe2.uf;

public class UnionFindFactory {

    public static UF getInstance(int type, int n) {
        switch (type) {
            case 1:
                return new QuickFind(n);
            case 2:
                return new QuickUnion(n);
            case 3:
                return new WeightedQuickUnion(n);
            case 4:
                return new QuickUnionWithPathCompression(n);
            default:
                throw new IllegalArgumentException("unbekannter UF Algorithmus");
        }
    }
}

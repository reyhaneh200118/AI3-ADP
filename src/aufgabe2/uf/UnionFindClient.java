package aufgabe2.uf;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UnionFindClient {

    public static void main(String[] args) {
        // Löst das Problem von der Verwaltung von Zusammenhangskomponeten auf StdIn
        // Daten in tinyUF.txt (11 Verbindungen 10 Knoten) mediumUF.txt (900 Verbindungen 625 Knoten)
        // largeUF.txt (2 Millionen Verbindungen zwischen 1 Millionen Knoten)
        int n = StdIn.readInt();
        UF uf = UnionFindFactory.getInstance(Integer.parseInt(args[0]),n);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
          // if (!uf.connected(p, q)) {
                uf.union(p, q);
               //System.out.println(p+ " " + q);
          // }
        }
        StdOut.println(uf.count() + " components");
    }
}

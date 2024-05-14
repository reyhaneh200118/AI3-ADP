package aufgabe2.uf;

import edu.princeton.cs.algs4.*;

public class UFTest {

    private static double timeTrial(int n, QuickUnionUF uf) {
        int[] a = new int[n];
        Stopwatch timer = new Stopwatch();
        for (int i = 0; i < n; i++) {
            int p = StdRandom.uniformInt(n);
            int q = StdRandom.uniformInt(n);
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
        }
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        for (int n = 250; true; n += n) {
            QuickUnionUF quickUnion = new QuickUnionUF(n);
            PathCompressionUF quickUnionPC = new PathCompressionUF(n);
            double time1 = timeTrial(n, quickUnion);
            double time2 = timeTrial(n, quickUnionPC);
            StdOut.printf("Quick-Union size %7d: %7.1f\n", n, time1);
            StdOut.printf("Quick-Union PC size %7d: %7.1f\n", n, time2);
            StdOut.println();
        }
    }
}
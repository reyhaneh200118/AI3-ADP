package aufgabe2.uf;

import edu.princeton.cs.algs4.*;

import java.io.IOException;

public class UFDoublingRatio {

    public static void main(String[] args) throws IOException {
        int type = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);
        int trials = Integer.parseInt(args[2]);
        int[] edges = new int[trials];
        double[] times = new double[trials];
        count(type, N, 0, edges, times);
        for (int t = 1; t < trials; t++) {
            N += N;
            count(type, N, t, edges, times);
            StdOut.printf("N=%d edges=%d time=%1.3f time ratio=%1.3f\n", N, edges[t], times[t], times[t] / times[t - 1]);
        }
    }

    private static void count(int type, int N, int t, int[] edges, double[] times) {
        UF uf = UnionFindFactory.getInstance(type, N);
        String filename = UFDoublingRatioDataGenerator.filename(N);
        In data = new In(filename);
        int[] pairs = data.readAllInts();
        int index = 0;
        Stopwatch timer = new Stopwatch();
        while (uf.count() > 1) {
            int p = pairs[index++];
            int q = pairs[index++];
            // Hier ist die Prüfung auf connected ausgelassen, um die
            // Testergebnisse nicht zu verfälschen
            // Die Testdaten enthalten nur Paare, die jeweils in unterschiedlichen Komponenten liegen
            uf.union(p, q);
                edges[t]++;
        }
        times[t] = timer.elapsedTime();
    }
}


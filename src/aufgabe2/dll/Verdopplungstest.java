package aufgabe2.dll;

import edu.princeton.cs.algs4.*;

import java.util.*;

public class Verdopplungstest {
    private static final int MAXIMUM_INTEGER = 1000000;

    public static void main(String[] args) {
        double prev = timeTrial(125);
        for (int n = 250; true; n += n) {
            double time = timeTrial(n);
            StdOut.printf("%7d %.9f %5.1f\n", n, time * 1e-9, time/prev);
            prev = time;
        }
    }


    public static double timeTrial(int n) {
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniformInt(-MAXIMUM_INTEGER,MAXIMUM_INTEGER);
        }
        LinkedList<Integer> intList = new LinkedList<>(Arrays.asList(a));
        Iterator<Integer> it = intList.iterator();
//        Stopwatch timer = new Stopwatch();
        long start = System.nanoTime();
        while (it.hasNext()) it.next();
        return System.nanoTime() - start;
//        return timer.elapsedTime();
    }

}

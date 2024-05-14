package aufgabe2;

import edu.princeton.cs.algs4.*;

import java.util.*;

public class Verdopplungstest {
    private static final int MAXIMUM_INTEGER = 1000000;
    private static final Map<Integer,Double> dllResults = Map.of(1000,0.0, 2000,0.0, 4000,0.0, 8000,0.1, 16000,0.2, 32000,0.8, 64000,3.2, 128000,12.9, 256000,55.9);
    private static final Map<Integer,Double> llResults = Map.of(1000,0.0, 2000,0.0, 4000,0.0, 8000,0.0, 16000,0.0, 32000,0.0, 64000,0.0, 128000,0.0, 256000,0.0);

    public static void main(String[] args) {
        double prev = timeTrial(125);
        for (int n = 250; true; n += n) {
            double time = timeTrial(n);
            StdOut.printf("%7d %7.1f %5.1f\n", n, time, time/prev);
            prev = time;
        }

//        drawResults();
    }


    public static double timeTrial(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniformInt(-MAXIMUM_INTEGER,MAXIMUM_INTEGER);
        }
        Stopwatch testTimer = new Stopwatch();
        DoublyLinkedList<Integer> intList = new DoublyLinkedList<>(Arrays.stream(a).boxed().toList());
        StdOut.println("Erzeugung: " + testTimer.elapsedTime());
//        LinkedList<Integer> intList = new LinkedList<>(Arrays.stream(a).boxed().toList());
        ListIterator<Integer> it = intList.listIterator();
        Stopwatch timer = new Stopwatch();
        while (it.hasNext()) it.next();
        return timer.elapsedTime();
    }


//    private static void drawResults() {
//        int N = 100;
////        StdDraw.setCanvasSize(600, 600);
//        StdDraw.setXscale(-1, N);
//        StdDraw.setYscale(-1, N);
//        StdDraw.setPenRadius(0.005);
//
//        // Zeichne x- und y-Achsen
//        StdDraw.setPenColor(StdDraw.BLACK);
//        StdDraw.line(0, 0, N, 0); // x-Achse
//        StdDraw.line(0, 0, 0, N); // y-Achse
//
////        StdDraw.setXscale(0,Math.log(256000.0));
////        StdDraw.setYscale(0.0,Math.log(60.0));
//
//        for (Map.Entry<Integer, Double> entry : dllResults.entrySet()) {
//            double x = Math.log(entry.getKey());
//            double y = Math.log(entry.getValue()) == Double.NEGATIVE_INFINITY ? 0.0 : Math.log(entry.getValue());
////            StdDraw.setPenColor(StdDraw.BLUE);
//            StdDraw.point(x, y);
////            StdOut.printf("%7d %5.1f\n", entry.getKey(), entry.getValue());
//        }
//    }
}

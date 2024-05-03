package aufgabe1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class NumberGenerator {

    public static void main(String[] args) {
        //args: 10 0 10
        int N = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);

        for (int i = 0; i < N; i++) {
            if (Math.random() < 0.5) {
                int x = StdRandom.uniformInt((int) min, (int) max); //Achtung: Intervall ist [min, max), nicht [min, max] wie gefordert
                StdOut.print(x + " ");
            } else {
                double x = StdRandom.uniformDouble(min, max);
                StdOut.printf("%.2f ",x);
            }
        }
        StdOut.println();
    }

}
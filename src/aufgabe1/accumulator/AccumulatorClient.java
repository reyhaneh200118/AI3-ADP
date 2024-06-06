package aufgabe1.accumulator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class AccumulatorClient {
    public static void main(String[] args) {
        int type = Integer.parseInt(args[0]);
        Accumulator acc;
        if (type == 0) {
            acc = new SimpleAccumulator();
        } else {
            int trials = Integer.parseInt(args[1]);
            double max = Integer.parseInt(args[2]);
            acc = new VisualAccumulator(trials,max);
        }
        double val = 0;
        while (!StdIn.isEmpty()) {
           val = StdIn.readDouble();
            acc.addDataValue(val);
        }
        StdOut.println(val);
    }

}
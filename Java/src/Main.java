import aufgabe1.accumulator.Accumulator;
import aufgabe1.accumulator.VisualAccumulator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Main {
        public static void main(String[] args) {
            int T = Integer.parseInt(args[0]);
            Accumulator acc = new VisualAccumulator(T,1.0);
            for (int i =0; i < T; i++) {
                acc.addDataValue(StdRandom.uniformDouble());
            }
            StdOut.println(acc);
        }
    }
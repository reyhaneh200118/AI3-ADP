package aufgabe1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class NPlusEvenFilter {
    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            double num = StdIn.readDouble();
            if (isPositiveEven(num)) {
                StdOut.println(num);
            }
        }
    }

    private static boolean isPositiveEven(double num) {
        return num >= 0.0 && num % 2 == 0;
    }
}

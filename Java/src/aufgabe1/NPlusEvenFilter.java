package aufgabe1;


import edu.princeton.cs.algs4.*;

public class NPlusEvenFilter {
    public static void main(String[] args) {
        while (StdIn.hasNextLine()) {
            double[] inputIntegers = StdIn.readAllDoubles();
            for (double i : inputIntegers)
            if ( i % 2 == 0) {
               StdOut.println(i);
            }
        }

    }

}

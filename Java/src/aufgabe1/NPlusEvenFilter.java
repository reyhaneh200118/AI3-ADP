package aufgabe1;


import edu.princeton.cs.algs4.*;

public class NPlusEvenFilter {
    public static void main(String[] args) {
        while (StdIn.hasNextLine()) {
            int[] inputIntegers = StdIn.readAllInts();
            for (int i : inputIntegers)
            if ( i % 2 == 0) {
               StdOut.print(i);
            }
        }

    }

}

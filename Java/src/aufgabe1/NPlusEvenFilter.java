package aufgabe1;


import edu.princeton.cs.algs4.*;

public class NPlusEvenFilter {
    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            double inputDouble = StdIn.readDouble();
            if ( inputDouble % 2 == 0 && inputDouble >= 0) {
               StdOut.println(inputDouble);
            }
        }

    }

}

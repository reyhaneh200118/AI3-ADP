package aufgabe1;

import com.sun.tools.javac.Main;
import edu.princeton.cs.algs4.StdOut;

import java.util.Random;

public class NumberGenerator {
    public static void main(String[] args) {
        Random rand = new Random();
        int n = Integer.parseInt(args[0]);
        int min = Integer.parseInt(args[1]);
        int max = Integer.parseInt(args[2]);

        if (min >= max || n < 0 || ((long) max - min >= Integer.MAX_VALUE)) throw new IllegalArgumentException();

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                int intNum = rand.nextInt((max - min) + 1) + min;
                StdOut.println(intNum);
            } else {
                double doubleNum = rand.nextDouble() * (max - min) + min;
                StdOut.println(doubleNum);
            }
        }
    }
}
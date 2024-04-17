package aufgabe1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Random;

public class NumberGenerator {
    private Random rand;

    public NumberGenerator(Random rand) {
        this.rand = rand;
    }

    public void generateNumber(int n, int min, int max) {
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

    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator(new Random());
        numberGenerator.generateNumber(10,0,100);
    }

}
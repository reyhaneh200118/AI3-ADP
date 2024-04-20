package aufgabe1.accumulator;


import aufgabe1.accumulator.Accumulator;

public class SimpleAccumulator implements Accumulator {
    private int N=0;
    private double total=0.0;
    @Override
    public void addDataValue(double d) {
        N++;
        total+=d;
    }
    @Override
    public double mean() {
        return total/N;
    }
    @Override
    public String toString() {
        return String.format("Mean (%d values): %7.5f", N,mean());
    }
}
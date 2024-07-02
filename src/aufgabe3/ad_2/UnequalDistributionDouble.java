package Aufgabe4;

import java.util.HashMap;
import java.util.Map;

public class UnequalDistributionDouble {

    private double value;

    public UnequalDistributionDouble(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnequalDistributionDouble that = (UnequalDistributionDouble) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return (int) value;
    }

    public static void main(String[] args) {

        int numKeys = 1000000; // Anzahl der Schlüssel für den Test

        // HashMap mit UnequalDistributionDouble
        Map<UnequalDistributionDouble, String> customHashMap = new HashMap<>();
        long startTimeCustom = System.currentTimeMillis();
        for (int i = 0; i < numKeys; i++) {
            double value = Math.random() * 1000; // Beispiel: Zufällige double-Werte zwischen 0 und 1000
            UnequalDistributionDouble key = new UnequalDistributionDouble(value);
            customHashMap.put(key, "Value-" + i);
        }
        long endTimeCustom = System.currentTimeMillis();
        System.out.println("Custom hashCode() - Time taken: " + (endTimeCustom - startTimeCustom) + " ms");

        // HashMap mit Double (Standardimplementierung)
        Map<Double, String> standardHashMap = new HashMap<>();
        long startTimeStandard = System.currentTimeMillis();
        for (int i = 0; i < numKeys; i++) {
            double value = Math.random() * 1000;
            standardHashMap.put(value, "Value-" + i);
        }
        long endTimeStandard = System.currentTimeMillis();
        System.out.println("Standard hashCode() for Double - Time taken: " + (endTimeStandard - startTimeStandard) + " ms");

        // Ausgabe der Ergebnisse
        System.out.println("Custom hashCode() - Size: " + customHashMap.size());
        System.out.println("Standard hashCode() for Double - Size: " + standardHashMap.size());
    }
    }


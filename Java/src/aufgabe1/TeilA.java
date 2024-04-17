package aufgabe1;


public class TeilA {

    public static int[] localMax(int[] ary,int radius) {
        return findLocalMax(ary,0,ary.length-1,radius);
    }

    private static int[] findLocalMax(int[] ary, int lo, int hi, int radius) {
        if (lo > hi) return null;

        int mid = lo + (hi + lo) / 2;
        boolean isLocalMax = true;
        for (int j = mid-radius; j < mid+radius; j++) {
            if (j < mid && ary[j] >= ary[j+1]) {
                isLocalMax = false;
                break;
            }
            if (j > mid && ary[j] <= ary[j+1]) {
                isLocalMax = false;
                break;
            }
        }
        if (isLocalMax) {
            return new int[] {Math.max(lo, mid - radius), Math.min(hi, mid + radius)};
        } else if (ary[mid - 1] > ary[mid]) {
            return findLocalMax(ary, radius, lo, mid - 1); // Linke Hälfte
        } else {
            return findLocalMax(ary, radius, mid + 1, hi); // Rechte Hälfte
        }
    }
    public static void main(String[] args) {
        int[] ary1 = {1, 61, 89, 75, 16, 33, 89, 59, 28, 3, 3, 97, 61, 85, 47, 38, 78, 7, 6, 15};
        int[] result = localMax(ary1, 2);
        if (result != null) {
            System.out.println("Berechnet der Aufruf von localMax(ary,2): [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("Kein lokales Maximum gefunden.");
        }
    }
}

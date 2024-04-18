package aufgabe1;


import java.util.Arrays;

public class TeilA {

    public static int[] localMax(int[] ary,int radius) {
        return findLocalMax(ary,0,ary.length,radius);
    }

    private static int[]findLocalMax(int[] ary, int lo, int hi, int radius){
        if (lo >= hi || lo < 0 || hi > ary.length || radius < 0) return null;
        int mid = lo + (hi - lo) / 2;
        boolean isLocalMax = true;

        for (int i = 0; i < radius; i++) {
            if (mid-i-1 < 0 || mid+i+1 >= ary.length) return null;
            if (ary[mid-i] <= ary[mid-i-1] || ary[mid+i] <= ary[mid+i+1]) {
                isLocalMax = false;
                break;
            }
        }

        if (isLocalMax) {
            return Arrays.copyOfRange(ary,mid-radius,mid+radius+1);
        } else {
            lo = ary[mid-1] <= ary[mid+1] ? lo : mid;
            hi = lo + mid;
            return findLocalMax(ary, lo, hi, radius);
        }

    }

    public static void main(String[] args) {
        int[] ary1 = {1, 61, 89, 75, 16, 33, 89, 59, 28, 3, 3, 97, 61, 85, 47, 38, 78, 7, 6, 15};
        int[] ary2 = {1, 61, 16, 75, 89, 133, 89, 59, 28, 3, 3, 97, 61, 85, 47, 38, 78, 7, 6, 15};
        int[] ary3 = {99,1, 61, 89, 75, 16, 33, 89, 59, 28, 3, 3, 97, 61, 85, 47, 38, 78, 7, 6, 15};
        int[] result;

        //ary1
        result = localMax(ary1, 2);
        System.out.println(Arrays.toString(result));

        //ary2
        result = localMax(ary2, 3);
        System.out.println(Arrays.toString(result));

        //ary3
        result = localMax(ary3, 1);
        System.out.println(Arrays.toString(result));

    }
}

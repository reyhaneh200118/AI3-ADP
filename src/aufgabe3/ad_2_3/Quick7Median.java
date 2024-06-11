package aufgabe3.ad_2_3;

import java.util.Arrays;
import java.util.Comparator;

import static aufgabe3.ad_2.SortClassCommons.*;
import static aufgabe3.ad_2.SortClassCommons.show;

public class Quick7Median {

    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static  <T extends Comparable<? super T>> int findMedianIndexOf7(T[] array, int i, int j, int k, int l, int m, int n, int o) {
        Integer[] indices = {i, j, k, l, m, n, o};
        Arrays.sort(indices, new Comparator<Integer>() {
            @Override
            public int compare(Integer index1, Integer index2) {
                return array[index1].compareTo(array[index2]);
            }
        });
        return indices[3];
    }
    public static <T extends Comparable<? super T>>  void sort(T[] a) {
        StdRandom.shuffle(a);
        sort( a,0, a.length - 1);
        assert isSorted(a);
    }

    private static <T extends Comparable<? super T>> void sort(T[] a, int lo, int hi) {
        if (hi <= lo) return;
        int median = findMedianIndexOf7(a, lo,lo+1,lo+2, lo + (hi - lo) / 2,hi-2,hi-1, hi);
        swap(a,lo,median);
        int pivot = partition( a, lo, hi);
        sort(a, lo, pivot - 1);
        sort(a,pivot + 1, hi);
    }

    public static <T extends Comparable<? super T>> int partition(T[] a, int lo, int hi){
        int i=lo, j=hi+1;
        T pivot = a[lo];
        while( true ) {
            while(less(a[++i],pivot)) {
                if (i==hi) break;
            }
            while(less(pivot,a[--j])) {
                if (j==lo) break;
            }
            if (i >= j) break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }

    public static void main(String[] args) {
        String[] a = new In(args[0]).readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}

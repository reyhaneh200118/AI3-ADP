package aufgabe3;

import static aufgabe3.ad_2.SortClassCommons.*;

public class MergeBottomUpThreeSort {
    public static <T extends Comparable<? super T>> void sort(T[] a) {
        T[] aux = a.clone();
        int N = a.length;
        for (int sz = 1; sz < N; sz = 3* sz) {
            for (int lo = 0; lo < N - sz; lo += 3 * sz) {
                merge(a, aux, lo, lo + sz - 1, Math.min(lo + 2 * sz - 1, N - 1), Math.min(lo + 3 * sz - 1, N - 1));
            }
        }
    }

    static <T extends Comparable<? super T>> void merge(T[] a, T[] aux, int lo, int ta2, int ta3, int hi) {
        int left = lo;
        int middle = ta2 + 1;
        int right = ta3 + 1;
        if (hi + 1 - lo >= 0) System.arraycopy(a, lo, aux, lo, hi + 1 - lo);

        boolean leftExhausted;
        boolean middleExhausted;
        boolean rightExhausted;

        for (int l = lo; l <= hi; l++) {
            leftExhausted = left > ta2;
            middleExhausted = middle > ta3;
            rightExhausted = right > hi;
            if (leftExhausted) {
                if (middleExhausted) a[l] = aux[right++]; //links und mitte erschöpft
                else if (rightExhausted) a[l] = aux[middle++]; //links und rechts erschöpft
                else if (less(aux[right], aux[middle])) a[l] = aux[right++];
                else a[l] = aux[middle++];
            } else if (middleExhausted) {
                if (rightExhausted) a[l] = aux[left++]; //mitte und rechts erschöpft
                else if (less(aux[right], aux[left])) a[l] = aux[right++];
                else a[l] = aux[left++];
            } else if (rightExhausted) {
                if (less(aux[middle], aux[left])) a[l] = aux[middle++];
                else a[l] = aux[left++];
            } else {
                if (less(aux[middle], aux[left])) {
                    if (less(aux[right], aux[middle])) a[l] = aux[right++];
                    else a[l] = aux[middle++];
                } else {
                    if (less(aux[right], aux[left])) a[l] = aux[right++];
                    else a[l] = aux[left++];
                }
            }

        }
    }

    public static void main(String[] args) {
//        String[] a = "EEGMRACERT".split("");
        String[] a = "KLMOPJIHGFEDCBA".split("");
        show(a);
        sort(a);
        assert isSorted(a);
        show(a);
    }
}

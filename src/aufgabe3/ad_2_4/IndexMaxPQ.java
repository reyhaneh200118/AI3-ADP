package aufgabe3.ad_2_4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class IndexMaxPQ<Key extends Comparable<? super Key>> {

    private int N; // Anzahl der Elemente
    private int[] qp; // Position des Index in der Priority-Warteschlange
    private int[] pq; // Priority-Warteschlange der Indizes
    private Key[] keys; // Array mit Schlüsseln, die über den Index in pq gefunden werden

    public IndexMaxPQ(int maxN) {
        qp = new int[maxN + 1];
        pq = new int[maxN + 1];
        keys = (Key[]) new Comparable[maxN + 1];
        for (int i = 0; i <= maxN; i++) qp[i] = -1;
    }

    // Konvention, wenn ein Index nicht in der Warteschlange ist, dann liefert qp -1 zurück
    public boolean contains(int k) {
        return qp[k] != -1;
    }

    public void insert(int k, Key key) {
        N++; // neue Position
        qp[k] = N;
        pq[N] = k;
        keys[k] = key;  // speichert die Keys unter dem Index k
        swim(N);
    }

    public void change(int k, Key key) {
        keys[k] = key;
        swim(qp[k]);
        sink(qp[k]);
    }

    public Key minKey() {
        return keys[pq[1]];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void delete(int k) {
        int index = qp[k];
        exch(index, N--);
        swim(index);
        sink(index);
        qp[k] = -1;
        keys[k] = null;
    }

    public int delMax() {
        int maxIndex = pq[1];
        exch(1, N--);
        sink(1); // reorganisieren
        keys[maxIndex] = null; // lösche das größte Element
        qp[N + 1] = -1; // lösche den Index
        return maxIndex;
    }

    public int maxIndex() {
        return pq[1];
    }


    private void sink(int k) {
        while (2 * k <= N) {
            int i = 2*k;
            if (i < N && less(i,i+1)) i++;
            if (!less(k, i)) break;
            exch(i, k);
            k = i;
        }
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private boolean less(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
    }

    private void exch(int posI, int posJ) {
        int indexI = pq[posI];
        qp[indexI] = posJ;
        qp[pq[posJ]] = posI;
        pq[posI] = pq[posJ];
        pq[posJ] = indexI;
    }


    public Key get(int index){
        return keys[index];
    }

    public void draw(String title){
        if (isEmpty()) return;
        String[] keyHeap = new String[N+1];
        for (int i=1; i<= N;i++) {
            keyHeap[i] = String.format("%d:%s",pq[i],keys[pq[i]]);
        }
        StdOut.println(title);
        StdOut.println(Arrays.toString(keyHeap));
        StdOut.println(Arrays.toString(keys));
        StdOut.println(Arrays.toString(pq));
        StdOut.println();
    }

    public static void main(String[] args) {
        IndexMaxPQ<String> maxPQ = new IndexMaxPQ<>(9);
        maxPQ.insert(5,"A");
        maxPQ.insert(1, "E");
        maxPQ.insert(9, "I");
        maxPQ.insert(4, "H");
        maxPQ.insert(7,"P");
        maxPQ.insert(8,"R");
        maxPQ.insert(3, "M");
        maxPQ.draw("Without Reorg");
        maxPQ.insert(2,"D");
        maxPQ.draw("Inserted D");

        maxPQ.change(4,"B");
        maxPQ.draw("changed 4 -> B");
        maxPQ.change( 5,"X");
        maxPQ.draw("changed 5 -> X");
        maxPQ.delete(8);
        maxPQ.draw("Deleted 8");

        maxPQ.delete(4);
        maxPQ.draw("Deleted 4");


    }

}

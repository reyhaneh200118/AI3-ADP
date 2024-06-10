package aufgabe3;

import aufgabe3.ad_2_4.MaxPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BottomK {
    public static void main(String[] args) {
        int K = Integer.parseInt(args[0]);
        MaxPQ<String> pq = new MaxPQ<>(K+1);
        while (StdIn.hasNextLine()) {
            pq.insert(StdIn.readLine());
            if (pq.size() > K) pq.delMax();  // nur die K-größten Elemente sind in der PQ
        }
        Stack<String> stack = new Stack<>(); // Sortieren mit einem Stack
        while (!pq.isEmpty()) stack.push(pq.delMax());
        for (String s: stack) StdOut.println(s);
    }
}

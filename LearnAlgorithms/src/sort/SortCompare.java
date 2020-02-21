package sort;

import edu.princeton.cs.algs4.*;

/**
 * @author jianglei
 * @date 2020/2/21 11:39
 * 比较算法性能
 */
public class SortCompare {
    private static final String INSERTION = "Insertion";
    private static final String SELECTION = "Selection";
    private static final String SHELL = "Shell";
    private static final String MERGE = "Merge";
    private static final String QUICK = "Quick";
    private static final String HEAP = "Heap";

    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (INSERTION.equals(alg)) {
            Insertion.sort(a);
        }
        if (SELECTION.equals(alg)) {
            Selection.sort(a);
        }
        if (SHELL.equals(alg)) {
            Shell.sort(a);
        }
        if (MERGE.equals(alg)) {
            Merge.sort(a);
        }
        if (QUICK.equals(alg)) {
            Quick.sort(a);
        }
        if (HEAP.equals(alg)) {
            Heap.sort(a);
        }
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N; j++) {
                a[j] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        StdOut.printf("For %d random Double\n   %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
    }
}

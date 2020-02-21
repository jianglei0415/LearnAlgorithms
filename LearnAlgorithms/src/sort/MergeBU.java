package sort;

import java.util.Arrays;

/**
 * @author jianglei
 * @date 2020/2/21 13:16
 * 归并排序（自底向上）
 */
public class MergeBU extends Example {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int i = 0; i < N - sz; i += sz + sz) {
                merge(a, i, i + sz - 1, Math.min(i + sz + sz - 1, N - 1));
            }
        }
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public static void main(String[] args) {
        String[] a = {"s", "o", "r", "t", "e", "x", "a", "m", "p", "l", "e"};
        System.out.println("排序前：" + Arrays.toString(a));
        sort(a);
        System.out.println("排序后：" + Arrays.toString(a));
    }
}

package sort;

import java.util.Arrays;

/**
 * @author jianglei
 * @date 2020/2/21 12:15
 * 归并排序（自顶向下）
 */
public class Merge extends Example {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
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

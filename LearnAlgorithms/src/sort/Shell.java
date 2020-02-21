package sort;

import java.util.Arrays;

/**
 * @author jianglei
 * @date 2020/2/21 11:56
 */
public class Shell extends Example {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exchange(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        String[] a = {"s", "o", "r", "t", "e", "x", "a", "m", "p", "l", "e"};
        System.out.println("排序前：" + Arrays.toString(a));
        sort(a);
        System.out.println("排序后：" + Arrays.toString(a));
    }
}

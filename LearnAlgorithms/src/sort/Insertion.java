package sort;

import java.util.Arrays;

/**
 * @author jianglei
 * @date 2020/2/21 11:35
 * 插入排序
 */
public class Insertion extends Example {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
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

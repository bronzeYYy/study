package cn.chen.java.sort;

import java.util.Arrays;
import java.util.Random;

public class Qsort implements Sort {
    /*
     * create by: chen
     * description: 快速排序
     * create time: 18:51 2019-08-10
     * @param a: 待排序的数组
     * @return void:
     */
    @Override
    public void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }
    private static void sort(int[] a, int start, int end) {
        if (end < start + 1) {
            return;
        }
        int j = start + 1;
        for (int k = start + 1; k <= end; k++) {
            if (a[k] < a[start]) {
                swap(a, j++, k);
            }
        }
        swap(a, start, --j);
        sort(a, start, j - 1);
        sort(a, j + 1, end);
    }
    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}

package cn.chen.java.sort;

import java.util.Arrays;

public class HeadSort implements Sort {
    public static void main(String[] args) {
        int[] a = new int[] {4,5,1,6,2,7,3,8};
        HeadSort headSort = new HeadSort();
        headSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
    @Override
    public void sort(int[] a) {
        headSort(a, a.length);
    }
    private void headSort(int[] a, int length) {
        if (length <= 1) {
            return;
        }
        // n / 2 - 1
        int l = length / 2 - 1;
        do {
            // 与左孩子进行交换
            if (a[l] < a[2 * l + 1]) {
                swap(a, l, 2 * l + 1);
            }
            // 与右孩子进行交换
            if (2 * l + 2 < length) {
                if (a[l] < a[2 * l + 2]) {
                    swap(a, l, 2 * l + 2);
                }
            }
        } while (l-- > 0);
        // 第一个元素为最大的，放到最后一位
        swap(a, 0, length - 1);
        // 对最大元素之前的所有元素重复执行
        headSort(a, length - 1);
    }
    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}

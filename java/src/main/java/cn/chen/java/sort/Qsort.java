package cn.chen.java.sort;

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
                // 比第一个（轴心点）小的往前交换
                swap(a, j++, k);
            }
        }
        swap(a, start, --j); // 将轴心点移动到最后一个比它小的数的后面
        sort(a, start, j - 1); // 轴心点之前的继续操作
        sort(a, j + 1, end); // 轴心点之后的继续操作
    }
    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}

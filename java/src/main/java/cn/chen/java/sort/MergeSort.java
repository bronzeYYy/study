package cn.chen.java.sort;

public class MergeSort implements Sort {

    @Override
    public void sort(int[] a) {
        int[] b = getSort(a, 0, a.length - 1);
        System.arraycopy(b, 0, a, 0, a.length);
    }
    /*
     * create by: chen
     * description: 获取排序后的结果
     * create time: 19:28 2019-08-10
     * @param a: 待排序的数组
     * @param start: 数组开始下标
     * @param end: 结束下标
     * @return int[]: 排序后的数组
     */
    private int[] getSort(int[] a, int start, int end) {
        if (end == start) {
            return new int[] {a[start]};
        }
        int[] l = getSort(a, start, (start + end) / 2);
        int[] r = getSort(a, (start + end) / 2 + 1, end);
        return merge(l, r);
    }
    /*
     * create by: chen
     * description: 对两个已排序的数组进行合并
     * a  b  c
     * 1  0  0
     * 3  2  1
     * 4  5  2
     *       3
     *       4
     *       5
     * create time: 19:29 2019-08-10
     * @param a: 数组1
     * @param b: 数组2
     * @return int[]: 合并后的数组
     */
    private int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        for (int i = 0, j = 0, k = 0; i < a.length || j < b.length;) {
            if (i >= a.length) {
                c[k++] = b[j++];
            } else if (j >= b.length) {
                c[k++] = a[i++];
            } else if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }
        return c;
    }
}

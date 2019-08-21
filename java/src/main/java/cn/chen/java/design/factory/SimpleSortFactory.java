package cn.chen.java.design.factory;

import cn.chen.java.sort.MergeSort;
import cn.chen.java.sort.Qsort;
import cn.chen.java.sort.Sort;

// 获取Sort的简单工厂类
public class SimpleSortFactory {
    public static Sort getSort(String type) {
        if (Sort.QSORT.equals(type)) {
            return new Qsort();
        }
        if (Sort.MERGE_SORT.equals(type)) {
            return new MergeSort();
        }
        return null;
    }
}

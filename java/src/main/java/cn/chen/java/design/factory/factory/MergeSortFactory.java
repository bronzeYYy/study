package cn.chen.java.design.factory.factory;

import cn.chen.java.sort.MergeSort;
import cn.chen.java.sort.Sort;

public class MergeSortFactory implements SortFactory {
    @Override
    public Sort create() {
        return new MergeSort();
    }
}

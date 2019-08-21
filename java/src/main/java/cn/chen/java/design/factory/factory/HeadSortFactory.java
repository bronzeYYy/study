package cn.chen.java.design.factory.factory;

import cn.chen.java.sort.HeadSort;
import cn.chen.java.sort.Sort;

public class HeadSortFactory implements SortFactory{
    @Override
    public Sort create() {
        return new HeadSort();
    }
}

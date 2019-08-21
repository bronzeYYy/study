package cn.chen.java.design.factory.factory;

import cn.chen.java.sort.Qsort;
import cn.chen.java.sort.Sort;

public class QSortFactory implements SortFactory {
    @Override
    public Sort create() {
        return new Qsort();
    }
}

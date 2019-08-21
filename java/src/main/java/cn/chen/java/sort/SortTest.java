package cn.chen.java.sort;

import cn.chen.java.design.factory.factory.HeadSortFactory;
import cn.chen.java.design.factory.factory.SortFactory;
import cn.chen.java.design.template.SortTestTemplate;

import java.util.Comparator;

public class SortTest {
    public static void main(String[] args) {
        /*SortTestTemplate sortTestTemplate = new SortTestTemplate() {
            @Override
            protected Sort getSort() {
                return SimpleSortFactory.getSort("qSort");
            }
        };
        sortTestTemplate.test(200);*/
        SortFactory sortFactory = new HeadSortFactory();
        SortTestTemplate sortTestTemplate = new SortTestTemplate() {
            @Override
            protected Sort getSort() {
                return sortFactory.create();
            }
        };
        sortTestTemplate.test(100);
    }
}

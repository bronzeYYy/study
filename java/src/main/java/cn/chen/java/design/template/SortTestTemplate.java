package cn.chen.java.design.template;

import cn.chen.java.sort.Sort;

import java.util.Arrays;
import java.util.Random;

// 排序方法测试的模板类
public abstract class SortTestTemplate {
    private Sort sort;

    // 这个方法由子类实现
    protected abstract Sort getSort();
    /*
     * create by: chen
     * description: 对子类getSort的方法获取的Sort进行测试
     * create time: 19:26 2019-08-10
     * @return void:
     */
    public void test(int nTest) {
        if (sort == null) {
            this.sort = getSort();
        }
        int n = 0;
        Random random = new Random();
        int[] a = new int[random.nextInt(1000)];
        for (int k = 0; k < nTest; k++) {
            for (int i = 0; i < a.length; i++) {
                a[i] = random.nextInt(10000);
            }
            int[] b = a.clone();
            sort.sort(a);
            Arrays.sort(b);
            String sa = Arrays.toString(a);
            String sb = Arrays.toString(b);
            if (sa.equals(sb)) {
                n++;
            }
        }
        System.out.println(nTest + "个测试，通过" + n + "个");
    }
}

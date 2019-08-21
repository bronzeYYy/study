import java.io.DataInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class  Test{
    static int[] a;
    static int n;
    static int x;
    static int index;
    static int min = Integer.MAX_VALUE;
    public static void dfs(int i, int sum) {

        for (int j = i + 1; j < n; j++) {
            int s = a[j] + sum;
            if (s >= x) {
                if (s < min) {
                    min = s;
                }
                index = j;
                if (j == i + 1) {
                    return;
                }
            } else {
                dfs(j, s);
            }
        }
    }
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        index = n;
        x = scanner.nextInt();
        a = new int[n];
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < index; i++) {
            dfs(i, 0);
        }
        System.out.println(min);*/

        /*DataInputStream dataInputStream = new DataInputStream(System.in);
        try {
            System.out.println(dataInputStream.readInt());
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        System.out.println(Test.test());
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
    public static int test() {
        int i = 1;
        try {
            System.exit(-1);
            return i;
        } finally {
            System.out.println("finally");
        }
    }
}
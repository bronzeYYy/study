package cn.chen.java.jvm;

public class MethodAreaTest {

    public static void main(String[] args) {
        System.out.println(getS1() == getS1()); // true
        System.out.println(getS1() == getS2()); // true
    }
    private static String getS1() {
        return "abc";
    }
    private static String getS2() {
        return "abc";
    }
}

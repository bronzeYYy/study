package cn.chen.java.design.observer;

public class MyObserverTest {
    public static void main(String[] args) {
        OfficialAccounts officialAccounts = new MyOfficialAccounts("西宁天气");
        User user = new MyUser("张三");
        User user1 = new MyUser("李四");
        user.subscribe(officialAccounts);
        user1.subscribe(officialAccounts);
        officialAccounts.postMsg("今天很冷");
    }
}

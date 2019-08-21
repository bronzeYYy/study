package cn.chen.java.design.observer;

public class MyUser implements User {
    private String name;
    MyUser(String name) {
        this.name = name;
    }
    @Override
    public void subscribe(OfficialAccounts officialAccounts) {
        officialAccounts.addUser(this);
    }

    @Override
    public void getMsg(String msg) {
        System.out.println(name + "收到了消息: " + msg);
    }

    @Override
    public String toString() {
        return name;
    }
}

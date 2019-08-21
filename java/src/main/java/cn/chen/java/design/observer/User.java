package cn.chen.java.design.observer;

public interface User {
    void subscribe(OfficialAccounts officialAccounts);
    void getMsg(String msg);
}

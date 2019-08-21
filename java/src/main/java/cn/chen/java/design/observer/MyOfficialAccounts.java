package cn.chen.java.design.observer;
import java.util.LinkedList;

public class MyOfficialAccounts implements OfficialAccounts {
    private String name;
    private LinkedList<User> users;
    MyOfficialAccounts(String name) {
        this.name = name;
        users = new LinkedList<>();
    }
    @Override
    public void addUser(User user) {
        System.out.println(user + "关注了" + name);
        users.add(user);
    }

    @Override
    public void postMsg(String msg) {
        users.forEach(user -> user.getMsg(msg));
    }

}

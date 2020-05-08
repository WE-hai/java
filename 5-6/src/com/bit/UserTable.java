package com.bit;

import java.util.ArrayList;
import java.util.List;

public class UserTable {
    private static List<User> userList;

    static {
        userList = new ArrayList<>();
        userList.add(new User(
                "peixinchen",
                "陈沛鑫",
                "111",
                500));
        userList.add(new User(
                "zhourong",
                "周荣",
                "222",
                5000));
        userList.add(new User(
                "xuxiaomin",
                "胥小敏",
                "333",
                50000));
    }

    public static User select(String username, String password) {
        for (User user : userList) {
            if (username.equals(user.username) && password.equals(user.password)) {
                return user;
            }
        }

        return null;
    }
}

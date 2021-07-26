package com.xdbin.edb;

import com.xdbin.edb.user.User;

/**
 * @author BaoXuebin
 * @since 2021/6/12
 */
public class Main {

    public static void main(String[] args) {
        User.insert(entity -> entity.id(1L).name("Leo"));
        User.insert(entity -> entity.id(2L).name("Bao"));

        System.out.println(User.id(1L));
        System.out.println(User.get(condition -> condition.name("Bao")));
        System.out.println(User.get(condition -> condition.name("1")));



//        User.condition().name("aaa").get();
//        User.contain().name("a").get();
//        User.condition().list();
//        User.condition().page(1, 10);
//        User.entity().insert();
//        User.id(1).update().name("Bao");
//        User.id(1).delete();
    }

}

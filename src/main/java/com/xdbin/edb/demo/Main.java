package com.xdbin.edb.demo;

/**
 * @author BaoXuebin
 * @since 2021/6/12
 */
public class Main {

    public static void main(String[] args) {
        User.insert(entity -> entity.id(1L).name("Leo"));
        User.insert(entity -> entity.id(2L).name("Bao"));

        System.out.println(User.list(null));
        System.out.println(User.list(query -> query.id(1L)));

        System.out.println(User.id(1L));
        System.out.println(User.get(query -> query.name("Bao")));
        System.out.println(User.get(query -> query.name("1")));

        System.out.println(User.id(1L).update(entity -> entity.name("Leo11")));
        System.out.println(User.id(1L));

        System.out.println(User.delete(query -> query.id(1L)));
        System.out.println(User.id(1L));
    }

}

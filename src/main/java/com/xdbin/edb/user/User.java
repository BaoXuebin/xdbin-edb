package com.xdbin.edb.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author BaoXuebin
 * @since 2021/6/12
 */
public class User {

    private static List<User> user = new ArrayList<User>();

    private Long userId;
    private String name;

    public static User id(Long userId) {
        Optional<User> result = user.stream().filter(u -> {
            return Objects.equals(userId, u.getUserId());
        }).findFirst();

        return result.orElse(null);
    }

    public static User get(Function<UserCondition, UserCondition> getCondition) {
        UserCondition userCondition = getCondition.apply(new UserCondition());

        for (User u : user) {
            if (match(u, userCondition)) {
                return u;
            }
        }

        return null;
    }

    public static User insert(Function<UserCondition, UserCondition> getCondition) {
        UserCondition userCondition = getCondition.apply(new UserCondition());

        User newUser = new User();
        newUser.setUserId(userCondition.getId());
        newUser.setName(userCondition.getName());
        user.add(newUser);

        return newUser;
    }

    private static boolean match(User u, UserCondition userCondition) {
        if (Objects.nonNull(userCondition.getId())) {
            return !Objects.equals(u.getUserId(), userCondition.getId());
        }
        if (Objects.nonNull(userCondition.getName())) {
            return !Objects.equals(u.getName(), userCondition.getName());
        }
        return true;
    }

    public Integer update(Function<UserCondition, UserCondition> getCondition) {
        UserCondition userCondition = getCondition.apply(new UserCondition());

        AtomicInteger count = new AtomicInteger(0);
        user.stream().filter(u -> match(this, userCondition)).forEach(u -> {
            if (Objects.nonNull(userCondition.getId())) {
                u.setUserId(userCondition.getId());
            }
            if (Objects.nonNull(userCondition.getName())) {
                u.setName(userCondition.getName());
            }
            count.getAndIncrement();
        });

        return count.get();
    }

    public Integer delete(Function<UserCondition, UserCondition> getCondition) {
        UserCondition userCondition = getCondition.apply(new UserCondition());

        AtomicInteger count = new AtomicInteger(0);
        user = user.stream().filter(u -> {
            if (match(u, userCondition)) {
                count.getAndIncrement();
                return false;
            }
            return true;
        }).collect(Collectors.toList());

        return count.get();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                '}';
    }
}

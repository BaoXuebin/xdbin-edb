package com.xdbin.edb.user;

/**
 * @author BaoXuebin
 * @since 2021/7/26
 */
public class UserCondition {

    private static UserCondition condition;

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserCondition id(Long id) {
        if (condition == null) {
            condition = new UserCondition();
        }
        condition.setId(id);
        return condition;
    }

    public UserCondition name(String name) {
        if (condition == null) {
            condition = new UserCondition();
        }
        condition.setName(name);
        return condition;
    }

    @Override
    public String toString() {
        return "UserCondition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

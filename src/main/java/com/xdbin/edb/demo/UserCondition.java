package com.xdbin.edb.demo;

/**
 * @author BaoXuebin
 * @since 2021/7/26
 */
public class UserCondition {

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
        this.setId(id);
        return this;
    }

    public UserCondition name(String name) {
        this.setName(name);
        return this;
    }

    @Override
    public String toString() {
        return "UserCondition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

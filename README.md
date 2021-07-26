# EDB

> 未实现

基于注解快速实现 Java 业务对象的增删改查，封装底层实现。

## 基本语法（设想）

**定义**
```java
@EDB
class User {
    @Id
    private Long userId;
    private String name;
    @Unique
    private String mobile;
}

```

**使用**
```java
public class Main {

    public static void main(String[] args) {
        User.insert(entity -> entity.id(1L).name("Leo"));
        User.insert(entity -> entity.id(2L).name("Bao"));

        System.out.println(User.id(1L));
        System.out.println(User.get(condition -> condition.name("Bao")));
        System.out.println(User.get(condition -> condition.name("1")));
    }

}
```
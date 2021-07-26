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
// 根据ID查询
User.id(1L);
// 条件查询
User.get(condition -> condition.id(1L).name("Leo"));
User.list(condition -> condition.id(1L).name("Leo"));
User.page(condition -> condition.id(1L).name("Leo", 1, 10));
// 新增
User.insert(entity -> entity.id(1L).name("Bao"));
```
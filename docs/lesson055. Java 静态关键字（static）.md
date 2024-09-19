# lesson055. Java 静态关键字（static）

在 Java 中，`static` 是一个关键字修饰符，可以应用于变量、方法，甚至类（对于修饰类的情况会在单独的视频中讲解）。**静态成员**是指被 `static` 所修饰的变量或方法，这些静态成员由类本身拥有，而不是类的实例。

#### 静态成员的特点

静态成员是由类本身拥有的，这意味着：

- 静态成员（变量或方法）只存在一份拷贝，无论创建多少个类的实例，它们都共享同一个静态成员。
- 静态成员可以在不创建类实例的情况下，通过类本身直接访问。

#### 静态变量示例

我们可以通过一个简单的例子来说明静态变量的用法：

```java
class Friend {
    // 静态变量
    static int numberOfFriends = 0;
    String name;

    // 构造方法
    Friend(String name) {
        this.name = name;
        numberOfFriends++; // 每创建一个新的 Friend 对象，静态变量自增1
    }
}
```

在这个例子中，`numberOfFriends` 是一个静态变量，表示所有 `Friend` **实例共享的一个变量**。

#### 访问静态变量

静态变量可以通过类名直接访问：

```java
System.out.println(Friend.numberOfFriends); // 输出当前朋友数量
```

也可以通过对象实例访问静态变量，但这种方式不推荐：

```java
Friend friend1 = new Friend("Baby Spongebob");
System.out.println(friend1.numberOfFriends); // 不推荐的方式
```

在这种情况下，虽然可以通过对象实例访问静态变量，但最好还是通过类名访问，因为静态变量是由类本身拥有的，而不是某个对象。

#### 非静态变量的区别

如果我们去掉静态关键字，这样每个 `Friend` 实例就会拥有一个**独立**的 `numberOfFriends` 变量，而不是共享的：

```java
class Friend {
    int numberOfFriends = 0; // 非静态变量
    String name;

    Friend(String name) {
        this.name = name;
        numberOfFriends++; // 每个实例都有独立的 numberOfFriends
    }
}
```

此时，每个 `Friend` 实例的 `numberOfFriends` 都是独立的，不能共享。

#### 静态方法

静态关键字不仅可以用于变量，还可以用于方法。静态方法同样是属于类的，而不是某个实例的。我们可以创建一个静态方法来返回当前的朋友数量：

```java
class Friend {
    static int numberOfFriends = 0;

    Friend(String name) {
        this.name = name;
        numberOfFriends++;
    }

    // 静态方法
    static void displayFriends() {
        System.out.println("You have " + numberOfFriends + " friends.");
    }
}
```

调用静态方法的正确方式是通过类名调用，而不是通过实例调用：

```java
Friend.displayFriends(); // 推荐的方式
```

同样，也可以通过对象实例调用静态方法，但不推荐：

```java
Friend friend1 = new Friend("Patrick");
friend1.displayFriends(); // 不推荐的方式
```

#### 静态方法的实际例子

`Math` 类中的 `round` 方法就是一个静态方法的例子：

```java
System.out.println(Math.round(4.7)); // 调用 Math 类的静态方法 round
```

在调用 `Math.round()` 时，我们不需要创建 `Math` 类的实例，**直接通过类名调用即可。这是静态方法的优势之一**。

#### 总结

静态关键字 `static` 提供了一种机制，使类的所有实例可以共享某个变量或方法，并且可以通过类名直接访问这些成员。无论是静态变量还是静态方法，它们都只有一份拷贝，且由类本身拥有。静态成员的访问应优先通过类名，以确保代码清晰和可维护性。

**要点总结：**

- 静态成员由类本身拥有，所有实例共享。
- 静态变量无需创建对象即可访问。
- 静态方法通常用于无需依赖实例数据的操作。

通过合理使用 `static`，可以更高效地管理类的共享资源，减少内存开销。
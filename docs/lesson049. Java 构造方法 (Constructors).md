# lesson049. Java 构造方法 (Constructors)

在 Java 中，**构造方法（Constructor）** 是一种特殊的方法，它在创建对象时被调用。构造方法的主要作用是初始化对象的属性。在本章节中，我们将深入探讨构造方法的概念及其使用场景。

------

#### 1. 什么是构造方法？

**构造方法（Constructor）** 是一种特殊的方法，它在创建对象时自动调用，用于初始化对象的属性。构造方法的名称必须与类名相同，且没有返回类型（甚至不能使用 `void` 关键字）。通过构造方法，我们可以在对象创建时为其赋予初始值。

##### 示例：默认构造方法

```java
public class Human {
    public Human() {
        System.out.println("一个 Human 对象被创建了！");
    }
}
```

在上面的例子中，`Human` 类定义了一个默认构造方法。当我们创建一个 `Human` 对象时，构造方法将被**自动调用**，输出一条消息。

```java
public class Main {
    public static void main(String[] args) {
        Human human = new Human();  // 调用构造方法
    }
}
```

##### 输出结果：

```plain
一个 Human 对象被创建了！
```

------

#### 2. 带参数的构造方法

构造方法不仅可以在对象创建时执行操作，还可以接收参数，从而在对象创建时为属性赋值。我们可以将参数传递给构造方法，并将这些参数的值赋给对象的属性。

##### 示例：带参数的构造方法

```java
public class Human {
    String name;
    int age;
    double weight;

    // 带参数的构造方法
    public Human(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
}
```

在上面的代码中，`Human` 类的构造方法接收三个参数，并将这些参数值赋给了对象的属性。`this` 关键字用于区分类的属性和构造方法的参数，同一个模版创建的不同对象应该有自己独有的属性值。

##### 创建对象并传递参数：

```java
public class Main {
    public static void main(String[] args) {
        // 创建一个 Human 对象，并传递参数
        Human human1 = new Human("Rick", 65, 70.5);
        Human human2 = new Human("Morty", 16, 50.0);

        // 输出对象的属性
        System.out.println(human1.name + " 的年龄是: " + human1.age + ", 体重是: " + human1.weight);
        System.out.println(human2.name + " 的年龄是: " + human2.age + ", 体重是: " + human2.weight);
    }
}
```

##### 输出结果：

```plain
Rick 的年龄是: 65, 体重是: 70.5
Morty 的年龄是: 16, 体重是: 50.0
```

------

#### 3. `this` 关键字的使用

在构造方法中，`this` 关键字用于引用当前对象的属性或方法。它可以帮助我们区分传递给构造方法的参数和类的属性。

##### 示例：使用 `this` 关键字

```java
public class Human {
    String name;
    int age;
    double weight;

    public Human(String name, int age, double weight) {
        // 使用 this 关键字来区分参数和属性
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
}
```

在上面的代码中，`this.name` 指的是当前对象的 `name` 属性，而 `name` 是构造方法的参数。通过 `this` 关键字，我们可以将参数值赋给当前正在构建的对象的属性。

------

#### 4. 构造方法的作用

构造方法的主要作用是初始化对象的属性，使我们能够在对象创建时为其赋予初始值。通过构造方法，我们可以创建具有不同属性的对象。

##### 示例：多个对象

```java
public class Main {
    public static void main(String[] args) {
        // 创建两个 Human 对象，具有不同的属性
        Human human1 = new Human("Rick", 65, 70.5);
        Human human2 = new Human("Morty", 16, 50.0);

        // 输出不同对象的属性
        System.out.println(human1.name + " 的年龄是: " + human1.age);
        System.out.println(human2.name + " 的年龄是: " + human2.age);
    }
}
```

##### 输出结果：

```plain
Rick 的年龄是: 65
Morty 的年龄是: 16
```

------

#### 5. 在类中定义方法

除了构造方法，类中还可以定义其他方法，用于执行对象的操作。在方法内部，我们可以通过 `this` 关键字访问对象的属性。

##### 示例：定义 `eat` 和 `drink` 方法

```java
public class Human {
    String name;
    int age;
    double weight;

    public Human(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    // 定义 eat 方法
    public void eat() {
        System.out.println(this.name + " 正在吃东西");
    }

    // 定义 drink 方法
    public void drink() {
        System.out.println(this.name + " 正在喝水");
    }
}
```

##### 调用方法：

```java
public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("Rick", 65, 70.5);
        Human human2 = new Human("Morty", 16, 50.0);

        // 调用 eat 和 drink 方法
        human1.eat();
        human2.drink();
    }
}
```

##### 输出结果：

```plain
Rick 正在吃东西
Morty 正在喝水
```

------

#### 6. 小结

**构造方法** 是 Java 中用于初始化对象的强大工具。通过构造方法，我们可以在创建对象时为其赋予初始值，使得对象的创建更加灵活和可定制。

##### 关键点回顾：

- 构造方法用于在创建对象时初始化对象的属性。
- 构造方法的名称必须与类名相同，且没有返回类型。
- 可以通过向构造方法传递参数来为对象的属性赋值。
- `this` 关键字用于引用当前对象的属性或方法。

------

### 练习：

1. 创建一个 `Animal` 类，包含 `name`、`type` 和 `age` 属性，并定义一个带参数的构造方法来初始化这些属性。
2. 修改 `Human` 类，添加一个 `speak` 方法，让对象能够输出一句话，例如：“我的名字是 Rick”。
3. 编写程序，创建一个 `Book` 类，并使用构造方法创建多个不同的书籍对象，包含 `title`、`author` 和 `pages` 属性。
# lesson051. Java 重载构造方法 (Overloaded Constructors)

在 Java 中，**构造方法（Constructor）** 是用来在创建对象时初始化对象的。**重载构造方法（Overloaded Constructors）** 是指在一个类中可以有多个构造方法，它们的名称相同，但参数不同。这使得我们可以根据不同的需求创建对象。在本章节中，我们将通过制作披萨的例子来学习如何使用重载构造方法。

------

#### 1. 什么是重载构造方法？

**重载构造方法** 是在同一个类中定义多个构造方法，尽管它们的名称相同，但参数（数量或类型）不同。这些构造方法可以根据传递的不同参数来创建不同的对象。

##### 构造方法的签名（Signature）

- 构造方法的 **签名** 由构造方法的名称和参数列表组成。
- 如果两个构造方法的名称相同，但参数列表不同（参数的数量或类型不同），则它们被认为是不同的构造方法，即重载构造方法。

------

#### 2. 示例：披萨类的重载构造方法

我们将创建一个 `Pizza` 类，并通过不同的构造方法来制作不同种类的披萨。

##### 基本构造方法

```java
public class Pizza {
    String bread;
    String sauce;
    String cheese;
    String topping;

    // 构造方法 1：带四个参数
    public Pizza(String bread, String sauce, String cheese, String topping) {
        this.bread = bread;
        this.sauce = sauce;
        this.cheese = cheese;
        this.topping = topping;
        System.out.println("你的披萨包含:");
        System.out.println(bread + ", " + sauce + ", " + cheese + ", " + topping);
    }
}
```

在上面的代码中，`Pizza` 类定义了一个带有四个参数的构造方法，用于创建包含四种原料的披萨。

##### 创建对象

```java
public class Main {
    public static void main(String[] args) {
        Pizza pizza1 = new Pizza("厚皮", "番茄酱", "马苏里拉", "意大利辣香肠");
    }
}
```

##### 输出结果：

```plain
你的披萨包含:
厚皮, 番茄酱, 马苏里拉, 意大利辣香肠
```

------

#### 3. 添加重载构造方法

假设我们想要制作不同种类的披萨，比如无配料的芝士披萨，或者只有面包和酱料的披萨。这时，我们可以通过重载构造方法来实现。

##### 重载构造方法 2：没有配料的披萨

```java
// 构造方法 2：只接收三个参数（没有配料）
public Pizza(String bread, String sauce, String cheese) {
    this.bread = bread;
    this.sauce = sauce;
    this.cheese = cheese;
    System.out.println("你的披萨包含:");
    System.out.println(bread + ", " + sauce + ", " + cheese);
}
```

这个构造方法的参数比第一个少了一个，不包含 `topping`（配料）。

##### 创建无配料的披萨

```java
public class Main {
    public static void main(String[] args) {
        Pizza pizza2 = new Pizza("薄皮", "白酱", "帕尔马干酪");
    }
}
```

##### 输出结果：

```plain
你的披萨包含:
薄皮, 白酱, 帕尔马干酪
```

------

#### 4. 进一步重载构造方法

我们可以继续添加更多重载构造方法来满足不同的需求。比如：

##### 重载构造方法 3：只有面包和酱料

```java
// 构造方法 3：只接收两个参数（没有奶酪和配料）
public Pizza(String bread, String sauce) {
    this.bread = bread;
    this.sauce = sauce;
    System.out.println("你的披萨包含:");
    System.out.println(bread + ", " + sauce);
}
```

##### 重载构造方法 4：只有面包

```java
// 构造方法 4：只接收一个参数（只有面包）
public Pizza(String bread) {
    this.bread = bread;
    System.out.println("你的披萨包含:");
    System.out.println(bread);
}
```

##### 无参数的构造方法

我们甚至可以添加一个不带参数的构造方法，表示空披萨。

```java
// 构造方法 5：无参数
public Pizza() {
    System.out.println("你的披萨是空的，没有任何配料。");
}
```

------

#### 5. 使用重载构造方法

我们可以根据不同的需求，使用不同的构造方法来创建披萨对象。

```java
public class Main {
    public static void main(String[] args) {
        Pizza pizza1 = new Pizza("厚皮", "番茄酱", "马苏里拉", "意大利辣香肠");
        Pizza pizza2 = new Pizza("薄皮", "白酱", "帕尔马干酪");
        Pizza pizza3 = new Pizza("厚皮", "番茄酱");
        Pizza pizza4 = new Pizza("薄皮");
        Pizza pizza5 = new Pizza();  // 空披萨
    }
}
```

##### 输出结果：

```plain
你的披萨包含:
厚皮, 番茄酱, 马苏里拉, 意大利辣香肠
你的披萨包含:
薄皮, 白酱, 帕尔马干酪
你的披萨包含:
厚皮, 番茄酱
你的披萨包含:
薄皮
你的披萨是空的，没有任何配料。
```

------

#### 6. 小结

**重载构造方法** 允许我们使用不同的参数组合来创建对象，从而使得类的构造更加灵活。通过为类定义多个构造方法，我们可以根据传递的不同参数来创建不同的对象。

##### 关键点回顾：

- 构造方法的名称必须与类名相同。
- 重载构造方法是指在一个类中定义多个构造方法，它们的名称相同，但参数不同。
- 可以根据不同的需求使用不同的构造方法来创建对象。

------

### 练习：

1. 创建一个 `Car` 类，定义多个重载构造方法来表示不同的车配置（比如带或不带空调、皮质座椅等）。
2. 修改 `Pizza` 类，添加更多的配料选项，并定义相应的重载构造方法。
3. 编写程序，创建一个 `Book` 类，使用重载构造方法表示不同的书籍信息（例如仅标题、标题加作者、标题加作者加页数等）。
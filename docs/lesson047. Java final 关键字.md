# lesson047. Java final 关键字

`final` 是 Java 中的一个关键字，用于声明不可修改的变量、方法或类。在本节中，我们将介绍 `final` 关键字的作用、使用场景及其常见的编程实践。

------

#### 1. 什么是 `final` 关键字？

`final` 关键字用于声明在程序运行期间不可更改的变量、方法或类。被 `final` 修饰的元素一旦初始化后就无法被修改。例如，声明为 `final` 的变量在赋值后不能再被重新赋值。

##### 常见用法：

- `final` **变量**：一旦初始化后不可更改。
- `final` **方法**：子类不能重写该方法。
- `final` **类**：不能被继承。

------

#### 2. `final` 变量

当一个变量被声明为 `final` 时，它的值在初始化后不能被改变。如果试图修改 `final` 变量的值，编译器将报错。

##### 示例：

```java
public class FinalExample {
    public static void main(String[] args) {
        final double PI = 3.14159;  // 声明一个 final 变量
        System.out.println("PI 的值是: " + PI);
        
        // 尝试更改 final 变量的值将会导致编译错误
        // PI = 4.0;  // 错误：无法为 final 变量赋值
    }
}
```

输出结果：

```plain
PI 的值是: 3.14159
```

在上面的例子中，`PI` 被声明为 `final`，因此在赋值后不能被修改。如果尝试重新赋值 `PI`，编译器将报错。

##### 常见编程实践：

当变量被声明为 `final` 时，通常会使用全大写字母来命名该变量，以表明它的不可变性。这是一种常见的编程习惯，但并不是强制要求。

```java
final int MAX_USERS = 100;  // 使用大写字母命名 final 变量
```

------

#### 3. `final` 方法

如果一个方法被声明为 `final`，那么子类不能重写这个方法。这在需要确保某些方法行为不能被更改的情况下非常有用。

##### 示例：

```java
class Parent {
    public final void showMessage() {
        System.out.println("这是父类中的消息。");
    }
}

class Child extends Parent {
    // 下面的代码将会导致编译错误，子类不能重写 final 方法
    // public void showMessage() {
    //     System.out.println("这是子类中的消息。");
    // }
}
```

在这个例子中，`Parent` 类中的 `showMessage` 方法被声明为 `final`，因此 `Child` 类不能重写该方法。如果子类尝试重写该方法，将会导致编译错误。

------

#### 4. `final` 类

当一个类被标记为 `final` 时，意味着这个类不能被继承。在某些情况下，出于安全性或设计的考虑，开发者可以通过将类声明为 `final` 来防止该类的行为被修改。

##### 示例：

```java
final class FinalClass {
    public void display() {
        System.out.println("这是一个 final 类。");
    }
}

// 下面的代码将会导致编译错误，无法继承 final 类
// class SubClass extends FinalClass {
// }
```

在这个例子中，`FinalClass` 被声明为 `final`，因此不能被任何其他类继承。如果尝试继承 `FinalClass`，编译器将报错。

------

#### 5. `final` 关键字的应用场景

`final` 关键字通常用于以下场景：

1. **常量定义**：使用 `final` 修饰的变量常用于定义常量，例如数学常量 `PI` 或系统的配置信息。

```java
final int MAX_CONNECTIONS = 10;
```

1. **防止方法重写**：在类的继承层次中，父类可以通过将方法声明为 `final` 来防止子类改变其实现。
2. **防止类被继承**：某些类（如 `String` 类）被设计为不能被继承，以确保其行为一致性和安全性。
3. **线程安全**：在多线程环境中，使用 `final` 变量可以确保变量在多个线程中不会被修改，从而避免并发问题。

------

#### 6. 小结

`final` 关键字是 Java 中用于增强程序安全性和可维护性的强大工具。通过使用 `final`，开发者可以确保某些变量、方法或类的行为不会在程序执行过程中被修改，从而提高代码的稳定性和可预见性。

##### 关键点回顾：

- `final` 变量在初始化后不能被修改。
- `final` 方法不能被子类重写。
- `final` 类不能被继承。
- 使用 `final` 关键字能够提升代码的安全性和可维护性。

------

### 练习：

1. 定义一个 `final` 变量，尝试在赋值后修改它，观察编译器的错误提示。
2. 创建一个包含 `final` 方法的类，并尝试在子类中重写该方法，理解 `final` 的作用。
3. 定义一个 `final` 类，并尝试继承它，观察编译结果。
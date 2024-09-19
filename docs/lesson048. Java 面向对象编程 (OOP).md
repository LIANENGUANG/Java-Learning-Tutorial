# lesson048. Java 面向对象编程 (OOP)

在本章节中，我们将深入探讨 Java 的 **面向对象编程**（Object-Oriented Programming, OOP）概念。面向对象编程是一种编程范式，它通过使用 **对象** 和 **类** 来设计程序结构。在 Java 中，万物皆对象，因此理解对象和类的概念是编写 Java 程序的基础。

------

#### 1. 什么是面向对象编程？

**面向对象编程（OOP）** 是一种通过对象来组织代码的编程方式。在 OOP 中，**对象** 代表现实世界中的实体，而 **类** 则是对象的蓝图。对象具有 **属性**（attributes）和 **方法**（methods）。

- **属性**：对象的特征或状态，通常表现为类中的变量。
- **方法**：对象可以执行的操作，通常表现为类中的函数。

##### 示例：现实世界中的对象

例如，看看你周围的物体，它们都可以被视为对象。假设你面前有一杯咖啡，那么这杯咖啡可以用以下方式表示：

- **属性**：

- 颜色：白色
- 温度：20 摄氏度（室温）
- 是否为空：是

- **方法**：

- **喝**（drink）：执行喝咖啡的动作。
- **洒**（spill）：如果打翻咖啡，执行洒出的动作。

------

#### 2. Java 中的类与对象

在 Java 中，**类** 是对象的模板，用于定义对象的属性和方法。通过类，我们可以创建多个对象，每个对象都有自己独立的属性值。

##### 2.1 类的定义

让我们通过一个 **Car（汽车）** 类来进一步理解类和对象的概念。

```java
public class Car {
    // 属性
    String make;    // 汽车品牌
    String model;   // 汽车型号
    int year;       // 出厂年份
    String color;   // 颜色
    double price;   // 价格

    // 方法
    void drive() {
        System.out.println("你正在驾驶这辆车");
    }

    void brake() {
        System.out.println("你踩下了刹车");
    }
}
```

在上面的代码中，我们定义了一个 `Car` 类，它包含以下属性：

- **make**：品牌（`String` 类型）
- **model**：型号（`String` 类型）
- **year**：年份（`int` 类型）
- **color**：颜色（`String` 类型）
- **price**：价格（`double` 类型）

此外，`Car` 类还定义了两个方法：

- `drive()`：打印一条驾驶信息。
- `brake()`：打印一条刹车信息。

##### 2.2 创建对象

通过类，我们可以创建对象。在 Java 中，通过 `new` 关键字来实例化一个对象。例如，我们可以创建一个 `Car` 对象：

```java
public class Main {
    public static void main(String[] args) {
        // 创建一个 Car 对象
        Car myCar = new Car();
        
        // 给对象的属性赋值
        myCar.make = "Chevrolet";
        myCar.model = "Corvette";
        myCar.year = 2020;
        myCar.color = "Blue";
        myCar.price = 50000;

        // 调用对象的方法
        System.out.println("这辆车的型号是：" + myCar.model);
        myCar.drive();
        myCar.brake();
    }
}
```

在上面的代码中，我们创建了一个名为 `myCar` 的 `Car` 对象，并为其赋予了一些具体的属性值。然后，我们使用 `myCar` 对象调用了 `drive()` 和 `brake()` 方法。

##### 输出结果：

```plain
这辆车的型号是：Corvette
你正在驾驶这辆车
你踩下了刹车
```

------

#### 3. 对象的属性与方法

每个对象都是类的实例，具有独立的属性值。例如，我们可以创建多个 `Car` 对象，每个对象的属性值可以不同。

```java
public class Main {
    public static void main(String[] args) {
        // 创建两个 Car 对象
        Car myCar1 = new Car();
        Car myCar2 = new Car();

        // 为第一个对象赋值
        myCar1.make = "Chevrolet";
        myCar1.model = "Corvette";
        myCar1.year = 2020;
        myCar1.color = "Blue";
        myCar1.price = 50000;

        // 为第二个对象赋值
        myCar2.make = "Tesla";
        myCar2.model = "Model S";
        myCar2.year = 2021;
        myCar2.color = "Red";
        myCar2.price = 80000;

        // 输出两个对象的属性
        System.out.println("第一辆车的型号是：" + myCar1.model);
        System.out.println("第二辆车的型号是：" + myCar2.model);
    }
}
```

##### 输出结果：

```plain
第一辆车的型号是：Corvette
第二辆车的型号是：Model S
```

------

#### 4. 方法的作用

对象的方法定义了该对象可以执行的操作。在上面的例子中，`drive()` 和 `brake()` 是 `Car` 对象可以执行的两个操作。我们可以通过对象名加上方法名的方式来调用这些方法。

##### 示例：

```java
myCar1.drive();  // 输出 "你正在驾驶这辆车"
myCar2.brake();  // 输出 "你踩下了刹车"
```

方法可以通过对象的属性来执行不同的操作。例如，我们可以根据汽车的状态来决定是否可以驾驶或刹车。

------

#### 5. 类的重用性

类是面向对象编程中的重要概念，它提供了代码的重用性。通过定义一个类，我们可以创建多个对象，而不需要重复编写相同的代码。每个对象都是类的一个实例，具有自己独立的属性。

##### 示例：创建多个对象

```java
Car myCar1 = new Car();
Car myCar2 = new Car();
```

我们可以通过同一个类 `Car` 来创建多个对象 `myCar1` 和 `myCar2`，并为它们赋予不同的属性值。

------

#### 6. 小结

面向对象编程是 Java 程序设计的核心思想。通过类和对象，程序员可以模拟现实世界中的实体，并将复杂的系统分解为多个具有独立职责的对象。

##### 关键点回顾：

- **类** 是对象的模板，定义了对象的属性和方法。
- **对象** 是类的实例，每个对象都有自己独立的属性。
- **属性** 定义了对象的状态，而 **方法** 则定义了对象可以执行的操作。
- 通过类，程序可以实现代码的重用性和模块化。

------

### 练习：

1. 创建一个 `Person` 类，定义一些属性（如姓名、年龄）和方法（如 `speak()` 和 `walk()`），然后创建多个 `Person` 对象并调用方法。
2. 修改 `Car` 类，添加一个 `startEngine()` 方法，模拟汽车启动时的操作。
3. 编写程序，创建一个 `Book` 类，并使用该类创建多个不同的书籍对象。
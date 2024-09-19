# lesson064. Java 多态性

#### 什么是多态性？

**多态性**（Polymorphism）是 Java 中的一个重要概念，这个词源自希腊语，**poly** 意为“多”，**morph** 意为“形式”。多态性意味着**同一个对象**可以有**多种形态**，即一个对象可以被视为多个不同的类型。

简单来说，多态性允许一个对象被看作其**父类**或**实现的接口**的实例，而不仅仅是它本身的类型。这使得代码更加灵活，可以处理不同的对象类型，同时保持通用性。

#### 示例：多种类型的车辆

假设我们要进行一场比赛，而参与比赛的可以是各种不同的交通工具，如汽车、自行车和船只。我们将创建一个 `Vehicle` 类作为父类，然后定义几个子类：`Car`、`Bicycle` 和 `Boat`。

#### 类的定义

```java
// 父类 Vehicle
public class Vehicle {
    public void go() {
        System.out.println("The vehicle is moving.");
    }
}

// 子类 Car 继承自 Vehicle
public class Car extends Vehicle {
    @Override
    public void go() {
        System.out.println("The car begins moving.");
    }
}

// 子类 Bicycle 继承自 Vehicle
public class Bicycle extends Vehicle {
    @Override
    public void go() {
        System.out.println("The bicycle begins moving.");
    }
}

// 子类 Boat 继承自 Vehicle
public class Boat extends Vehicle {
    @Override
    public void go() {
        System.out.println("The boat begins moving.");
    }
}
```

#### 使用多态存储不同类型的对象

现在我们可以创建不同的交通工具实例，并通过多态性将它们存储到一个 `Vehicle` 类型的数组中。这样，我们可以将所有不同类型的车辆看作 `Vehicle` 类型，并用一个通用的方式处理它们。

```java
public class Main {
    public static void main(String[] args) {
        // 创建 Car, Bicycle 和 Boat 的实例
        Car car = new Car();
        Bicycle bicycle = new Bicycle();
        Boat boat = new Boat();

        // 使用多态性将所有交通工具存储在一个 Vehicle 类型的数组中
        Vehicle[] racers = {car, bicycle, boat};

        // 使用增强 for 循环来遍历数组并调用 go 方法
        for (Vehicle racer : racers) {
            racer.go();  // 调用各自实现的 go 方法
        }
    }
}
```

#### 输出结果：

```plain
The car begins moving.
The bicycle begins moving.
The boat begins moving.
```

#### 多态性如何工作？

在上面的代码中，`racers` 数组的类型是 `Vehicle[]`，但数组中的每个元素既可以是 `Car`、`Bicycle`，也可以是 `Boat`。当我们调用 `racer.go()` 时，Java 会根据实际对象的类型来调用正确的 `go()` 方法，这就是**方法重写**（Method Overriding）和**运行时多态**（Runtime Polymorphism）的作用。

由于 `Car`、`Bicycle` 和 `Boat` 类都重写了 `Vehicle` 类的 `go()` 方法，Java 在运行时会自动选择正确的 `go()` 方法执行。

#### 总结

- **多态性**使对象可以具有多种形态，允许我们将子类对象看作父类对象处理。
- 通过多态性，我们可以创建通用的代码，处理不同类型的对象。
- **方法重写**是多态性的重要机制，子类可以提供父类方法的具体实现。
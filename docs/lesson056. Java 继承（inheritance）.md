# lesson056. Java 继承（inheritance）

在 Java 中，**继承**（Inheritance）是类之间的一种关系，它允许一个类继承另一个类的属性和方法。通过继承，一个类可以复用另一个类的已有代码，从而减少代码重复，提高代码的可维护性。

#### 继承的基本概念

- **父类**（Superclass）：提供属性和方法的类，也称为基类或超类。
- **子类**（Subclass）：继承父类的类，也称为派生类或扩展类。

子类通过继承父类，可以获得父类的所有属性和方法，并且可以根据需要添加自己的属性和方法。

#### 继承的语法

在 Java 中，使用 `extends` 关键字来实现继承。子类继承父类的语法格式如下：

```java
class 子类 extends 父类 {
    // 子类的属性和方法
}
```

#### 示例代码

以下是一个简单的 Java 继承示例：

```java
class Vehicle {
    // 父类的属性
    double speed;

    // 父类的方法
    void go() {
        System.out.println("This vehicle is moving.");
    }

    void stop() {
        System.out.println("This vehicle has stopped.");
    }
}

class Car extends Vehicle {
    // 子类的属性
    int wheels = 4;
    int doors = 4;
}

class Bicycle extends Vehicle {
    // 子类的属性
    int wheels = 2;
    int pedals = 2;
}

public class Main {
    public static void main(String[] args) {
        // 创建 Car 对象
        Car car = new Car();
        car.go();
        System.out.println("Car speed: " + car.speed);
        System.out.println("Car doors: " + car.doors);

        // 创建 Bicycle 对象
        Bicycle bike = new Bicycle();
        bike.stop();
        System.out.println("Bicycle speed: " + bike.speed);
        System.out.println("Bicycle pedals: " + bike.pedals);
    }
}
```

#### 代码解释

1. **父类** `Vehicle`：

- 包含 `speed` 属性，表示车辆的速度。
- 包含 `go()` 和 `stop()` 方法，分别表示车辆的移动和停止。

2. **子类** `Car` **和** `Bicycle`：

- `Car` 类继承了 `Vehicle` 类并添加了 `wheels` 和 `doors` 属性。
- `Bicycle` 类同样继承了 `Vehicle` 类并添加了 `wheels` 和 `pedals` 属性。

3. **在** `main` **方法中**：

- 创建了 `Car` 和 `Bicycle` 对象。
- 调用了从 `Vehicle` 类继承的 `go()` 和 `stop()` 方法，并访问了各自的属性。

#### 继承的优势

- **代码复用**：通过继承，子类可以复用父类的代码，避免重复编写相同的属性和方法。
- **扩展性**：子类可以在继承父类的基础上添加新的属性和方法，增强功能。

#### 多态性（Polymorphism）

继承是 Java 实现多态性的重要基础。通过使用父类类型的引用指向子类对象，可以动态地调用子类的方法，这使得代码更加灵活和可扩展。

#### 结论

继承是 Java 面向对象编程的重要组成部分，它允许类之间共享代码，从而提高代码的复用性和可维护性。在设计程序时，如果多个类之间有共同的属性和方法，可以考虑将这些共有的部分提取到一个父类中，然后让子类继承它。
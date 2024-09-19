# lesson054. Java 对象传递 (Passing Objects)

在 Java 中，我们可以将对象作为参数传递给方法。通过这种方式，我们可以让方法去操作传递的对象。在本教程中，我们将通过一个简单的例子来学习如何将对象作为参数传递给方法，并通过方法对该对象进行操作。

------

#### 1. 什么是对象传递？

在 Java 中，当我们将对象传递给方法时，实际上传递的是对象的**引用**。这意味着该方法可以通过引用来访问和修改对象的属性。

##### 示例场景：

我们有一个 `Garage` 类和一个 `Car` 类。我们将创建一些 `Car` 对象，并通过 `Garage` 类的方法将这些 `Car` 对象“停放”在“车库”中。

------

#### 2. 创建 `Car` 类

首先，我们定义一个 `Car` 类，每个 `Car` 对象都有一个 `name` 属性，用于表示车的名称。

```java
public class Car {
    String name;

    // Car 类的构造方法，接收车名作为参数
    public Car(String name) {
        this.name = name;
    }
}
```

------

#### 3. 创建 `Garage` 类并声明方法

接下来，我们创建一个 `Garage` 类，并为其定义一个 `park` 方法，该方法接收 `Car` 对象作为参数，并将车停放在车库中。

```java
public class Garage {
    // 定义一个接受 Car 对象的 park 方法
    public void park(Car car) {
        System.out.println(car.name + " is parked in the garage.");
    }
}
```

##### 解释：

- `park` 方法接收一个 `Car` 对象作为参数，并使用 `car.name` 来获取车的名称，然后打印一条消息，表示该车已停放在车库中。

------

#### 4. 将对象作为参数传递

我们现在可以创建 `Car` 和 `Garage` 的实例，并将 `Car` 对象作为参数传递给 `Garage` 的 `park` 方法。

##### 示例：将对象传递给方法

```java
public class Main {
    public static void main(String[] args) {
        // 创建 Garage 类的实例
        Garage garage = new Garage();

        // 创建 Car 类的实例
        Car car1 = new Car("BMW");
        Car car2 = new Car("Tesla");

        // 将 car1 对象传递给 park 方法
        garage.park(car1);  // 输出: BMW is parked in the garage.

        // 将 car2 对象传递给 park 方法
        garage.park(car2);  // 输出: Tesla is parked in the garage.
    }
}
```

##### 输出结果：

```plain
BMW is parked in the garage.
Tesla is parked in the garage.
```

------

#### 5. 传递对象的原理

当我们将对象作为参数传递时，我们传递的是对象的**引用**。这意味着在该方法内对对象属性的任何修改都会反映在原始对象上。

##### 示例：修改对象的属性

```java
public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage();
        Car car1 = new Car("BMW");

        // 停车前
        System.out.println("Car name before parking: " + car1.name);

        // 传递 car1 对象并修改它的属性
        garage.modifyCar(car1);

        // 停车后
        System.out.println("Car name after parking: " + car1.name);
    }
}

class Garage {
    // 修改传递的 Car 对象的属性
    public void modifyCar(Car car) {
        car.name = "Audi";  // 直接修改 car 的名称（属性）
        System.out.println(car.name + " is parked in the garage.");
    }
}
```

##### 输出结果：

```plain
Car name before parking: BMW
Audi is parked in the garage.
Car name after parking: Audi
```

##### 解释：

- 当 `modifyCar` 方法被调用时，方法修改了 `car1` 对象的 `name` 属性，因此在方法外部也能看到这个变化。这证明了对象是通过引用传递的。

------

#### 6. 对象传递的限制

当我们传递对象的引用时，**虽然可以修改该对象的属性，但不能改变该对象的引用**。例如，如果我们试图在方法中将对象引用指向一个新的对象，原始对象不会受到影响。

##### 示例：不能改变对象的引用

```java
public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("BMW");

        // 停车前
        System.out.println("Car before: " + car1.name);

        // 尝试修改 car1 的引用
        modifyReference(car1);

        // 停车后
        System.out.println("Car after: " + car1.name);  // 仍然是 BMW
    }

    public static void modifyReference(Car car) {
        // 尝试将 car 指向新的对象，通过 new 关键字
        car = new Car("Audi");
        System.out.println("In method: " + car.name);  // 输出: Audi
    }
}
```

##### 输出结果：

```plain
Car before: BMW
In method: Audi
Car after: BMW
```

##### 解释：

- 在 `modifyReference` 方法中，我们试图将 `car` 引用指向一个新的 `Car` 对象（`Audi`）。但是，这只是改变了方法内部的引用。方法外部的 `car1` 引用仍然指向原来的 `Car` 对象（`BMW`）。

------

#### 7. 小结

- 在 Java 中，对象作为参数传递时是通过**引用传递**的，这意味着方法可以修改对象的属性。
- 虽然方法可以修改对象的属性，但它不能改变对象的引用。
- 通过将对象作为参数传递，我们可以在方法中操作这些对象，使程序更加灵活和模块化。

##### 关键点回顾：

- 对象通过引用传递，方法可以修改对象的属性。
- 方法不能改变对象的引用，只能修改对象的属性。
- 传递对象作为参数后，对象的任何修改都会反映在原始对象上。

------

### 练习

1. 创建一个 `Person` 类，包含 `name` 和 `age` 属性，定义一个方法 `updatePerson`，该方法接受 `Person` 对象并修改其属性。测试对象传递的效果。
2. 修改 `Garage` 类，创建一个 `bicycle` 类并尝试将 `bicycle` 对象传递给 `Garage` 的 `park` 方法，看看会发生什么。
3. 编写程序，创建一个 `Library` 类，包含一个 `addBook` 方法，接受 `Book` 对象作为参数。创建多个 `Book` 对象并将它们传递给 `Library` 对象。
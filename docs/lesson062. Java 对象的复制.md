# lesson062. Java 对象的复制

#### 什么是对象复制？

在 Java 中，对象的复制是指创建一个与现有对象具有相同属性的新对象。对于原始类型（如 `int`、`float` 等），复制非常简单，因为它们是**值类型**，可以通过直接赋值来复制。但对于对象（**引用类型**），直接赋值会导致两个变量指向**同一个对象**，而不是创建一个新的独立对象。

#### 直接赋值的问题

如果我们尝试用直接赋值的方式复制对象：

```java
Car car1 = new Car("Chevrolet", "Camaro", 2021);
Car car2 = car1;  // 直接赋值
```

这种情况下，`car1` 和 `car2` 其实指向**同一个对象**，它们共享同一个内存地址。如果修改了 `car2` 的属性，`car1` 的属性也会同时被修改，因为它们实际上是同一个对象的两个引用，也就是说实际上我们是给一辆车起了两个名字。

#### 浅复制 vs 深复制

- **浅复制**：只复制对象的字段值。如果字段是引用类型（比如对象），浅复制只会复制引用地址，两个对象仍然共享同一个引用。
- **深复制**：不仅复制对象的字段值，还会递归复制引用类型的对象，确保两个对象完全独立。

在本示例中，我们将使用**浅复制**，手动复制对象的各个属性。

------

### 示例代码：浅复制对象

为了复制对象的属性，我们可以在类中创建一个 `copy` 方法，手动复制每个属性的值。

#### `Car` 类

```java
public class Car {
    // 私有属性
    private String make;
    private String model;
    private int year;

    // 构造方法
    public Car(String make, String model, int year) {
        this.setMake(make);
        this.setModel(model);
        this.setYear(year);
    }

    // Getter 方法
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    // Setter 方法
    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // 复制方法
    public void copy(Car car) {
        this.setMake(car.getMake());
        this.setModel(car.getModel());
        this.setYear(car.getYear());
    }
}
```

#### 使用 `copy` 方法复制对象

```java
public class Main {
    public static void main(String[] args) {
        // 创建第一个 Car 对象
        Car car1 = new Car("Chevrolet", "Camaro", 2021);

        // 使用无参构造方法创建第二个 Car 对象
        Car car2 = new Car("Ford", "Mustang", 2022);

        // 复制 car1 的属性到 car2
        car2.copy(car1);

        // 打印 car1 和 car2 的属性
        System.out.println("Car 1: " + car1.getMake() + " " + car1.getModel() + " " + car1.getYear());
        System.out.println("Car 2: " + car2.getMake() + " " + car2.getModel() + " " + car2.getYear());
    }
}
```

#### 输出结果：

```plain
Car 1: Chevrolet Camaro 2021
Car 2: Chevrolet Camaro 2021
```

在这个例子中，`car2.copy(car1)` 将 `car1` 的 `make`、`model` 和 `year` 复制到了 `car2`，但 `car1` 和 `car2` 依然是**不同的对象**，它们有不同的内存地址。

------

### 使用复制构造函数

除了使用 `copy` 方法，还可以通过**复制构造函数**（Copy Constructor）在创建对象时进行复制。

#### 复制构造函数的实现

```java
public class Car {
    // 私有属性
    private String make;
    private String model;
    private int year;

    // 常规构造方法
    public Car(String make, String model, int year) {
        this.setMake(make);
        this.setModel(model);
        this.setYear(year);
    }

    // 复制构造函数
    public Car(Car car) {
        this.setMake(car.getMake());
        this.setModel(car.getModel());
        this.setYear(car.getYear());
    }

    // Getter 和 Setter 方法同上（省略）
}
```

#### 使用复制构造函数创建新对象

```java
public class Main {
    public static void main(String[] args) {
        // 创建第一个 Car 对象
        Car car1 = new Car("Chevrolet", "Camaro", 2021);

        // 使用复制构造函数创建第二个 Car 对象
        Car car2 = new Car(car1);

        // 打印 car1 和 car2 的属性
        System.out.println("Car 1: " + car1.getMake() + " " + car1.getModel() + " " + car1.getYear());
        System.out.println("Car 2: " + car2.getMake() + " " + car2.getModel() + " " + car2.getYear());
    }
}
```

#### 输出结果：

```plain
Car 1: Chevrolet Camaro 2021
Car 2: Chevrolet Camaro 2021
```

在这个例子中，我们使用**复制构造函数**在创建 `car2` 对象时就将 `car1` 的属性复制了过去。这样 `car2` 是一个新的对象，具有和 `car1` 相同的属性。

------

### 总结

- 直接赋值（`car2 = car1`）只会复制对象的引用，导致两个变量指向同一个对象。
- 通过**复制方法**或**复制构造函数**，可以手动复制对象的属性，创建一个新的独立对象。

#### 复制对象的两种方式：

1. **复制方法**（`copy`）：在对象创建之后手动调用。
2. **复制构造函数**：在对象创建时自动复制。

这两种方式都可以用于浅复制对象。如果对象内部包含其他复杂对象，可能需要实现**深复制**，这会更加复杂。

------
# lesson052. Java toString 方法

在 Java 中，`toString` **方法** 是一个特殊的方法，用于返回对象的文本表示形式。所有对象都继承了 `toString` 方法，默认情况下，这个方法返回对象的内存地址的字符串表示形式。然而，通过**重写（override）** `toString` 方法，我们可以让它返回更加用户友好的信息，比如对象的属性值。

------

#### 1. 什么是 `toString` 方法？

`toString` 是 Java 的 `Object` 类中的一个方法，所有类都默认继承了这个方法。它用于返回对象的字符串表示形式。默认情况下，`toString` 方法返回的是对象的内存地址（哈希码）的字符串表示。

##### 示例：默认的 `toString` 方法

```java
public class Car {
    String make;
    String model;
    String color;
    int year;

    public Car(String make, String model, String color, int year) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Ford", "Mustang", "Red", 2021);
        System.out.println(car);  // 默认情况下，输出对象的内存地址
    }
}
```

##### 输出结果：

```plain
Car@1b6d3586
```

如上所示，`System.out.println(car)` 输出的是对象 `car` 在内存中的地址。

------

#### 2. 为什么要重写 `toString` 方法？

默认的 `toString` 方法虽然返回对象的内存地址，但这对用户来说并没有太多意义。通过重写 `toString` 方法，我们可以让它返回该对象的详细信息，例如对象的属性，这样可以更加清晰地展示对象的内容。

##### 示例：重写 `toString` 方法

```java
public class Car {
    String make;
    String model;
    String color;
    int year;

    public Car(String make, String model, String color, int year) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
    }

    // 重写 toString 方法
    @Override
    public String toString() {
        return "Car [Make: " + make + ", Model: " + model + 
               ", Color: " + color + ", Year: " + year + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Ford", "Mustang", "Red", 2021);
        System.out.println(car);  // 现在输出的是对象的属性信息
    }
}
```

##### 输出结果：

```plain
Car [Make: Ford, Model: Mustang, Color: Red, Year: 2021]
```

在重写 `toString` 方法后，`System.out.println(car)` 输出了对象的属性信息，而不是默认的内存地址。

------

#### 3. `toString` 方法的两种使用方式

`toString` 方法可以**显式**或**隐式**调用。

- **显式调用**：通过 `对象名.toString()` 来调用该方法。
- **隐式调用**：当我们将对象传递给 `System.out.println()` 或 `System.out.print()` 时，Java 会自动调用 `toString` 方法。

##### 示例：显式和隐式调用

```java
public class Main {
    public static void main(String[] args) {
        Car car = new Car("Ford", "Mustang", "Red", 2021);

        // 隐式调用
        System.out.println(car);  // 自动调用 car.toString()

        // 显式调用
        System.out.println(car.toString());
    }
}
```

##### 输出结果：

```plain
Car [Make: Ford, Model: Mustang, Color: Red, Year: 2021]
Car [Make: Ford, Model: Mustang, Color: Red, Year: 2021]
```

无论是显式调用还是隐式调用，都会得到相同的输出结果。

------

#### 4. 如何重写 `toString` 方法

重写 `toString` 方法时，我们可以根据需要返回对象的各种属性信息，格式可以自行定义。例如，可以将每个属性值放在不同的行上，或者使用逗号分隔。

##### 示例：自定义 `toString` 输出格式

```java
public class Car {
    String make;
    String model;
    String color;
    int year;

    public Car(String make, String model, String color, int year) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car Details:\n" +
               "Make: " + make + "\n" +
               "Model: " + model + "\n" +
               "Color: " + color + "\n" +
               "Year: " + year;
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Ford", "Mustang", "Red", 2021);
        System.out.println(car);
    }
}
```

##### 输出结果：

```plain
Car Details:
Make: Ford
Model: Mustang
Color: Red
Year: 2021
```

------

#### 5. 什么时候应该重写 `toString` 方法？

在以下场景下，重写 `toString` 方法非常有用：

- 你希望对象在被打印时输出有意义的内容，而不是内存地址。
- 你希望调试或日志记录时能快速查看对象的状态。
- 需要将对象的属性信息转换为字符串，比如用于 UI 显示或文件输出。

------

#### 6. 小结

- `toString` **方法** 是 Java 中所有对象默认继承的一个方法，返回对象的字符串表示形式。
- **重写** `toString` **方法** 可以让我们自定义对象的输出格式，使其更加直观和有用。
- `toString` 方法可以显式调用或隐式调用。
- 在开发中，重写 `toString` 方法有助于提高程序的可读性和可调试性。

------

### 练习

1. 创建一个 `Person` 类，包含 `name`, `age` 和 `gender` 三个属性，重写 `toString` 方法，使其返回这些属性的字符串表示形式。
2. 修改 `Car` 类，添加更多属性（如 `engineType` 和 `price`），并更新 `toString` 方法以显示所有属性。
3. 编写程序，创建一个 `Book` 类，包含 `title`, `author` 和 `yearPublished` 属性，重写 `toString` 方法以返回书籍的详细信息。
# lesson061. Java 封装（Encapsulation）

#### 什么是封装？

**封装**（Encapsulation）是面向对象编程中的一个重要概念，它指的是将类的属性（变量）设为**私有**（`private`），通过**公有的**（`public`）方法（通常是**getter**和**setter**方法）来控制对这些属性的访问和修改。这种方式允许我们**隐藏类的具体实现细节**，并通过定义的方法来访问或修改属性值，从而增加类的安全性和可维护性。

#### 为什么使用封装？

- **数据保护**：通过将类的属性设为 `private`，可以避免外部类直接修改或访问这些属性，保护数据的完整性。
- **控制访问**：可以通过 `getter` 和 `setter` 方法控制属性的访问和修改权限，比如可以在 `setter` 方法中添加逻辑来验证传入的值。
- **灵活性**：即使类的内部实现发生了变化，只要 `getter` 和 `setter` 方法的接口保持不变，外部代码也不会受到影响。

#### 示例代码：实现封装

让我们通过一个关于汽车的例子来演示封装的基本用法。

```java
// Car.java
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
        if (year > 1886) { // 汽车是 1886 年发明的
            this.year = year;
        } else {
            this.year = 1886; // 如果年份不合理，设为 1886
        }
    }
}
```

#### 使用封装的类

```java
// Main.java
public class Main {
    public static void main(String[] args) {
        // 创建 Car 对象
        Car car = new Car("Chevrolet", "Camaro", 2021);

        // 通过 Getter 方法获取属性值
        System.out.println("Make: " + car.getMake());  // 输出: Chevrolet
        System.out.println("Model: " + car.getModel());  // 输出: Camaro
        System.out.println("Year: " + car.getYear());  // 输出: 2021

        // 通过 Setter 方法修改属性值
        car.setYear(2022);  // 修改年份为 2022
        System.out.println("Updated Year: " + car.getYear());  // 输出: 2022

        // 如果尝试设置一个不合法的年份
        car.setYear(1800);  // 年份无效，设置为 1886
        System.out.println("Corrected Year: " + car.getYear());  // 输出: 1886
    }
}
```

#### 代码说明

1. **私有属性**：`make`、`model` 和 `year` 被声明为 `private`，因此它们只能在 `Car` 类内部访问。
2. **构造方法**：我们在构造方法中通过调用 `setter` 方法来初始化属性。
3. **Getter 方法**：用于返回私有属性的值。例如，`getMake()` 返回汽车的品牌 `make`。
4. **Setter 方法**：用于修改私有属性的值。例如，`setYear(int year)` 方法允许我们设置汽车的年份，并且在设置年份时进行了简单的验证，确保年份合理。

#### 封装的优点

- **数据隐藏**：封装隐藏了类的内部实现细节，外部类不能直接访问类的私有属性。
- **安全性**：通过封装可以防止数据被不合理地修改。比如，在 `setYear` 方法中，我们对传入的年份进行了验证，确保它不小于 1886 年。
- **代码可维护性**：如果类的内部实现发生改变，外部类不会受到影响，因为它们只与 `getter` 和 `setter` 方法打交道。

#### 总结

- **封装**通过将类的属性设置为 `private` 并提供 `getter` 和 `setter` 方法来控制它们的访问和修改，增加了代码的安全性和灵活性。
- 使用封装可以更好地保护数据，避免外部类直接修改对象的内部状态，并通过 `setter` 方法添加必要的验证逻辑，保证数据的正确性。

封装是面向对象编程中的一项基本原则，能够帮助开发者编写**更加健壮、可维护**的代码。
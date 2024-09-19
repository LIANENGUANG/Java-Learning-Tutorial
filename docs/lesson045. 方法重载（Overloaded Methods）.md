# lesson045. 方法重载（Overloaded Methods）

在这章中，我们将讨论 **Java 中的“方法重载”**。方法重载是一种让我们能够定义多个具有相同名称但参数不同的方法的技术。通过这项技术，程序可以根据传递给方法的不同参数执行不同的操作。让我们一起学习如何在 Java 中使用方法重载。

------

### 1. **什么是方法重载？**

**方法重载** 指的是 **多个方法共享相同的名称**，但是它们的 **参数列表不同**。Java 允许同一个类中存在多个同名方法，只要它们的参数不同即可。方法的唯一标识符是它的 **签名**，即方法的名称加上参数的类型和数量。

#### **关键点**：

- 方法重载允许多个方法共享相同的名称。
- 每个重载的方法必须具有不同的参数列表。
- 参数的 **数量**、**类型** 和 **顺序** 都可以用来区分重载的方法。

------

### 2. **方法签名**

在 Java 中，方法的 **签名** 由方法名和参数列表（包括参数的数量、类型和顺序）组成。方法签名必须唯一，重载方法的名称可以相同，但参数列表必须不同。

#### **示例 1：方法签名**

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(add(2, 3));       // 调用第一个 add 方法
        System.out.println(add(2, 3, 4));    // 调用第二个 add 方法
    }

    // 第一个 add 方法，接受两个整数参数
    public static int add(int a, int b) {
        return a + b;
    }

    // 第二个 add 方法，接受三个整数参数
    public static int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

#### **结果**：

- `add(2, 3)` 调用了接受 **两个参数** 的 `add` 方法，输出为 `5`。
- `add(2, 3, 4)` 调用了接受 **三个参数** 的 `add` 方法，输出为 `9`。

------

### 3. **如何解决方法重载冲突**

在定义重载方法时，如果参数列表完全相同，Java 编译器将无法区分不同的方法，导致编译错误。

#### **错误示例**：

```java
public static int add(int a, int b) {
    return a + b;
}

public static int add(int a, int b) {
    return a * b;  // 编译错误，方法签名重复
}
```

#### **解决方法**：

1. **改变参数的数量**：可以通过传递不同数量的参数来区分重载方法。
2. **改变参数的类型**：可以通过传递不同类型的参数来区分重载方法。

------

### 4. **案例：多个重载方法**

让我们通过一个实际例子来创建多个重载的 `add` 方法：

#### **示例 2：多个重载的 add 方法**

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(add(1, 2));              // 调用第一个方法
        System.out.println(add(1, 2, 3));           // 调用第二个方法
        System.out.println(add(1, 2, 3, 4));        // 调用第三个方法
    }

    // 第一个 add 方法，接受两个整数参数
    public static int add(int a, int b) {
        return a + b;
    }

    // 第二个 add 方法，接受三个整数参数
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    // 第三个 add 方法，接受四个整数参数
    public static int add(int a, int b, int c, int d) {
        return a + b + c + d;
    }
}
```

#### **解释**：

- 通过定义不同数量的参数，我们可以创建多个 `add` 方法。
- 当调用 `add(1, 2)` 时，匹配的是接受两个参数的第一个 `add` 方法。
- 当调用 `add(1, 2, 3)` 时，匹配的是接受三个参数的第二个 `add` 方法。
- 当调用 `add(1, 2, 3, 4)` 时，匹配的是接受四个参数的第三个 `add` 方法。

------

### 5. **不同数据类型的重载**

除了参数数量不同外，参数的 **数据类型** 也可以用来区分重载的方法。我们可以创建多个重载方法，分别接受不同类型的参数。

#### **示例 3：不同数据类型的重载**

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(add(1, 2));          // 调用整数版本的 add 方法
        System.out.println(add(1.0, 2.0));      // 调用浮点数版本的 add 方法
    }

    // 接受整数参数的 add 方法
    public static int add(int a, int b) {
        return a + b;
    }

    // 接受浮点数参数的 add 方法
    public static double add(double a, double b) {
        return a + b;
    }
}
```

#### **解释**：

- 当调用 `add(1, 2)` 时，匹配的是接受整数参数的 `add` 方法。
- 当调用 `add(1.0, 2.0)` 时，匹配的是接受浮点数参数的 `add` 方法。

------

### 6. **总结**

- **方法重载** 是通过 **参数数量** 和 **参数类型** 的不同来区分同名方法的技术。
- 重载方法的名称相同，但参数列表必须不同，参数的 **数量**、**类型** 和 **顺序** 都可以用来区分重载的方法。
- 方法重载可以使代码更具可读性，尤其是在实现类似的功能时，能够根据不同的需求调用不同的版本。

#### **小结**：

- 同一个类中可以定义多个重载方法，但这些方法的参数列表必须不同。
- 参数的数量、类型以及顺序决定了方法的签名。
- 方法重载提高了代码的可维护性和灵活性。

------
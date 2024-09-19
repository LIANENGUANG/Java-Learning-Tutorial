# lesson044. Java 方法（Methods）

在这章中，我们将详细讨论 **Java 中的“方法”**，并学习如何定义、调用以及如何通过参数和返回值与方法进行交互。这些内容基于视频中的讲解，帮助你更好地理解 Java 方法的基本概念和用法。

------

### 1. **什么是方法？**

**方法**是 **一段代码块**，当你调用它时，该代码块将被执行。在 Java 中，几乎所有的代码都必须写在方法内。例如，程序执行时，默认会调用 `main` 方法，所有我们编写的代码都在 `main` 方法的花括号内。

#### **语法结构**：

```java
returnType methodName(parameters) {
    // 方法体，写要执行的代码
    return value;  // 如果有返回值，返回相应的值
}
```

- `returnType`：方法返回值的类型。如果方法不返回任何值，使用 `void`。
- `methodName`：方法的名称。
- `parameters`：传递给方法的参数，可以没有参数。

------

### 2. **如何定义和调用方法**

让我们从一个简单的例子开始，定义一个方法来显示一个消息。

#### **示例 1：定义一个简单的方法**

```java
public class Main {
    public static void main(String[] args) {
        hello();  // 调用方法
    }

    public static void hello() {
        System.out.println("Hello!");
    }
}
```

#### **解释**：

- `hello()` 是我们定义的方法，它会打印 `"Hello!"`。
- 我们在 `main` 方法中调用了 `hello()` 方法，因此，当程序运行时，控制台会显示 `"Hello!"`。

------

### 3. **方法的** `static` **关键字**

在上面的例子中，我们使用了 `static` 关键字。这是因为 `main` 方法本身是静态的（`static`），而我们调用的 `hello()` 方法也必须是静态的，才能从 `main` 方法中引用。

如果方法不需要通过对象调用，而是直接通过类名调用，那么我们就需要使用 `static` 关键字。

------

### 4. **带参数的方法**

我们可以向方法传递参数，使得方法在不同情况下能够执行不同的操作。

#### **示例 2：带参数的方法**

```java
public class Main {
    public static void main(String[] args) {
        greet("Alice");
        greet("Bob");
    }

    public static void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }
}
```

#### **解释**：

- `greet(String name)` 方法接收一个参数 `name`，并在控制台上打印 `"Hello, name!"`。
- 在 `main` 方法中，我们分别调用了 `greet("Alice")` 和 `greet("Bob")`，所以程序会输出：

```plain
Hello, Alice!
Hello, Bob!
```

------

### 5. **参数与返回值**

#### **参数（Parameters）与参数传递（Arguments）**：

参数是方法声明时所指定的变量类型，而在调用方法时传递的实际值叫做 **实参（arguments）**。

例如，`greet(String name)` 中，`String name` 是 **参数**，而在调用方法时传递的 `"Alice"` 和 `"Bob"` 是 **实参**。

#### **返回值**：

方法可以返回一个值给调用它的地方。如果方法有返回值，必须指定返回值的类型，并使用 `return` 语句来返回结果。

#### **示例 3：带返回值的方法**

```java
public class Main {
    public static void main(String[] args) {
        int result = add(5, 10);
        System.out.println("Sum: " + result);
    }

    public static int add(int a, int b) {
        return a + b;
    }
}
```

#### **解释**：

- `add(int a, int b)` 方法接收两个整数参数，并返回它们的和。
- 在 `main` 方法中，我们调用了 `add(5, 10)`，并将返回的结果存储在 `result` 中，然后输出结果：`Sum: 15`。

------

### 6. **方法重载（Overloading）**

方法重载允许定义多个具有相同名称但参数列表不同的方法。Java 会根据参数的类型和数量来决定调用哪个方法。

#### **示例 4：方法重载**

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(sum(5, 10));      // 调用第一个 sum 方法
        System.out.println(sum(5.5, 10.5));  // 调用第二个 sum 方法
    }

    // 第一个 sum 方法
    public static int sum(int a, int b) {
        return a + b;
    }

    // 第二个 sum 方法
    public static double sum(double a, double b) {
        return a + b;
    }
}
```

#### **解释**：

- `sum(int a, int b)` 和 `sum(double a, double b)` 是两个重载的方法，分别处理整数和浮点数的相加操作。

------

### 7. **局部变量和作用域**

在方法内部定义的变量称为 **局部变量**，它们只能在方法内部使用，方法执行完毕后，这些变量就会被销毁。

#### **示例 5：局部变量的作用域**

```java
public class Main {
    public static void main(String[] args) {
        int result = multiply(4, 5);
        System.out.println("Product: " + result);
    }

    public static int multiply(int a, int b) {
        int product = a * b;  // 局部变量
        return product;
    }
}
```

#### **解释**：

- `product` 是 `multiply` 方法中的局部变量，只能在 `multiply` 方法中使用，无法在其他方法中访问。

------

### 8. **递归方法**

递归是指方法自己调用自己，用于解决一些特定的问题，比如计算阶乘或遍历树形结构。

#### **示例 6：递归计算阶乘**

```java
public class Main {
    public static void main(String[] args) {
        int result = factorial(5);
        System.out.println("Factorial of 5: " + result);
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);  // 递归调用
        }
    }
}
```

#### **解释**：

- `factorial()` 方法通过递归调用自己来计算阶乘。当 `n == 0` 时，停止递归，返回 1。

------

### 9. **总结**

- **方法** 是 Java 中非常重要的组成部分，它帮助我们将代码模块化，使得代码更加简洁和易于维护。
- 方法可以接收参数，并返回结果。
- **方法重载** 允许我们定义多个同名方法，但参数不同。
- **局部变量** 只能在方法内部使用。
- **递归** 是一种特殊的方法调用方式，方法自己调用自己。
# lesson066. Java 异常处理

#### 什么是异常？

异常是指程序在运行时发生的意外事件，它会**中断程序的正常执行**流程。常见的异常包括除以零（`ArithmeticException`）或输入不匹配（`InputMismatchException`）等。这些事件会导致程序崩溃，因此我们需要一种方法来**优雅地处理**这些异常，并让程序继续运行。

#### 基本的异常处理

假设我们要编写一个简单的程序来**除法运算**，并打印结果。如果我们输入了不合法的数据（如除以零或输入非数字字符），程序将抛出异常。我们可以通过**异常处理机制**来捕获这些异常并进行处理。

让我们从一个简单的程序入手，然后加入异常处理。

#### 示例代码：捕获 `ArithmeticException`

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // 提示用户输入两个整数
            System.out.println("Enter a whole number to divide:");
            int x = scanner.nextInt();  // 获取第一个整数

            System.out.println("Enter a whole number to divide by:");
            int y = scanner.nextInt();  // 获取第二个整数

            // 进行除法运算
            int z = x / y;  // 可能抛出 ArithmeticException
            System.out.println("Result: " + z);

        } catch (ArithmeticException e) {
            // 捕获并处理除以零异常
            System.out.println("You can't divide by zero!");

        } finally {
            // 关闭 Scanner
            scanner.close();
            System.out.println("Scanner closed.");
        }
    }
}
```

在上面的代码中，我们使用了 `try-catch-finally` 结构：

- **try** 块：包含可能引发异常的代码（即“危险代码”）。
- **catch** 块：捕获并处理特定类型的异常，在这里我们捕获 `ArithmeticException`（除以零异常）。
- **finally** 块：无论是否发生异常，`finally` 块中的代码总是会执行。通常用于关闭资源，例如关闭 `Scanner`。

#### 示例代码：捕获 `InputMismatchException`

如果用户输入了非数字字符（如字母），程序将抛出 `InputMismatchException`。我们可以通过另一个 `catch` 块来处理这种异常。

```java
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // 提示用户输入两个整数
            System.out.println("Enter a whole number to divide:");
            int x = scanner.nextInt();  // 获取第一个整数

            System.out.println("Enter a whole number to divide by:");
            int y = scanner.nextInt();  // 获取第二个整数

            // 进行除法运算
            int z = x / y;
            System.out.println("Result: " + z);

        } catch (ArithmeticException e) {
            // 捕获并处理除以零异常
            System.out.println("You can't divide by zero!");

        } catch (InputMismatchException e) {
            // 捕获并处理输入不匹配异常
            System.out.println("Please enter a valid number!");

        } finally {
            // 关闭 Scanner
            scanner.close();
            System.out.println("Scanner closed.");
        }
    }
}
```

#### 捕获所有异常

虽然可以使用 `Exception` 类捕获所有类型的异常，但这通常被认为是不好的做法，因为它会捕获**所有的异常**，而不仅仅是我们期望处理的特定异常。

```java
catch (Exception e) {
    System.out.println("Something went wrong!");
}
```

虽然这样可以捕获所有未预见的异常，但最好还是针对特定的异常类型进行处理，以便提高代码的可读性和可维护性。

#### `finally` 块的作用

`finally` 块中的代码**总是会执行**，无论是否发生异常。这对于确保资源关闭或清理操作非常有用。例如，关闭文件或数据库连接，或者在这里关闭 `Scanner`。

```java
finally {
    scanner.close();
    System.out.println("Scanner closed.");
}
```

无论程序是否发生异常，`finally` 块中的 `scanner.close()` 都会被执行，确保 `Scanner` 被正确关闭。

#### 总结

- **异常** 是程序运行时出现的意外情况，可能会中断程序的正常执行。
- **try-catch-finally** 结构允许我们捕获并处理这些异常。

- **try** 块包含可能引发异常的代码。
- **catch** 块用于捕获并处理特定类型的异常。
- **finally** 块用于执行无论是否抛出异常都必须执行的代码。

- 捕获特定异常类型（如 `ArithmeticException` 和 `InputMismatchException`）是更好的做法，而不是使用通用的 `Exception`。
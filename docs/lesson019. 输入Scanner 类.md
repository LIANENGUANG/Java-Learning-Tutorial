# lesson019. 输入Scanner 类

### `Scanner` **类小结**

在 Java 中，`Scanner` 类是用于从**标准输入**（如键盘）读取用户输入的常用工具。它位于 `java.util` 包中，提供了多种方法来读取不同类型的数据（如整数、浮点数、字符串等）。

------

### 1. **引入** `Scanner` **类**

在使用 `Scanner` 类之前，必须导入它：

```java
import java.util.Scanner;
```

------

### 2. **创建** `Scanner` **对象**

要读取用户输入，需要创建一个 `Scanner` 对象，并将 `System.in` 作为参数传递给它。`System.in` 表示标准输入流（通常是键盘输入）。

```java
Scanner scanner = new Scanner(System.in);
```

------

### 3. **常用方法**

`Scanner` 提供了多种方法来读取不同类型的输入：

| 方法                                 | 说明                                           | 示例                                    |
| ------------------------------------ | ---------------------------------------------- | --------------------------------------- |
| `nextInt()`                          | 读取一个整数                                   | `int num = scanner.nextInt();`          |
| `nextDouble()`                       | 读取一个双精度浮点数                           | `double d = scanner.nextDouble();`      |
| `nextLine()`                         | 读取一整行字符串                               | `String line = scanner.nextLine();`     |
| `next()`                             | 读取一个单词，遇到空格或换行符结束             | `String word = scanner.next();`         |
| `nextBoolean()`                      | 读取布尔值 (`true` 或 `false`)                 | `boolean flag = scanner.nextBoolean();` |
| `nextFloat()`                        | 读取一个浮点数                                 | `float f = scanner.nextFloat();`        |
| `nextLong()`                         | 读取一个长整型                                 | `long l = scanner.nextLong();`          |
| `hasNextInt()`、`hasNextDouble()` 等 | 检查下一个输入是否为指定类型，可以防止读取错误 | `if (scanner.hasNextInt()) { ... }`     |

------

### 4. **示例代码**

#### **读取整数和字符串**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 创建 Scanner 对象
        Scanner scanner = new Scanner(System.in);

        // 读取整数
        System.out.print("请输入一个整数: ");
        int number = scanner.nextInt();
        System.out.println("你输入的整数是: " + number);

        // 清空换行符
        scanner.nextLine();

        // 读取字符串
        System.out.print("请输入一行文本: ");
        String text = scanner.nextLine();
        System.out.println("你输入的文本是: " + text);

        // 关闭 Scanner
        scanner.close();
    }
}
```

#### **读取浮点数**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取浮点数
        System.out.print("请输入一个浮点数: ");
        double num = scanner.nextDouble();
        System.out.println("你输入的浮点数是: " + num);

        scanner.close();
    }
}
```

------

### 5. **注意事项**

1. **关闭** `Scanner`：

- 使用 `Scanner` 读取输入时，最好在使用完毕后调用 `scanner.close()` 来关闭它，以释放资源。
- **注意**：如果关闭 `Scanner`，它会关闭 `System.in`，而 `System.in` 一旦关闭，无法重新打开。因此，不要在程序的中途关闭 `Scanner`，否则后续无法再读取输入。

2. **读取换行符问题**：

示例：

```java
int num = scanner.nextInt();
scanner.nextLine();  // 清除换行符
String text = scanner.nextLine();  // 正常读取字符串
```

- `nextInt()`、`nextDouble()` 等方法不会读取换行符，如果你在读取这些类型后再调用 `nextLine()`，可能会出现 **跳过输入** 的现象。因此，通常在读取完数字后，紧接着调用一次 `nextLine()` 来清空换行符。

3. **输入类型不匹配**：

- 如果输入的值与期望的类型不匹配（如用户输入了一个字母，而 `nextInt()` 期望读取一个整数），程序会抛出 `InputMismatchException`。可以使用 `hasNextXXX()` 方法来检查输入是否合法。

------

### 6. **优缺点**

#### **优点**：

- **简单易用**：提供了多种读取不同类型数据的便捷方法。
- **多样性**：可以读取整数、浮点数、字符串、布尔值等不同类型的数据。

#### **缺点**：

- **性能较低**：相比低级输入流（如 `BufferedReader`），`Scanner` 的性能稍差，尤其是在处理大量输入时。
- **换行符问题**：在处理混合输入（如数字和字符串）时，换行符可能会导致一些意外行为。

------

### 7. **总结**

- `Scanner` 是读取用户输入的常用工具，它可以读取多种类型的输入数据，如整数、浮点数、字符串等。
- 使用 `Scanner` 时，注意类型匹配、换行符问题以及关闭资源。
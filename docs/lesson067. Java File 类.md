# lesson067. Java File 类

#### 什么是 File 类？

`File` 类是 Java 中用于表示文件和目录路径名的**抽象表示**。使用 `File` 类，我们可以检测文件是否存在、获取文件的路径、删除文件等。它是操作文件的基础工具。

#### 检测文件是否存在

首先，让我们学习如何检测某个文件是否存在。例如，我们在桌面上创建了一个名为 `secret_message.txt` 的文本文件，并将其放入项目文件夹中。接下来，我们将使用 `File` 类来检测这个文件是否存在。

#### 示例代码：检测文件是否存在

```java
import java.io.File;

public class Main {
    public static void main(String[] args) {
        // 创建一个 File 对象，表示文件
        File file = new File("secret_message.txt");

        // 使用 exists() 方法检测文件是否存在
        if (file.exists()) {
            System.out.println("That file exists! :)");
        } else {
            System.out.println("That file doesn't exist. :(");
        }
    }
}
```

在这个例子中，我们创建了一个 `File` 对象，并将 `secret_message.txt` 文件的路径传递给构造函数。然后，我们使用 `exists()` 方法来检查该文件是否存在。输出结果会根据文件是否存在而有所不同。

#### 检测文件路径中的文件

如果文件不在项目文件夹中，而是在其他地方（比如桌面），我们需要提供文件的完整路径。例如，文件在桌面上，我们需要指定它的**绝对路径**。

```java
import java.io.File;

public class Main {
    public static void main(String[] args) {
        // 使用绝对路径创建 File 对象
        File file = new File("C:/Users/YourName/Desktop/secret_message.txt");

        if (file.exists()) {
            System.out.println("That file exists! :)");
        } else {
            System.out.println("That file doesn't exist. :(");
        }
    }
}
```

注意：在 Windows 系统中，路径中的反斜杠 `\` 是一个转义字符，因此我们需要用双反斜杠 `\\` 或者使用正斜杠 `/`。

#### 常用方法

除了 `exists()` 方法，`File` 类还有一些非常有用的方法：

1. **getPath()**: 获取文件的路径（相对路径）。
2. **getAbsolutePath()**: 获取文件的绝对路径（完整路径）。
3. **isFile()**: 检查对象是否是文件（而不是目录）。
4. **delete()**: 删除文件。

#### 示例代码：获取文件路径、删除文件

```java
public class Main {
    public static void main(String[] args) {
        File file = new File("secret_message.txt");

        if (file.exists()) {
            System.out.println("File exists!");

            // 获取文件的相对路径
            System.out.println("Path: " + file.getPath());

            // 获取文件的绝对路径
            System.out.println("Absolute Path: " + file.getAbsolutePath());

            // 检查是否是文件
            System.out.println("Is file: " + file.isFile());

            // 删除文件
            file.delete();
            System.out.println("File deleted.");
        } else {
            System.out.println("File doesn't exist.");
        }
    }
}
```

#### 输出结果

如果文件存在，输出将类似于：

```plain
File exists!
Path: secret_message.txt
Absolute Path: C:/Users/YourName/Project/secret_message.txt
Is file: true
File deleted.
```

如果文件不存在，输出将是：

```plain
File doesn't exist.
```

#### 总结

- **File 类** 是 Java 中用于表示文件和目录路径名的类。
- 我们可以使用 `exists()` 方法来检查文件是否存在。
- **getPath()** 获取文件的相对路径，**getAbsolutePath()** 获取文件的绝对路径。
- 使用 **delete()** 方法可以删除文件。

这些是 `File` 类中一些常用的基础方法，还有许多其他的方法可以帮助我们更好地操作文件。
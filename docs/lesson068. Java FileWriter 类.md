# lesson068. Java FileWriter 类

`FileWriter` 类是 Java 中用于将数据写入文件的类。通过它，我们可以轻松地将文本写入文件，并且可以选择覆盖文件的内容或将新内容追加到文件末尾。

#### 创建 FileWriter 实例

要开始使用 `FileWriter`，首先我们需要创建一个 `FileWriter` 对象。我们可以在构造函数中指定目标文件的路径或文件名。如果文件不存在，`FileWriter` 会自动创建文件。

#### 示例代码：写入文件

```java
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // 使用 try-with-resources 来自动关闭 FileWriter
        try (FileWriter writer = new FileWriter("poem.txt")) {
            // 写入文件内容
            writer.write("Roses are red\n");
            writer.write("Violets are blue\n");
            writer.write("Booty, booty, booty, booty\n");
            writer.write("Rockin' everywhere\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

在这个例子中，我们使用 `FileWriter` 向 `poem.txt` 文件写入几行文本。如果 `poem.txt` 文件不存在，程序会自动创建它。每次运行程序时，文件中的内容将被覆盖。

#### 添加换行符

为了在文件中换行，我们使用换行符 `\n`。这会在写入的文本中插入一个新行。

```java
writer.write("Roses are red\n");
writer.write("Violets are blue\n");
```

#### 追加内容到文件

如果我们不想覆盖文件的内容，而是将新内容追加到现有文件的末尾，可以使用 `FileWriter` 的另一个构造函数，传入一个布尔值 `true` 来启用追加模式。

```java
try (FileWriter writer = new FileWriter("poem.txt", true)) {
    writer.write("\nA poem by bro");
}
```

在这个示例中，我们使用 `FileWriter("poem.txt", true)` 以追加模式打开 `poem.txt` 文件，并在文件末尾添加一行新的文本。

#### 示例代码：完整的写入与追加

```java
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // 写入文件
        try (FileWriter writer = new FileWriter("poem.txt")) {
            writer.write("Roses are red\n");
            writer.write("Violets are blue\n");
            writer.write("Booty, booty, booty, booty\n");
            writer.write("Rockin' everywhere\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 追加内容
        try (FileWriter writer = new FileWriter("poem.txt", true)) {
            writer.write("\nA poem by bro");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

#### 使用 `append()` 方法

`FileWriter` 还提供了 `append()` 方法，它可以直接向文件末尾追加文本。

```java
writer.append("\nA poem by bro");
```

#### 关闭 FileWriter

在完成写操作后，**始终需要关闭** `FileWriter`，以确保所有数据都被正确写入文件，并释放相关的资源。我们可以使用 `try-with-resources` 语法，它会自动关闭资源，确保即使发生异常，文件也会被正确关闭。

```java
try (FileWriter writer = new FileWriter("poem.txt")) {
    // 写入操作
} catch (IOException e) {
    e.printStackTrace();
}
```

#### 总结

- **FileWriter** 类用于将文本写入文件。
- 可以使用 `write()` 方法将文本写入文件，并使用 `\n` 添加换行符。
- 通过在 `FileWriter` 构造函数中传入 `true`，可以启用追加模式。
- 始终记得关闭 `FileWriter`，可以使用 `try-with-resources` 语句自动管理资源。


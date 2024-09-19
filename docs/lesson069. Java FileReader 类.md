# lesson069. Java FileReader 类

`FileReader` 类是 Java 中用于读取文件内容的类，它可以将文件中的内容作为字符流逐个字符地读取。使用 `FileReader` 类，我们可以轻松地从文件中读取数据并将其显示在控制台上。

#### 使用 FileReader 读取文件

我们通过 `FileReader` 类的 `read()` 方法来逐个读取文件中的字符。`read()` 方法返回一个整数值，该值是当前读取字符的字节值。当文件读取结束时，`read()` 方法返回 `-1`，表示文件结尾。

#### 示例代码：读取文件内容

```java
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // 使用 try-with-resources 来自动关闭 FileReader
        try (FileReader reader = new FileReader("art.txt")) {
            int data = reader.read(); // 读取第一个字符

            // 使用 while 循环逐个读取字符，直到文件结尾 (-1)
            while (data != -1) {
                // 将读取的字节值转换为字符并输出
                System.out.print((char) data);
                
                // 继续读取下一个字符
                data = reader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

在这个代码中，我们使用了 `FileReader` 逐个字符地读取文件 `art.txt` 的内容，并转换为字符后输出到控制台。

#### 逐个字符读取的逻辑

- `reader.read()`：读取文件中的一个字符，并返回其字节值。
- `-1`：当读取到文件末尾时，`read()` 方法返回 `-1`，这表示没有更多数据可读取。
- `System.out.print((char) data)`：将字节值强制转换为字符并打印到控制台。

#### 使用 ASCII 艺术示例

假设我们的文件 `art.txt` 包含以下 ASCII 艺术：

```plain
  /\_/\
 ( o.o )
  > ^ <
```

当运行上述程序时，控制台将输出该 ASCII 艺术。

#### 关闭 FileReader

在完成文件读取操作后，始终需要关闭 `FileReader`，以确保释放相关资源。我们可以使用 `try-with-resources` 语法来确保 `FileReader` 被正确关闭，即使在读取过程中发生异常。

```java
try (FileReader reader = new FileReader("art.txt")) {
    // 读取操作
} catch (IOException e) {
    e.printStackTrace();
}
```

#### 总结

- **FileReader** 类用于读取文件的内容，逐个字符读取。
- 使用 `read()` 方法来读取文件中的字符，当返回 `-1` 时表示文件读取完成。
- 始终记得关闭 `FileReader`，可以使用 `try-with-resources` 语句自动管理资源。
# lesson026. next() 与 nextLine()

在 Java 中，`Scanner` 类用于从输入流中读取数据。`Scanner` 的一些方法（如 `next()`、`nextLine()`）处理换行符的方式有所不同。具体而言，**是否在遇到换行符就结束读取**，取决于你使用的 `Scanner` 方法。

------

### **1.** `next()` **方法：**

- `next()` 方法用于读取输入中的**下一个标记（token）**，默认情况下，标记是由空白字符（包括空格、制表符、换行符等）分隔的**非空字符串**。
- 换行符、空格和其他空白字符只是用来分隔标记，它们不会被包含在返回的字符串中。

#### **行为：**

- 读取到空白字符（如空格、制表符、换行符）时，`next()` 方法会忽略它们，直到找到下一个非空的标记为止。
- 因此，`next()` **方法不会在遇到换行符时结束读取，而是在遇到下一个非空标记时继续读取**。

#### **示例：**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter some text:");

        // 使用 next() 读取下一个标记
        String word1 = scanner.next();
        String word2 = scanner.next();
        
        System.out.println("First word: " + word1);
        System.out.println("Second word: " + word2);
    }
}
```

假设你的输入是：

```plain
Hello World
```

输出将是：

```plain
First word: Hello
Second word: World
```

**注意：**

- `next()` 方法在遇到空格或换行时会跳过这些空白字符，并继续读取下一个标记。

------

### **2.** `nextLine()` **方法：**

- `nextLine()` 方法用于读取整行输入，会读取从当前位置到输入中的下一个换行符为止（包括空格和换行符之前的所有字符）。
- 读取后，光标会移动到**下一行**的开头。

#### **行为：**

- `nextLine()` **方法会在遇到换行符时结束读取，并返回整行的内容**。
- 换行符本身不会包含在返回的字符串中，但它会标志着读取的结束。

#### **示例：**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter some text:");

        // 使用 nextLine() 读取整行
        String line = scanner.nextLine();

        System.out.println("You entered: " + line);
    }
}
```

假设你的输入是：

```plain
Hello World
```

输出将是：

```plain
You entered: Hello World
```

**注意：**

- 当你按下 `Enter` 键时，`nextLine()` 会读取输入的整行文本，并返回该行的字符串。

------

### **3.** `next()` **与** `nextLine()` **的区别：**

- `next()`：读取到**空白字符（如空格、制表符或换行符）**时会停止，并返回一个单词（下一个标记），**会跳过换行符**。
- `nextLine()`：读取整行输入，直到遇到**换行符**，并返回该行的所有内容，**换行符标志结束**。

------

### **4. 一个常见问题：**`next()` **和** `nextLine()` **混用**

如果在使用 `next()` 或 `nextInt()` 之后紧接着使用 `nextLine()` 时，可能会出现一个问题，即 `nextLine()` 读取的只是之前输入的换行符，而不是新的输入。

#### **示例：**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer:");
        int num = scanner.nextInt();

        // 现在尝试读取一行文本
        System.out.println("Enter some text:");
        String text = scanner.nextLine();

        System.out.println("Number: " + num);
        System.out.println("Text: " + text);
    }
}
```

假设输入：

```plain
5
Hello World
```

输出将是：

```plain
Number: 5
Text: 
```

**原因：**

- 当你输入 `5` 并按下 `Enter` 时，`nextInt()` 只读取了数字 `5`，但是**换行符** `\n` **仍然留在输入缓冲区中**。
- 当 `nextLine()` 被调用时，它会直接读取这个换行符，导致返回一个空字符串。

#### **解决方法：**

在调用 `nextLine()` 之前，可以添加一个额外的 `nextLine()` 来消耗掉输入缓冲区中的换行符。

#### **修正后的代码：**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer:");
        int num = scanner.nextInt();

        // 消耗掉换行符
        scanner.nextLine();

        // 现在读取一行文本
        System.out.println("Enter some text:");
        String text = scanner.nextLine();

        System.out.println("Number: " + num);
        System.out.println("Text: " + text);
    }
}
```

现在，如果你输入：

```plain
5
Hello World
```

输出将是：

```plain
Number: 5
Text: Hello World
```

------

### **5. 小结**

- `next()`：会读取下一个标记（token），在遇到空白字符（如空格、换行符）时结束读取，但不会包含空白字符。
- `nextLine()`：会读取整行，在输入中遇到换行符时结束，并返回该行的所有内容（不包含换行符）。

当在 `next()` 或 `nextInt()` 之后使用 `nextLine()` 时，需要特别注意输入缓冲区中的换行符问题，通常可以用一个额外的 `nextLine()` 来消耗掉换行符。
# lesson038. Java 中 String 类的常用方法

在 Java 中，`String` 是一种引用数据类型，用于存储字符序列。`String` 类提供了许多有用的方法，帮助我们操作和处理字符串。在这一章节中，我们将介绍一些常用的 `String` 方法，并解释它们的用途。

------

#### 1. `equalsIgnoreCase()` 方法

`equalsIgnoreCase(String anotherString)` 用于比较两个字符串的内容是否相等，**忽略大小写**。

```java
String name = "Bro";
boolean result = name.equalsIgnoreCase("bro");
System.out.println(result);  // 输出: true
```

- 如果字符串 `name` 和 `"bro"` 相等（忽略大小写），则返回 `true`，否则返回 `false`。

------

#### 2. `length()` 方法

`length()` 方法返回字符串的长度，也就是字符串中字符的数量。

```java
String name = "Bro";
int length = name.length();
System.out.println(length);  // 输出: 3
```

- 这里，`"Bro"` 的长度为 3，因为它包含 3 个字符。

------

#### 3. `charAt()` 方法

`charAt(int index)` 方法返回字符串中指定索引位置的字符。索引从 `0` 开始。

```java
String name = "Bro";
char firstChar = name.charAt(0);
System.out.println(firstChar);  // 输出: B
```

- 这里，`name.charAt(0)` 返回的是字符串 `name` 的第一个字符，即 `'B'`。

------

#### 4. `indexOf()` 方法

`indexOf(String str)` 方法返回第一次出现指定子字符串的位置索引。如果找不到子字符串，则返回 `-1`。

```java
String name = "Bro";
int index = name.indexOf("o");
System.out.println(index);  // 输出: 2
```

- 这里，`"o"` 在字符串 `"Bro"` 中的索引为 2，因为索引从 0 开始。

------

#### 5. `isEmpty()` 方法

`isEmpty()` 方法用于检查字符串是否为空。如果字符串的长度为 0，则返回 `true`，否则返回 `false`。

```java
String name = "";
boolean isEmpty = name.isEmpty();
System.out.println(isEmpty);  // 输出: true
```

- 这里，因为 `name` 是空字符串，所以 `isEmpty()` 返回 `true`。

------

#### 6. `toUpperCase()` 和 `toLowerCase()` 方法

- `toUpperCase()` 方法将字符串转换为大写字母。
- `toLowerCase()` 方法将字符串转换为小写字母。

```java
String name = "Bro";
String upper = name.toUpperCase();
String lower = name.toLowerCase();
System.out.println(upper);  // 输出: BRO
System.out.println(lower);  // 输出: bro
```

------

#### 7. `trim()` 方法

`trim()` 方法去除字符串两端的空格，但不影响中间的空格。

```java
String name = "  Bro  ";
String trimmed = name.trim();
System.out.println(trimmed);  // 输出: "Bro"
```

- 这里，`trim()` 去除了字符串 `"  Bro  "` 两端的空格，返回 `"Bro"`。

------

#### 8. `replace()` 方法

`replace(char oldChar, char newChar)` 方法将字符串中的某个字符替换为另一个字符。

```java
String name = "Bro";
String replaced = name.replace('o', 'a');
System.out.println(replaced);  // 输出: "Bra"
```

- 这里，`replace('o', 'a')` 将字符串中的 `'o'` 替换为 `'a'`，返回 `"Bra"`。

------

### 示例代码

以下是一个示例程序，它展示了如何使用上面提到的所有 `String` 方法：

```java
public class Main {
    public static void main(String[] args) {
        // 创建一个字符串
        String name = "Bro";

        // 1. 比较字符串，忽略大小写
        boolean equalsIgnoreCaseResult = name.equalsIgnoreCase("bro");
        System.out.println("equalsIgnoreCase: " + equalsIgnoreCaseResult);

        // 2. 获取字符串的长度
        int length = name.length();
        System.out.println("Length: " + length);

        // 3. 获取字符串的第一个字符
        char firstChar = name.charAt(0);
        System.out.println("First character: " + firstChar);

        // 4. 找到子字符串的索引
        int indexOfO = name.indexOf("o");
        System.out.println("Index of 'o': " + indexOfO);

        // 5. 检查字符串是否为空
        boolean isEmpty = name.isEmpty();
        System.out.println("Is empty: " + isEmpty);

        // 6. 转换为大写和小写
        String upper = name.toUpperCase();
        String lower = name.toLowerCase();
        System.out.println("Uppercase: " + upper);
        System.out.println("Lowercase: " + lower);

        // 7. 去除字符串两端的空格
        String trimmed = name.trim();
        System.out.println("Trimmed: " + trimmed);

        // 8. 替换字符
        String replaced = name.replace('o', 'a');
        System.out.println("Replaced 'o' with 'a': " + replaced);
    }
}
```

------

### 输出结果

当运行上述代码时，输出将是：

```plain
equalsIgnoreCase: true
Length: 3
First character: B
Index of 'o': 2
Is empty: false
Uppercase: BRO
Lowercase: bro
Trimmed: Bro
Replaced 'o' with 'a': Bra
```

------

### 总结

- Java 中的 `String` 类提供了丰富的工具来操作字符串。我们可以进行比较、提取子字符串、转换大小写、替换字符等操作。
- 这些方法使得处理文本数据更加方便和高效。
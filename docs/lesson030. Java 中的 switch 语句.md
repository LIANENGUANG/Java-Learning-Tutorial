# lesson030. Java 中的 switch 语句

在 Java 中，`switch` **语句** 是一种多分支控制结构，允许你根据变量的值选择执行不同的代码块。相较于多重的 `if-else` 语句，`switch` 语句在处理多个条件时可以让代码更加清晰和简洁。

------

#### 1. `switch` 语句的基本语法

```java
switch (expression) {
    case value1:
        // 当 expression 的值等于 value1 时执行的代码
        break;  // 结束此 case
    case value2:
        // 当 expression 的值等于 value2 时执行的代码
        break;  // 结束此 case
    // 可以有任意多个 case 语句
    default:
        // 如果没有匹配的 case，执行此处的代码
        break;
}
```

- `expression`：需要判断的表达式，通常是 `int`、`char`、`String` 或枚举类型。
- `case` **语句**：每个 `case` 语句后跟一个值，当 `expression` 的值与该值匹配时，执行对应的代码。
- `break`：在每个 `case` 块后通常会使用 `break` 语句来终止 `switch` 语句。如果没有 `break`，程序会继续执行下一个 `case` 块的代码（即"贯穿"现象）。
- `default`：可选，用于处理所有没有匹配 `case` 的情况。

------

#### 2. 示例：使用整数的 `switch` 语句

```java
public class Main {
    public static void main(String[] args) {
        int day = 3;

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day");
                break;
        }
    }
}
```

#### 输出：

```plain
Wednesday
```

**解释**：

- 当 `day` 的值为 `3` 时，程序找到 `case 3`，并输出 `"Wednesday"`，然后遇到 `break`，结束 `switch` 语句的执行。

------

#### 3. 示例：使用字符串的 `switch` 语句

从 Java 7 版本开始，`switch` 语句支持 `String` 类型。下面是一个基于 `String` 类型的 `switch` 示例：

```java
public class Main {
    public static void main(String[] args) {
        String fruit = "Apple";

        switch (fruit) {
            case "Apple":
                System.out.println("You chose Apple.");
                break;
            case "Banana":
                System.out.println("You chose Banana.");
                break;
            case "Cherry":
                System.out.println("You chose Cherry.");
                break;
            default:
                System.out.println("Unknown fruit.");
                break;
        }
    }
}
```

#### 输出：

```plain
You chose Apple.
```

------

#### 4. `switch` 语句中的 `break` 和 "贯穿"现象

如果在 `case` 语句中不使用 `break`，程序会继续执行下一个 `case`，这被称为**"贯穿"**。通常我们会使用 `break` 来防止这种情况，但有时有意为之可以实现某些特殊的逻辑。

##### 示例：没有 `break` 的情况

```java
int day = 2;

switch (day) {
    case 1:
        System.out.println("Monday");
    case 2:
        System.out.println("Tuesday");
    case 3:
        System.out.println("Wednesday");
    default:
        System.out.println("Invalid day");
}
```

#### 输出：

```plain
Tuesday
Wednesday
Invalid day
```

**解释**：

- 由于 `case 2` 中没有 `break`，程序会继续执行 `case 3` 和 `default`，导致多个语句被执行。

------

#### 5. `default` 分支

`default` 分支在 `switch` 语句中是可选的。它用于处理所有没有匹配 `case` 的情况。如果没有匹配的 `case`，并且没有 `default`，`switch` 语句将不执行任何操作。

##### 示例：使用 `default`

```java
int day = 8;

switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    default:
        System.out.println("Invalid day");
        break;
}
```

#### 输出：

```plain
Invalid day
```

如果 `day` 不是 `1` 或 `2`，则会执行 `default` 分支。

------

#### 6. 多个 `case` 处理相同的逻辑

有时我们希望多个 `case` 共享相同的代码逻辑。可以将这些 `case` 语句放在一起，所有这些 `case` 语句都可以执行同一个代码块。

##### 示例：多个 `case` 共享同一代码块

```java
int month = 7;

switch (month) {
    case 12:
    case 1:
    case 2:
        System.out.println("Winter");
        break;
    case 3:
    case 4:
    case 5:
        System.out.println("Spring");
        break;
    case 6:
    case 7:
    case 8:
        System.out.println("Summer");
        break;
    case 9:
    case 10:
    case 11:
        System.out.println("Fall");
        break;
    default:
        System.out.println("Invalid month");
        break;
}
```

#### 输出：

```plain
Summer
```

**解释**：

- `case 6`、`case 7` 和 `case 8` 都会执行 `"Summer"` 这一代码块。

------

#### 7. `switch` 表达式（Java 12+）

从 **Java 12** 开始，`switch` 语句引入了新的增强版本，称为**`switch` 表达式**。它可以返回值，也不再需要 `break` 语句。这个特性在 Java 12 作为预览功能引入，并在 Java 14 正式发布。

##### 示例：`switch` 表达式

```java
int month = 7;
String season = switch (month) {
    case 12, 1, 2 -> "Winter";
    case 3, 4, 5 -> "Spring";
    case 6, 7, 8 -> "Summer";
    case 9, 10, 11 -> "Fall";
    default -> "Invalid month";
};

System.out.println(season);
```

#### 输出：

```plain
Summer
```

**解释**：

- 在这个例子中，`switch` 表达式返回一个值，并通过 `->` 简写箭头语法来简化代码。
- 你可以使用多个 `case` 值，并用逗号分隔。

------

#### 8. 总结

- `switch` **语句** 是一种多分支的条件控制结构，允许根据变量的值执行不同的代码块。
- 每个 `case` 分支后通常需要 `break` 来防止"贯穿"到下一个 `case`。
- `default` 用于处理所有没有匹配的 `case`，是可选的。
- 从 Java 7 开始，`switch` 支持 `String` 类型。
- Java 12 引入了新的 `switch` **表达式**，让代码更简洁并且可以返回值。

`switch` 语句和表达式是处理多重条件判断时非常有用的工具，尤其在处理多个相同逻辑的分支时，可以使代码更加简洁和清晰。
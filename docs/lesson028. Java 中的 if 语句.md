# lesson028. Java 中的 if 语句

在 Java 中，`if` **语句** 是最常见的分支控制结构之一，用于根据条件的真假来执行不同的代码片段。`if` 语句的基本语法如下：

```java
if (condition) {
    // 当 condition 为 true 时执行的代码
}
```

------

#### 1. 基本语法与示例

`if` 语句会检查括号中的条件表达式。如果条件为 `true`，则执行大括号 `{}` 内的代码块；如果条件为 `false`，则跳过该代码块。

```java
int age = 20;

if (age >= 18) {
    System.out.println("You are an adult.");
}
```

在上面的示例中，`age` 的值为 `20`，条件 `age >= 18` 为 `true`，因此会输出 `"You are an adult."`。

------

#### 2. `else` 语句

`else` 语句可以与 `if` 语句一起使用，用于在条件为 `false` 时执行其他代码。

```java
int age = 16;

if (age >= 18) {
    System.out.println("You are an adult.");
} else {
    System.out.println("You are not an adult.");
}
```

在这个例子中，`age` 的值为 `16`，条件 `age >= 18` 为 `false`，因此会输出 `"You are not an adult."`。

------

#### 3. `else if` 语句

当有多个条件需要判断时，可以使用 `else if` 语句。`else if` 用于在前面的条件为 `false` 时，继续检查其他条件。

```java
int age = 16;

if (age >= 18) {
    System.out.println("You are an adult.");
} else if (age >= 13) {
    System.out.println("You are a teenager.");
} else {
    System.out.println("You are a child.");
}
```

在这个例子中，`age` 的值为 `16`，第一个条件 `age >= 18` 为 `false`，因此执行第二个条件 `age >= 13`，输出 `"You are a teenager."`。

------

#### 4. 嵌套的 `if` 语句

在一个 `if` 或 `else` 语句中还可以嵌套另一个 `if` 语句，用于更复杂的条件判断。

```java
int age = 20;
boolean hasID = true;

if (age >= 18) {
    if (hasID) {
        System.out.println("You can enter.");
    } else {
        System.out.println("You need an ID to enter.");
    }
} else {
    System.out.println("You are not old enough to enter.");
}
```

在这个例子中，首先检查 `age >= 18`，如果为 `true`，则进一步检查是否有身份证 `hasID`，然后分别输出不同的信息。

------

#### 5. `if` 语句的注意事项

- **大括号** `{}` **的使用**：如果 `if` 或 `else` 语句中的代码块只有一行代码，Java 允许省略大括号。但为了代码的可读性和避免错误，建议始终使用大括号。

```java
if (age >= 18)
    System.out.println("You are an adult.");
```

- **条件表达式**：`if` 语句中的条件必须是一个布尔表达式，或者能返回 `true` 或 `false` 的值。

------

#### 6. 总结

- `if` 语句：用于检查条件是否为真，为真时执行代码块。
- `else` 语句：用于在条件为假时执行另一段代码。
- `else if` 语句：用于处理多个条件判断。
- 嵌套的 `if`：允许在 `if` 中包含另一个 `if`，解决更复杂的逻辑。

`if` 语句是 Java 中最基础的条件控制结构之一，它允许我们根据不同的条件执行不同的代码逻辑，在编写逻辑判断时非常有用。
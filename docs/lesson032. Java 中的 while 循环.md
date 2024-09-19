# lesson032. Java 中的 while 循环

在 Java 中，`while` **循环**是一种控制结构，用于重复执行某段代码，**只要指定的条件为** `true`。当条件为 `false` 时，循环终止，程序继续执行循环后的代码。

------

#### 1. `while` 循环的基本语法

```java
while (condition) {
    // 循环体：当 condition 为 true 时重复执行的代码块
}
```

- `condition`：这是一个布尔表达式。只要 `condition` 的结果为 `true`，循环体中的代码就会反复执行。
- **循环体**：在大括号 `{}` 内的代码块，将在每次循环迭代时执行。

------

#### 2. 示例：无限循环

在图片中的代码展示了一个**无限循环**的示例：

```java
while (1 == 1) {
    System.out.println("Help, I'm stuck in a while loop");
}
```

**解释**：

- `1 == 1` 永远为 `true`，因此这个 `while` 循环会一直执行，持续输出 `"Help, I'm stuck in a while loop"`。
- 这是一个典型的**无限循环**，因为条件永远不会变为 `false`，所以循环永远不会停止。

##### 无限循环的输出（控制台）：

```plain
Help, I'm stuck in a while loop
Help, I'm stuck in a while loop
Help, I'm stuck in a while loop
...
```

------

#### 3. 如何避免无限循环

为了避免无限循环，在循环体中通常需要**修改条件变量**，使得循环能够在某个时刻结束。

##### 示例：有限循环

```java
int counter = 0;

while (counter < 5) {
    System.out.println("Counter is: " + counter);
    counter++;  // 每次循环后递增 counter
}
```

**解释**：

- 循环条件为 `counter < 5`，当 `counter` 小于 5 时，循环会继续执行。
- 每次循环后，`counter` 的值递增 1，最终使得 `counter` 不再小于 5，循环结束。

**输出**：

```plain
Counter is: 0
Counter is: 1
Counter is: 2
Counter is: 3
Counter is: 4
```

------

#### 4. `while` 循环的使用场景

`while` 循环通常用于：

- **不确定循环次数**的场景：当我们不知道具体的循环次数，但知道某个条件满足时需要重复执行某些操作。
- **等待用户输入**：例如等待用户输入正确的值。
- **处理流数据**：如从文件或网络流中读取数据，直到文件结束或网络断开。

------

#### 5. `while` 循环的注意事项

- **无限循环**：确保循环条件最终会变为 `false`，否则循环将永远不会终止，导致程序卡死。
- **条件检查**：`while` 循环在执行循环体之前，会先检查条件。如果初始条件为 `false`，则循环体**一次也不会执行**。

##### 示例：条件为 `false` 时

```java
int counter = 10;

while (counter < 5) {
    System.out.println("This will never be printed.");
}
```

**解释**：

- 由于 `counter` 的初始值为 10，而 `counter < 5` 为 `false`，所以循环体根本不会执行。

------

#### 6. 总结

- `while` **循环** 适用于在条件满足时反复执行某些操作。
- 请确保循环条件最终会变为 `false`，以避免无限循环。
- 如果条件一开始为 `false`，循环体将不会执行。

`while` 循环是 Java 中重要的控制结构之一，尤其适用于循环次数不确定的场景。理解 `while` 循环的工作原理和如何正确使用它，将帮助你编写更加高效和灵活的代码。
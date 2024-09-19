# lesson033. Java 中的 do-while 循环

在 Java 中，`do-while` **循环** 是一种控制结构，与 `while` 循环类似，但有一个非常重要的区别：**无论条件是否为** `true`**，**`do-while` **循环的代码块会至少执行一次**。这是因为条件判断是在循环体执行之后进行的。

------

#### 1. `do-while` 循环的基本语法

```java
do {
    // 循环体：至少执行一次的代码块
} while (condition);
```

- **循环体**：在 `do` 块中包含的代码会**至少执行一次**。
- `condition`：这是一个布尔表达式。每次执行完循环体后，才会对条件进行判断。如果 `condition` 为 `true`，则继续执行循环；如果为 `false`，则终止循环。

------

#### 2. `do-while` 与 `while` 的区别

- 在 `while` **循环** 中，条件是在循环体执行之前检查的，如果条件一开始就是 `false`，循环体一次也不会执行。
- 在 `do-while` **循环** 中，循环体会**至少执行一次**，然后再检查条件。

------

#### 3. 示例：`do-while` 循环的基本用法

```java
int counter = 0;

do {
    System.out.println("Counter is: " + counter);
    counter++;
} while (counter < 5);
```

**解释**：

- `counter` 的初始值为 0，循环体首先执行一次，输出 `"Counter is: 0"`。
- 然后 `counter++`，使 `counter` 变为 1，再次检查条件 `counter < 5`，由于条件为 `true`，循环继续执行，直到 `counter` 达到 5。

**输出**：

```plain
Counter is: 0
Counter is: 1
Counter is: 2
Counter is: 3
Counter is: 4
```

------

#### 4. 保证至少执行一次的特性

`do-while` **循环**的一个重要特性就是，**即使条件一开始为** `false`**，循环体也会被执行一次**。这在某些场景下非常有用，比如在等待用户输入时，或者需要先执行某些初始化操作再进行条件检查。

##### 示例：条件一开始为 `false`

```java
int counter = 10;

do {
    System.out.println("This will be printed once.");
} while (counter < 5);
```

**解释**：

- 在这个例子中，`counter` 的初始值为 10，而 `counter < 5` 为 `false`，但由于 `do-while` 的特性，循环体仍然会被执行一次，输出 `"This will be printed once."`，然后循环终止。

**输出**：

```plain
This will be printed once.
```

------

#### 5. `do-while` 的使用场景

`do-while` 循环通常用于以下场景：

- **用户输入验证**：当你需要至少提示用户输入一次，并在条件满足时重复要求输入。
- **初始化操作**：当代码块需要执行一次以处理初始状态，然后根据条件决定是否继续执行。
- **菜单操作**：在程序中实现循环菜单，用户必须至少看到一次菜单选项。

##### 示例：用户输入验证

```java
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);
int number;

do {
    System.out.println("Enter a number greater than 10: ");
    number = scanner.nextInt();
} while (number <= 10);

System.out.println("Thank you! You entered: " + number);
```

**解释**：

- 用户被要求输入一个大于 10 的数字，`do-while` 循环保证至少询问一次，直到用户输入符合条件的数字。

------

#### 6. 总结

- `do-while` 循环与 `while` 循环的最大区别在于：`do-while` **保证循环体至少执行一次**，即使条件最初为 `false`。
- `do-while` 用于在循环之前需要执行某些操作的场景，例如用户输入或初始化。
- **语法结构**是：先执行 `do` 块中的代码，然后再检查 `while` 后面的条件。

`do-while` 循环可以确保某些操作至少执行一次，这个特性使它在某些场景下比 `while` 循环更合适。
# lesson035. Java 中的嵌套循环（Nested Loops）

在 Java 中，**嵌套循环**指的是一个循环体内再包含另一个循环。也就是说，在一个循环的代码块中，再次定义并执行另一个循环。嵌套循环可以用于处理多维数组、打印复杂的图案或进行更复杂的计算。

------

#### 1. 嵌套循环的定义

```java
for (initialization; condition; update) {
    // 外层循环体
    for (initialization; condition; update) {
        // 内层循环体
    }
}
```

- **外层循环**：控制整个嵌套循环的总体迭代次数。
- **内层循环**：每次外层循环迭代时，内层循环都会完整执行一遍。

------

#### 2. 示例：嵌套的 `for` 循环

```java
for (int i = 1; i <= 3; i++) {  // 外层循环
    for (int j = 1; j <= 3; j++) {  // 内层循环
        System.out.println("i = " + i + ", j = " + j);
    }
}
```

**解释**：

- **外层循环**：`i` 的取值从 1 到 3，循环执行 3 次。
- **内层循环**：每次外层循环执行时，内层循环都会从 1 到 3，再次执行 3 次。
- 因此，内层循环每次都会在外层循环的每次迭代中完整执行。

**输出**：

```plain
i = 1, j = 1
i = 1, j = 2
i = 1, j = 3
i = 2, j = 1
i = 2, j = 2
i = 2, j = 3
i = 3, j = 1
i = 3, j = 2
i = 3, j = 3
```

------

#### 3. 使用嵌套循环打印图案

嵌套循环通常用于打印复杂的图案，例如矩形、三角形等。

##### 示例：打印矩形

```java
for (int i = 1; i <= 4; i++) {  // 外层循环控制行数
    for (int j = 1; j <= 5; j++) {  // 内层循环控制列数
        System.out.print("* ");
    }
    System.out.println();  // 每打印完一行后换行
}
```

**输出**：

```plain
* * * * * 
* * * * * 
* * * * * 
* * * * *
```

------

#### 4. 多层嵌套循环

嵌套循环不仅限于两层，还可以嵌套更多的循环，不过过多的嵌套会使代码复杂度增加，通常不建议超过 2-3 层。

##### 示例：三层嵌套循环

```java
for (int i = 1; i <= 2; i++) {
    for (int j = 1; j <= 2; j++) {
        for (int k = 1; k <= 2; k++) {
            System.out.println("i = " + i + ", j = " + j + ", k = " + k);
        }
    }
}
```

**输出**：

```plain
i = 1, j = 1, k = 1
i = 1, j = 1, k = 2
i = 1, j = 2, k = 1
i = 1, j = 2, k = 2
i = 2, j = 1, k = 1
i = 2, j = 1, k = 2
i = 2, j = 2, k = 1
i = 2, j = 2, k = 2
```

------

#### 5. 嵌套循环的使用场景

嵌套循环在以下场景中非常有用：

- **二维数组的处理**：遍历数组的每一行和每一列。
- **打印图案**：例如矩形、三角形等。
- **组合问题**：例如生成所有可能的排列组合。
- **矩阵计算**：例如矩阵乘法。

------

#### 6. 嵌套循环的性能考虑

需要注意的是，嵌套循环的复杂度会随层数增加而迅速增长。例如，两个嵌套的 `for` 循环的复杂度是 O(n²)，三层嵌套的循环复杂度是 O(n³)。这会对大规模数据处理的性能产生一定影响。因此，在使用嵌套循环时要注意优化和控制循环层数。

------

#### 7. 总结

- **嵌套循环** 是指一个循环体内包含另一个循环。外层循环每执行一次，内层循环都会完整执行一遍。
- 嵌套循环通常用于处理多维数组、打印图案或解决组合问题。
- 虽然嵌套循环非常强大，但要避免过多的嵌套，因为这会导致代码复杂度和运行时间急剧增加。

嵌套循环是编写复杂逻辑的一种常见方式，但在使用时要结合具体应用场景，合理设计循环层次和逻辑。



```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 创建 Scanner 对象用于接收用户输入
        Scanner scanner = new Scanner(System.in);

        // 变量声明：行数、列数和符号
        int rows;
        int columns;
        String symbol;

        // 获取用户输入的行数
        System.out.println("Enter # of rows: ");
        rows = scanner.nextInt();

        // 获取用户输入的列数
        System.out.println("Enter # of columns: ");
        columns = scanner.nextInt();

        // 获取用户输入的符号
        System.out.println("Enter symbol to use: ");
        symbol = scanner.next();

        // 使用嵌套循环打印矩形
        for (int i = 1; i <= rows; i++) {  // 外层循环控制行
            for (int j = 1; j <= columns; j++) {  // 内层循环控制列
                System.out.print(symbol + " ");
            }
            System.out.println();  // 每打印完一行换行
        }
    }
}
```
# lesson021. Java 表达式、操作数与运算符

在编程中，**表达式（Expression）** 是程序的基础，它们允许我们执行计算、条件判断以及操作各种数据类型。在 Java 中，表达式由 **操作数（Operands）** 和 **运算符（Operators）** 组成。

------

### **1. 表达式 (Expression)**

**表达式** 是由**操作数**和**运算符**组成的一个计算式，能够生成一个值。例如：

```java
int result = 5 + 3;  // 5 + 3 是一个表达式，结果为 8
```

在这个例子中，`5 + 3` 是一个表达式，它会产生一个值 `8`。

------

### **2. 操作数 (Operands)**

**操作数** 是表达式中的数据或变量，它们是运算符进行操作的对象。操作数可以是：

- **常量/字面量**：如 `5`, `10.5`, `'A'` 等。
- **变量**：如 `x`, `y`, `name` 等。
- **表达式的结果**：如 `a + b`，这是两个操作数的运算结果。

例如：

```java
int a = 5;
int b = 10;
int sum = a + b;  // a 和 b 是操作数
```

在 `a + b` 中，`a` 和 `b` 是操作数，它们是运算符 `+` 操作的对象。

------

### **3. 运算符 (Operators)**

**运算符** 是用于对操作数进行操作的符号，它们可以进行各种计算、赋值和比较等操作。常见的运算符包括：

#### **算术运算符 (Arithmetic Operators)**

- `+`：加法
- `-`：减法
- `*`：乘法
- `/`：除法
- `%`：取模（求余数）

#### **赋值运算符 (Assignment Operators)**

- `=`：赋值运算符，将右边的值赋给左边的变量。
- `+=`：加并赋值运算符，例如：`x += 5` 等价于 `x = x + 5`。
- `-=`：减并赋值运算符，例如：`x -= 3` 等价于 `x = x - 3`。

#### **比较运算符 (Comparison Operators)**

- `==`：等于
- `!=`：不等于
- `>`：大于
- `<`：小于
- `>=`：大于等于
- `<=`：小于等于

#### **逻辑运算符 (Logical Operators)**

- `&&`：逻辑 AND（并且）
- `||`：逻辑 OR（或者）
- `!`：逻辑 NOT（非）

------

### **4. 示例代码**

下面的代码展示了使用不同运算符组成的表达式：

```java
public class Main {
    public static void main(String[] args) {
        // 操作数
        int a = 10;
        int b = 20;

        // 算术运算符
        int sum = a + b;     // 加法
        int diff = b - a;    // 减法
        int product = a * b; // 乘法
        int quotient = b / a; // 除法
        int remainder = b % a; // 取模

        // 输出结果
        System.out.println("Sum: " + sum);         // 输出 30
        System.out.println("Difference: " + diff); // 输出 10
        System.out.println("Product: " + product); // 输出 200
        System.out.println("Quotient: " + quotient); // 输出 2
        System.out.println("Remainder: " + remainder); // 输出 0

        // 比较运算符
        boolean isEqual = (a == b); // 比较 a 和 b 是否相等
        System.out.println("Is a equal to b? " + isEqual); // 输出 false

        // 逻辑运算符
        boolean result = (a < b) && (a > 5); // 逻辑 AND
        System.out.println("Logical AND result: " + result); // 输出 true
    }
}
```

#### **输出结果:**

```latex
Sum: 30
Difference: 10
Product: 200
Quotient: 2
Remainder: 0
Is a equal to b? false
Logical AND result: true
```

------

### **5. 运算符的优先级**

运算符有优先级，有些运算符会比其他运算符先执行。优先级从高到低如下：

1. **括号**：`()`，例如 `(a + b)`
2. **一元运算符**：`+`（正），`-`（负），`++`，`--`，`!`
3. **算术运算符**：`*`，`/`，`%` 高于 `+`，`-`
4. **比较运算符**：`<`，`>`，`<=`，`>=`
5. **相等运算符**：`==`，`!=`
6. **逻辑运算符**：`&&` 高于 `||`
7. **赋值运算符**：`=`，`+=`，`-=`，`*=`

例如：

```java
int result = 5 + 3 * 2;  // 结果是 11，因为乘法优先于加法
```

这里，`3 * 2` 会先执行，然后再加上 `5`，结果为 `11`。

------

### **6. 小结**

- **表达式** 是由操作数和运算符组成的，它们用于计算或判断。
- **操作数** 是运算符操作的对象，通常是变量、常量或表达式的结果。
- **运算符** 用于操作操作数，常见的有算术运算符、赋值运算符、比较运算符和逻辑运算符。
- **运算符的优先级** 决定了表达式中运算的先后顺序，括号可以用来改变默认的优先级。

掌握表达式和运算符是编写有效 Java 程序的基础，通过了解它们的行为，你可以更好地控制数据流和程序逻辑。
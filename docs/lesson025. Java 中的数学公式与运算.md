# lesson025. Java 中的数学公式与运算

在 Java 编程语言中，数学运算是非常常见的需求。Java 提供了丰富的数学运算功能，通过内置的 `Math` **类** 可以方便地进行各种数学计算。`Math` 类中包含常见的数学函数、常量和工具方法，能够帮助我们实现多种数学公式。

本章将介绍 Java 中常用的数学运算、数学公式和 `Math` 类的具体使用。

------

### **1.** `Math` **类简介**

`Math` 类是 Java 中专门用于进行数学运算的类，位于 `java.lang` 包中，因此可以直接使用，无需导入。

------

### **2. 常量**

`Math` 类中定义了两个常数：

- `Math.PI`：圆周率常数，约等于 `3.14159`。
- `Math.E`：自然对数的底数，约等于 `2.71828`。

#### **示例：**

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Value of PI: " + Math.PI);
        System.out.println("Value of E: " + Math.E);
    }
}
```

#### **输出：**

```plain
Value of PI: 3.141592653589793
Value of E: 2.718281828459045
```

------

### **3. 基本算术运算**

除了基本的加（`+`）、减（`-`）、乘（`*`）、除（`/`）等运算，`Math` 类还提供了更多的数学方法。

#### **常用方法：**

- `Math.abs(x)`：返回 `x` 的绝对值。
- `Math.max(a, b)`：返回 `a` 和 `b` 中的较大值。
- `Math.min(a, b)`：返回 `a` 和 `b` 中的较小值。
- `Math.pow(a, b)`：返回 `a` 的 `b` 次幂。
- `Math.sqrt(x)`：返回 `x` 的平方根。
- `Math.cbrt(x)`：返回 `x` 的立方根。
- `Math.round(x)`：返回 `x` 四舍五入后的值。

#### **示例：**

```java
public class Main {
    public static void main(String[] args) {
        int a = -10;
        double b = 25.0;

        System.out.println("Absolute value of a: " + Math.abs(a)); // 10
        System.out.println("Square root of b: " + Math.sqrt(b));   // 5.0
        System.out.println("2 to the power of 3: " + Math.pow(2, 3)); // 8.0
        System.out.println("Max of 10 and 20: " + Math.max(10, 20));  // 20
        System.out.println("Min of 10 and 20: " + Math.min(10, 20));  // 10
    }
}
```

#### **输出：**

```plain
Absolute value of a: 10
Square root of b: 5.0
2 to the power of 3: 8.0
Max of 10 and 20: 20
Min of 10 and 20: 10
```

------

### **4. 三角函数**

Java 提供了常见的三角函数方法，输入的参数是弧度（radians），而不是角度。如果需要使用角度，可以使用 `Math.toRadians()` 方法将角度转换为弧度。

#### **常用方法：**

- `Math.sin(x)`：计算 `x` 弧度的正弦值。
- `Math.cos(x)`：计算 `x` 弧度的余弦值。
- `Math.tan(x)`：计算 `x` 弧度的正切值。
- `Math.toRadians(degrees)`：将角度转换为弧度。
- `Math.toDegrees(radians)`：将弧度转换为角度。

#### **示例：**

```java
public class Main {
    public static void main(String[] args) {
        double angleDegrees = 45.0;
        double angleRadians = Math.toRadians(angleDegrees);

        System.out.println("Sin of 45 degrees: " + Math.sin(angleRadians)); // 0.7071
        System.out.println("Cos of 45 degrees: " + Math.cos(angleRadians)); // 0.7071
        System.out.println("Tan of 45 degrees: " + Math.tan(angleRadians)); // 1.0

        // 将弧度转换为角度
        double radians = Math.PI / 4;
        System.out.println("Radians to degrees: " + Math.toDegrees(radians)); // 45.0
    }
}
```

#### **输出：**

```plain
Sin of 45 degrees: 0.7071067811865475
Cos of 45 degrees: 0.7071067811865476
Tan of 45 degrees: 0.9999999999999999
Radians to degrees: 45.0
```

------

### **5. 对数与指数运算**

Java 还提供了计算对数与指数的功能：

#### **常用方法：**

- `Math.log(x)`：返回 `x` 的自然对数（以 `e` 为底）。
- `Math.log10(x)`：返回 `x` 的以 10 为底的对数。
- `Math.exp(x)`：返回 `e` 的 `x` 次幂。

#### **示例：**

```java
public class Main {
    public static void main(String[] args) {
        double num = 10.0;

        System.out.println("Natural log of num: " + Math.log(num));   // ln(10)
        System.out.println("Log base 10 of num: " + Math.log10(num)); // log10(10)
        System.out.println("e raised to the power of 2: " + Math.exp(2)); // e^2
    }
}
```

#### **输出：**

```plain
Natural log of num: 2.302585092994046
Log base 10 of num: 1.0
e raised to the power of 2: 7.38905609893065
```

------

### **6. 随机数生成**

`Math` 类提供了生成随机数的方法：

- `Math.random()`：生成一个介于 `0.0`（包含）和 `1.0`（不包含）之间的伪随机数。

如果需要生成一定范围内的随机数，可以对生成的随机数进行缩放和位移：

#### **示例：生成 0 到 100 的随机数**

```java
public class Main {
    public static void main(String[] args) {
        // 生成一个 0 到 100 的随机数
        int randomNum = (int) (Math.random() * 101); // 0 <= randomNum <= 100
        System.out.println("Random number between 0 and 100: " + randomNum);
    }
}
```

#### **输出：**

```plain
Random number between 0 and 100: 42  （随机结果）
```

------

### **7. 圆的面积和周长公式**

我们可以使用 `Math.PI` 和一些基本运算来计算圆的面积和周长。

#### **圆的周长公式：**

$$
C = 2 \times \pi \times r
$$

- `C` 是周长，`r` 是半径。

#### **圆的面积公式：**

$$
A = \pi \times r^2
$$

- `A` 是面积，`r` 是半径。

#### **示例：**

```java
public class Main {
    public static void main(String[] args) {
        double radius = 5.0;

        // 计算圆的周长
        double circumference = 2 * Math.PI * radius;
        System.out.println("Circumference of the circle: " + circumference);

        // 计算圆的面积
        double area = Math.PI * Math.pow(radius, 2);
        System.out.println("Area of the circle: " + area);
    }
}
```

#### **输出：**

```plain
Circumference of the circle: 31.41592653589793
Area of the circle: 78.53981633974483
```

------

### **8. 其他常用数学公式**

#### **勾股定理：**

勾股定理描述了直角三角形中两条直角边与斜边的关系：
$$
c = \sqrt{a2 + b2}
$$

- `a` 和 `b` 是直角边，`c` 是斜边。

#### **示例：**

```java
public class Main {
    public static void main(String[] args) {
        double a = 3.0;
        double b = 4.0;

        // 使用勾股定理计算斜边
        double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        System.out.println("Hypotenuse of the triangle: " + c);  // 输出 5.0
    }
}
```

#### **输出：**

```plain
Hypotenuse of the triangle: 5.0
```

------

### **9. 小结**

- Java 提供了丰富的数学运算功能，`Math` 类中包含常用的数学方法和常量，如 `Math.PI`、`Math.E` 等。
- 常见的数学运算包括基本算术运算、三角函数、对数与指数运算、随机数生成等。
- 可以通过 `Math` 类的方法轻松实现数学公式，如圆的周长与面积、勾股定理等。

通过掌握 `Math` 类的使用，可以轻松应对 Java 程序中的各种数学计算需求。
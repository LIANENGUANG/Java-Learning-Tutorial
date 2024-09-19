# lesson023. 强制类型转换（Type Casting）

在 Java 中，**类型转换** 是将一种数据类型的值转换为另一种数据类型的过程。对于不同类型之间的转换，有两种方式：

1. **自动类型转换（Implicit Casting/Automatic Type Conversion）**：由编译器自动完成，无需显式指定。
2. **强制类型转换（Explicit Casting/Type Casting）**：需要程序员显式指定，强制将一种数据类型转换为另一种数据类型。

本章主要讨论**强制类型转换**。

------

### **1. 什么是强制类型转换？**

**强制类型转换**（Type Casting）是将一种较大的数据类型转换为较小的数据类型，或者在某些情况下将一种数据类型强制转换为另一种不兼容的数据类型。由于强制类型转换是在开发者的明确指示下进行的，可能会导致数据截断或精度丢失，因此在使用时需要格外小心。

#### **语法：**

```java
targetType variable = (targetType) value;
```

- `targetType` 是目标类型，即你想要转换成的数据类型。
- `value` 是要转换的值。

------

### **2. 强制类型转换的规则**

在强制类型转换时，通常出现在以下两种情况：

- **将较大的数据类型转换为较小的数据类型**。
- **将不兼容的数据类型之间进行转换**（如 `double` 转为 `int`，`Object` 转为具体类型等）。

#### **常见的强制类型转换：**

1. **浮点数到整数的转换**：`double` 或 `float` 转换为 `int`，小数部分会被截断。
2. **较大整数类型到较小整数类型的转换**：`long` 转换为 `int` 或 `byte`，可能会导致溢出。

------

### **3. 示例：浮点数到整数的强制类型转换**

当将浮点数（如 `double` 或 `float`）转换为整数类型时，**小数部分会被截断**，只保留整数部分。

#### **示例：**

```java
public class Main {
    public static void main(String[] args) {
        double d = 9.8;
        
        // 强制类型转换为 int
        int i = (int) d;
        
        System.out.println("Original double value: " + d);  // 输出 9.8
        System.out.println("Converted int value: " + i);    // 输出 9
    }
}
```

#### **输出：**

```plain
Original double value: 9.8
Converted int value: 9
```

在这个例子中，`9.8` 被强制转换为 `int` 类型，结果为 `9`，小数部分 `0.8` 被截断。

------

### **4. 示例：较大整数类型到较小整数类型的转换**

当将较大的整数类型（如 `long`、`int`）转换为较小的整数类型（如 `byte`、`short`）时，可能会发生**数据溢出**，即目标类型无法表示的部分会被丢弃。

#### **示例：**

```java
public class Main {
    public static void main(String[] args) {
        int largeValue = 130;
        
        // 强制类型转换为 byte
        byte smallValue = (byte) largeValue;
        
        System.out.println("Original int value: " + largeValue);    // 输出 130
        System.out.println("Converted byte value: " + smallValue);  // 输出 -126
    }
}
```

#### **输出：**

```plain
Original int value: 130
Converted byte value: -126
```

**解释：**

- `byte` 的取值范围是 `-128` 到 `127`。当 `130` 转换为 `byte` 时，发生了溢出，结果为 `-126`。
- 这是因为 `byte` 类型只能存储 8 位数据，而 `130` 超过了 `byte` 类型的最大值 `127`，所以按照二进制补码的规则，数值循环回负数区间。

------

### **5. 示例：不兼容类型的转换**

除了基本数据类型之间的转换，还可以在不兼容的对象类型之间进行强制类型转换。

#### **向下转型（Downcasting）**

在 Java 的继承层次结构中，可以将父类类型的对象**强制转换**为子类类型。这通常被称为**向下转型**（Downcasting）。向下转型需要确保对象实际上是子类类型，否则会抛出 `ClassCastException`。

#### **示例：**

```java
class Animal {
    public void makeSound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    public void makeSound() {
        System.out.println("Dog barks");
    }

    public void fetch() {
        System.out.println("Dog fetches ball");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();  // 向上转型：子类对象赋给父类引用

        // animal.fetch();  // 编译错误：父类引用无法调用子类特有的方法

        // 强制类型转换：向下转型
        Dog dog = (Dog) animal;
        dog.fetch();  // 成功调用子类特有的方法
    }
}
```

#### **输出：**

```plain
Dog fetches ball
```

**解释：**

- `animal` 实际上是 `Dog` 类型，但被声明为 `Animal` 类型。为了调用 `Dog` 类中特有的方法 `fetch()`，需要将 `animal` 强制转换为 `Dog` 类型。
- 如果 `animal` 实际上不是 `Dog` 类型，转换会导致 `ClassCastException` 异常。

------

### **6. 类型转换的注意事项**

#### **数据丢失**

- 当进行强制类型转换时，如果目标类型的表示范围小于源类型，可能会丢失数据。例如，在将 `double` 转换为 `int` 时，浮点数的小数部分会被截断。

#### **溢出**

- 将较大的整数类型转换为较小的整数类型时，可能会发生溢出，导致结果与预期不符。

#### **类型检查**

- 在对象的类型转换中，必须确保对象实际上是目标类型。否则，运行时会抛出 `ClassCastException`。

#### `instanceof` **运算符**

- 为了避免类型转换异常，可以使用 `instanceof` 运算符在进行转换之前检查对象是否为某个特定类型。例如：

```java
if (animal instanceof Dog) {
    Dog dog = (Dog) animal;
    dog.fetch();
}
```

------

### **7. 小结**

- **强制类型转换** 是将一种数据类型显式地转换为另一种数据类型。通常用于将较大的数据类型转换为较小的数据类型，或者在不同不兼容类型之间进行转换。
- 强制类型转换可能会导致 **数据丢失** 或 **溢出**，因此在使用时需要特别小心。
- 对于对象的类型转换，必须确保对象是目标类型，否则会抛出 `ClassCastException` 异常。
- 在进行对象类型转换时，可以使用 `instanceof` 运算符来确保安全的类型转换。

掌握强制类型转换能够帮助我们更好地处理不同数据类型之间的转换，编写更灵活的 Java 程序，但同时也需要注意可能的风险。
# lesson040. int 和 Integer 之间的区别

理解 `int` 和 `Integer` 之间的区别，实际上是理解 **基本数据类型** 和 **引用类型** 的区别的一个典型例子。我们这一章的重点是解释它们的**本质区别**，而不是简单地罗列它们的不同方法。

### 1. `int` 和 `Integer` 的本质区别

#### `int` **是基本数据类型**

- `int` 是 Java 中最基础的**基本数据类型**，它存储的是**实际的数值**。
- **存储方式**：`int` 直接存储在栈内存中，变量中保存的就是数据本身，而不是对象或引用。
- **效率**：`int` 类型的操作是高度优化的，处理速度非常快，适用于数值计算和对效率要求较高的场景。
- **没有方法**：`int` 只是一个数值，不能调用任何方法。

```java
int a = 5;
int b = a + 10;
System.out.println(b);  // 输出: 15
```

在这个例子中，`a` 和 `b` 都是 `int` 类型，它们**直接存储数值**，并且只能通过操作符（如 `+`）来进行计算。

#### `Integer` **是引用类型（包装类）**

- `Integer` 是一个类，属于 Java 的**引用类型**，它封装了一个 `int` 值，并且提供了许多方法来操作这个 `int` 值。
- **存储方式**：`Integer` 本质上是一个对象，存储在堆内存中。变量存储的是**对象的引用**（对象在内存中的地址），而不是实际的数据。
- **附带方法**：因为 `Integer` 是一个类，它可以附带许多方法，比如 `Integer.parseInt()`、`Integer.valueOf()` 等，帮助我们进行类型转换、比较等操作。

```java
Integer x = 5;  // 自动装箱：int → Integer
Integer y = x + 10;  // 自动拆箱：Integer → int，然后再计算
System.out.println(y);  // 输出: 15
```

在这个例子中，`x` 是一个 `Integer` 对象，虽然它看起来像 `int`，但它实际上是 `Integer` 类的一个实例。它存储在堆内存中，变量 `x` 存储的是这个对象的引用（内存地址）。

------

### 2. 为什么 `Integer` 可以有方法，而 `int` 没有？

#### `int` **是基本数据类型，不能有方法**

- `int` **是一种非常低级的类型**，它的设计目的是为了**快速、直接地存储数值**。它没有任何额外的开销，因此它没有对象的特性，也不能调用方法。
- **没有对象的特性**：由于 `int` 不是对象，它只是一个简单的数值存储单元，所以我们不能像操作对象那样对它调用方法。例如，你不能对一个 `int` 调用 `.toString()` 或 `.compareTo()` 之类的方法。

```java
int a = 10;
// a.toString(); // 编译错误，int 没有方法
```

#### `Integer` **是类对象，可以有方法**

- `Integer` **是一个类**，而类是面向对象编程的核心概念。类不仅能存储数据，还能定义与这些数据相关的**行为**（方法）。因此，`Integer` 对象可以有很多方法来操作和处理 `int` 值。

```java
Integer num = 5;
String str = num.toString();  // 调用 Integer 对象的 toString() 方法
System.out.println(str);  // 输出: "5"
```

在这个例子中，`num` 是一个 `Integer` 对象，它可以调用 `toString()` 方法，将数值转换为字符串。这是因为 `Integer` 是一个类，它有方法，而 `int` 没有这些特性。

- **类的封装性**：`Integer` 作为一个类，封装了 `int` 值以及一些用于操作 `int` 值的行为（方法）。因此，你可以调用 `Integer` 对象的各种方法，比如转换成字符串、比较大小等。

------

### 3. **自动装箱与拆箱：连接** `int` **和** `Integer` **的桥梁**

为了方便开发者在基本数据类型与引用类型之间进行转换，Java 提供了**自动装箱（Autoboxing）**和**拆箱（Unboxing）**的机制。

#### **自动装箱（Autoboxing）**

- **将基本数据类型自动转换为对应的包装类**。例如，当你将一个 `int` 值赋给 `Integer` 类型的变量时，Java 会自动将 `int` 转换为 `Integer` 对象。

```java
int a = 10;
Integer b = a;  // 自动装箱：int → Integer
```

在上面的例子中，`a` 是 `int` 类型，`b` 是 `Integer` 类型。Java 编译器会自动将 `int` 值 `a` 转换为 `Integer` 对象，并赋值给 `b`。

#### **拆箱（Unboxing）**

- **将包装类对象转换为对应的基本数据类型**。例如，当你将 `Integer` 对象赋值给 `int` 类型的变量时，Java 会自动将 `Integer` 转换为 `int`。

```java
Integer x = 10;
int y = x;  // 自动拆箱：Integer → int
```

在上面的例子中，`x` 是 `Integer` 对象，`y` 是 `int` 类型。Java 会自动将 `x` 中的 `Integer` 对象转换为基本类型 `int`，并赋值给 `y`。

------

### 4. **本质上，**`Integer` **是** `int` **的“包装”**

- `Integer` **是** `int` **的包装类**。它存在的目的是为了解决 `int` 不能作为对象使用的问题。特别是在需要对象的场景中（如 Java 的集合类），不能使用基本数据类型，只能使用对象，因此 `Integer` 就派上了用场。

- 例如，`ArrayList` 只能存储对象，不能存储基本数据类型：

```java
// 错误：ArrayList 不能存储基本数据类型
// ArrayList<int> list = new ArrayList<int>();

// 正确：使用 Integer 包装类
ArrayList<Integer> list = new ArrayList<>();
list.add(10);  // 自动装箱：int → Integer
```

- **为什么需要包装类？**

- Java 的设计初衷是为了兼容原来的 C/C++，这些语言中有基本数据类型（如 `int`），这些类型的设计目的就是为了提高性能。
- 但在面向对象编程的场景中，必须使用对象来传递、处理数据，因此 Java 引入了包装类（如 `Integer`）来解决这个问题。

------

### 5. **总结：**`int` **和** `Integer` **的本质区别**

- `int` **是基本数据类型**：它直接存储数值，没有方法，也不具备对象的特性。它的优势是高效，适合数值计算。
- `Integer` **是引用类型**：它是 `int` 的包装类，存储的是对象的引用，具备类和对象的特性，因此可以调用方法。它适合在面向对象编程的场景中使用，特别是在需要对象而不能使用基本数据类型的情况下。
- **自动装箱与拆箱**：Java 提供了自动装箱和拆箱机制，使得我们可以在 `int` 和 `Integer` 之间自由切换，而不必手动进行转换。
- **本质区别**：`int` 是一个简单的数值存储单元，`Integer` 是一个对象，它封装了 `int` 值并提供了许多操作方法。

```java
public final class Integer extends Number implements Comparable<Integer> {

    // 存储 int 的值
    private final int value;  // `int` 类型的值被封装在 `Integer` 对象中

    // 存储一些常量
    public static final int MIN_VALUE = 0x80000000;  // 最小值
    public static final int MAX_VALUE = 0x7fffffff;  // 最大值

    // 构造方法：创建一个 Integer 对象，封装一个 int 值
    public Integer(int value) {
        this.value = value;
    }

    // 返回封装的 int 值
    public int intValue() {
        return value;
    }

    // 比较两个 Integer 对象
    public int compareTo(Integer anotherInteger) {
        return compare(this.value, anotherInteger.value);
    }

    public static int compare(int x, int y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }

    // 静态方法：将字符串转换为 int
    public static int parseInt(String s) throws NumberFormatException {
        return parseInt(s, 10);
    }

    // 静态方法：将 int 转换为 Integer 对象（自动装箱时会用到）
    public static Integer valueOf(int i) {
        if (i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);
    }

    // 重写 toString 方法，返回数值的字符串表示
    @Override
    public String toString() {
        return String.valueOf(value);
    }
    
    // 一些其他方法，如 hashCode(), equals(), 等等
}
```
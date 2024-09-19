# lesson039. Java 中的包装类（Wrapper Classes）

在 Java 中，**包装类**（Wrapper Classes）为我们提供了一种方法，可以将**基本数据类型**（primitive data types）封装为**引用数据类型**（reference data types）。这让基本数据类型可以像对象一样使用，并且使它们可以应用于集合类（如 `ArrayList`）中。此外，包装类还提供了许多有用的方法来操作基本数据类型。

------

#### 1. 为什么使用包装类？

- **基本数据类型** 存储的是实际的值，而**包装类**存储的是这些值的对象形式(引用)。
- 包装类提供了许多有用的方法，可以用于操作数据。
- Java 的集合（例如 `ArrayList`）只能存储对象，因此需要将基本数据类型转换为包装类。

------

#### 2. 基本数据类型与对应的包装类

| **基本数据类型** | **包装类**  |
| ---------------- | ----------- |
| `boolean`        | `Boolean`   |
| `char`           | `Character` |
| `int`            | `Integer`   |
| `double`         | `Double`    |
| `float`          | `Float`     |
| `long`           | `Long`      |
| `short`          | `Short`     |
| `byte`           | `Byte`      |

包装类为每种基本数据类型提供了对应的引用类型。例如，`int` 的包装类是 `Integer`，`boolean` 的包装类是 `Boolean`。

------

#### 3. 自动装箱（Autoboxing）与拆箱（Unboxing）

- **自动装箱（Autoboxing）** 是指 Java 编译器会自动将基本数据类型转换为对应的包装类。
- **拆箱（Unboxing）** 是指 Java 编译器会自动将包装类对象转换为对应的基本数据类型。

##### 示例：

```java
public class Main {
    public static void main(String[] args) {
        // Autoboxing: 将基本数据类型转换为包装类
        int primitiveInt = 5;
        Integer wrapperInt = primitiveInt;  // 自动装箱
        System.out.println(wrapperInt);  // 输出: 5

        // Unboxing: 将包装类转换为基本数据类型
        Integer anotherWrapperInt = 10;
        int anotherPrimitiveInt = anotherWrapperInt;  // 拆箱
        System.out.println(anotherPrimitiveInt);  // 输出: 10
    }
}
```

在上面的例子中，`int` 被自动转换为 `Integer`（自动装箱），而 `Integer` 被自动转换为 `int`（拆箱）。

------

#### 4. 常用的方法（以 `Integer` 为例）

包装类提供了一些有用的方法，以下是 `Integer` 的常用方法：

- `parseInt(String s)`：将字符串转换为 `int` 类型。
- `toString()`：将整数转换为字符串。
- `valueOf(String s)`：将字符串转换为 `Integer` 对象。

##### 示例：

```java
public class Main {
    public static void main(String[] args) {
        // 将字符串解析为整数
        int num = Integer.parseInt("123");
        System.out.println(num);  // 输出: 123

        // 将整数转换为字符串
        String str = Integer.toString(123);
        System.out.println(str);  // 输出: "123"

        // 将字符串转换为 Integer 对象
        Integer numObj = Integer.valueOf("123");
        System.out.println(numObj);  // 输出: 123
    }
}
```

------

#### 5. 包装类的应用场景

- **集合类**：Java 的集合类（如 `ArrayList`、`HashSet` 等）不能存储基本数据类型。如果需要存储基本类型的值，必须使用对应的包装类。

```java
ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(10);  // 自动装箱
numbers.add(20);
System.out.println(numbers);  // 输出: [10, 20]
```

- **实用方法**：包装类还提供了许多有用的静态方法，用于类型转换、数字比较等操作。

------

#### 6. 总结

- **包装类** 将基本数据类型封装为对象，使它们可以与集合类等需要对象的 API 一起使用。
- 自动装箱 和 拆箱 简化了基本类型和包装类之间的转换。因为有了这个机制，我们在编写代码时可以几乎无缝地在基本类型和包装类之间切换，甚至在某些场景下可以感觉它们像是同一个东西。
- 包装类提供了许多有用的方法，帮助我们更有效地操作基本数据类型的数据。

包装类是 Java 中非常重要的特性，它使得基本数据类型能够在面向对象编程中得到更加广泛的应用。
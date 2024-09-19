# lesson027. Java 中的 Random 类

在 Java 中，`Random` 类用于生成伪随机数。它位于 `java.util` 包中，提供了多种生成不同范围随机数的方法。通过 `Random` 类，我们可以生成整数、浮点数、布尔值等类型的随机数据。

------

### **1.** `Random` **类简介**

- `Random` 类是 Java 中用于生成伪随机数的内置类。
- 它使用一个伪随机数生成器（PRNG），基于一个**种子值**（seed）来生成随机数。如果不指定种子值，`Random` 类会使用当前时间作为种子。

#### **导入** `Random` **类：**

```java
import java.util.Random;
```

------

### **2. 创建** `Random` **对象**

要使用 `Random` 类，首先需要创建一个 `Random` 对象。可以选择使用默认的构造方法（自动生成种子）或手动指定种子值。

#### **创建** `Random` **对象：**

```java
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // 使用默认构造器创建 Random 对象
        Random random = new Random();
        
        // 使用指定种子值创建 Random 对象
        Random randomWithSeed = new Random(12345L);
    }
}
```

- **无参构造方法**：`Random random = new Random();` 使用当前时间作为种子。
- **指定种子值的构造方法**：`Random randomWithSeed = new Random(12345L);` 使用指定的种子值 `12345L`。

**注意：** 如果使用相同的种子值，两次生成的随机数序列将会完全相同。

------

### **3. 常用方法**

`Random` 类提供了多种方法来生成不同类型的随机数，如整数、浮点数和布尔值。

#### **常用方法列表：**

- `nextInt()`：生成一个随机的 `int` 类型数值，范围是从 `-2^31` 到 `2^31-1`。
- `nextInt(int bound)`：生成一个在 `[0, bound)` 范围内的随机整数。
- `nextLong()`：生成一个随机的 `long` 类型数值。
- `nextDouble()`：生成一个在 `[0.0, 1.0)` 范围内的随机 `double` 类型数值。
- `nextFloat()`：生成一个在 `[0.0, 1.0)` 范围内的随机 `float` 类型数值。
- `nextBoolean()`：生成一个随机的布尔值（`true` 或 `false`）。
- `nextBytes(byte[] bytes)`：生成一个随机的字节数组。

#### **示例：生成不同类型的随机数**

```java
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        // 生成一个随机的整数
        int randomInt = random.nextInt();
        System.out.println("Random int: " + randomInt);

        // 生成一个在 0 到 100 之间的随机整数
        int randomIntBound = random.nextInt(100);
        System.out.println("Random int (0 - 99): " + randomIntBound);

        // 生成一个随机的长整型数
        long randomLong = random.nextLong();
        System.out.println("Random long: " + randomLong);

        // 生成一个随机的双精度浮点数
        double randomDouble = random.nextDouble();
        System.out.println("Random double (0.0 - 1.0): " + randomDouble);

        // 生成一个随机的单精度浮点数
        float randomFloat = random.nextFloat();
        System.out.println("Random float (0.0 - 1.0): " + randomFloat);

        // 生成一个随机的布尔值
        boolean randomBoolean = random.nextBoolean();
        System.out.println("Random boolean: " + randomBoolean);
    }
}
```

#### **示例输出：**

```plain
Random int: -1430697088
Random int (0 - 99): 85
Random long: 8164803137655767891
Random double (0.0 - 1.0): 0.8162346549811699
Random float (0.0 - 1.0): 0.46575367
Random boolean: true
```

------

### **4. 生成指定范围的随机数**

#### **生成指定范围的整数**

如果要生成一个在 `[min, max]` 范围内的随机整数，可以使用以下公式：

[
\text{randomNumber} = \text{min} + \text{random.nextInt}(\text{max} - \text{min} + 1)
]

#### **示例：生成 1 到 10 之间的随机数**

```java
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int min = 1;
        int max = 10;
        int randomNumber = min + random.nextInt(max - min + 1);

        System.out.println("Random number between 1 and 10: " + randomNumber);
    }
}
```

#### **生成指定范围的浮点数**

要生成一个在 `[min, max]` 范围内的随机浮点数，可以使用以下公式：

[
\text{randomDouble} = \text{min} + (\text{max} - \text{min}) \times \text{random.nextDouble}()
]

#### **示例：生成 1.0 到 10.0 之间的随机数**

```java
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        double min = 1.0;
        double max = 10.0;
        double randomDouble = min + (max - min) * random.nextDouble();

        System.out.println("Random double between 1.0 and 10.0: " + randomDouble);
    }
}
```

#### **生成随机布尔值**

`Random` 类的 `nextBoolean()` 方法可以直接生成随机的布尔值。

#### **示例：**

```java
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        // 生成一个随机布尔值
        boolean randomBoolean = random.nextBoolean();
        System.out.println("Random boolean: " + randomBoolean);
    }
}
```

------

### **5. 使用种子值**

如果你使用相同的种子值来初始化 `Random` 对象，每次运行程序时生成的随机数序列都会相同。

#### **示例：使用相同的种子值生成随机数**

```java
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random1 = new Random(12345L);
        Random random2 = new Random(12345L);

        System.out.println("Random number from random1: " + random1.nextInt(100));
        System.out.println("Random number from random2: " + random2.nextInt(100));
    }
}
```

#### **输出：**

```plain
Random number from random1: 42
Random number from random2: 42
```

**注意：**

- 当使用相同的种子值时，即使使用不同的 `Random` 对象，生成的随机数序列也是相同的。

------

### **6.** `ThreadLocalRandom`

在并发编程中，如果多个线程共享同一个 `Random` 实例，可能会导致性能问题。Java 提供了 `ThreadLocalRandom` 类来解决这个问题，它通过为每个线程提供独立的随机数生成器来避免冲突。

#### **示例：使用** `ThreadLocalRandom` **生成随机数**

```java
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        // 从 ThreadLocalRandom 获取随机数
        int randomInt = ThreadLocalRandom.current().nextInt(0, 100);
        double randomDouble = ThreadLocalRandom.current().nextDouble(0.0, 1.0);

        System.out.println("Random int (0 - 99): " + randomInt);
        System.out.println("Random double (0.0 - 1.0): " + randomDouble);
    }
}
```

#### **示例输出：**

```plain
Random int (0 - 99): 68
Random double (0.0 - 1.0): 0.587236987654321
```

`ThreadLocalRandom` **的优势：**

- **线程安全**：每个线程有自己独立的 `Random` 实例，避免了性能瓶颈。
- **简洁**：无需手动创建 `Random` 对象，可以直接使用 `ThreadLocalRandom.current()`。

------

### **7. 小结**

- `Random` **类** 是 Java 中用于生成伪随机数的工具类。它提供了生成不同类型（如 `int`、`double`、`boolean`）随机数的方法。
- 可以通过 **指定范围** 来生成特定范围内的随机数（如 `[min, max]` 范围的整数或浮点数）。
- **种子值** 可以用来保证随机数序列的**可重复性**，即使用相同的种子值会生成相同的随机数序列。
- 对于并发环境，推荐使用 `ThreadLocalRandom`，它为每个线程提供独立的随机数生成器，避免了线程间的竞争。

通过 `Random` 类和 `ThreadLocalRandom` 类，你可以轻松生成各种随机数，以满足程序中不同场景的需求。
# lesson050. Java 变量作用域 (Scope)

在 Java 中，变量的 **作用域 (Scope)** 决定了变量可以被访问的范围。根据变量声明的位置，变量可以分为 **局部变量** 和 **全局变量**。在本章节中，我们将详细讨论这两种变量的区别以及它们在 Java 编程中的使用场景。

------

#### 1. 什么是局部变量？

**局部变量（Local Variable）** 是在方法内部声明的变量，仅在该方法内可见。换句话说，局部变量只能在其所属的方法或代码块中访问，方法执行完成后，局部变量将被销毁。

##### 局部变量示例：

```java
public class DiceRoller {
    public void rollDice() {
        int number = 0;  // 局部变量，只能在 rollDice 方法内访问
        number = (int)(Math.random() * 6) + 1;
        System.out.println("你掷出了: " + number);
    }
}
```

在上面的例子中，`number` 是一个局部变量，它只在 `rollDice` 方法内存在。每次方法被调用时，`number` 都会被重新初始化并赋值。

------

#### 2. 什么是全局变量？

**全局变量（Global Variable）**，在 Java 中通常称为 **实例变量** 或 **类变量**，是在类中定义但不在方法内部的变量。全局变量可以被该类的所有方法访问。

##### 全局变量示例：

```java
public class DiceRoller {
    Random random;  // 全局变量，可以在类的所有方法中访问
    int number;     // 全局变量
    
    public DiceRoller() {
        random = new Random();  // 在构造方法中初始化全局变量
    }

    public void rollDice() {
        number = random.nextInt(6) + 1;
        System.out.println("你掷出了: " + number);
    }
}
```

在上面的例子中，`random` 和 `number` 是全局变量。它们在类 `DiceRoller` 中声明，可以在类的任何方法中被访问和修改。

------

#### 3. 局部变量与全局变量的区别

- **局部变量**：声明在方法内部，仅在该方法内有效。局部变量在方法执行完成后被销毁。
- **全局变量**：声明在类内但不在方法内部，可以在类的所有方法中访问。全局变量的生命周期与对象的生命周期相同。

##### 示例：局部变量和全局变量的对比

```java
public class DiceRoller {
    Random random;  // 全局变量
    int number;     // 全局变量
    
    public DiceRoller() {
        random = new Random();  // 初始化全局变量
        rollDice();
    }

    public void rollDice() {
        int result = random.nextInt(6) + 1;  // 局部变量，仅在 rollDice 方法内有效
        System.out.println("你掷出的结果是: " + result);
    }
}
```

在上面的代码中，`random` 和 `number` 是全局变量，`result` 是 `rollDice` 方法中的局部变量。`result` 只能在 `rollDice` 方法中使用，而 `random` 可以在类的所有方法中访问。

------

#### 4. 全局变量的作用

全局变量在需要在多个方法之间共享数据时非常有用。例如，当我们需要在多个方法之间共享一个随机数生成器对象时，可以将其声明为全局变量。

##### 示例：使用全局变量共享数据

```java
public class DiceRoller {
    Random random;  // 全局变量
    int number;     // 全局变量
    
    public DiceRoller() {
        random = new Random();  // 初始化全局变量
    }

    public void rollDice() {
        number = random.nextInt(6) + 1;
        System.out.println("你掷出了: " + number);
    }

    public void printNumber() {
        System.out.println("上一次掷出的点数是: " + number);
    }
}
```

在这个例子中，`random` 和 `number` 是全局变量。`rollDice` 方法会生成一个随机数并赋值给 `number`，而 `printNumber` 方法可以访问并打印 `number` 的值。因为 `number` 是全局变量，多个方法可以共享它的值。

------

#### 5. 局部变量的作用

局部变量适用于仅在单个方法内使用的数据。它们在方法执行结束后被销毁，因此不会占用不必要的内存。

##### 示例：局部变量的使用

```java
public class DiceRoller {
    public void rollDice() {
        int result = (int)(Math.random() * 6) + 1;  // 局部变量
        System.out.println("你掷出的结果是: " + result);
    }
}
```

在上面的代码中，变量 `result` 是局部变量，仅在 `rollDice` 方法中有效，方法执行结束后，`result` 将被销毁。

------

#### 6. 何时使用全局变量与局部变量？

- **全局变量**：

- 当需要在多个方法中共享数据时，使用全局变量。
- 全局变量的生命周期与对象相同，因此要谨慎使用，避免占用过多内存或导致意外的状态共享。

- **局部变量**：

- 当数据仅在某个方法中需要时，使用局部变量。
- 局部变量的生命周期较短，方法执行完后即被销毁，适用于临时数据的存储。

------

#### 7. 小结

理解全局变量和局部变量的区别是编写高效 Java 程序的基础。局部变量和全局变量的选择取决于程序的需求——局部变量适合临时数据，全局变量适合需要跨方法共享的数据。

##### 关键点回顾：

- **局部变量**：在方法内部声明，仅在该方法内有效。
- **全局变量**：在类中声明，但不在方法内部，可以在整个类中访问。
- 要根据变量的使用场景选择合适的作用域，避免不必要的全局变量使用。

------

### 练习：

1. 创建一个 `Calculator` 类，包含两个全局变量 `num1` 和 `num2`，并定义一个方法 `add()` 来计算它们的和。
2. 修改 `DiceRoller` 类，添加一个新的方法 `resetNumber()`，将 `number` 变量重置为 0。
3. 编写程序，创建一个 `BankAccount` 类，包含全局变量 `balance`，并定义方法 `deposit()` 和 `withdraw()` 来修改余额。
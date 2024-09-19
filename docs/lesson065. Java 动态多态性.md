# lesson065. Java 动态多态性

#### 什么是动态多态性？

**多态性**，如我们之前所讨论的，源自希腊语，其中 **poly** 意为“多”，**morph** 意为“形态”，合起来就是“多种形态”。简单来说，多态性允许一个对象可以表现为多个不同的类型。

而**动态**意味着程序**在运行时**（即编译后的执行阶段）才确定对象的具体类型。因此，**动态多态性**是指一个对象在程序运行时能够表现为多个不同的类型，而不是在编译时就确定。

#### 动态多态性的示例

我们来看一个简单的例子。假设我们有一个 `Animal` 类，这是一个父类（超类），并且有两个子类：`Dog` 和 `Cat`。在程序运行时，用户可以选择创建一个 `Dog` 对象或者 `Cat` 对象，但在编译时我们并不知道用户会选择哪一个对象。

我们将使用动态多态性，来让程序在运行时根据用户的选择来决定具体的对象类型。

#### 类的定义

首先，让我们定义父类 `Animal` 以及两个子类 `Dog` 和 `Cat`。

```java
// 父类 Animal
public class Animal {
    public void speak() {
        System.out.println("Animal goes BRR");
    }
}

// 子类 Dog 继承自 Animal
public class Dog extends Animal {
    @Override
    public void speak() {
        System.out.println("Dog goes bark");
    }
}

// 子类 Cat 继承自 Animal
public class Cat extends Animal {
    @Override
    public void speak() {
        System.out.println("Cat goes meow");
    }
}
```

在上面的代码中，`Animal` 类有一个 `speak()` 方法，它会输出一个通用的动物发声。而 `Dog` 和 `Cat` 类分别重写了这个 `speak()` 方法，提供了各自的实现。

#### 使用动态多态性

接下来，编写 `Main` 类，其中用户可以选择是创建 `Dog` 还是 `Cat` 对象，并且程序会根据用户的选择在运行时动态地决定具体的对象类型。

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 创建 Scanner 对象以获取用户输入
        Scanner scanner = new Scanner(System.in);

        // 提示用户选择动物
        System.out.println("What animal do you want?");
        System.out.println("1 = Dog, 2 = Cat");
        
        // 获取用户的选择
        int choice = scanner.nextInt();

        // 声明一个 Animal 类型的引用
        Animal animal;

        // 根据用户的选择动态决定创建哪种动物对象
        if (choice == 1) {
            animal = new Dog();  // 创建 Dog 对象
        } else if (choice == 2) {
            animal = new Cat();  // 创建 Cat 对象
        } else {
            animal = new Animal();  // 默认创建 Animal 对象
            System.out.println("Invalid choice.");
        }

        // 调用动物的 speak 方法
        animal.speak();
    }
}
```

#### 输出结果

当用户运行程序时，他们会看到以下提示：

```plain
What animal do you want?
1 = Dog, 2 = Cat
```

如果用户输入 `1`，程序输出：

```plain
Dog goes bark
```

如果用户输入 `2`，程序输出：

```plain
Cat goes meow
```

如果用户输入其他数字，例如 `42`，程序输出：

```plain
Invalid choice.
Animal goes BRR
```

#### 动态多态性如何工作？

在这个示例中，`Animal animal;` 声明了一个 `Animal` 类型的引用，但我们并不知道它到底会引用哪种具体的对象（`Dog` 或 `Cat`）。在运行时，程序根据用户的输入决定是实例化 `Dog` 还是 `Cat`，这就是**动态多态性**的核心。

通过使用父类 `Animal` 作为引用类型，程序可以在运行时动态地选择创建哪种类型的对象，并调用对应的 `speak()` 方法。

#### 总结

- **动态多态性**允许在程序运行时决定对象的具体类型，而不是在编译时确定。
- 通过父类引用，可以在运行时调用子类的重写方法（如 `speak()`），从而实现**方法重写**和**运行时多态**。
- 动态多态性提高了程序的灵活性，允许使用更通用的代码来处理不同的对象类型。
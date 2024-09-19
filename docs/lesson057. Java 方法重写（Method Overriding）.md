# lesson057. Java 方法重写（Method Overriding）

#### 定义

**方法重写**（Method Overriding）是在子类中定义一个与父类方法**相同签名**（相同方法名、参数列表和返回类型）的方法，以便子类可以提供该方法的**自己的实现**。它是**多态性**（Polymorphism）的一部分，允许子类根据自身需求，修改从父类继承的方法行为。

#### 基本条件

- **继承关系**：方法重写只能发生在父类与子类之间，子类必须继承父类。
- **方法签名相同**：子类重写的方法必须与父类的方法**有相同的名称、参数列表和返回类型**。
- **访问修饰符**：子类重写方法的访问权限不能比父类的更严格。但可以扩大访问权限（例如，父类方法是 `protected`，子类可以是 `public`）。
- `@Override` **注解**：虽然不是必须的，但使用 `@Override` 注解可以明确表达这是一个重写方法，并帮助编译器进行检查。

#### 基本结构

```java
class Parent {
    // 父类的方法
    public void display() {
        System.out.println("Display from Parent class");
    }
}

class Child extends Parent {
    // 子类重写父类的方法
    @Override
    public void display() {
        System.out.println("Display from Child class");
    }
}
```

在上面的例子中，子类 `Child` 重写了父类 `Parent` 的 `display()` 方法。

#### 方法重写的优势

1. **多态性**：方法重写允许你在运行时调用子类的版本，而不是父类的版本，从而实现**动态绑定**。
2. **代码复用与扩展**：子类可以继承父类的功能并根据需要进行修改，而不需要完全重新实现相同的逻辑。

#### 代码示例

```java
// 父类 Animal
class Animal {
    public void speak() {
        System.out.println("The animal speaks");
    }
}

// 子类 Dog，重写了父类的 speak() 方法
class Dog extends Animal {
    @Override
    public void speak() {
        System.out.println("The dog barks");
    }
}

// 主类
public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();  // 创建父类对象
        animal.speak();  // 输出: The animal speaks

        Dog dog = new Dog();  // 创建子类对象
        dog.speak();  // 输出: The dog barks

        Animal animalDog = new Dog();  // 父类引用指向子类对象
        animalDog.speak();  // 输出: The dog barks (多态)
    }
}
```

#### 解释：

- **父类** `Animal` 提供了一个 `speak()` 方法，输出 `"The animal speaks"`。
- **子类** `Dog` 重写了 `speak()` 方法，提供了自己的实现，输出 `"The dog barks"`。
- 当我们调用 `dog.speak()` 时，执行的是 `Dog` 类的 `speak()` 方法，而不是 `Animal` 类的。
- 通过多态性，`Animal animalDog = new Dog();` 依然会调用 `Dog` 的 `speak()` 方法，这是因为 Java 在运行时会动态选择子类的实现。

#### `super` 关键字

在重写方法时，子类仍然可以访问父类的版本。通过 `super` 关键字，子类可以在重写的方法中调用父类的原始实现。

```java
class Animal {
    public void speak() {
        System.out.println("The animal speaks");
    }
}

class Dog extends Animal {
    @Override
    public void speak() {
        // 调用父类的 speak() 方法
        super.speak();
        // 在父类的基础上，添加子类特有的行为
        System.out.println("The dog barks");
    }
}
```

**输出**：

```plain
The animal speaks
The dog barks
```

#### 访问修饰符规则：

- 子类重写的方法**不能**有比父类方法**更严格的访问权限**，但可以扩大访问权限。例如：

- 父类方法 `protected`，子类可以将其重写为 `public`。
- 但如果父类方法是 `public`，子类不能将其重写为 `protected` 或 `private`。

#### 静态方法不能被重写

在 Java 中，**静态方法**（`static`）不能被重写，**因为它们属于类，而非实例**。静态方法可以被**隐藏**（method hiding），即在子类中定义一个相同签名的静态方法，但这并不是真正的重写。

```java
class Parent {
    public static void staticMethod() {
        System.out.println("Static method in Parent");
    }
}

class Child extends Parent {
    public static void staticMethod() {
        System.out.println("Static method in Child");
    }
}

public class Main {
    public static void main(String[] args) {
        Parent.staticMethod();  // 输出: Static method in Parent
        Child.staticMethod();   // 输出: Static method in Child
    }
}
```

#### 构造器不能被重写

构造器用于创建对象，不能被继承和重写。每个类都有自己的构造方法，子类不能重写父类的构造方法，但可以通过 `super()` 调用父类构造器。

#### final 方法不能被重写

如果父类中的方法被声明为 `final`，则该方法不能被子类重写。

```java
class Animal {
    public final void speak() {
        System.out.println("This method cannot be overridden");
    }
}

class Dog extends Animal {
    // 编译错误，无法重写 final 方法
    @Override
    public void speak() {
        System.out.println("The dog barks");
    }
}
```

#### 总结

- **方法重写**是 Java 中实现多态性的重要机制。
- 子类可以通过重写父类的方法来提供更具体的实现，同时可以借助 `super` 调用父类的方法。
- 静态方法、构造方法、`final` 方法不能被重写。
- 使用 `@Override` 注解可以帮助编译器检查是否正确重写了方法。

**方法重写** 使得子类能够根据自身的需求提供特定的功能，从而实现更灵活和可扩展的面向对象编程。
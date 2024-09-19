# lesson063. Java 接口 (Interface)

#### 什么是接口？

在 Java 中，**接口**（Interface）可以看作是类的**模板**，它定义了类**必须做什么**，但不关心它**怎么做**。类可以**实现**多个接口，这与继承有所不同，继承只能有一个直接的父类，而接口可以是多个。

接口中可以定义方法，但这些方法没有具体的实现（类似于抽象类中的抽象方法）。实现接口的类必须**重写**接口中的所有方法，并提供具体的实现。

#### 接口的创建与实现

让我们看看如何实际使用接口。假设我们有三个类：`Rabbit`（兔子）、`Hawk`（老鹰）和 `Fish`（鱼）。我们将为这些类创建两个接口：`Prey`（猎物）和 `Predator`（捕食者），并根据动物的角色实现这些接口。

#### 创建接口

在 Java 中创建接口的语法非常简单：

```java
public interface Prey {
    void flee();  // 定义猎物的行为方法，但不提供实现 --- Prey-->被捕食的动物
}

public interface Predator {
    void hunt();  // 定义捕食者的行为方法，但不提供实现
}
```

接口 `Prey` 包含一个方法 `flee()`，表示猎物的逃跑行为。接口 `Predator` 包含一个方法 `hunt()`，表示捕食者的捕猎行为。

#### 实现接口

现在，我们将让 `Rabbit` 类实现 `Prey` 接口，因为兔子是猎物。`Hawk` 类实现 `Predator` 接口，因为老鹰是捕食者。

```java
// Rabbit 类实现 Prey 接口
public class Rabbit implements Prey {
    @Override
    public void flee() {
        System.out.println("The rabbit is fleeing.");
    }
}

// Hawk 类实现 Predator 接口
public class Hawk implements Predator {
    @Override
    public void hunt() {
        System.out.println("The hawk is hunting.");
    }
}
```

在 `Rabbit` 类中，我们实现了 `Prey` 接口的 `flee()` 方法，定义了兔子逃跑时的行为。同样，在 `Hawk` 类中，我们实现了 `Predator` 接口的 `hunt()` 方法，定义了老鹰捕猎时的行为。

#### 创建对象并调用方法

现在我们可以在主类中创建这些类的对象，并调用它们实现的接口方法。

```java
public class Main {
    public static void main(String[] args) {
        // 创建 Rabbit 对象并调用 flee 方法
        Rabbit rabbit = new Rabbit();
        rabbit.flee();  // 输出: The rabbit is fleeing.

        // 创建 Hawk 对象并调用 hunt 方法
        Hawk hawk = new Hawk();
        hawk.hunt();  // 输出: The hawk is hunting.
    }
}
```

执行结果：

```plain
The rabbit is fleeing.
The hawk is hunting.
```

#### 实现多个接口

有些动物既是捕食者也是猎物。例如，鱼类根据大小不同，既可能是猎物也可能是捕食者。这时我们可以让 `Fish` 类同时实现 `Prey` 和 `Predator` 接口。

```java
// Fish 类同时实现 Prey 和 Predator 接口
public class Fish implements Prey, Predator {
    @Override
    public void flee() {
        System.out.println("The fish is fleeing from a larger fish.");
    }

    @Override
    public void hunt() {
        System.out.println("The fish is hunting smaller fish.");
    }
}
```

在 `Fish` 类中，我们同时实现了 `Prey` 接口的 `flee()` 方法和 `Predator` 接口的 `hunt()` 方法，这样鱼类既可以逃跑，也可以捕猎。

#### 测试 `Fish` 类

```java
public class Main {
    public static void main(String[] args) {
        // 创建 Fish 对象并调用 hunt 和 flee 方法
        Fish fish = new Fish();
        fish.hunt();  // 输出: The fish is hunting smaller fish.
        fish.flee();  // 输出: The fish is fleeing from a larger fish.
    }
}
```

执行结果：

```plain
The fish is hunting smaller fish.
The fish is fleeing from a larger fish.
```

通过这个例子，我们展示了接口可以让一个类实现多种功能。`Fish` 类同时实现了两个接口，具备了两个角色的行为。

------

### 总结

1. **接口是类的模板**，它定义了类必须实现的方法，但不提供具体实现。
2. **类可以实现多个接口**，这与继承不同，继承只能有一个直接父类。
3. 接口中的方法没有方法体，必须由实现类**重写**这些方法并提供具体实现。
4. 接口可以帮助我们实现面向接口编程，使代码更加灵活和模块化。

通过接口，Java 支持多重继承的行为方式，而不会带来多重继承的复杂性。

------
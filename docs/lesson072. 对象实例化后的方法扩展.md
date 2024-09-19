# lesson072. 对象实例化后的方法扩展

在 Java 中，类是对象的蓝图，而对象是类的实例。类的定义（包括其属性和方法）在编译时就已经确定，因此一旦对象被实例化，我们**不能**动态地为它添加新的方法。尽管如此，在实际开发中，我们仍然可以通过其它机制来扩展对象的行为，比如**继承**、**多态**和**匿名内部类**，从而实现代码的灵活性。

#### 1. 对象实例化后不能再添加方法

在 Java 这样的静态类型语言中，类的结构在编译时已经完全确定，一旦对象被实例化，它便继承了类中定义的所有属性和方法。对象不能像动态语言（如 JavaScript）那样在运行时添加新的方法。

```java
public class MyFrame extends JFrame {
    public MyFrame() {
        this.setTitle("自定义 JFrame");
    }

    public void showMessage() {
        System.out.println("这是一个自定义的消息！");
    }
}

public class Main {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        frame.showMessage(); // 调用已定义的方法

        // 不能动态添加新方法
        // frame.newMethod();  // 这是不允许的，编译时会报错
    }
}
```

在上面的例子中，`frame` 是 `MyFrame` 的实例，它只能调用 `MyFrame` 类中预定义的 `showMessage()` 方法。实例化后，我们无法再给 `frame` 对象动态添加新的方法。

#### 2. 通过继承扩展对象行为

虽然我们不能直接为已实例化的对象添加方法，但我们可以通过**继承**来扩展类的功能。继承允许我们创建子类，在子类中添加新的方法，继承父类的功能并扩展它。

```java
public class MyFrame extends JFrame {
    public MyFrame() {
        this.setTitle("自定义 JFrame");
    }

    public void showMessage() {
        System.out.println("这是 MyFrame 的消息！");
    }
}

// 扩展 MyFrame 类，添加新方法
public class ExtendedFrame extends MyFrame {
    public void newMethod() {
        System.out.println("这是 ExtendedFrame 的新方法！");
    }
}

public class Main {
    public static void main(String[] args) {
        ExtendedFrame frame = new ExtendedFrame();
        frame.showMessage();  // 调用继承自 MyFrame 的方法
        frame.newMethod();    // 调用 ExtendedFrame 中的新方法
    }
}
```

通过继承，`ExtendedFrame` 类不仅继承了 `MyFrame` 的所有方法（如 `showMessage()`），还可以定义自己的新方法（如 `newMethod()`）。这样，虽然不能直接在已有对象上添加新方法，但可以通过创建子类来实现功能的扩展。

#### 3. 多态与接口的灵活性

Java 中的多态允许我们通过接口来定义不同类的行为，并在运行时动态地更改对象的实现方式。这种机制提供了极大的灵活性，可以在不改变对象结构的前提下实现行为的变化。

```java
public interface Message {
    void showMessage();
}

public class MyFrame implements Message {
    public void showMessage() {
        System.out.println("MyFrame 的消息！");
    }
}

public class AnotherFrame implements Message {
    public void showMessage() {
        System.out.println("AnotherFrame 的消息！");
    }
}

public class Main {
    public static void main(String[] args) {
        Message frame = new MyFrame();  // 使用接口引用 MyFrame 实例
        frame.showMessage();  // 输出 MyFrame 的消息

        frame = new AnotherFrame();  // 动态更改为 AnotherFrame 实例
        frame.showMessage();  // 输出 AnotherFrame 的消息
    }
}
```

在这个例子中，通过接口 `Message`，我们可以在运行时动态地更改对象的行为。`frame` 在不同的时刻可以指向不同的类，但它们都实现了 `Message` 接口。通过多态，程序的扩展性和灵活性大大增强。

#### 4. 使用匿名内部类临时扩展方法

如果你只是在某个特定场景下需要临时扩展或修改对象的某些行为，**匿名内部类**是一个非常好的选择。匿名内部类允许你在不创建新类的情况下重写类中的方法。

```java
public class MyFrame {
    public void showMessage() {
        System.out.println("这是 MyFrame 的消息！");
    }
}

public class Main {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame() {
            @Override
            public void showMessage() {
                System.out.println("这是匿名内部类的消息！");
            }
        };
        frame.showMessage();  // 输出 "这是匿名内部类的消息！"
    }
}
```

在这个例子中，我们创建了 `MyFrame` 的匿名子类，并重写了 `showMessage()` 方法。这种方式适用于需要临时修改某个对象的行为而不想创建额外的类的情况。

#### 总结

在 Java 中，虽然不能在对象实例化后动态添加方法，但我们可以通过**继承**、**多态**和**匿名内部类**等机制实现对象行为的扩展和灵活性：

1. **继承**：通过创建子类扩展父类的功能，添加新的方法。
2. **多态**：通过接口和多态机制，在运行时灵活地更改对象的行为。
3. **匿名内部类**：在特定场景下临时修改对象的行为，无需创建新的类。

通过这些机制，Java 程序可以保持代码的可扩展性、灵活性，同时遵循静态类型语言的设计原则。
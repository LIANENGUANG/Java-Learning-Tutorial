# lesson007. Java 程序中的 main 方法

在 Java 中，`main` 方法是程序的入口点。每当你运行一个 Java 程序时，JVM（Java 虚拟机）会首先寻找并执行 `main` 方法。没有 `main` 方法的 Java 程序是无法运行的。

#### `main` 方法的格式

```java
public static void main(String[] args) {
    // 程序执行的代码
}
```

#### 解释：

1. `public`：

- 这是一个访问修饰符，表示 `main` 方法可以被任何地方调用。由于 JVM 需要调用 `main` 方法，因此它必须是 `public` 的。

2. `static`：

- `main` 方法是静态的，这意味着它不依赖于类的实例化。JVM 在不创建类对象的情况下就可以调用它。

3. `void`：

- `main` 方法没有返回值，因此返回类型为 `void`。

4. `String[] args`：

- 这是一个字符串数组，用于接收命令行参数。`args` 是参数名，`String[]` 表示参数的类型为字符串数组。如果你在运行 Java 程序时提供了命令行参数，它们会被传递到这个数组中。如果没有提供参数，数组将为空。

#### 示例：一个简单的 Java 程序

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

#### 解释：

- 这个程序包含一个名为 `HelloWorld` 的类，以及一个 `main` 方法。
- 当你运行这个程序时，JVM 会从 `main` 方法开始执行，并且输出 `Hello, World!` 到控制台。

#### `main` 方法的作用是什么？

- `main` 方法是程序的入口点，所有的 Java 应用程序都必须至少包含一个 `main` 方法。
- 当你运行 Java 程序时，JVM 会启动，并从包含 `main` 方法的类开始执行程序。

#### `main` 方法的参数 `String[] args`：

- `args` 是一个字符串数组，用来保存运行 Java 程序时传递的命令行参数。
- 例如，假设你运行以下命令：

```bash
java HelloWorld arg1 arg2 arg3
```

在这种情况下，`args` 数组将包含 `["arg1", "arg2", "arg3"]`。

#### 示例：使用命令行参数

```java
public class CommandLineExample {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("你传递的第一个参数是: " + args[0]);
        } else {
            System.out.println("没有传递任何参数.");
        }
    }
}
```

- 如果运行程序时提供了参数，程序会输出第一个参数；如果没有提供参数，程序会提示没有参数。

#### 总结

- 在 Java 中，`main` 方法是程序的入口点，JVM 从这里开始执行程序。
- `main` 方法必须是 `public`，`static`，并且返回类型为 `void`。
- `String[] args` 用于接收命令行参数，尽管不一定需要使用它，但它是 `main` 方法的必需部分。
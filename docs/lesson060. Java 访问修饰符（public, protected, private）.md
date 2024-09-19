# lesson060. Java 访问修饰符（public, protected, private）

#### 访问修饰符的作用

在 Java 中，**访问修饰符**（Access Modifiers）用于控制类、方法和变量的访问级别，提供了一层**安全性**和**封装性**。不同的访问修饰符决定了哪些类或对象可以访问某个类的成员。

主要有以下几种访问修饰符：

1. `public`：公共访问，全局可见。
2. `protected`：受保护的访问，包内和子类可见。
3. `private`：私有访问，类内可见。
4. **默认（无修饰符）**：包内可见。

### 1. `public` 访问修饰符

- `public` **成员**可以被任何包中的任何类访问。无论类位于哪个包，只要使用了 `public` 关键字，其他类都可以访问该成员。

#### 示例代码：

```java
// package1 中的类 A
package package1;

public class A {
    public String publicMessage = "This is public";
}

// package2 中的类 B
package package2;

import package1.A;

public class B {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.publicMessage);  // 可以访问 public 变量
    }
}
```

#### 解释：

- `A` 类中的 `publicMessage` 变量是 `public` 的，因此可以在 `package2` 中的 `B` 类中直接访问。

### 2. `protected` 访问修饰符

- `protected` **成员**可以被**同一个包**中的类访问，或者**不同包**中的**子类**访问。它提供了包内访问权限，并允许继承的子类访问该成员。

#### 示例代码：

```java
// package1 中的类 A
package package1;

public class A {
    protected String protectedMessage = "This is protected";
}

// package2 中的类 B 继承自 A
package package2;

import package1.A;

public class B extends A {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.protectedMessage);  // 可以访问 protected 变量
    }
}
```

#### 解释：

- `protectedMessage` 是 `protected` 的，因此 `B` 类作为 `A` 类的子类可以访问它，即使它们位于不同的包中。

### 3. `private` 访问修饰符

- `private` **成员**只能在**声明它的类**内部访问。其他类，包括子类，甚至同包中的类，都无法访问该成员。

#### 示例代码：

```java
// package1 中的类 A
package package1;

public class A {
    private String privateMessage = "This is private";
    
    public String getPrivateMessage() {
        return privateMessage;
    }
}

// package2 中的类 B
package package2;

import package1.A;

public class B {
    public static void main(String[] args) {
        A a = new A();
        // System.out.println(a.privateMessage);  // 错误，无法访问 private 变量
        System.out.println(a.getPrivateMessage());  // 通过公共方法访问 private 变量
    }
}
```

#### 解释：

- `privateMessage` 是 `private` 的，因此其他类无法直接访问它，但可以通过 `A` 类的公共方法 `getPrivateMessage()` 访问该私有变量。

### 4. 默认（无修饰符）

- 如果没有指定任何访问修饰符，默认的访问级别是**包级别访问**（default package-private）。这意味着该成员只能被**同一个包**中的类访问，不能被其他包中的类访问。

#### 示例代码：

```java
// package1 中的类 A
package package1;

class A {
    String defaultMessage = "This is default";
}

// package1 中的类 B
package package1;

public class B {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.defaultMessage);  // 可以访问 default 变量
    }
}

// package2 中的类 C
package package2;

import package1.A;

public class C {
    public static void main(String[] args) {
        // A a = new A();  // 错误，无法访问默认包级别的类
    }
}
```

#### 解释：

- `defaultMessage` 没有指定访问修饰符，因此它是默认包级别的，只能在 `package1` 中的类 `B` 中访问，`package2` 中的类 `C` 无法访问它。

### 访问修饰符的可见性总结

| 修饰符      | 当前类 | 同包（其他类） | 子类（同包或跨包）  | 其他包 |
| ----------- | ------ | -------------- | ------------------- | ------ |
| `public`    | ✔️      | ✔️              | ✔️                   | ✔️      |
| `protected` | ✔️      | ✔️              | ✔️（跨包子类可访问） | ✖️      |
| 默认        | ✔️      | ✔️              | ✖️                   | ✖️      |
| `private`   | ✔️      | ✖️              | ✖️                   | ✖️      |

### 总结

- `public`：完全公开，可以被任何类访问。
- `protected`：受保护，可以被同包类或不同包中的子类访问。
- `private`：完全私有，仅限于类内部访问。
- **默认（包级别）**：只能被同包内的类访问。

通过了解和使用这些访问修饰符，可以帮助我们更好地**控制类之间的访问权限**，保护数据的隐私，增强程序的**安全性**和**可维护性**。
# lesson058. Java 中的 super 关键字

#### 定义

在 Java 中，`super` 是一个引用**父类对象**（即**超类**）的特殊关键字。它通常用于访问或调用**父类的属性和方法**，特别是在子类对父类进行了扩展时。`super` 关键字的使用方式与 `this` 关键字类似，`this` 引用当前类实例，而 `super` 引用父类实例。

#### `super` 的常见用法

- **调用父类的构造方法**：在子类的构造方法中，使用 `super()` 可以调用父类的构造方法。
- **访问父类的成员变量**：当子类和父类中有相同名称的变量时，使用 `super` 访问父类中的变量。
- **调用父类的方法**：当子类重写了父类的方法时，可以通过 `super` 调用父类的版本。

#### 代码例子

以下是一个例子，其中展示了如何使用 `super` 关键字。这个例子包含三个类：

1. `Person` 类：表示一个人，包含 `name` 和 `age` 属性。
2. `Hero` 类：继承自 `Person`，添加了 `power` 属性。
3. `Main` 类：测试 `Person` 和 `Hero` 类的功能。

```java
//******************************************
public class Main {

    public static void main(String[] args) {
        
        // super =  keyword refers to the superclass (parent) of an object
        //          very similar to the "this" keyword
        
        Hero hero1 = new Hero("Batman", 42, "$$$");
        Hero hero2 = new Hero("Superman", 43, "everything");
        
        System.out.println(hero1.toString());
        System.out.println(hero2.toString());
    }
}
//******************************************
public class Person {

    String name;
    int age;
    
   å // 父类构造方法
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // 父类的 toString() 方法
    public String toString() {
        return this.name + "\n" + this.age + "\n";
    }
}
//******************************************
public class Hero extends Person {

    String power;
    
    // 子类构造方法，调用父类构造方法
    Hero(String name, int age, String power) {    
        super(name, age); // 使用 super 调用父类构造方法
        this.power = power;
    }
    
    // 重写 toString() 方法
    @Override
    public String toString() {
        return super.toString() + this.power; // 使用 super 调用父类的 toString() 方法
    }
}
//******************************************
```

#### 代码解析

1. `Person` **类**：

```java
public class Person {
    String name;
    int age;
    
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String toString() {
        return this.name + "\n" + this.age + "\n";
    }
}
```

- `Person` 类是一个简单的类，包含两个属性：`name` 和 `age`。它有一个构造方法，用于初始化这些属性，并且重写了 `toString()` 方法，用于返回对象的描述。

1. `Hero` **类（子类）**：

```java
public class Hero extends Person {
    String power;
    
    Hero(String name, int age, String power) {
        super(name, age); // 调用父类的构造方法
        this.power = power;
    }
    
    @Override
    public String toString() {
        return super.toString() + this.power;  // 调用父类的 toString() 方法
    }
}
```

- `Hero` 类继承了 `Person` 类，添加了一个新属性 `power`，表示英雄的能力。
- 在 `Hero` 类的构造方法中，使用 `super(name, age)` 来调用父类 `Person` 的构造方法，初始化继承自父类的 `name` 和 `age` 属性。
- `Hero` 类重写了父类的 `toString()` 方法。在重写的 `toString()` 方法中，使用 `super.toString()` 调用了父类的 `toString()` 方法，并在其基础上添加了 `power` 的信息。

1. `Main` **类**：

```java
public class Main {
    public static void main(String[] args) {
        Hero hero1 = new Hero("Batman", 42, "$$$");
        Hero hero2 = new Hero("Superman", 43, "everything");
        
        System.out.println(hero1.toString());
        System.out.println(hero2.toString());
    }
}
```

- `Main` 类是程序的入口，创建了两个 `Hero` 对象：`hero1` 和 `hero2`，并打印它们的描述。
- 通过调用 `hero1.toString()` 和 `hero2.toString()`，程序会输出英雄的 `name`、`age` 和 `power`。

#### 输出结果

```bash
Batman
42
$$$
Superman
43
everything
```

- `super` 关键字确保了 `Hero` 类能够正确调用 `Person` 类的构造方法和 `toString()` 方法。在 `Hero` 类中，`super.toString()` 返回的是父类 `Person` 的 `name` 和 `age`，然后添加了 `Hero` 类的 `power` 信息。

#### `super` 关键字的三种常见用法

1. **调用父类的构造方法**：
   在子类的构造方法中，使用 `super()` 调用父类构造方法，必须是构造方法的第一行。如果父类没有无参构造方法，子类构造方法必须显式调用 `super`。

```java
Hero(String name, int age, String power) {
    super(name, age);  // 调用父类的构造方法
    this.power = power;
}
```

2. **访问父类的成员变量**：
   如果子类和父类中有相同名称的成员变量，可以使用 `super` 来**区分调用父类的成员变量**。

```java
class Animal {
    String type = "Animal";
}

class Dog extends Animal {
    String type = "Dog";

    public void printType() {
        System.out.println(super.type); // 输出 "Animal"
        System.out.println(this.type);  // 输出 "Dog"
    }
}
```

3. **调用父类的方法**：
   子类可以重写父类的方法，但有时仍然需要调用父类的版本，可以使用 `super.methodName()` 来调用父类的方法。

```java
public String toString() {
    return super.toString() + this.power;  // 调用父类的 toString() 方法
}
```

#### 注意事项

- `super()` **必须是子类构造器中的第一行**。如果子类构造器没有显式调用 `super()`，Java 会自动调用父类的无参构造器。如果父类没有无参构造器，必须在子类构造器中手动调用 `super`。
- `super` **只能在子类中使用**，它是用来调用父类的成员和方法的，不能在静态上下文中使用。
- `super` **不能用于调用父类的私有成员**，只能访问父类的公共或受保护的成员。

#### 总结

- `super` **关键字** 用来引用父类的构造方法、成员变量和方法。
- 它主要用于帮助子类访问或调用父类的功能，确保子类可以继承并扩展父类的行为。
- `super` 关键字在构造器中尤为重要，确保父类的初始化逻辑得以执行。

通过使用 `super`，我们可以在子类中灵活地继承和复用父类的逻辑，实现 Java 面向对象编程中的继承和多态性。
# lesson053. Java 对象数组 (Array of Objects)

在 Java 中，数组不仅可以存储基本数据类型（如 `int`、`char`、`String` 等），还可以存储对象。这就叫做**对象数组**。通过对象数组，我们可以方便地管理和操作多个对象。在本教程中，我们将通过一个简单的例子来学习如何创建和操作 Java 中的对象数组。

------

#### 1. 什么是对象数组？

对象数组是指存储对象的数组。与基本类型数组不同，对象数组的每个元素都是一个对象的引用。我们可以使用数组方便地存储和访问多个对象。

##### 创建对象数组的基本步骤：

1. **声明数组**：指定数组的数据类型（即对象类型），并为数组命名。
2. **初始化数组**：指定数组的大小，或直接赋值。
3. **创建对象**：使用 `new` 关键字实例化对象，并将它们存储在数组中。

------

#### 2. 示例：创建一个 `Food` 类

我们将创建一个 `Food` 类，每个 `Food` 对象都有一个 `name` 属性，用于表示食物的名称。

```java
public class Food {
    String name;

    // 构造方法，接收食物名称作为参数
    public Food(String name) {
        this.name = name;
    }
}
```

------

#### 3. 创建对象数组

接下来，我们将创建一个 `Food` 对象数组，模拟一个存放食物的“冰箱”。

##### 方法 1：先声明数组，再赋值

```java
public class Main {
    public static void main(String[] args) {
        // 声明一个可以存放 3 个 Food 对象的数组
        // 冰箱是一堆食物的数组
        Food[] refrigerator = new Food[3];

        // 创建 Food 对象并赋值给数组
        refrigerator[0] = new Food("Pizza");
        refrigerator[1] = new Food("Hamburger");
        refrigerator[2] = new Food("Hotdog");

        // 访问数组中的对象并打印它们的 name 属性
        System.out.println(refrigerator[0].name);  // 输出 "Pizza"
        System.out.println(refrigerator[1].name);  // 输出 "Hamburger"
        System.out.println(refrigerator[2].name);  // 输出 "Hotdog"
    }
}
```

##### 解释：

1. `Food[] refrigerator = new Food[3];`：我们创建了一个长度为 3 的 `Food` 对象数组，名为 `refrigerator`。
2. `refrigerator[0] = new Food("Pizza");`：我们创建了一个 `Pizza` 对象，并将其存储在数组的第一个位置（索引为 0）。
3. 通过 `refrigerator[0].name` 可以访问 `Pizza` 对象的 `name` 属性，并将其打印出来。

##### 输出结果：

```plain
Pizza
Hamburger
Hotdog
```

------

#### 4. 另一种创建数组的方式

我们可以在创建数组时直接初始化数组中的对象。

##### 方法 2：声明和初始化数组

```java
public class Main {
    public static void main(String[] args) {
        // 声明并初始化数组
        Food[] refrigerator = {
            new Food("Pizza"),
            new Food("Hamburger"),
            new Food("Hotdog")
        };

        // 打印数组中的对象的 name 属性
        System.out.println(refrigerator[0].name);  // 输出 "Pizza"
        System.out.println(refrigerator[1].name);  // 输出 "Hamburger"
        System.out.println(refrigerator[2].name);  // 输出 "Hotdog"
    }
}
```

##### 解释：

在这种方式中，我们直接在数组声明时初始化了 3 个 `Food` 对象，并将它们存储在数组中。这种方法更加简洁。

##### 输出结果：

```plain
Pizza
Hamburger
Hotdog
```

------

#### 5. 访问数组中的对象

我们可以通过数组的索引来访问和操作数组中的对象。例如，我们可以循环遍历数组，访问每个对象的属性。

##### 示例：遍历对象数组

```java
public class Main {
    public static void main(String[] args) {
        Food[] refrigerator = {
            new Food("Pizza"),
            new Food("Hamburger"),
            new Food("Hotdog")
        };

        // 使用 for 循环遍历数组
        for (int i = 0; i < refrigerator.length; i++) {
            System.out.println(refrigerator[i].name);
        }
    }
}
```

##### 输出结果：

```plain
Pizza
Hamburger
Hotdog
```

------

#### 6. 小结

1. **对象数组** 是存储对象引用的数组，数组的每个元素都是一个对象。
2. 创建对象数组的基本步骤是：声明数组、初始化数组、创建对象并将其存储在数组中。
3. 我们可以通过数组的索引来访问和操作数组中的对象。

##### 关键点回顾：

- 对象数组中的每个元素实际上是一个对象的引用。
- 数组索引从 0 开始。
- 可以通过循环遍历对象数组，访问每个对象的属性。

------

### 练习

1. 创建一个 `Book` 类，包含 `title`, `author` 和 `yearPublished` 属性。创建一个 `Book` 对象数组并将其初始化为包含 3 本书，随后打印每本书的详细信息。
2. 修改 `Food` 类，增加更多属性（如 `calories`），并更新程序以打印每个食物的名称和卡路里值。
3. 编写程序，创建一个 `Student` 类，包含 `name` 和 `age` 属性。然后创建一个 `Student` 对象数组，并将 5 个学生对象存储在数组中，最后打印每个学生的详细信息。
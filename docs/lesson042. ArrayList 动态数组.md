# lesson042. ArrayList 动态数组

### 1. **什么是** `ArrayList`**？**

`ArrayList` 是 Java 中非常常用的类，位于 `java.util` 包内，它表示一个**可调整大小的数组**，可以动态增加和删除元素。

与普通数组不同，`ArrayList` 能在运行时动态扩展或收缩。对于需要频繁增删元素的场景，`ArrayList` 是非常合适的选择。

#### **特点**：

- **动态大小**：可以根据需要动态调整大小，而不像普通数组那样固定不变。
- **快速随机访问**：通过索引访问元素的速度非常快，跟普通数组相同。
- **存储对象**：`ArrayList` 只能存储对象类型（引用类型），不能直接存储基本数据类型（如 `int`、`char` 等）。但由于自动装箱机制，可以存储包装类如 `Integer`、`Character` 等。

### 2. **创建** `ArrayList`

#### **语法**：

```java
ArrayList<Type> listName = new ArrayList<Type>();
```

- `Type` 是你要存储的对象类型，例如 `String`、`Integer` 等，注意不能是`int`。
- `listName` 是你定义的 `ArrayList` 的名字。

#### **示例**：

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 创建一个存储字符串的 ArrayList
        ArrayList<String> names = new ArrayList<String>();
    }
}
```

### 3. **常用操作**

#### 3.1 **添加元素：**`add()` **方法**

使用 `add()` 方法可以向 `ArrayList` 中添加元素。

```java
ArrayList<String> names = new ArrayList<String>();
names.add("Alice");
names.add("Bob");
names.add("Charlie");
```

#### 3.2 **获取元素：**`get()` **方法**

通过 `get()` 方法可以根据索引获取元素。索引从 `0` 开始。

```java
String name = names.get(1);  // 获取索引为 1 的元素，返回 "Bob"
```

#### 3.3 **修改元素：**`set()` **方法**

`set()` 方法可以根据索引修改元素。

```java
names.set(2, "David");  // 将索引为 2 的元素修改为 "David"
```

#### 3.4 **删除元素：**`remove()` **方法**

`remove()` 方法可以删除指定索引的元素，或根据元素值删除元素。

```java
names.remove(1);  // 删除索引为 1 的元素 ("Bob")
names.remove("Alice");  // 删除值为 "Alice" 的元素
```

#### 3.5 **获取大小：**`size()` **方法**

`size()` 方法返回 `ArrayList` 中当前元素的数量。

```java
int size = names.size();  // 返回当前 ArrayList 的大小
```

#### 3.6 **遍历** `ArrayList`

可以使用 `for` 循环或增强型 `for` 循环遍历 `ArrayList`。

```java
// 使用普通 for 循环
for (int i = 0; i < names.size(); i++) {
    System.out.println(names.get(i));
}

// 使用增强型 for 循环
for (String name : names) {
    System.out.println(name);
}
```

#### 3.7 **清空** `ArrayList`**：**`clear()` **方法**

`clear()` 方法用于清空 `ArrayList` 中的所有元素。

```java
names.clear();  // 清空 ArrayList 中的所有元素
```

#### 3.8 **检查是否为空：**`isEmpty()` **方法**

`isEmpty()` 方法用于检查 `ArrayList` 是否为空。

```java
if (names.isEmpty()) {
    System.out.println("The list is empty.");
}
```

### 4. `ArrayList` **中的自动装箱与拆箱**

`ArrayList` 只能存储对象类型，不能直接存储基本数据类型。但是，Java 提供了**自动装箱**和**拆箱**功能，可以将基本数据类型自动转换为对应的包装类。

#### **示例**：

```java
ArrayList<Integer> numbers = new ArrayList<Integer>();
numbers.add(10);  // 自动装箱：int -> Integer
numbers.add(20);
numbers.add(30);

int num = numbers.get(0);  // 自动拆箱：Integer -> int
System.out.println(num);  // 输出：10
```

### 5. **高级操作**

#### 5.1 **排序** `ArrayList`**：**`Collections.sort()`

使用 `Collections.sort()` 方法可以对 `ArrayList` 进行排序。

```java
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(30);
        numbers.add(10);
        numbers.add(20);

        // 排序
        Collections.sort(numbers);

        for (int number : numbers) {
            System.out.println(number);  // 输出：10, 20, 30
        }
    }
}
```

#### 5.2 **查找最大值和最小值：**`Collections.max()` **和** `Collections.min()`

可以使用 `Collections.max()` 和 `Collections.min()` 方法来查找 `ArrayList` 中的最大值和最小值。

```java
import java.util.Collections;

int max = Collections.max(numbers);
int min = Collections.min(numbers);
System.out.println("Max: " + max);  // 输出最大值
System.out.println("Min: " + min);  // 输出最小值
```

#### 5.3 **自定义排序**

如果你想对 `ArrayList` 中的对象根据自定义规则排序，可以通过实现 `Comparator` 接口来实现。

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class AgeComparator implements Comparator<Person> {
    public int compare(Person p1, Person p2) {
        return p1.age - p2.age;  // 按年龄升序排序
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<Person>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        // 使用自定义的 AgeComparator 进行排序
        Collections.sort(people, new AgeComparator());

        for (Person person : people) {
            System.out.println(person.name + ": " + person.age);
        }
    }
}
```

### 6. `ArrayList` **的局限性**

虽然 `ArrayList` 用起来非常方便，但它也有一些局限性：

- **线程不安全**：`ArrayList` 不是线程安全的，如果多个线程同时操作同一个 `ArrayList`，可能会发生数据不一致的情况。你可以使用 `Collections.synchronizedList()` 将其转换为线程安全的版本。

```java
List<String> syncList = Collections.synchronizedList(new ArrayList<String>());
```

- **性能问题**：`ArrayList` 在元素插入、删除时可能会涉及到数组元素的移动，导致性能下降。对于频繁插入和删除操作，可以考虑使用 `LinkedList`。

------

### 7.综合示例

我们可以通过使用 `set()`、`remove()` 和 `clear()` 等方法对 `ArrayList` 进行操作，并通过打印输出结果来观察这些操作的效果。以下是一个完整的示例，展示了如何使用这些方法操作 `ArrayList` 以及操作后的输出。

**示例代码：**

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 创建一个 ArrayList 来存储 String 类型的名字
        ArrayList<String> names = new ArrayList<String>();

        // 向 ArrayList 中添加元素
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        // 打印初始的 ArrayList
        System.out.println("Initial ArrayList: " + names);

        // 使用 set() 方法修改第一个元素
        names.set(0, "Alex");
        System.out.println("After using set() to change 'Alice' to 'Alex': " + names);

        // 使用 remove() 方法删除第二个元素 ("Bob")
        names.remove(1);  // 删除索引为 1 的元素
        System.out.println("After using remove() to delete 'Bob': " + names);

        // 再次添加一些元素
        names.add("David");
        names.add("Emma");
        System.out.println("After adding 'David' and 'Emma': " + names);

        // 使用 clear() 方法清空整个 ArrayList
        names.clear();
        System.out.println("After using clear() to remove all elements: " + names);
    }
}
```

**代码说明：**

1. **创建** `ArrayList` **并添加元素**：

- 我们创建了一个 `ArrayList<String>` 来存储名字，并使用 `add()` 方法添加了 `"Alice"`、`"Bob"` 和 `"Charlie"`。

1. `set()` **方法**：

- 使用 `set(0, "Alex")` 将索引为 0 的元素 `"Alice"` 修改为 `"Alex"`。

1. `remove()` **方法**：

- 使用 `remove(1)` 删除索引为 1 的元素 `"Bob"`。

1. **再次使用** `add()` **方法**：

- 添加了 `"David"` 和 `"Emma"` 两个新元素。

1. `clear()` **方法**：

- 使用 `clear()` 清空整个 `ArrayList`。

**输出结果：**

```plain
Initial ArrayList: [Alice, Bob, Charlie]
After using set() to change 'Alice' to 'Alex': [Alex, Bob, Charlie]
After using remove() to delete 'Bob': [Alex, Charlie]
After adding 'David' and 'Emma': [Alex, Charlie, David, Emma]
After using clear() to remove all elements: []
```

**结果分析：**

1. **初始状态**：

- `ArrayList` 中的元素为 `[Alice, Bob, Charlie]`。

1. **使用** `set()` **方法**：

- 将第一个元素 `"Alice"` 修改为 `"Alex"`，结果变为 `[Alex, Bob, Charlie]`。

1. **使用** `remove()` **方法**：

- 删除了索引为 1 的元素 `"Bob"`，结果变为 `[Alex, Charlie]`。

1. **再次添加元素**：

- 添加了 `"David"` 和 `"Emma"`，结果变为 `[Alex, Charlie, David, Emma]`。

1. **使用** `clear()` **方法**：

- 清空了整个 `ArrayList`，结果为空 `[]`。

------

### 8. **总结**

这一章介绍了 `ArrayList` 的基本使用方法和常见操作。`ArrayList` 是 Java 中非常强大且常用的集合类，适合用于需要动态调整大小的场景。通过这一章，你应该已经掌握了 `ArrayList` 的创建、元素的增删改查、遍历、排序等操作。
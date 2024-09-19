# lesson043. 增强型 for 循环（for-each loop）

### 1. **什么是增强型** `for` **循环？**

增强型 `for` 循环，也叫 `for-each loop`，是一种简化遍历数组或集合（如 `ArrayList`）的方式。它的语法更简洁，并且更加可读，适合在不关心索引的情况下遍历元素。

#### **特点**：

- **简洁**：相比传统的 `for` 循环，`for-each` 省去了定义索引和控制循环的步骤。
- **可读性强**：代码更加直观，易于理解。
- **局限性**：不能修改正在遍历的集合中的元素，不能获取当前元素的索引。

### 2. **增强型** `for` **循环的语法**

增强型 `for` 循环的语法如下：

```java
for (Type element : collection) {
    // 对每个元素进行操作
}
```

- `Type`：集合中元素的类型（如 `String`、`int` 等）。
- `element`：每次迭代时的当前元素。
- `collection`：要遍历的数组或集合（如 `ArrayList`、数组等）。

### 3. **使用增强型** `for` **循环遍历数组**

增强型 `for` 循环最常见的用法是遍历数组或集合中的所有元素。以下是遍历一个数组的示例：

```java
public class Main {
    public static void main(String[] args) {
        // 定义一个数组
        int[] numbers = {10, 20, 30, 40, 50};

        // 使用增强型 for 循环遍历数组
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
```

#### **输出结果**：

```plain
10
20
30
40
50
```

### 4. **使用增强型** `for` **循环遍历** `ArrayList`

增强型 `for` 循环也可以用于遍历 `ArrayList` 这样的集合。以下是一个使用 `ArrayList` 的示例：

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 创建一个 ArrayList 并添加元素
        ArrayList<String> names = new ArrayList<String>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        // 使用增强型 for 循环遍历 ArrayList
        for (String name : names) {
            System.out.println(name);
        }
    }
}
```

#### **输出结果**：

```plain
Alice
Bob
Charlie
```

### 5. **增强型** `for` **循环的优缺点**

#### **优点**：

- **语法简洁**：不需要手动管理索引，减少了错误的可能性。
- **可读性强**：代码更加直观，易于理解，适合快速遍历集合或数组。

#### **缺点**：

- **灵活性不足**：无法获取当前元素的索引。如果你需要访问元素的索引，仍然需要使用传统的 `for` 循环。
- **不能修改元素**：增强型 `for` 循环不能直接修改集合中的元素，必须通过索引来修改。

### 6. **增强型** `for` **循环的局限性**

尽管增强型 `for` 循环很方便，但它并不适用于所有场景。例如，你不能在增强型 `for` 循环中向 `ArrayList` 中添加或删除元素。如果你需要动态修改列表的内容，应该使用传统的 `for` 循环或 `Iterator`。

```java
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        // 使用 Iterator 来删除元素
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            if (name.equals("Bob")) {
                iterator.remove();  // 删除元素
            }
        }

        // 打印删除后的 ArrayList
        for (String name : names) {
            System.out.println(name);
        }
    }
}
```

#### **输出结果**：

```plain
Alice
Charlie
```

### 7. **增强型** `for` **循环与传统** `for` **循环的比较**

| 特性         | 增强型 `for` 循环                          | 传统 `for` 循环                  |
| ------------ | ------------------------------------------ | -------------------------------- |
| **语法**     | 简洁、可读                                 | 较为复杂，需要手动维护索引       |
| **索引访问** | 不支持                                     | 支持                             |
| **元素修改** | 不能直接修改元素                           | 可以通过索引修改元素             |
| **适用场景** | 遍历整个集合或数组，且不需要索引或修改元素 | 需要索引访问元素或修改元素的场景 |

### 8. **总结**

增强型 `for` 循环是遍历集合和数组的简化工具。它提供了更加简洁和可读的方式来处理集合中的元素，尤其适合那些不需要修改集合或访问元素索引的情况。

- **使用场景**：当你需要遍历集合或数组的所有元素，且不需要修改元素或访问索引时，增强型 `for` 循环是最佳选择。
- **局限性**：由于无法访问索引或修改元素，增强型 `for` 循环在某些情况下不如传统的 `for` 循环灵活。

下一章将介绍 `Iterator`，它提供了遍历集合的另一种方式，并且允许在遍历过程中安全地修改集合中的元素。

------

这个章节介绍了增强型 `for` 循环的用法、优势和局限性，并通过代码示例展示了其基本操作。你可以根据实际需求在项目中灵活应用。
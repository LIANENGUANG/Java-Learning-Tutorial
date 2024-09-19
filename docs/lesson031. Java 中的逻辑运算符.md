# lesson031. Java 中的逻辑运算符

在 Java 中，**逻辑运算符**用于连接两个或多个条件表达式，并返回一个布尔值（`true` 或 `false`）。这些运算符通常与 `if` 语句或其他条件判断语句一起使用，来编写更复杂的逻辑判断。

------

#### 1. 常见的逻辑运算符

在 Java 中，常见的逻辑运算符有以下几种：

- `&&` （逻辑与，AND）：当**所有条件**为 `true` 时，整个表达式才为 `true`。
- `||` （逻辑或，OR）：只要有**任意一个条件**为 `true`，整个表达式就为 `true`。
- `!` （逻辑非，NOT）：用于反转布尔表达式的值。如果条件为 `true`，那么 `!` 操作后变为 `false`；反之亦然。

------

#### 2. `&&`（AND）运算符

`&&` 运算符要求**所有条件**必须为 `true`，整个表达式才为 `true`。如果有一个条件为 `false`，最终结果就是 `false`。

##### 示例：

```java
int age = 20;
boolean hasID = true;

if (age >= 18 && hasID) {
    System.out.println("You are allowed to enter.");
} else {
    System.out.println("You are not allowed to enter.");
}
```

**解释**：

- `age >= 18` 为 `true`，`hasID` 也为 `true`，因此整个表达式 `age >= 18 && hasID` 为 `true`，输出 `"You are allowed to enter."`。

##### 注意：

- 如果第一个条件已经为 `false`，Java 将不会再检查第二个条件（短路操作），因为整个表达式必然为 `false`。

------

#### 3. `||`（OR）运算符

`||` 运算符要求**至少一个条件**为 `true`，整个表达式就为 `true`。

##### 示例：

```java
boolean isWeekend = true;
boolean isHoliday = false;

if (isWeekend || isHoliday) {
    System.out.println("You can relax today.");
} else {
    System.out.println("You have to work today.");
}
```

**解释**：

- `isWeekend` 为 `true`，所以尽管 `isHoliday` 为 `false`，整个表达式 `isWeekend || isHoliday` 为 `true`，输出 `"You can relax today."`。

##### 注意：

- 如果第一个条件已经为 `true`，那么 Java 不会再检查第二个条件（短路操作），因为整个表达式必然为 `true`。

------

#### 4. `!`（NOT）运算符

`!` 运算符用于**反转**一个布尔值。如果条件为 `true`，使用 `!` 后会变为 `false`；如果条件为 `false`，使用 `!` 后会变为 `true`。

##### 示例：

```java
boolean isRaining = false;

if (!isRaining) {
    System.out.println("You can go outside.");
} else {
    System.out.println("You should stay inside.");
}
```

**解释**：

- `isRaining` 为 `false`，使用 `!isRaining` 后变为 `true`，因此输出 `"You can go outside."`。

------

#### 5. 逻辑运算符的组合使用

你可以将多个逻辑运算符组合在一起，构建更复杂的条件判断。

##### 示例：

```java
int age = 22;
boolean hasID = true;
boolean isMember = false;

if ((age >= 18 && hasID) || isMember) {
    System.out.println("You are allowed to enter.");
} else {
    System.out.println("You are not allowed to enter.");
}
```

**解释**：

- 在这个例子中，`age >= 18 && hasID` 为 `true`，因此虽然 `isMember` 为 `false`，但整个表达式 `(age >= 18 && hasID) || isMember` 仍然为 `true`，输出 `"You are allowed to enter."`。

------

#### 6. 总结

- `&&` （AND）：当**所有条件**为 `true` 时，整个表达式为 `true`。如果有任何一个条件为 `false`，结果就是 `false`。
- `||` （OR）：当**至少一个条件**为 `true` 时，整个表达式为 `true`。只有当所有条件都为 `false` 时，结果才为 `false`。
- `!` （NOT）：反转布尔表达式的值。`true` 变为 `false`，`false` 变为 `true`。

逻辑运算符在 Java 中非常重要，帮助我们构建复杂的条件判断逻辑。在编写 `if` 语句和其他条件判断时，这些运算符能够让代码更加灵活和高效。
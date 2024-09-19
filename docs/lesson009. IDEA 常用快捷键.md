# lesson009. IDEA 常用快捷键

在 Java 开发中，使用合适的快捷键能够大大提升编程效率。对于 IntelliJ IDEA 这种强大的 IDE（集成开发环境），掌握一些常用的快捷键可以让你更加高效地编写、调试和运行代码。下面是一些常用的 IntelliJ IDEA 快捷键及其功能说明。

#### 1. `sout` **+** `Tab`**：快速生成** `System.out.println`

这是 IntelliJ IDEA 中生成 `System.out.println` 语句的快捷方式。只需输入 `sout`，然后按下 `Tab` 键，IDE 将自动补全为 `System.out.println()`，可以省去手动输入的时间。

**示例**：

- 输入：`sout` + `Tab`
- 自动补全为：`System.out.println();`

#### 2. `psvm` **+** `Tab`**：快速生成** `main` **方法**

在 Java 程序中，`main` 方法是程序的入口点。使用 `psvm` + `Tab` 能快速生成 `public static void main(String[] args)` 代码片段。

**示例**：

- 输入：`psvm` + `Tab`
- 自动补全为：

```java
public static void main(String[] args) {
}
```

#### 3. `Ctrl` **+** `/`**：单行注释**

在 IntelliJ 中，通过按下 `Ctrl` + `/` 可以快速对当前行进行注释或取消注释。

**示例**：

- 选中某行代码，按下 `Ctrl` + `/`，该行代码会被加上 `//` 注释。
- 再次按下 `Ctrl` + `/`，注释会被取消。

#### 4. `Ctrl` **+** `Shift` **+** `/`**：多行注释**

对于多行注释，可以使用 `Ctrl` + `Shift` + `/`，这将添加或取消 `/* ... */` 形式的注释。

**示例**：

- 选中多行代码，按下 `Ctrl` + `Shift` + `/`，所有选中的代码将被注释为：

```java
/*
  这些行被注释了
*/
```

#### 5. `Alt` **+** `Enter`**：智能修正**

当代码中有语法错误或可以优化的部分时，按下 `Alt` + `Enter` 可以弹出一个修正建议菜单，帮助你自动修复问题或优化代码。

**示例**：

- 当变量未声明时，按下 `Alt` + `Enter`，IDE 会建议你自动生成声明。

#### 6. `Ctrl` **+** `D`**：复制一行**

想快速复制当前行？只需按下 `Ctrl` + `D`，当前行将被自动复制到下一行，省去了手动复制、粘贴的时间。

#### 7. `Ctrl` **+** `Shift` **+** `F10`**：运行程序**

按下 `Ctrl` + `Shift` + `F10` 可以快速运行当前的 Java 程序，不需要手动去点运行按钮。

#### 8. `Ctrl` **+** `Space`**：代码补全**

当你输入代码时，按下 `Ctrl` + `Space` 可以让 IntelliJ IDEA 自动补全代码片段或提供相关的代码建议。

#### 9. `Shift` **+** `F6`**：重命名**

在重构代码时，可以使用 `Shift` + `F6` 来重命名变量、方法、类等。IDE 将自动更新所有相关引用，确保代码一致性。

#### 10. `Ctrl` **+** `Shift` **+** `Up/Down`**：移动代码行**

按下 `Ctrl` + `Shift` + `Up/Down` 键可以将当前行代码上下移动，方便你快速调整代码顺序。

------

### 快捷键总结

- `sout` **+** `Tab`：生成 `System.out.println()`。
- `psvm` **+** `Tab`：生成 `public static void main(String[] args)`。
- `command` **+** `/`：单行注释/取消注释。
- `command` **+** `Shift` **+** `/`：多行注释/取消注释。
- `option` **+** `Enter`：智能修正。
- `command` **+** `D`：复制当前行。
- `Ctrl` **+** `Shift` **+** `F10`：运行程序。
- `command` **+** `Shift` **+** `Up/Down`：上下移动当前代码行。
- `command` **+** `shift` + `R`：当前文件内替换。
- `command` **+** `+/-`：放大或者缩小编辑器字体。
- `command` **+** `shift` + `L`：格式化代码更美观。
- `command` **+** `G`：跳转到指定行。
- `command` + `R`：运行程序。
- `command` + `，`：intellij preferences打开设置。
- `command` + `A`：选中编辑器全部代码。

### 如何在 IntelliJ IDEA 中找到快捷键设置 (Keymap)

IntelliJ IDEA 提供了强大的 **Keymap**（快捷键映射）设置功能，你可以通过以下步骤来查看或修改快捷键：

1. **打开 Keymap 设置**：
   - **快捷键方式**：
     按下 `Cmd` + `,`，这是 macOS 常用的打开程序设置的快捷键，适用于大多数应用程序，包括 IntelliJ IDEA。
   - **菜单栏方式**：
     在 IntelliJ IDEA 界面中，点击顶部菜单栏中的 **IntelliJ IDEA**，然后选择下拉菜单中的 **Preferences...**，即可进入设置面板。
   
2. **导航到 Keymap 设置**：
   在设置面板中，点击左侧菜单的 **Keymap**，你将看到所有可配置的快捷键。

3. **查找快捷键**：
   在 Keymap 设置的搜索框中，你可以输入某个功能的名称来查看或修改它的快捷键。例如，输入 `Run` 可以找到所有与运行相关的快捷键。

4. **修改快捷键**：
   在键位映射列表中，右键点击某个快捷键动作，选择 **Add Keyboard Shortcut**（添加键盘快捷键）或 **Remove**（移除）来修改或删除快捷键。

### 快捷键对应的 Keymap 名称（英文）

我们最好通过搜索引擎找到我们所需要调整的快捷键所对应的 Keymap 的英文名称精准定位到该快捷键，以下列出的是我们上述所说的常用快捷键对应的keymap名称，大家可以根据自己的需要在自己的 IDE 中进行适当的修改：

#### 1. `sout` + `Tab`：**Live Template**

- **Keymap 名称**：`System.out.println(); (sout)`
- 这是一个 **Live Template**（动态模板），你可以在 Keymap 设置中搜索 **Live Templates**，找到 `sout` 模板。

#### 2. `psvm` + `Tab`：**Live Template**

- **Keymap 名称**：`public static void main(String[] args) (psvm)`
- 同样是一个 **Live Template**，可以通过搜索 **Live Templates** 查看和修改。

#### 3. `Ctrl` + `/`（macOS：`Cmd` + `/`）：**Comment with Line Comment**

- **Keymap 名称**：`Comment with Line Comment`
- 这个快捷键用于单行注释，搜索 **Comment with Line Comment** 可以找到。

#### 4. `Ctrl` + `Shift` + `/`（macOS：`Cmd` + `Shift` + `/`）：**Comment with Block Comment**

- **Keymap 名称**：`Comment with Block Comment`
- 这个快捷键用于多行注释，搜索 **Comment with Block Comment** 可以找到。

#### 5. `Alt` + `Enter`（macOS：`Option` + `Enter`）：**Show Intention Actions**

- **Keymap 名称**：`Show Intention Actions`
- 这是 IntelliJ IDEA 的智能修正快捷键，搜索 **Show Intention Actions** 可以找到。

#### 6. `Ctrl` + `D`（macOS：`Cmd` + `D`）：**Duplicate Line or Block**

- **Keymap 名称**：`Duplicate Line or Block`
- 这个快捷键用于复制当前行或选定的代码块，搜索 **Duplicate Line or Block** 可以找到。

#### 7. `Ctrl` + `Shift` + `F10`（macOS：`Cmd` + `Shift` + `R`）：**Run**

- **Keymap 名称**：`Run`
- 这个快捷键用于运行当前程序，搜索 **Run** 可以找到。

#### 8. `Ctrl` + `Space`（macOS：`Cmd` + `Space`）：**Code Completion**

- **Keymap 名称**：`Code Completion`
- 这个快捷键用于代码补全功能，搜索 **Code Completion** 可以找到。

#### 9. `Shift` + `F6`：**Rename**

- **Keymap 名称**：`Rename`
- 这个快捷键用于重命名变量、方法或类，搜索 **Rename** 可以找到。

#### 10. `Ctrl` + `Shift` + `Up/Down`（macOS：`Cmd` + `Shift` + `Up/Down`）：**Move Statement Up/Down**

- **Keymap 名称**：`Move Statement Up/Down`
- 用于移动当前行或代码块，搜索 **Move Statement Up/Down** 可以找到。

你可以通过 IntelliJ IDEA 的 **Keymap** 设置来查看和修改快捷键。所有快捷键的功能都对应一个特定的 **Keymap 名称**，你可以通过设置菜单中的搜索框输入这些名称来找到具体的快捷键配置。

如果你希望进一步优化快捷键或查看更多快捷键，建议在 Keymap 设置中熟悉并定制符合自己开发习惯的快捷键。

# lesson011. IntelliJ IDEA 中快速替换（以替换 `print` 为 `println` 为例）

在编写代码的过程中，可能会遇到需要批量替换某些代码片段的情况。IntelliJ IDEA 提供了强大的搜索和替换功能，可以帮助我们快速、高效地替换代码中的内容。下面以将所有的 `print` 替换为 `println` 为例，介绍如何使用 IntelliJ IDEA 的快速替换功能。

------

### 1. **使用快捷键打开搜索和替换功能**

首先，在 IntelliJ IDEA 中，打开搜索和替换功能有两种方法：

- **方法 1**：通过菜单导航：

- 点击 `Edit` 菜单，选择 `Find` -> `Replace...`。

- **方法 2**：使用快捷键：

- `Command + R`（macOS） 或 `Ctrl + R`（Windows/Linux） 打开当前文件内的替换工具。
- `Command + Shift + R`（macOS） 或 `Ctrl + Shift + R`（Windows/Linux） 用于跨文件的全局替换。

------

### 2. **在当前文件中替换** `print` **为** `println`

1. **打开替换工具**：

- 使用快捷键 `Command + R`（macOS） 或 `Ctrl + R`（Windows/Linux） 打开替换工具。

2. **输入要替换的内容**：

- 在 **Find** 输入框中，输入 `print`。
- 在 **Replace with** 输入框中，输入 `println`。

3. **执行替换**：

- 点击 `Replace` 按钮，替换当前文件中的单个 `print` 为 `println`。
- 如果需要将所有 `print` 一次性替换成 `println`，可以点击 `Replace All` 按钮，IDE 将会将文件中所有匹配的 `print` 全部替换为 `println`。

------

### 3. **在整个项目中替换** `print` **为** `println`

如果你想在整个项目中替换所有的 `print`，可以使用全局替换功能。

1. **打开全局替换工具**：

- 使用快捷键 `Command + Shift + R`（macOS） 或 `Ctrl + Shift + R`（Windows/Linux） 打开全局替换工具。

2. **输入要替换的内容**：

- 在 **Find** 输入框中，输入 `print`。
- 在 **Replace with** 输入框中，输入 `println`。

3. **设置替换范围**：

- IntelliJ IDEA 会自动列出所有匹配的 `print` 代码。你可以选择要替换的范围，包括当前文件、整个项目，或者仅限于某个文件夹。

4. **执行替换**：

- 点击 `Replace All`，将整个项目中所有的 `print` 替换为 `println`。

------

### 4. **使用正则表达式进行替换**

如果需要更复杂的替换，IntelliJ IDEA 还支持 **正则表达式**（Regular Expressions）。例如，如果你想替换 `print()` 为 `println()` 并且想保留括号内的内容，可以使用正则表达式。

1. **启用正则表达式**：

- 在替换工具的右侧，勾选 **Regex** 选项。

2. **输入正则表达式**：

其中，`(.*)` 表示匹配括号内的任意内容，`$1` 则表示保留匹配到的内容。

- 在 **Find** 输入框中输入：`print\((.*)\)`
- 在 **Replace with** 输入框中输入：`println($1)`

3. **执行替换**：

- 点击 **Replace** 或 **Replace All** 完成替换。

------

### 5. **常见问题及注意事项**

- **区分大小写**：如果你的项目中同时存在 `Print` 和 `print`，你可以通过勾选 **Match Case** 来区分大小写。
- **替换范围**：在全局替换时，确保选择正确的替换范围（文件夹或整个项目），以避免替换到不该替换的内容。
- **替换后检查**：在进行大规模替换时，建议先在一个文件中测试替换效果，确认无误后再进行全局替换。

------

### 总结

- **替换快捷键**：

- 当前文件替换：`Command + R`（macOS） 或 `Ctrl + R`（Windows/Linux）
- 全局替换：`Command + Shift + R`（macOS） 或 `Ctrl + Shift + R`（Windows/Linux）

- **替换步骤**：

1. 打开替换工具。
2. 输入要查找和替换的内容。
3. 执行替换或全局替换。

- **正则表达式替换**：使用正则表达式可以进行更高级的替换操作，比如保留括号内的内容。

通过 IntelliJ IDEA 的替换功能，你可以高效地在代码中进行批量修改，节省大量的手动编辑时间。
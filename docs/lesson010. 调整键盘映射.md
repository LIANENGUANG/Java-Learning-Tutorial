# lesson010. 调整键盘映射

### 如何在 macOS 下调整 IntelliJ IDEA 的快捷键（以单行注释快捷键为例）

在 macOS 上，默认的 `Ctrl + /` 快捷键可能无法使用，因为 macOS 上的键盘布局与 Windows/Linux 不同，很多系统功能占用了 `Ctrl` 键组合。所以在 macOS 上，`Command + /` 是默认的快捷键来进行单行注释。这是因为 IntelliJ IDEA 自动适配了 macOS 的键盘布局。

#### 如果你希望将 `Command + /` 改为 `Ctrl + /`，可以按照以下步骤进行快捷键调整。

------

### 1. **查看当前快捷键映射方案**

IntelliJ IDEA 提供了不同的平台快捷键映射方案：

- **Mac OS X 10.5+**：这是 macOS 默认的快捷键方案，很多快捷键使用 `Command` 键。
- **Windows/Linux**：使用 `Ctrl` 键作为快捷键的主要修饰符。

要查看或更改当前使用的快捷键方案：

1. 打开 IntelliJ IDEA，点击菜单栏中的 `IntelliJ IDEA` -> `Preferences`（或使用快捷键 `Command + ,` 打开设置）。
2. 在设置窗口中，左侧导航栏选择 **Keymap**。
3. 在右侧面板中，你会看到当前使用的快捷键方案。例如，macOS 默认会选择 **Mac OS X 10.5+**。

------

### 2. **修改单行注释的快捷键**

如果你想将 `Command + /` 修改为 `Ctrl + /`，可以按照以下步骤进行：

1. **打开 Keymap 设置**：

- 点击 `IntelliJ IDEA` -> `Preferences`，或者按快捷键 `Command + ,`。
- 在左侧导航栏中选择 **Keymap**。

2. **查找单行注释的快捷键**：

- 在 Keymap 窗口的搜索栏中，输入 `Comment with Line Comment`。这个就是用于单行注释的操作。

3. **修改快捷键**：

- 右键点击 **Comment with Line Comment** 选项。
- 选择 **Add Keyboard Shortcut**。
- 在弹出的窗口中，按下你希望设置的快捷键组合（如 `Ctrl + /`）。
- 如果提示该快捷键已被其他操作占用，你可以选择将旧快捷键替换，或者选择其他组合键。

4. **应用并保存设置**：

- 点击 **OK** 完成设置。
- 现在，你可以使用 `Ctrl + /` 来执行单行注释操作了。

------

### 3. **示例：调整单行注释快捷键为** `Ctrl + /`

假设你在 Mac 上使用 IntelliJ IDEA，并且希望将单行注释的快捷键从 `Command + /` 改为 `Ctrl + /`：

- **问题**：默认情况下，macOS 上的 IntelliJ IDEA 使用 `Command + /` 作为单行注释的快捷键，但你想将其改为 `Ctrl + /`。
- **解决方案**：按照上述步骤，在 IntelliJ IDEA 的 **Keymap** 设置中找到 **Comment with Line Comment**，并将快捷键修改为 `Ctrl + /`。

#### 修改前：

- 单行注释快捷键：`Command + /`

#### 修改后：

- 单行注释快捷键：`Ctrl + /`

现在，你可以使用 `Ctrl + /` 轻松地注释或取消注释代码行了。

------

### 4. **常见问题**

#### 1. **为什么 macOS 上使用** `Command + /`**？**

- 由于 macOS 系统的一些默认快捷键配置，很多软件在 macOS 上会使用 `Command` 键作为主要的快捷键修饰符，而不是 `Ctrl` 键。

#### 2. **如何恢复默认快捷键？**

- 如果你想恢复默认的 `Command + /` 快捷键，只需在 **Keymap** 中找到 **Comment with Line Comment**，右键点击并选择 **Remove** 来删除自定义的快捷键设置，系统会恢复到默认的 `Command + /`。

------

### 总结

- **默认快捷键**：在 macOS 上，IntelliJ IDEA 默认使用 `Command + /` 来进行单行注释。
- **自定义快捷键**：如果你希望使用 `Ctrl + /` 来进行单行注释，可以通过 IntelliJ IDEA 的 **Keymap** 设置进行修改。
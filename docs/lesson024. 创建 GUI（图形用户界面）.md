# lesson024. 创建 GUI（图形用户界面）

在 Java 中，**GUI（Graphical User Interface）** 是一种允许用户通过图形化的元素（如按钮、文本框、对话框等）与程序进行交互的界面。Java 提供了多个库来创建 GUI，其中 **Swing** 是最常用的 GUI 库之一。通过 `javax.swing` 包中的组件，我们可以快速创建对话框、窗口等图形用户界面。

------

### **1.** `JOptionPane` **简单对话框**

`JOptionPane` 是 Java Swing 中的一个类，用于创建简单的对话框，它可以用于显示消息、获取用户输入等。

#### **常用方法：**

- `showMessageDialog(Component parentComponent, Object message)`：显示一个消息对话框。
- `showInputDialog(Component parentComponent, Object message)`：显示一个输入对话框，允许用户输入数据。
- `showConfirmDialog(Component parentComponent, Object message)`：显示一个确认对话框，用户可以选择 `Yes`、`No` 或 `Cancel`。

------

### **2. 创建一个简单的 GUI 程序**

下图中的代码展示了如何使用 `JOptionPane` 类创建几个简单的对话框，获取用户的输入并显示消息。

#### **示例代码：**

```java
import javax.swing.JOptionPane;  // 引入 JOptionPane 类

public class Main {
    public static void main(String[] args) {
        // 获取用户的名字
        String name = JOptionPane.showInputDialog("Enter your name");
        // 显示问候消息
        JOptionPane.showMessageDialog(null, "Hello " + name);

        // 获取用户的年龄并转换为整数类型
        // JOptionPane.showInputDialog 返回的是字符串类型
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age"));
        // 显示年龄
        JOptionPane.showMessageDialog(null, "You are " + age + " years old");

        // 获取用户的身高并转换为浮点数
        double height = Double.parseDouble(JOptionPane.showInputDialog("Enter your height (in cm)"));
        // 显示身高
        JOptionPane.showMessageDialog(null, "You are " + height + " cm tall");
    }
}
```

#### **解释：**

1. `JOptionPane.showInputDialog("Enter your name")`：

- 弹出一个对话框，提示用户输入其姓名。
- 返回用户输入的字符串，并将其存储在变量 `name` 中。

2. `JOptionPane.showMessageDialog(null, "Hello " + name)`：

- 显示一个消息对话框，内容为 "Hello [用户名]"，例如 "Hello John"。

3. `Integer.parseInt(JOptionPane.showInputDialog("Enter your age"))`：

- 弹出一个输入对话框，提示用户输入年龄。
- 使用 `Integer.parseInt()` 将输入的字符串转换为整数，并将其存储在变量 `age` 中。

4. `Double.parseDouble(JOptionPane.showInputDialog("Enter your height"))`：

- 类似于上面的年龄输入，这里提示用户输入身高，并将输入的字符串转换为 `double` 类型。

------

### **3. 更复杂的 GUI 组件**

除了 `JOptionPane` 之外，Swing 还提供了许多其他 GUI 组件，比如：

- `JFrame`：主窗口。
- `JButton`：按钮。
- `JLabel`：标签，用于显示文本。
- `JTextField`：文本框，允许用户输入文本。
- `JPanel`：面板，用于组织其他组件。

#### **示例：使用** `JFrame` **创建一个简单的窗口**

```java
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // 创建一个 JFrame 窗口
        JFrame frame = new JFrame("Simple GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // 创建一个标签
        JLabel label = new JLabel("Welcome to the GUI program!", SwingConstants.CENTER);
        
        // 创建一个按钮
        JButton button = new JButton("Click Me");

        // 创建一个面板并将组件添加到面板
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(button);

        // 将面板添加到窗口
        frame.add(panel);

        // 显示窗口
        frame.setVisible(true);
    }
}
```

#### **解释：**

1. `JFrame`：

- 创建一个窗口对象 `frame`。
- 设置窗口的关闭操作为 `EXIT_ON_CLOSE`，即点击关闭按钮时程序退出。
- 设置窗口大小为 400x200 像素。

2. `JLabel`：

- 创建一个标签 `label`，文本居中显示。

3. `JButton`：

- 创建一个按钮 `button`，按钮上显示 "Click Me"。

4. `JPanel`：

- 创建一个面板 `panel`，用来布局和组织组件。
- 将标签和按钮添加到面板中。

5. `frame.add(panel)`：

- 将面板添加到窗口中。

6. `frame.setVisible(true)`：

- 使窗口可见。

------

### **4. GUI 事件处理**

GUI 程序的关键在于事件处理。例如，用户点击按钮时，程序需要做出响应。Java 提供了事件监听器来捕捉用户的动作。

#### **示例：添加按钮点击事件**

```java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // 创建一个 JFrame 窗口
        JFrame frame = new JFrame("Button Click Event");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // 创建一个按钮
        JButton button = new JButton("Click Me");

        // 添加按钮点击事件
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 当按钮被点击时，弹出消息框
                JOptionPane.showMessageDialog(null, "Button Clicked!");
            }
        });

        // 创建一个面板并将按钮添加到面板
        JPanel panel = new JPanel();
        panel.add(button);

        // 将面板添加到窗口
        frame.add(panel);

        // 显示窗口
        frame.setVisible(true);
    }
}
```

#### **解释：**

1. `button.addActionListener()`：

- 添加一个事件监听器，监听按钮的点击事件。
- 当按钮被点击时，执行 `actionPerformed()` 方法。

2. `JOptionPane.showMessageDialog()`：

- 当按钮被点击时，弹出一个消息对话框，显示 "Button Clicked!"。

------

### **5. 小结**

- `JOptionPane` 是 Java Swing 中一个用于创建输入、消息和确认对话框的类，适用于简单的 GUI 操作。
- 更复杂的 GUI 程序可以使用 `JFrame`、`JButton`、`JLabel`、`JPanel` 等组件来创建窗口和交互界面。
- 事件处理是 GUI 程序的重要部分，通常通过事件监听器（如 `ActionListener`）来响应用户的操作。

通过这些 GUI 组件和事件监听器，你可以创建功能丰富的图形用户界面，提升用户体验。
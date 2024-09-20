# lesson073. Java Swing 中的 JLabel 进阶使用

在本章节中，我们将深入探讨如何在 Java Swing 中使用 `JLabel` 来显示图像、文本，并通过各种方法自定义它的外观和行为。我们将通过一个完整的代码示例，详细讲解 `JLabel` 的属性和方法。

------

#### 1. 代码解释

下面是一个完整的示例代码，它展示了如何使用 `JLabel` 来显示文本和图像，并自定义其外观和布局。

```java
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Main {

    public static void main(String[] args) {

        // JLabel = a GUI display area for a string of text, an image, or both
        
        ImageIcon image = new ImageIcon("dude.png"); // 加载图像
        Border border = BorderFactory.createLineBorder(Color.green, 3); // 创建绿色边框，宽度为 3 像素
        
        JLabel label = new JLabel(); // 创建一个 JLabel 对象
        label.setText("bro, do you even code?"); // 设置标签的文本
        label.setIcon(image); // 设置标签的图标（图片）
        label.setHorizontalTextPosition(JLabel.CENTER); // 设置文本相对于图标的水平位置：居中
        label.setVerticalTextPosition(JLabel.TOP); // 设置文本相对于图标的垂直位置：顶部
        label.setForeground(new Color(0x00FF00)); // 设置文本的字体颜色为绿色
        label.setFont(new Font("MV Boli", Font.PLAIN, 100)); // 设置文本的字体样式和大小
        label.setIconTextGap(-25); // 设置文本与图标之间的间距
        label.setBackground(Color.black); // 设置标签的背景颜色为黑色
        label.setOpaque(true); // 设置标签不透明，以便显示背景颜色
        //label.setBorder(border); // 设置标签的边框 (未启用)
        label.setVerticalAlignment(JLabel.CENTER); // 设置图标和文本在标签内的垂直居中
        label.setHorizontalAlignment(JLabel.CENTER); // 设置图标和文本在标签内的水平居中
        //label.setBounds(100, 100, 250, 250); // 设置标签的位置和大小（未启用）
            
        JFrame frame = new JFrame(); // 创建一个 JFrame 窗口
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置关闭操作
        //frame.setSize(500,500); // 设置窗口大小（未启用）
        //frame.setLayout(null); // 使用绝对布局（未启用）
        frame.setVisible(true); // 使窗口可见
        frame.add(label); // 将标签添加到窗口
        frame.pack(); // 根据内容自动调整窗口大小
    }
}
```

---

#### 2. 详细讲解

##### 2.1 `JLabel` 的基础设置

- **`label.setText("bro, do you even code?");`**  
  这行代码设置了 `JLabel` 显示的文本内容。标签不仅可以显示文本，还可以显示图像或两者结合。

- **`ImageIcon image = new ImageIcon("dude.png");`**  
  `ImageIcon` 用于加载和显示图像。通过将图像文件路径传递给 `ImageIcon` 构造函数，标签中可以显示这张图片。

##### 2.2 文本和图像的布局

- **`label.setIcon(image);`**  
  这行代码将图片添加到标签中，`JLabel` 可以同时显示文本和图像。

- **`label.setHorizontalTextPosition(JLabel.CENTER);`**  
  水平文本位置相对于图标设置为居中，这意味着文本会显示在图标的正上方或正下方。

- **`label.setVerticalTextPosition(JLabel.TOP);`**  
  这行代码将文本相对于图标设置为顶部，这意味着文本将显示在图标的上方。

##### 2.3 字体和样式设置

- **`label.setForeground(new Color(0x00FF00));`**  
  设置文本的颜色为绿色。颜色通过 `Color` 对象设置，`0x00FF00` 是绿色的 RGB 颜色代码。

- **`label.setFont(new Font("MV Boli", Font.PLAIN, 100));`**  
  这行代码设置了标签文本的字体样式。`MV Boli` 是字体名称，`Font.PLAIN` 表示普通样式，100 是字体大小。

##### 2.4 对齐和间距设置

- **`label.setIconTextGap(-25);`**  
  调整文本与图标之间的间距，这里设置为 -25，表示文本会更靠近图标，甚至可能覆盖在一起。

- **`label.setHorizontalAlignment(JLabel.CENTER);`**  
  这行代码将图标和文本设置为在标签内水平居中。

- **`label.setVerticalAlignment(JLabel.CENTER);`**  
  这行代码将图标和文本设置为在标签内垂直居中。

##### 2.5 背景和边框设置

- **`label.setBackground(Color.black);`**  
  设置标签的背景颜色为黑色。默认情况下，`JLabel` 是透明的，因此需要将其设置为不透明才能显示背景颜色。

- **`label.setOpaque(true);`**  
  使标签不透明，以便显示设置的背景颜色。如果不调用此方法，背景颜色将不会生效。

- **`Border border = BorderFactory.createLineBorder(Color.green, 3);`**  
  使用 `BorderFactory` 创建一个绿色的边框，宽度为 3 像素。虽然这行代码在实际运行中没有启用，但它展示了如何为标签设置边框。

##### 2.6 使用 `pack()` 方法

- **`frame.pack();`**  
  这行代码根据标签内容自动调整窗口的大小。与 `setSize()` 不同，`pack()` 方法会确保窗口刚好能容纳其内容。

---

#### 3. 运行效果

当您运行此程序时，将会出现一个包含文本 "bro, do you even code?" 和图像的窗口。文本为绿色，字体大小为 100，背景为黑色，文本相对于图标的位置位于图标的顶部，并且图标和文本在整个标签中居中对齐。

---

#### 4. 小结

通过这个示例代码，我们学习了如何使用 `JLabel` 显示文本和图像，并对其外观进行定制。`JLabel` 是 Java Swing 中非常有用的组件，它可以通过简单的设置来满足各种需求。

##### 关键点回顾：
- **`JLabel`** 可以显示文本、图像或两者结合。
- 通过 `setForeground()` 和 `setFont()` 可以设置文本的颜色和字体。
- 使用 `setHorizontalTextPosition()` 和 `setVerticalTextPosition()` 可以调整文本相对于图标的位置。
- `pack()` 方法可以根据内容自动调整窗口大小。
- `JLabel` 还可以设置背景颜色、边框及对齐方式。

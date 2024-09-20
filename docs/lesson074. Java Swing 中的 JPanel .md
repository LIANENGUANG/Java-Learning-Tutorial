# lesson074. Java Swing 中的 `JPanel` 讲解

#### 1. `JPanel` 是什么？

`JPanel` 是 Java Swing 中的一个容器类，它可以用于组织和布局其它 GUI 组件。你可以将按钮、标签、文本框等组件添加到 `JPanel`，然后将 `JPanel` 添加到 `JFrame` 中。`JPanel` 的作用类似于在界面上划分区域，以便更好地管理和布局组件。

---

#### 2. 如何创建 `JPanel`？

要创建一个 `JPanel`，你首先需要实例化一个 `JPanel` 对象。然后可以设置它的背景颜色、边界等属性，并将其添加到一个 `JFrame` 中。

##### 示例代码：

```java
import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
    
        // 创建一个 JFrame
        JFrame frame = new JFrame(); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(750, 750); 
        frame.setLayout(null); // 使用无布局管理器
        frame.setVisible(true); 
        
        // 创建一个红色的 JPanel
        JPanel redPanel = new JPanel(); 
        redPanel.setBackground(Color.RED); 
        redPanel.setBounds(0, 0, 250, 250); // 设置位置和大小
        
        // 将 JPanel 添加到 JFrame
        frame.add(redPanel);
    }
}
```

---

#### 3. 添加多个 `JPanel`

一个 `JFrame` 可以包含多个 `JPanel`，你可以通过设置不同的坐标和尺寸将多个 `JPanel` 添加到同一个 `JFrame` 中。

##### 示例代码：

```java
import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
    
        JFrame frame = new JFrame(); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(750, 750); 
        frame.setLayout(null);
        frame.setVisible(true); 
        
        // 红色面板
        JPanel redPanel = new JPanel(); 
        redPanel.setBackground(Color.RED); 
        redPanel.setBounds(0, 0, 250, 250);
        frame.add(redPanel);
        
        // 蓝色面板
        JPanel bluePanel = new JPanel(); 
        bluePanel.setBackground(Color.BLUE); 
        bluePanel.setBounds(250, 0, 250, 250);
        frame.add(bluePanel);
        
        // 绿色面板
        JPanel greenPanel = new JPanel(); 
        greenPanel.setBackground(Color.GREEN); 
        greenPanel.setBounds(0, 250, 500, 250);
        frame.add(greenPanel);
    }
}
```

在这个例子中，我们创建了三个面板：红色、蓝色和绿色。每个面板都有自己的大小和位置，红色和蓝色面板分别位于窗口的左上角和右上角，而绿色面板则占据了下半部分的一部分区域。

---

#### 4. 向 `JPanel` 中添加组件

`JPanel` 可以像 `JFrame` 一样，容纳多个组件（如标签、按钮等）。你可以创建一个 `JLabel`，并将其添加到某个 `JPanel` 中。

##### 代码示例：

```java
import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
    
        JFrame frame = new JFrame(); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(750, 750); 
        frame.setLayout(null);
        frame.setVisible(true); 
        
        // 红色面板
        JPanel redPanel = new JPanel(); 
        redPanel.setBackground(Color.RED); 
        redPanel.setBounds(0, 0, 250, 250);
        
        // 创建标签并添加到 redPanel
        JLabel label = new JLabel("Hello, World!");
        redPanel.add(label);
        
        frame.add(redPanel);
    }
}
```

在这个例子中，我们创建了一个标签 `"Hello, World!"` 并将其添加到了 `redPanel` 中。

---

#### 5. 自定义 `JPanel` 的布局

`JPanel` 默认使用的是 `FlowLayout` 布局管理器，这意味着组件将按从左到右、从上到下排列。如果你想自定义组件的位置，则可以通过设置布局为 `null` 并使用 `setBounds()` 方法来手动设置组件的位置和大小。

##### 示例代码：

```java
import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
    
        JFrame frame = new JFrame(); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(750, 750); 
        frame.setLayout(null);
        frame.setVisible(true); 
        
        // 红色面板
        JPanel redPanel = new JPanel(); 
        redPanel.setBackground(Color.RED); 
        redPanel.setBounds(0, 0, 250, 250);
        redPanel.setLayout(null); // 使用无布局管理器

        // 创建标签并手动设置其位置
        JLabel label = new JLabel("Hello, World!");
        label.setBounds(50, 50, 100, 50); // x, y, 宽度, 高度
        redPanel.add(label);
        
        frame.add(redPanel);
    }
}
```

在这个例子中，我们将 `redPanel` 的布局管理器设置为 `null`，并通过 `setBounds()` 方法手动设置了标签的位置。

---

#### 6. `JPanel` 中的边框设置

你可以为 `JPanel` 设置边框来增强视觉效果。Java Swing 提供了 `BorderFactory` 来创建各种类型的边框。

##### 示例代码：

```java
import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
    
        JFrame frame = new JFrame(); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(750, 750); 
        frame.setLayout(null);
        frame.setVisible(true); 
        
        // 红色面板
        JPanel redPanel = new JPanel(); 
        redPanel.setBackground(Color.RED); 
        redPanel.setBounds(0, 0, 250, 250);
        
        // 设置边框
        redPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
        
        frame.add(redPanel);
    }
}
```

在这个例子中，我们为 `redPanel` 添加了一个绿色的边框，边框的宽度为 5 像素。

---

#### 7. `JPanel` 中的布局管理器

`JPanel` 可以使用各种布局管理器，比如 `BorderLayout`、`FlowLayout`、`GridLayout` 等。在不使用布局管理器时，我们可以手动摆放组件的位置，但在更复杂的 GUI 程序中，布局管理器可以帮助我们更好地管理组件的位置和大小。

---

#### 8. 总结

`JPanel` 是 Java Swing 中非常重要的容器类，它可以帮助我们组织和管理其他组件。通过灵活地使用 `JPanel`，你可以创建出复杂的 GUI 布局。在本章节中，我们学习了如何创建 `JPanel`、向其中添加组件、自定义布局以及为 `JPanel` 设置边框。
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

    // 构造方法
    public MyFrame() {

        // 创建按钮
        JButton button = new JButton("点击我");
        button.setBounds(200, 100, 100, 50); // 设置按钮的位置和大小

        // 将按钮添加到 JFrame
        this.add(button);

        // 为按钮添加事件监听器
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 当按钮被点击时，输出一条信息
                System.out.println("按钮被点击了！");
            }
        });

        // 设置窗口属性
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null); // 无布局管理器
        this.setSize(500, 500); // 窗口大小
        this.setVisible(true); // 显示窗口
    }

    public static void main(String[] args) {
        new MyFrame(); // 创建并显示窗口
    }
}
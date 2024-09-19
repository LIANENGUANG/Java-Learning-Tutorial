# lesson070. Java Audio 播放器

在 Java 中，我们可以使用 `javax.sound.sampled` 包来创建一个简单的音频播放器。虽然该包不支持 MP3 格式，但它完全支持 WAV 格式的音频文件。因此，你需要使用 WAV 文件来测试这个程序。

#### 步骤 1：导入必要的包

首先，我们需要导入 `javax.sound.sampled` 包中的类，这些类将帮助我们处理音频文件。

```java
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
```

#### 步骤 2：加载 WAV 文件

使用 `File` 类来加载音频文件。例如，我们假设有一个名为 `level_up.wav` 的文件位于项目目录中。

#### 示例代码：加载和播放音频文件

```java
public class AudioPlayer {
    public static void main(String[] args) {
        try {
            // 创建文件对象，指向 WAV 文件
            File file = new File("level_up.wav");

            // 创建音频输入流
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

            // 获取 Clip 对象
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            // 创建一个扫描器等待用户输入
            Scanner scanner = new Scanner(System.in);
            String response = "";

            // 打印操作提示信息
            while (!response.equals("Q")) {
                System.out.println("P = Play, S = Stop, R = Reset, Q = Quit");
                System.out.print("Enter your choice: ");
                response = scanner.next().toUpperCase();

                switch (response) {
                    case ("P"): // 播放音频
                        clip.start();
                        break;
                    case ("S"): // 停止播放
                        clip.stop();
                        break;
                    case ("R"): // 重置音频到开头
                        clip.setMicrosecondPosition(0);
                        break;
                    case ("Q"): // 退出
                        clip.close();
                        System.out.println("Bye!");
                        break;
                    default:
                        System.out.println("Not a valid response");
                }
            }

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
```

#### 代码说明

1. **加载文件**：使用 `File` 类来加载音频文件。确保文件路径正确（如 `level_up.wav`）。
2. **创建** `AudioInputStream`：通过 `AudioSystem.getAudioInputStream()` 方法创建音频输入流。
3. **播放音频**：使用 `Clip` 类的 `start()` 方法来播放音频文件。
4. **停止音频**：使用 `stop()` 方法停止音频播放。
5. **重置音频**：通过 `setMicrosecondPosition(0)` 方法将音频重置到开头。
6. **退出程序**：通过用户输入 `Q` 来退出循环并关闭音频。

#### 步骤 3：保持程序运行

音频播放是在后台线程中进行的，程序可能在音频播放完成之前就终止。因此，我们通过用户输入来保持程序运行，直到用户选择退出。

#### 总结

- 使用 `Clip` 类来播放、停止和重置音频。
- 通过 `Scanner` 类获取用户输入，控制音频的播放状态。
- 使用 `AudioInputStream` 和 `AudioSystem.getClip()` 来处理 WAV 文件。
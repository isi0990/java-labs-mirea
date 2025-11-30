package prac12;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Animation extends JFrame {
    private ArrayList<ImageIcon> frames = new ArrayList<>();
    private int currentFrame = 0;
    private JLabel animationLabel;
    private Timer timer;
    private int currentSpeedIndex = 0;
    private final int[] speeds = {100, 50, 25, 10}; // Доступные скорости в миллисекундах

    public Animation(String[] imagePaths) {
        setTitle("Animation");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (String path : imagePaths) {
            frames.add(new ImageIcon(path));
        }

        animationLabel = new JLabel(frames.get(0));

        // Создаем кнопку для изменения скорости
        JButton speedButton = new JButton("Speed: " + speeds[currentSpeedIndex] + "ms");

        // Настраиваем таймер
        timer = new Timer(100, e -> {
            currentFrame = (currentFrame + 1) % frames.size();
            animationLabel.setIcon(frames.get(currentFrame));
        });

        // Добавляем обработчик для кнопки
        speedButton.addActionListener(e -> {
            currentSpeedIndex = (currentSpeedIndex + 1) % speeds.length;
            timer.setDelay(speeds[currentSpeedIndex]);
            speedButton.setText("Speed: " + speeds[currentSpeedIndex] + "ms");
        });

        // Размещаем компоненты
        setLayout(new BorderLayout());
        add(animationLabel, BorderLayout.CENTER);
        add(speedButton, BorderLayout.SOUTH);

        timer.start();
    }

    public static void main(String[] args) {
        String[] paths = {"src/prac12/1.png", "src/prac12/2.png", "src/prac12/3.png"};

        SwingUtilities.invokeLater(() -> {
            new Animation(paths).setVisible(true);
        });
    }
}
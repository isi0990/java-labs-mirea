package prac12;

import javax.swing.*;

public class ImageViewer extends JFrame {
    public ImageViewer(String imagePath) {
        setTitle("Image Viewer");
        setSize(528, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon(imagePath);
        JLabel label = new JLabel(icon);
        add(label);
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Не обнаружено ссылки");
            return;
        }

        SwingUtilities.invokeLater(() -> {
            new ImageViewer(args[0]).setVisible(true);
        });
    }
}
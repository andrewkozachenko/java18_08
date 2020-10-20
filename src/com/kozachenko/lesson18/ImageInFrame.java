package com.kozachenko.lesson18;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImageInFrame {
    public static void main(String[] args) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new URL(
                    "http://www.java2s.com/style/download.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon icon = new ImageIcon(img);
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(200, 300);
        JLabel lbl = new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

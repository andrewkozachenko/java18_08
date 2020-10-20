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
        String pig = "https://secure.img1-fg.wfcdn.com/im/52705193/resize-h800-w800%5Ecompr-r85/6266/62663384/Sitting+Baby+Pig+Statue.jpg";
        try {
//            img = ImageIO.read(new URL(
//                    "http://www.java2s.com/style/download.png"));
            img = ImageIO.read(new URL(pig));
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

package com.kozachenko.lesson16;

import com.kozachenko.lesson15.calculator.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGui extends JFrame {
    private final String TITLE = "Calculator";
    private JPanel mainPanel;
    private JTextField inputField;
    private JButton getResultButton;
    private JLabel resultLabel;

    public CalculatorGui() throws HeadlessException {
        setTitle(TITLE);
        GridLayout layout = new GridLayout(1,5);

        mainPanel = new JPanel(layout);

        Dimension mainPanelDimension = new Dimension(400, 50);
        mainPanel.setPreferredSize(mainPanelDimension);
        inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(100, 20));
//        inputField.setText("Hello please input here");
        mainPanel.add(inputField);

        getResultButton = new JButton();

        getResultButton.setText("Result");
        resultLabel = new JLabel();
        resultLabel.setPreferredSize(new Dimension(100,20));
        mainPanel.add(resultLabel);
        mainPanel.add(getResultButton);

        getResultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = inputField.getText();
                Calculator calculator = new Calculator();
                String result =  calculator.calculate(s);
                resultLabel.setText(result);
            }
        });

        add(mainPanel);


        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

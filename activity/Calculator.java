import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class Calculator {
    int boardWidth = 360;
    int boardHeight = 540;

    Color LightGray = new Color(212,212,210);
    Color DarkGray = new Color(88,80,80);
    Color CustomBlack = new Color(28,28,28);
    Color CustomOrange = new Color(255,149,0);

    String[] buttonValues = {
        "AC", "+/-", "%", "÷", 
        "7", "8", "9", "×", 
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "0", ".", "√", "="
    };
    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    String[] topSymbols = {"AC", "+/-", "%"};

    JFrame frame =new JFrame("Calculator");
    JLabel displayLabel = new JLabel();
    JPanel displayPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();

    Calculator() {
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        displayLabel.setBackground(CustomBlack);
        displayLabel.setForeground(Color.white);
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 80));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setText("0");
        displayLabel.setOpaque(true);

        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel);
        frame.add(displayPanel, BorderLayout.NORTH);

        buttonsPanel.setLayout(new GridLayout(5,4));
        buttonsPanel.setBackground(CustomBlack);
        frame.add(buttonsPanel);

        for (int i = 0; i < buttonValues.length; i++){
            JButton button = new JButton();
            String buttonValue = buttonValues[i];
            button.setFont(new Font("Arial", Font.PLAIN, 30));
            button.setText(buttonValue);
            button.setFocusable(false);
            button.setBorder(new LineBorder(CustomBlack));
            
            if (Arrays.asList(topSymbols).contains(buttonValue)){
                button.setBackground(LightGray);
                button.setForeground(CustomBlack);
            } else if (Arrays.asList(rightSymbols).contains(buttonValue)){
                button.setBackground(CustomOrange);
                button.setForeground(Color.white);
            } else {
                button.setBackground(DarkGray);
                button.setForeground(Color.white);
            }

            buttonsPanel.add(button);
        }

    }

public static void main(String[] args) {
    Calculator calculator = new Calculator();
}
}
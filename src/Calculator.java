import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener {

    Boolean isOperatorClicked = false;
    double newValue, oldValue;
    int calculation;

    JFrame frame;
    JLabel displayLabel;
    JButton[] numberButtons = new JButton[10];
    JButton addButton, subButton, mulButton, divButton, equalButton, clearButton, dotButton;

    public Calculator() {
        // Frame setup
        frame = new JFrame("Calculator");
        frame.setBounds(100, 100, 400, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(45, 45, 45));

        // Display Label
        displayLabel = new JLabel("0");
        displayLabel.setBounds(20, 30, 340, 70);
        displayLabel.setFont(new Font("Arial", Font.BOLD, 28));
        displayLabel.setBackground(new Color(220, 220, 220));
        displayLabel.setOpaque(true);
        displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        displayLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(displayLabel);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(20, 120, 340, 350);
        buttonPanel.setLayout(new GridLayout(5, 4, 10, 10));
        buttonPanel.setBackground(new Color(45, 45, 45));

        // Button initialization
        @SuppressWarnings("unused")
		String[] buttonLabels = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "x",
            ".", "0", "=", "/",
            "Clear"
        };

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = createButton(Integer.toString(i), new Color(220, 220, 220), Color.BLACK);
            numberButtons[i].addActionListener(this);
        }

        addButton = createButton("+", new Color(250, 200, 100), Color.BLACK);
        subButton = createButton("-", new Color(250, 200, 100), Color.BLACK);
        mulButton = createButton("x", new Color(250, 200, 100), Color.BLACK);
        divButton = createButton("/", new Color(250, 200, 100), Color.BLACK);
        equalButton = createButton("=", new Color(100, 200, 250), Color.WHITE);
        clearButton = createButton("Clear", new Color(255, 100, 100), Color.WHITE);
        dotButton = createButton(".", new Color(220, 220, 220), Color.BLACK);

        // Add buttons to panel
        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(addButton);

        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(subButton);

        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(mulButton);

        buttonPanel.add(dotButton);
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(equalButton);
        buttonPanel.add(divButton);

        buttonPanel.add(clearButton);

        frame.add(buttonPanel);

        // Button actions
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        equalButton.addActionListener(this);
        clearButton.addActionListener(this);
        dotButton.addActionListener(this);

        frame.setVisible(true);
    }

    private JButton createButton(String text, Color bg, Color fg) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBackground(bg);
        button.setForeground(fg);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setUI(new RoundedButtonUI());
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        // Handle number buttons
        for (int i = 0; i < 10; i++) {
            if (source == numberButtons[i]) {
                if (isOperatorClicked) {
                    displayLabel.setText(Integer.toString(i));
                    isOperatorClicked = false;
                } else {
                    if (displayLabel.getText().equals("0")) {
                        displayLabel.setText(Integer.toString(i));
                    } else {
                        displayLabel.setText(displayLabel.getText() + i);
                    }
                }
            }
        }

        // Handle operators
        if (source == addButton) {
            handleOperator(1);
        } else if (source == subButton) {
            handleOperator(2);
        } else if (source == mulButton) {
            handleOperator(3);
        } else if (source == divButton) {
            handleOperator(4);
        } else if (source == equalButton) {
            calculateResult();
        } else if (source == clearButton) {
            displayLabel.setText("0");
        } else if (source == dotButton) {
            if (!displayLabel.getText().contains(".")) {
                displayLabel.setText(displayLabel.getText() + ".");
            }
        }
    }

    private void handleOperator(int operator) {
        isOperatorClicked = true;
        oldValue = Double.parseDouble(displayLabel.getText());
        calculation = operator;
    }

    double calculateResult() {
        newValue = Double.parseDouble(displayLabel.getText());
        double result = 0;

        switch (calculation) {
            case 1:
                result = oldValue + newValue;
                System.out.println(calculation);
                break;
            case 2:
                result = oldValue - newValue;
                break;
            case 3:
                result = oldValue * newValue;
                break;
            case 4:
                result = oldValue / newValue;
                break;
        }
        
        displayLabel.setText((result % 1 == 0) ? String.valueOf((int) result) : String.valueOf(result));
        return result;
    }

    public static void main(String[] args) {
        new Calculator();
    }
}

// Custom Button UI for rounded buttons
class RoundedButtonUI extends javax.swing.plaf.basic.BasicButtonUI {
    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2 = (Graphics2D) g;
        AbstractButton b = (AbstractButton) c;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(b.getBackground());
        g2.fillRoundRect(0, 0, b.getWidth(), b.getHeight(), 30, 30);

        g2.setColor(b.getForeground());
        FontMetrics fm = g2.getFontMetrics();
        int x = (b.getWidth() - fm.stringWidth(b.getText())) / 2;
        int y = (b.getHeight() + fm.getAscent()) / 2 - 2;
        g2.drawString(b.getText(), x, y);
    }
}

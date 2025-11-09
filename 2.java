import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingCalculator extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton addBtn, subBtn, mulBtn, divBtn;

    public SwingCalculator() {
        // Frame setup
        setTitle("Swing Application");
        setSize(300, 250);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Labels
        JLabel l1 = new JLabel("Number 1");
        l1.setBounds(30, 30, 80, 25);
        add(l1);

        JLabel l2 = new JLabel("Number 2");
        l2.setBounds(30, 70, 80, 25);
        add(l2);

        // Text fields
        t1 = new JTextField();
        t1.setBounds(120, 30, 100, 25);
        add(t1);

        t2 = new JTextField();
        t2.setBounds(120, 70, 100, 25);
        add(t2);

        // Buttons
        addBtn = new JButton("ADD");
        addBtn.setBounds(20, 120, 100, 30);
        addBtn.addActionListener(this);
        add(addBtn);

        subBtn = new JButton("SUB");
        subBtn.setBounds(150, 120, 100, 30);
        subBtn.addActionListener(this);
        add(subBtn);

        mulBtn = new JButton("MUL");
        mulBtn.setBounds(20, 160, 100, 30);
        mulBtn.addActionListener(this);
        add(mulBtn);

        divBtn = new JButton("DIV");
        divBtn.setBounds(150, 160, 100, 30);
        divBtn.addActionListener(this);
        add(divBtn);

        setVisible(true);
    }

    // Event handling
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(t1.getText());
            double num2 = Double.parseDouble(t2.getText());
            double result = 0;
            String msg = "";

            if (e.getSource() == addBtn) {
                result = num1 + num2;
                msg = "Addition: " + result;
            } else if (e.getSource() == subBtn) {
                result = num1 - num2;
                msg = "Subtraction: " + result;
            } else if (e.getSource() == mulBtn) {
                result = num1 * num2;
                msg = "Multiplication: " + result;
            } else if (e.getSource() == divBtn) {
                if (num2 != 0) {
                    result = num1 / num2;
                    msg = "Division: " + result;
                } else {
                    msg = "Error: Cannot divide by zero!";
                }
            }

            JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid Input! Enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new SwingCalculator();
    }
}

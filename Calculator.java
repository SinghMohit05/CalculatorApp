import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    JTextField t;
    double n1, n2, res;
    char op;

    Calculator() {
        setTitle("Calculator");
        t = new JTextField();
        t.setBounds(30, 40, 230, 30);
        add(t);

        String[] btns = {"7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
        int x=30, y=100;
        for (String s: btns) {
            JButton b = new JButton(s);
            b.setBounds(x,y,50,40);
            b.addActionListener(this);
            add(b);
            x += 60;
            if (x > 200) { x=30; y+=50; }
        }
        setLayout(null);
        setSize(300,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.charAt(0) >= '0' && s.charAt(0) <= '9' || s.equals(".")) {
            t.setText(t.getText() + s);
        } else if (s.equals("=")) {
            n2 = Double.parseDouble(t.getText());
            switch (op) {
                case '+': res = n1 + n2; break;
                case '-': res = n1 - n2; break;
                case '*': res = n1 * n2; break;
                case '/': res = n1 / n2; break;
            }
            t.setText("" + res);
        } else {
            n1 = Double.parseDouble(t.getText());
            op = s.charAt(0);
            t.setText("");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}

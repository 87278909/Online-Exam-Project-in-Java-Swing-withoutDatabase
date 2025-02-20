import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener {
    JLabel l;
    JRadioButton jb[] = new JRadioButton[5];
    JButton b1, b2;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];

    OnlineTest(String s) {
        super(s);
        l = new JLabel();
        add(l);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            jb[i] = new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1 = new JButton("Next");
        b2 = new JButton("Bookmark");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);
        add(b2);
        set();
        l.setBounds(30, 40, 450, 20);
        jb[0].setBounds(50, 80, 100, 20);
        jb[1].setBounds(50, 110, 100, 20);
        jb[2].setBounds(50, 140, 100, 20);
        jb[3].setBounds(50, 170, 100, 20);
        b1.setBounds(100, 240, 100, 30);
        b2.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (check())
                count = count + 1;
            current++;
            set();
            if (current == 9) {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }
        if (e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 9)
                b2.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (check())
                    count = count + 1;
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }

        if (e.getActionCommand().equals("Result")) {
            if (check())
                count = count + 1;
            current++;
            JOptionPane.showMessageDialog(this, "Correct answers=" + count);
            System.exit(0);
        }
    }

    void set() {
        jb[4].setSelected(true);
        if (current == 0) {
            l.setText("Que1: Which of these is not a primitive type?");
            jb[0].setText("int");
            jb[1].setText("Float");
            jb[2].setText("boolean");
            jb[3].setText("char");
        }
        if (current == 1) {
            l.setText("Que2: What is the size of a 'char' in Java?");
            jb[0].setText("8 bits");
            jb[1].setText("16 bits");
            jb[2].setText("32 bits");
            jb[3].setText("64 bits");
        }
        if (current == 2) {
            l.setText("Que3: Which of these is not a Java feature?");
            jb[0].setText("Object-oriented");
            jb[1].setText("Use of pointers");
            jb[2].setText("Platform-independent");
            jb[3].setText("Portable");
        }
        if (current == 3) {
            l.setText("Que4: Which is the superclass of all classes in Java?");
            jb[0].setText("Object");
            jb[1].setText("String");
            jb[2].setText("Class");
            jb[3].setText("System");
        }
        if (current == 4) {
            l.setText("Que5: Which keyword is used for inheritance in Java?");
            jb[0].setText("implements");
            jb[1].setText("extends");
            jb[2].setText("super");
            jb[3].setText("this");
        }
        if (current == 5) {
            l.setText("Que6: Which of these is not a keyword in Java?");
            jb[0].setText("class");
            jb[1].setText("int");
            jb[2].setText("get");
            jb[3].setText("if");
        }
        if (current == 6) {
            l.setText("Que7: Which method is used to start a thread execution?");
            jb[0].setText("run()");
            jb[1].setText("init()");
            jb[2].setText("start()");
            jb[3].setText("resume()");
        }
        if (current == 7) {
            l.setText("Que8: Which of these exceptions is thrown by the 'wait()' method?");
            jb[0].setText("IOException");
            jb[1].setText("ClassNotFoundException");
            jb[2].setText("InterruptedException");
            jb[3].setText("ArithmeticException");
        }
        if (current == 8) {
            l.setText("Que9: Which of these keywords is used to define interfaces in Java?");
            jb[0].setText("interface");
            jb[1].setText("Interface");
            jb[2].setText("intf");
            jb[3].setText("Intf");
        }
        if (current == 9) {
            l.setText("Que10: Which of these is not a valid keyword in Java?");
            jb[0].setText("try");
            jb[1].setText("static");
            jb[2].setText("Integer");
            jb[3].setText("new");
        }
        l.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++)
            jb[j].setBounds(50, 80 + i, 200, 20);
    }

    boolean check() {
        if (current == 0)
            return (jb[1].isSelected());
        if (current == 1)
            return (jb[1].isSelected());
        if (current == 2)
            return (jb[1].isSelected());
        if (current == 3)
            return (jb[0].isSelected());
        if (current == 4)
            return (jb[1].isSelected());
        if (current == 5)
            return (jb[2].isSelected());
        if (current == 6)
            return (jb[2].isSelected());
        if (current == 7)
            return (jb[2].isSelected());
        if (current == 8)
            return (jb[0].isSelected());
        if (current == 9)
            return (jb[2].isSelected());
        return false;
    }

    public static void main(String s[]) {
        new OnlineTest("Online Java Test");
    }
}

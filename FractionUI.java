import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FractionUI extends JFrame  {

   // String[] buttons = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "/", "x"};
    static JFrame f;
    static Fraction curFraction = new Fraction(0, 1);
    static Fraction newFraction;

    static JLabel curNum;
    static JLabel curNum2;
    static JLabel newNum;
    static JLabel newNum2;

    static JLabel compareLabel;
    static JLabel compareLabel2;
    static JLabel toDecLabel;
    static JLabel toDecLabel2;

    public static void main(String[] args) {

        createCalculator();
    }


    public static void createCalculator() {
        createFrame();
        addButtonsAndLabels();
    }

    public static void createFrame() {
        f= new JFrame();
        f.setSize(400,550);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void addButtonsAndLabels() {

        //BUTTONS

        JButton one = new JButton("1");
        one.setBounds(0, 100, 100, 100);
        f.add(one);
        one.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newNum2.setText(newNum2.getText() + "1");
            }
        });

        JButton two = new JButton("2");
        two.setBounds(100, 100, 100, 100);
        f.add(two);
        two.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newNum2.setText(newNum2.getText() + "2");
            }
        });

        JButton three = new JButton("3");
        three.setBounds(200, 100, 100, 100);
        f.add(three);
        three.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newNum2.setText(newNum2.getText() + "3");
            }
        });

        JButton four = new JButton("4");
        four.setBounds(0, 200, 100, 100);
        f.add(four);
        four.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newNum2.setText(newNum2.getText() + "4");
            }
        });

        JButton five = new JButton("5");
        five.setBounds(100, 200, 100, 100);
        f.add(five);
        five.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newNum2.setText(newNum2.getText() + "5");
            }
        });

        JButton six = new JButton("6");
        six.setBounds(200, 200, 100, 100);
        f.add(six);
        six.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newNum2.setText(newNum2.getText() + "6");
            }
        });

        JButton seven = new JButton("7");
        seven.setBounds(0, 300, 100, 100);
        f.add(seven);
        seven.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newNum2.setText(newNum2.getText() + "7");
            }
        });

        JButton eight = new JButton("8");
        eight.setBounds(100, 300, 100, 100);
        f.add(eight);
        eight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newNum2.setText(newNum2.getText() + "8");
            }
        });

        JButton nine = new JButton("9");
        nine.setBounds(200, 300, 100, 100);
        f.add(nine);
        nine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newNum2.setText(newNum2.getText() + "9");
            }
        });

        JButton zero = new JButton("0");
        zero.setBounds(100, 400, 100, 100);
        f.add(zero);
        zero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newNum2.setText(newNum2.getText() + "0");
            }
        });

        JButton times = new JButton("x");
        times.setBounds(300, 200, 100, 100);
        f.add(times);
        times.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newFraction = new Fraction(newNum2.getText());
                curFraction = curFraction.multiply(newFraction);
                curNum2.setText(curFraction.toString());
                newNum2.setText("");
                toDecLabel2.setText(String.valueOf(curFraction.toDecimal()));
            }
        });

        JButton divide = new JButton("/");
        divide.setBounds(300, 300, 100, 100);
        f.add(divide);
        divide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newFraction = new Fraction(newNum2.getText());
                curFraction = curFraction.divide(newFraction);
                curNum2.setText(curFraction.toString());
                newNum2.setText("");
                toDecLabel2.setText(String.valueOf(curFraction.toDecimal()));
            }
        });

        JButton plus = new JButton("+");
        plus.setBounds(0, 400, 100, 100);
        f.add(plus);
        plus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newFraction = new Fraction(newNum2.getText());
                curFraction = curFraction.add(newFraction);
                curNum2.setText(curFraction.toString());
                newNum2.setText("");
                toDecLabel2.setText(String.valueOf(curFraction.toDecimal()));
            }
        });

        JButton minus = new JButton("-");
        minus.setBounds(200, 400, 100, 100);
        f.add(minus);
        minus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newFraction = new Fraction(newNum2.getText());
                curFraction = curFraction.subtract(newFraction);
                curNum2.setText(curFraction.toString());
                newNum2.setText("");
                toDecLabel2.setText(String.valueOf(curFraction.toDecimal()));
            }
        });

        JButton compare = new JButton(">/<");
        compare.setBounds(300, 100, 100, 100);
        f.add(compare);
        compare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newFraction = new Fraction(newNum2.getText());
                int comp = curFraction.compareTo(newFraction);
                if(comp == 1 ) {
                    compareLabel2.setText(newFraction.toString() + " is larger");
                } else {
                    compareLabel2.setText(newFraction.toString() + " is larger");
                }
                newNum2.setText("");
            }
        });

        JButton denom = new JButton("Denominator");
        denom.setBounds(300, 400, 100, 100);
        f.add(denom);
        denom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String delims = "[/]";
                String[] tokens = newNum2.getText().split(delims);
                if(tokens.length < 2) {
                    newNum2.setText(newNum2.getText() + "/");
                }
            }
        });

        JButton clear = new JButton("Clear");
        clear.setBounds(0, 75, 100, 25);
        f.add(clear);
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                curFraction.setNumerator(0);
                curFraction.setDenominator(1);
                newFraction.setNumerator(0);
                newFraction.setDenominator(1);
                curNum2.setText("0/1");
                newNum2.setText("");
                compareLabel2.setText("");
                toDecLabel2.setText("");

            }
        });

        //LABELS

        curNum = new JLabel("Current Fraction: ");
        curNum.setBounds(15, 0, 150, 50);
        f.add(curNum);

        curNum2 =  new JLabel("0/1");
        curNum2.setBounds(15, 25, 150, 50);
        f.add(curNum2);

        newNum = new JLabel("New Fraction: ");
        newNum.setBounds(165, 0, 150, 50);
        f.add(newNum);

        newNum2 = new JLabel("");
        newNum2.setBounds(165, 25, 150, 50);
        f.add(newNum2);

        compareLabel = new JLabel("Compare: ");
        compareLabel.setBounds(315, 0, 150, 50);
        f.add(compareLabel);

        compareLabel2 = new JLabel("n/a");
        compareLabel2.setBounds(315, 25, 150, 50);
        f.add(compareLabel2);

        toDecLabel = new JLabel("Decimal: ");
        toDecLabel.setBounds(150, 50, 150, 50);
        f.add(toDecLabel);

        toDecLabel2 = new JLabel("0.0 ");
        toDecLabel2.setBounds(230, 50, 150, 50);
        f.add(toDecLabel2);
    }

}
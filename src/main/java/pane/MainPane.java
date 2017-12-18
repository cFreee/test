package pane;

import calculator.SimpleCalculator;
import equation.Operator;
import equation.Number;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alex on 2017-7-14.
 */
public class MainPane extends JFrame {

    Container container = getContentPane();
    Button [] numbers = new Button[10];
    Button [] opts = new Button[5];
    Button calculateButton = new Button("=");
    Label viewLabel = new Label();
    JPanel panel = new JPanel(new GridLayout(4,4));

    Number a = null;
    Number b = null;
    Operator opt = null;

    public MainPane(){
        init();
    }

    public void init(){
        //init number buttons
        initNumButtons();
        //init opt buttons
        initOptButtons();
        //init "=" button
        initCalculatorButton();
        //init container
        container.setLayout(new BorderLayout(1,2));
        container.add(viewLabel, BorderLayout.NORTH);
        container.add(panel,BorderLayout.CENTER);
        // init JFrame
        this.setSize(new Dimension(300,300));
        Toolkit toolkit = this.getToolkit();
        this.setLocation(toolkit.getScreenSize().width/2,toolkit.getScreenSize().height/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void initNumButtons(){
        for(int i = 0; i < Number.values().length; i++) {
            final Number tempNum = Number.getInstance(i);
            numbers[i] = new Button(tempNum.name());
            numbers[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (opt == null) {
                        a = tempNum;
                        viewLabel.setText("" + a.ordinal());
                    } else {
                        b = tempNum;
                        viewLabel.setText(a.ordinal() + " " + opt.getOpt() + " " + b.ordinal());
                    }
                }
            });
            panel.add(numbers[i]);
        }
    }

    private void initOptButtons(){
        for(int i = 0; i< Operator.values().length; i++){
            final Operator tempOpt = Operator.getIstance(i);
            opts[i] = new Button(tempOpt.name());
            opts[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(a == null)
                        viewLabel.setText("enter a number first.");
                    else{
                        opt = tempOpt;
                        viewLabel.setText(a.ordinal() + " " + opt.getOpt());
                        b = null;
                    }

                }
            });
            panel.add(opts[i]);
        }
    }

    private void initCalculatorButton(){
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SimpleCalculator SimpleCalculator = new SimpleCalculator();
                SimpleCalculator.setCalModeIstance(a, b, opt);
                double result = SimpleCalculator.cal();
                viewLabel.setText(a.ordinal() + " " + opt.getOpt() + " " + b.ordinal() + " = " + result);
                a = null;b=null;opt = null;
            }
        });
        panel.add(calculateButton);
    }
}

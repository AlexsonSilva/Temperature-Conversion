package com.company;

import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Temperature extends JFrame {
    private static final double CelsiusToFahrenheit = 9.00 / 5.0;
    private static final double FahrenheitToCelsius = 5.0 / 9.0;
    private static final int offset =32;
    private final JCheckBox celsiusCheckBox;
    private final JCheckBox fahrenheitCheckBox;
    private ButtonGroup checkboxGroup;
    private final JLabel label;
    private final JTextField textField1;
    private final JTextField textField2;
    private final JButton buttonConversion;
    private ConvertButtonHandler convButtlonHandler;

    public Temperature(){
        super("Temperature Conversion");
        setLayout(new FlowLayout());

        //Add a Label
        label = new JLabel("Temperature Conversion");
        label.setForeground(Color.BLUE);
        label.setFont(new Font("Tahoma", Font.BOLD, 22));
        add(label);

        //Add the CheckBoxes
        celsiusCheckBox = new JCheckBox("Celsius");
        fahrenheitCheckBox = new JCheckBox("Fahrenheit");
        add(celsiusCheckBox);
        add(fahrenheitCheckBox);

        //Add the textFields
        textField1 = new JTextField("", 15);
        textField1.setBackground(new Color(30,144,255));
        add(textField1);
        textField1.setInputVerifier(new NumericInputVerifier());

        textField2 = new JTextField("", 15);
        textField2.setBackground(new Color(30,144,255));
        add(textField2);
        textField2.setEditable(false);

        //Add the Button
        buttonConversion = new JButton("Conversion");
        add(buttonConversion);

        convButtlonHandler = new ConvertButtonHandler();
        buttonConversion.addActionListener(convButtlonHandler);

        checkboxGroup = new ButtonGroup();
        checkboxGroup.add(celsiusCheckBox);
        checkboxGroup.add(fahrenheitCheckBox);

    }
    private class NumericInputVerifier extends InputVerifier{

        @Override
        public boolean verify(JComponent input) {
           if (((JTextField) input).getText().matches("[0-9]+")){
               return true;
           }else {
               JOptionPane.showMessageDialog(input, "Only numbers are allowed!", "Warning", JOptionPane.WARNING_MESSAGE);
               return false;
           }

        }
    }

    private class ConvertButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent event) {
            double celsius = 0.0, fahrenheit = 0.0;
            celsius = Double.parseDouble(textField1.getText());
            fahrenheit = Double.parseDouble(textField1.getText());
            if (celsiusCheckBox.isSelected()){
                celsius = (fahrenheit -offset) * FahrenheitToCelsius;
                textField2.setText(celsius + " ºC");
            }else {
                fahrenheit = celsius * CelsiusToFahrenheit + offset;
                textField2.setText( fahrenheit + " ºF");
            }

        }
    }

}

package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Temperature extends JFrame {
    private static final double CelsiusToFahrenheit = 9.00 / 5.0;
    private static final double FahrenheitToCelsius = 5.0 / 9.0;
    private static final int offset =32;
    private final JCheckBox celsiusCheckBox;
    private final JCheckBox fahrenheitCheckBox;
    private ButtonGroup checkboxGroup;
    private final JTextField textField1;
    private final JTextField textField2;
    private final JButton buttonConversion;
    private  ConvertButtonHandler convButtlonHandler;

    public Temperature(){
        super("Temperature Conversion");
        setLayout(new FlowLayout());

        celsiusCheckBox = new JCheckBox("Celsius");
        fahrenheitCheckBox = new JCheckBox("Fahrenheit");
        add(celsiusCheckBox);
        add(fahrenheitCheckBox);


        textField1 = new JTextField("", 15);
        add(textField1);
        textField2 = new JTextField("", 15);
        add(textField2);
        textField2.setEditable(false);
        buttonConversion = new JButton("Conversion");
        add(buttonConversion);
        convButtlonHandler = new ConvertButtonHandler();
        buttonConversion.addActionListener(convButtlonHandler);

        checkboxGroup = new ButtonGroup();
        checkboxGroup.add(celsiusCheckBox);
        checkboxGroup.add(fahrenheitCheckBox);

    }

    private class ConvertButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent event) {
            double celsius = 0.0, fahrenheit = 0.0;
            celsius = Double.parseDouble(textField1.getText());
            fahrenheit = Double.parseDouble(textField1.getText());
            if (celsiusCheckBox.isSelected()){
                celsius = (fahrenheit -offset) * FahrenheitToCelsius;
                textField2.setText(celsius + "ºC");
            }else {
                fahrenheit = celsius * CelsiusToFahrenheit + offset;
                textField2.setText( fahrenheit + "ºF");
            }

        }
    }

}

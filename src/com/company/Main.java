package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
	    Temperature temperature = new Temperature();
        temperature.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        temperature.setSize(300, 400);
        temperature.getContentPane().setBackground(new Color(255, 140, 0));
        temperature.setVisible(true);
    }
}

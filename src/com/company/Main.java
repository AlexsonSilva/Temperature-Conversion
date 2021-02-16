package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	    Temperature temperature = new Temperature();
        temperature.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        temperature.setSize(300, 400);
        temperature.setVisible(true);
    }
}

package com.edutilos.main;

import javax.swing.*;

/**
 * Created by edutilos on 05/04/2017.
 */
public class RMSRunner {
    public static void main(String[] args) {
        SwingRestaurantManagementSystem rms = new SwingRestaurantManagementSystem();
        rms.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        rms.setVisible(true);

    }


    private static void testParse() {
        //Integer.parseInt("123.123");
        // Double.parseDouble("123.0");
        System.out.println(Boolean.parseBoolean("True"));
    }
}

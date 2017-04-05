package com.edutilos.main;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorListener implements ActionListener{
    private JTextArea areaCalculatorDisplay ;

    public CalculatorListener(JTextArea areaCalculatorDisplay) {
        this.areaCalculatorDisplay = areaCalculatorDisplay;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton src = (JButton)e.getSource();
        String causer = src.getText();
        String txt = "";
        switch(causer) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case ".": {
                String display = areaCalculatorDisplay.getText();
                display += causer ;
                areaCalculatorDisplay.setText(display);
                break;
            }

            case "+":
            case "-":
            case "*":
            case "/": {
                String display = areaCalculatorDisplay.getText();
                display += " "+ causer + " ";
                areaCalculatorDisplay.setText(display);
                break;
            }

            case "C": areaCalculatorDisplay.setText("");
                break;
        }
    }
}

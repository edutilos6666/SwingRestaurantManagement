/*
 * Created by JFormDesigner on Wed Apr 05 11:07:47 CEST 2017
 */

package com.edutilos.main;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class SwingRestaurantManagementSystem extends JFrame {
    public SwingRestaurantManagementSystem() {
        initComponents();
        extraInit();
        registerEvents();
    }



    private java.util.List<PriceEnum> priceContainer  = new ArrayList<>();
   private java.util.List<CurrencyEnum> currencyContainer = new ArrayList<>();
    private void registerEvents() {
            cbChickenBurger.addActionListener(l-> {
              if(cbChickenBurger.isSelected()) {
                   try {
                        String str = fieldChickenBurger.getText();
                       Integer number = Integer.parseInt(str);
                       String txtCostOfMeal = fieldCostOfMeal.getText();
                       Double costOfMeal = 0.0 ;
                       if(!txtCostOfMeal.equals(""))
                       costOfMeal = Double.parseDouble(fieldCostOfMeal.getText());
                       Double thisCost = number * PriceEnum.ChickenBurger.getValue();
                       costOfMeal += thisCost;
                       fieldCostOfMeal.setText(String.valueOf(costOfMeal));
                    } catch(NumberFormatException ex) {
                       System.err.println(ex.getMessage()); 
                   }
              } else {
                  try {
                      Integer number = Integer.parseInt(fieldChickenBurger.getText());
                      String txtCostOfMeal = fieldCostOfMeal.getText();
                      Double costOfMeal = 0.0 ;
                      if(!txtCostOfMeal.equals(""))
                          costOfMeal = Double.parseDouble(fieldCostOfMeal.getText());
                      Double thisCost = number * PriceEnum.ChickenBurger.getValue();
                      costOfMeal -= thisCost;
                      fieldCostOfMeal.setText(String.valueOf(costOfMeal));
                  } catch(NumberFormatException ex) {
                      System.err.println(ex.getMessage()); 
                  }
              }
            });


          cbChickenBurgerMeal.addActionListener(l-> {
              if(cbChickenBurgerMeal.isSelected()) {
                  try {
                      String str = fieldChickenBurgerMeal.getText();
                      Integer number = Integer.parseInt(str);
                      String txtCostOfMeal = fieldCostOfMeal.getText();
                      Double costOfMeal = 0.0 ;
                      if(!txtCostOfMeal.equals(""))
                          costOfMeal = Double.parseDouble(fieldCostOfMeal.getText());
                      Double thisCost = number * PriceEnum.ChickenBurgerMeal.getValue();
                      costOfMeal += thisCost;
                      fieldCostOfMeal.setText(String.valueOf(costOfMeal));
                  } catch(NumberFormatException ex) {
                      System.err.println(ex.getMessage()); 
                  }
              } else {
                  try {
                      Integer number = Integer.parseInt(fieldChickenBurgerMeal.getText());
                      String txtCostOfMeal = fieldCostOfMeal.getText();
                      Double costOfMeal = 0.0 ;
                      if(!txtCostOfMeal.equals(""))
                          costOfMeal = Double.parseDouble(fieldCostOfMeal.getText());
                      Double thisCost = number * PriceEnum.ChickenBurgerMeal.getValue();
                      costOfMeal -= thisCost;
                      fieldCostOfMeal.setText(String.valueOf(costOfMeal));
                  } catch(NumberFormatException ex) {
                      System.err.println(ex.getMessage()); 
                  }
              }
          });


        cbBaconAndCheeseBurger.addActionListener(l-> {
            if(cbBaconAndCheeseBurger.isSelected()) {
                try {
                    String str = fieldBaconAndCheeseBurger.getText();
                    Integer number = Integer.parseInt(str);
                    String txtCostOfMeal = fieldCostOfMeal.getText();
                    Double costOfMeal = 0.0 ;
                    if(!txtCostOfMeal.equals(""))
                        costOfMeal = Double.parseDouble(fieldCostOfMeal.getText());
                    Double thisCost = number * PriceEnum.BaconAndCheeseBurger.getValue();
                    costOfMeal += thisCost;
                    fieldCostOfMeal.setText(String.valueOf(costOfMeal));
                } catch(NumberFormatException ex) {
                    System.err.println(ex.getMessage()); 
                }
            } else {
                try {
                    Integer number = Integer.parseInt(fieldBaconAndCheeseBurger.getText());
                    String txtCostOfMeal = fieldCostOfMeal.getText();
                    Double costOfMeal = 0.0 ;
                    if(!txtCostOfMeal.equals(""))
                        costOfMeal = Double.parseDouble(fieldCostOfMeal.getText());
                    Double thisCost = number * PriceEnum.BaconAndCheeseBurger.getValue();
                    costOfMeal -= thisCost;
                    fieldCostOfMeal.setText(String.valueOf(costOfMeal));
                } catch(NumberFormatException ex) {
                    System.err.println(ex.getMessage()); 
                }
            }
        });


        /*
             comboDrinks.addItem("Select a drink");
        comboDrinks.addItem("Apple Juice");
        comboDrinks.addItem("Tea");
        comboDrinks.addItem("Cola");
        comboDrinks.addItem("Coke");
        comboDrinks.addItem("Coffee");
        comboDrinks.addItem("Ice Tea");
        comboDrinks.addItem("Ice Coffee");
         */
         comboDrinks.addItemListener(l-> {
             int selectedIndex = comboDrinks.getSelectedIndex();
             double price = 0.0;
             switch(selectedIndex) {
                 case 1:  price = PriceEnum.AppleJuice.getValue(); break;
                 case 2: price = PriceEnum.Tea.getValue(); break;
                 case 3: price = PriceEnum.Cola.getValue(); break;
                 case 4: price = PriceEnum.Coke.getValue(); break;
                 case 5: price = PriceEnum.Coffee.getValue(); break;
                 case 6: price = PriceEnum.IceTea.getValue(); break;
                 case 7: price = PriceEnum.IceCoffee.getValue(); break;
             }

             fieldCostOfDrinks.setText(String.valueOf(price));
         });



        cbHomeDelivery.addActionListener(l-> {
            if(cbHomeDelivery.isSelected()) {
                 fieldCostOfDelivery.setText(String.valueOf(PriceEnum.HomeDelivery.getValue()));
            } else {
                fieldCostOfDelivery.setText("");
            }
        });



        cbTax.addActionListener(l-> {
            try {
                if (cbTax.isSelected()) {
                    double total = calculateTotal();
                    if (total != -1) {
                        double tax = total * PriceEnum.Tax.getValue() / 100;
                        fieldTax.setText(String.valueOf(tax));
                    }
                } else {
                    fieldTax.setText("");
                }
            } catch(Exception ex) {
                System.err.println(ex.getMessage());
            }
        });


        btnTotal.addActionListener(l-> {
            try {
                double subTotal = calculateTotal();
                if (subTotal != -1) {
                    String taxStr = fieldTax.getText();
                    double tax = 0;
                    if (!taxStr.equals("")) tax = Double.parseDouble(taxStr);
                    double total = subTotal + tax;
                    fieldSubTotal.setText(String.valueOf(subTotal));
                    fieldTotal.setText(String.valueOf(total));
                }
            } catch(Exception ex) {
                System.err.println(ex.getMessage());
            }
        });



        btnReceipt.addActionListener(l-> {
             try {
                 int chickenBurger = 0 ,
                         chickenBurgerMeal = 0 ,
                         baconAndCheeseBurger = 0 ;
                 String strChickenBurger = fieldChickenBurger.getText();
                 if(!strChickenBurger.equals("")) chickenBurger = Integer.parseInt(strChickenBurger);
                 String strChickenBurgerMeal = fieldChickenBurgerMeal.getText();
                 if(!strChickenBurgerMeal.equals("")) chickenBurgerMeal = Integer.parseInt(strChickenBurgerMeal);
                 String strBaconAndCheeseBurger = fieldBaconAndCheeseBurger.getText();
                 if(!strBaconAndCheeseBurger.equals(""))  baconAndCheeseBurger = Integer.parseInt(strBaconAndCheeseBurger);

                 int selectedDrinkIndex = comboDrinks.getSelectedIndex();
                 String selectedDrink = "";
                 if(selectedDrinkIndex > 0) selectedDrink = comboDrinks.getSelectedItem().toString();
                 final String nl = "\r\n";
                 StringBuilder builder = new StringBuilder("Restaurant Management System").append(nl);
                 if(chickenBurger != 0)
                     builder.append("Chicken Burger:           ").append(String.valueOf(chickenBurger)).append(nl);
                 if(chickenBurgerMeal != 0)
                     builder.append("Chicken Burger Meal:      ").append(String.valueOf(chickenBurgerMeal)).append(nl);
                 if(baconAndCheeseBurger != 0)
                     builder.append("Bacon And Cheese Burger:  ").append(String.valueOf(baconAndCheeseBurger)).append(nl);
                 if(!selectedDrink.equals(""))
                     builder.append("Selected Drink:           ").append(selectedDrink).append("(").append(String.valueOf(PriceEnum.fromString(selectedDrink).getValue())).append(")").append(nl);

                 builder.append("Thanks for using Job Estimator System").append(nl);

                 areaReceipt.setText(builder.toString());

             } catch(Exception ex) {
                 System.err.println(ex.getMessage()); 
             }
        });


        btnReset.addActionListener(l-> {
            fieldChickenBurger.setText("");
            fieldChickenBurgerMeal.setText("");
            fieldBaconAndCheeseBurger.setText("");
            cbChickenBurger.setSelected(false);
            cbChickenBurgerMeal.setSelected(false);
            cbBaconAndCheeseBurger.setSelected(false);
            comboDrinks.setSelectedIndex(0);
            cbTax.setSelected(false);
            cbHomeDelivery.setSelected(false);
            fieldCostOfDrinks.setText("");
            fieldCostOfMeal.setText("");
            fieldCostOfDelivery.setText("");
            fieldSubTotal.setText("");
            fieldTotal.setText("");
            fieldTax.setText("");
            comboCurrency.setSelectedIndex(0);
            fieldCurrency.setText("");
            fieldCurrencyOutput.setText("");

            areaReceipt.setText("");
        });

        btnExit.addActionListener(l-> {
            this.setVisible(false);
        });




        /*
          comboCurrency.addItem("Choose One...");
        comboCurrency.addItem("USA");
        comboCurrency.addItem("Nigeria");
        comboCurrency.addItem("Kenya");
        comboCurrency.addItem("Canada");
        comboCurrency.addItem("Brazil");
        comboCurrency.addItem("Indonesia");
        comboCurrency.addItem("Philippine");
         */
        btnConvert.addActionListener(l-> {
             try {
                 String strCurreny = fieldCurrency.getText();
                 int selectedIndex = comboCurrency.getSelectedIndex();
                 if(selectedIndex <= 0) return ;
                 CurrencyEnum selectedEnum = null;
                 switch(selectedIndex) {
                     case 1: selectedEnum =  CurrencyEnum.USA ; break;
                     case 2: selectedEnum = CurrencyEnum.Nigeria; break;
                     case 3: selectedEnum = CurrencyEnum.Kenya; break;
                     case 4: selectedEnum = CurrencyEnum.Canada; break ;
                     case 5: selectedEnum = CurrencyEnum.Brazil; break;
                     case 6: selectedEnum = CurrencyEnum.Indonesia; break;
                     case 7: selectedEnum = CurrencyEnum.Philippine; break;
                 }


                 double currency = Double.parseDouble(strCurreny);
                 double out = currency * selectedEnum.getValue();
                 StringBuilder builder = new StringBuilder().append(out).append(" ").append(selectedEnum.getAbbr());
                 fieldCurrencyOutput.setText(builder.toString());
             } catch(Exception ex) {
                 System.err.println(ex.getMessage());
             }
        });

        btnCloseCurrency.addActionListener(l-> {
            comboCurrency.setSelectedIndex(0);
            fieldCurrency.setText("");
            fieldCurrencyOutput.setText("");
        });



        CalculatorListener calculatorListener = new CalculatorListener(areaCalculatorDisplay);
        btn0.addActionListener(calculatorListener);
        btn1.addActionListener(calculatorListener);
        btn2.addActionListener(calculatorListener);
        btn3.addActionListener(calculatorListener);
        btn4.addActionListener(calculatorListener);
        btn5.addActionListener(calculatorListener);
        btn6.addActionListener(calculatorListener);
        btn7.addActionListener(calculatorListener);
        btn8.addActionListener(calculatorListener);
        btn9.addActionListener(calculatorListener);
        btnPlus.addActionListener(calculatorListener);
        btnMinus.addActionListener(calculatorListener);
        btnMultiply.addActionListener(calculatorListener);
        btnDivide.addActionListener(calculatorListener);
        btnClear.addActionListener(calculatorListener);
        btnDot.addActionListener(calculatorListener);


        btnEquals.addActionListener(l-> {
            try {
                String display = areaCalculatorDisplay.getText();
                Double res = CalculatorEngine.evaluate(display);
                display =  display  + " = " + res ;
                areaCalculatorDisplay.setText(display);
            } catch(Exception ex) {
                areaCalculatorDisplay.setText(ex.getMessage());
            }
        });

    }



    private double calculateTotal() throws Exception  {

            String txtCostOfDrinks = fieldCostOfDrinks.getText();
            double costOfDrinks = 0 ;
            if(!txtCostOfDrinks.equals(""))  costOfDrinks = Double.parseDouble(txtCostOfDrinks);
            String txtCostOfMeal = fieldCostOfMeal.getText();
            double costOfMeal = 0;
            if(!txtCostOfMeal.equals("")) costOfMeal = Double.parseDouble(txtCostOfMeal);
            String txtCostOfDelivery = fieldCostOfDelivery.getText();
            double costOfDelivery = 0;
            if(!txtCostOfDelivery.equals("")) costOfDelivery = Double.parseDouble(txtCostOfDelivery);
            return costOfDrinks+ costOfMeal + costOfDelivery;

    }

    private enum PriceEnum {
     ChickenBurger(6.69), ChickenBurgerMeal(10.69), BaconAndCheeseBurger(8.69),
        AppleJuice(2.48), Tea(1.48), Cola(3.48), Coke(3.48), Coffee(1.68),
        IceTea(2.48), IceCoffee(2.68), HomeDelivery(15.0), Tax(1.005);
        private double value;
        PriceEnum(double value) {
          this.value = value;
        }

        public double getValue() {
            return value;
        }

        public static PriceEnum fromString(String str){
            //str = str.toLowerCase();
            if(str.equalsIgnoreCase("ChickenBurger")) return ChickenBurger;
            else if(str.equalsIgnoreCase("ChickenBurgerMeal")) return ChickenBurgerMeal;
            else if(str.equalsIgnoreCase("BaconAndCheeseBurger")) return BaconAndCheeseBurger;
            else if(str.equalsIgnoreCase("AppleJuice")) return AppleJuice;
            else if(str.equalsIgnoreCase("Tea")) return Tea ;
            else if(str.equalsIgnoreCase("Cola")) return Cola;
            else if(str.equalsIgnoreCase("Coke")) return Coke ;
            else if(str.equalsIgnoreCase("Coffee")) return Coffee;
            else if(str.equalsIgnoreCase("IceTea")) return IceTea;
            else if(str.equalsIgnoreCase("IceCoffee")) return IceCoffee;
            else if(str.equalsIgnoreCase("HomeDelivery")) return HomeDelivery;
            else if(str.equalsIgnoreCase("Tax")) return Tax;
            return null;
        }
    }



/*
     //GBP
        currencyContainer.add(CurrencyEnum.USA);  //USD
        currencyContainer.add(CurrencyEnum.Nigeria); // NGN
        currencyContainer.add(CurrencyEnum.Kenya); //KES
        currencyContainer.add(CurrencyEnum.Canada);  //CAD
        currencyContainer.add(CurrencyEnum.Brazil); //BRL
        currencyContainer.add(CurrencyEnum.Indonesia); //IDR
        currencyContainer.add(CurrencyEnum.Philippine); //PHP
 */
    private enum CurrencyEnum {
        USA(1.25, "USD"), Nigeria(381.95, "NGN"), Kenya(128.93, "KES"), Canada(1.67, "CAD"), Brazil(3.87, "BRL"), Indonesia(16629.43, "IDR"), Philippine(62.63, "PHP");
        private double value ;
        private String abbr ;
        CurrencyEnum(double value, String abbr) {
            this.value = value;
            this.abbr = abbr ;
        }

        public double getValue() {
            return this.value;
        }
        public String getAbbr() {
            return this.abbr ;
        }
    }

    private void extraInit() {
        comboDrinks.addItem("Select a drink");
        comboDrinks.addItem("Apple Juice");
        comboDrinks.addItem("Tea");
        comboDrinks.addItem("Cola");
        comboDrinks.addItem("Coke");
        comboDrinks.addItem("Coffee");
        comboDrinks.addItem("Ice Tea");
        comboDrinks.addItem("Ice Coffee");

        comboDrinks.setSelectedIndex(0);


        comboCurrency.addItem("Choose One...");
        comboCurrency.addItem("USA");
        comboCurrency.addItem("Nigeria");
        comboCurrency.addItem("Kenya");
        comboCurrency.addItem("Canada");
        comboCurrency.addItem("Brazil");
        comboCurrency.addItem("Indonesia");
        comboCurrency.addItem("Philippine");
        comboCurrency.setSelectedIndex(0);

        priceContainer.add(PriceEnum.ChickenBurger);
        priceContainer.add(PriceEnum.ChickenBurgerMeal);
        priceContainer.add(PriceEnum.BaconAndCheeseBurger);
        priceContainer.add(PriceEnum.AppleJuice);
        priceContainer.add(PriceEnum.Tea);
        priceContainer.add(PriceEnum.Cola);
        priceContainer.add(PriceEnum.Coke);
        priceContainer.add(PriceEnum.Coffee);
        priceContainer.add(PriceEnum.IceTea);
        priceContainer.add(PriceEnum.IceCoffee);
        priceContainer.add(PriceEnum.HomeDelivery);
        priceContainer.add(PriceEnum.Tax);



        //GBP
        currencyContainer.add(CurrencyEnum.USA);  //USD
        currencyContainer.add(CurrencyEnum.Nigeria); // NGN
        currencyContainer.add(CurrencyEnum.Kenya); //KES
        currencyContainer.add(CurrencyEnum.Canada);  //CAD
        currencyContainer.add(CurrencyEnum.Brazil); //BRL
        currencyContainer.add(CurrencyEnum.Indonesia); //IDR
        currencyContainer.add(CurrencyEnum.Philippine); //PHP

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Nijat Aghayev
        lblTitle = new JLabel();
        panel0 = new JPanel();
        cbChickenBurger = new JCheckBox();
        fieldChickenBurger = new JTextField();
        cbChickenBurgerMeal = new JCheckBox();
        fieldChickenBurgerMeal = new JTextField();
        cbBaconAndCheeseBurger = new JCheckBox();
        fieldBaconAndCheeseBurger = new JTextField();
        lblDrinks = new JLabel();
        comboDrinks = new JComboBox();
        cbTax = new JCheckBox();
        cbHomeDelivery = new JCheckBox();
        panel2 = new JPanel();
        panel3 = new JPanel();
        comboCurrency = new JComboBox();
        fieldCurrency = new JTextField();
        btnConvert = new JButton();
        btnCloseCurrency = new JButton();
        fieldCurrencyOutput = new JTextField();
        panel4 = new JPanel();
        lblCostOfDrinks = new JLabel();
        fieldCostOfDrinks = new JTextField();
        lblCostOfMeal = new JLabel();
        fieldCostOfMeal = new JTextField();
        lblCostOfDelivery = new JLabel();
        fieldCostOfDelivery = new JTextField();
        panel6 = new JPanel();
        lblSubTotal = new JLabel();
        lblTax = new JLabel();
        lblTotal = new JLabel();
        fieldSubTotal = new JTextField();
        fieldTax = new JTextField();
        fieldTotal = new JTextField();
        panel7 = new JPanel();
        btnTotal = new JButton();
        btnReceipt = new JButton();
        btnReset = new JButton();
        btnExit = new JButton();
        tabbedPane1 = new JTabbedPane();
        panel5 = new JPanel();
        scrollPane1 = new JScrollPane();
        areaReceipt = new JTextArea();
        panel8 = new JPanel();
        scrollPane2 = new JScrollPane();
        areaCalculatorDisplay = new JTextArea();
        lblCalculator = new JLabel();
        btn0 = new JButton();
        btn1 = new JButton();
        btn2 = new JButton();
        btn3 = new JButton();
        btn4 = new JButton();
        btn5 = new JButton();
        btn6 = new JButton();
        btn7 = new JButton();
        btn8 = new JButton();
        btn9 = new JButton();
        btnPlus = new JButton();
        btnMinus = new JButton();
        btnMultiply = new JButton();
        btnDivide = new JButton();
        btnEquals = new JButton();
        btnDot = new JButton();
        btnClear = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- lblTitle ----
        lblTitle.setText("Restaurant Management Systems");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblTitle);
        lblTitle.setBounds(175, 20, 225, 35);

        //======== panel0 ========
        {
            panel0.setBorder(new LineBorder(Color.black, 2));

            // JFormDesigner evaluation mark
            panel0.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel0.getBorder())); panel0.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel0.setLayout(null);

            //---- cbChickenBurger ----
            cbChickenBurger.setText("ChickenBurger");
            panel0.add(cbChickenBurger);
            cbChickenBurger.setBounds(new Rectangle(new Point(10, 20), cbChickenBurger.getPreferredSize()));
            panel0.add(fieldChickenBurger);
            fieldChickenBurger.setBounds(150, 20, 95, fieldChickenBurger.getPreferredSize().height);

            //---- cbChickenBurgerMeal ----
            cbChickenBurgerMeal.setText("C Burger Meal");
            panel0.add(cbChickenBurgerMeal);
            cbChickenBurgerMeal.setBounds(10, 60, 106, 24);
            panel0.add(fieldChickenBurgerMeal);
            fieldChickenBurgerMeal.setBounds(150, 60, 95, 24);

            //---- cbBaconAndCheeseBurger ----
            cbBaconAndCheeseBurger.setText("B&C Burger");
            panel0.add(cbBaconAndCheeseBurger);
            cbBaconAndCheeseBurger.setBounds(10, 100, 106, 24);
            panel0.add(fieldBaconAndCheeseBurger);
            fieldBaconAndCheeseBurger.setBounds(150, 100, 95, 24);

            //---- lblDrinks ----
            lblDrinks.setText("Drinks");
            panel0.add(lblDrinks);
            lblDrinks.setBounds(25, 145, 70, lblDrinks.getPreferredSize().height);

            //---- comboDrinks ----
            comboDrinks.setPrototypeDisplayValue("Select a Drink");
            comboDrinks.setToolTipText("Select a drink");
            panel0.add(comboDrinks);
            comboDrinks.setBounds(110, 145, 135, 25);

            //---- cbTax ----
            cbTax.setText("Tax");
            panel0.add(cbTax);
            cbTax.setBounds(new Rectangle(new Point(30, 190), cbTax.getPreferredSize()));

            //---- cbHomeDelivery ----
            cbHomeDelivery.setText("Home Delivery");
            panel0.add(cbHomeDelivery);
            cbHomeDelivery.setBounds(new Rectangle(new Point(135, 190), cbHomeDelivery.getPreferredSize()));

            //======== panel2 ========
            {
                panel2.setBorder(LineBorder.createBlackLineBorder());
                panel2.setLayout(null);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel2.getComponentCount(); i++) {
                        Rectangle bounds = panel2.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel2.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel2.setMinimumSize(preferredSize);
                    panel2.setPreferredSize(preferredSize);
                }
            }
            panel0.add(panel2);
            panel2.setBounds(5, 180, 245, panel2.getPreferredSize().height);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel0.getComponentCount(); i++) {
                    Rectangle bounds = panel0.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel0.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel0.setMinimumSize(preferredSize);
                panel0.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel0);
        panel0.setBounds(5, 55, 255, 235);

        //======== panel3 ========
        {
            panel3.setBorder(new LineBorder(Color.black, 2));
            panel3.setLayout(null);
            panel3.add(comboCurrency);
            comboCurrency.setBounds(50, 25, 150, comboCurrency.getPreferredSize().height);
            panel3.add(fieldCurrency);
            fieldCurrency.setBounds(50, 90, 160, fieldCurrency.getPreferredSize().height);

            //---- btnConvert ----
            btnConvert.setText("Convert");
            panel3.add(btnConvert);
            btnConvert.setBounds(50, 165, 85, 30);

            //---- btnCloseCurrency ----
            btnCloseCurrency.setText("Close");
            panel3.add(btnCloseCurrency);
            btnCloseCurrency.setBounds(145, 165, 85, 30);

            //---- fieldCurrencyOutput ----
            fieldCurrencyOutput.setEditable(false);
            panel3.add(fieldCurrencyOutput);
            fieldCurrencyOutput.setBounds(50, 130, 160, 24);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel3.getComponentCount(); i++) {
                    Rectangle bounds = panel3.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel3.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel3.setMinimumSize(preferredSize);
                panel3.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel3);
        panel3.setBounds(265, 55, 255, 235);

        //======== panel4 ========
        {
            panel4.setBorder(new LineBorder(Color.black, 2));
            panel4.setLayout(null);

            //---- lblCostOfDrinks ----
            lblCostOfDrinks.setText("Cost of Drinks");
            panel4.add(lblCostOfDrinks);
            lblCostOfDrinks.setBounds(10, 25, 89, 20);

            //---- fieldCostOfDrinks ----
            fieldCostOfDrinks.setEditable(false);
            panel4.add(fieldCostOfDrinks);
            fieldCostOfDrinks.setBounds(110, 25, 135, fieldCostOfDrinks.getPreferredSize().height);

            //---- lblCostOfMeal ----
            lblCostOfMeal.setText("Cost of Meal");
            panel4.add(lblCostOfMeal);
            lblCostOfMeal.setBounds(10, 60, 89, 20);

            //---- fieldCostOfMeal ----
            fieldCostOfMeal.setEditable(false);
            panel4.add(fieldCostOfMeal);
            fieldCostOfMeal.setBounds(110, 60, 135, 24);

            //---- lblCostOfDelivery ----
            lblCostOfDelivery.setText("Cost of Delivery");
            panel4.add(lblCostOfDelivery);
            lblCostOfDelivery.setBounds(10, 90, 89, 20);

            //---- fieldCostOfDelivery ----
            fieldCostOfDelivery.setEditable(false);
            panel4.add(fieldCostOfDelivery);
            fieldCostOfDelivery.setBounds(110, 90, 135, 24);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel4.getComponentCount(); i++) {
                    Rectangle bounds = panel4.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel4.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel4.setMinimumSize(preferredSize);
                panel4.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel4);
        panel4.setBounds(5, 295, 255, 150);

        //======== panel6 ========
        {
            panel6.setBorder(new LineBorder(Color.black, 2));
            panel6.setLayout(null);

            //---- lblSubTotal ----
            lblSubTotal.setText("Sub Total:");
            panel6.add(lblSubTotal);
            lblSubTotal.setBounds(20, 25, 65, lblSubTotal.getPreferredSize().height);

            //---- lblTax ----
            lblTax.setText("Tax:");
            panel6.add(lblTax);
            lblTax.setBounds(20, 65, 60, 16);

            //---- lblTotal ----
            lblTotal.setText("Total:");
            panel6.add(lblTotal);
            lblTotal.setBounds(20, 95, 65, 16);

            //---- fieldSubTotal ----
            fieldSubTotal.setEditable(false);
            panel6.add(fieldSubTotal);
            fieldSubTotal.setBounds(95, 25, 135, 24);

            //---- fieldTax ----
            fieldTax.setEditable(false);
            panel6.add(fieldTax);
            fieldTax.setBounds(95, 60, 135, 24);

            //---- fieldTotal ----
            fieldTotal.setEditable(false);
            panel6.add(fieldTotal);
            fieldTotal.setBounds(95, 90, 135, 24);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel6.getComponentCount(); i++) {
                    Rectangle bounds = panel6.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel6.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel6.setMinimumSize(preferredSize);
                panel6.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel6);
        panel6.setBounds(265, 295, 255, 150);

        //======== panel7 ========
        {
            panel7.setBorder(new LineBorder(Color.black, 2));
            panel7.setLayout(null);

            //---- btnTotal ----
            btnTotal.setText("Total");
            panel7.add(btnTotal);
            btnTotal.setBounds(20, 15, 75, 32);

            //---- btnReceipt ----
            btnReceipt.setText("Receipt");
            panel7.add(btnReceipt);
            btnReceipt.setBounds(125, 15, 90, 32);

            //---- btnReset ----
            btnReset.setText("Reset");
            panel7.add(btnReset);
            btnReset.setBounds(280, 15, 75, 32);

            //---- btnExit ----
            btnExit.setText("Exit");
            panel7.add(btnExit);
            btnExit.setBounds(385, 15, 75, 32);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel7.getComponentCount(); i++) {
                    Rectangle bounds = panel7.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel7.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel7.setMinimumSize(preferredSize);
                panel7.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel7);
        panel7.setBounds(5, 455, 515, 70);

        //======== tabbedPane1 ========
        {
            tabbedPane1.setBorder(new LineBorder(Color.black, 2));

            //======== panel5 ========
            {
                panel5.setLayout(new BorderLayout());

                //======== scrollPane1 ========
                {

                    //---- areaReceipt ----
                    areaReceipt.setEditable(false);
                    scrollPane1.setViewportView(areaReceipt);
                }
                panel5.add(scrollPane1, BorderLayout.CENTER);
            }
            tabbedPane1.addTab("Receipt", panel5);

            //======== panel8 ========
            {
                panel8.setLayout(null);

                //======== scrollPane2 ========
                {

                    //---- areaCalculatorDisplay ----
                    areaCalculatorDisplay.setEditable(false);
                    scrollPane2.setViewportView(areaCalculatorDisplay);
                }
                panel8.add(scrollPane2);
                scrollPane2.setBounds(15, 40, 255, 200);

                //---- lblCalculator ----
                lblCalculator.setText("Simple Calculator");
                panel8.add(lblCalculator);
                lblCalculator.setBounds(new Rectangle(new Point(90, 10), lblCalculator.getPreferredSize()));

                //---- btn0 ----
                btn0.setText("0");
                panel8.add(btn0);
                btn0.setBounds(5, 260, 60, 32);

                //---- btn1 ----
                btn1.setText("1");
                panel8.add(btn1);
                btn1.setBounds(75, 260, 60, 32);

                //---- btn2 ----
                btn2.setText("2");
                panel8.add(btn2);
                btn2.setBounds(150, 260, 60, 32);

                //---- btn3 ----
                btn3.setText("3");
                panel8.add(btn3);
                btn3.setBounds(220, 260, 60, 32);

                //---- btn4 ----
                btn4.setText("4");
                panel8.add(btn4);
                btn4.setBounds(5, 295, 60, 32);

                //---- btn5 ----
                btn5.setText("5");
                panel8.add(btn5);
                btn5.setBounds(75, 295, 60, 32);

                //---- btn6 ----
                btn6.setText("6");
                panel8.add(btn6);
                btn6.setBounds(150, 295, 60, 32);

                //---- btn7 ----
                btn7.setText("7");
                panel8.add(btn7);
                btn7.setBounds(220, 295, 60, 32);

                //---- btn8 ----
                btn8.setText("8");
                panel8.add(btn8);
                btn8.setBounds(5, 330, 60, 32);

                //---- btn9 ----
                btn9.setText("9");
                panel8.add(btn9);
                btn9.setBounds(75, 330, 60, 32);

                //---- btnPlus ----
                btnPlus.setText("+");
                panel8.add(btnPlus);
                btnPlus.setBounds(150, 330, 60, 32);

                //---- btnMinus ----
                btnMinus.setText("-");
                panel8.add(btnMinus);
                btnMinus.setBounds(220, 330, 60, 32);

                //---- btnMultiply ----
                btnMultiply.setText("*");
                panel8.add(btnMultiply);
                btnMultiply.setBounds(5, 365, 60, 32);

                //---- btnDivide ----
                btnDivide.setText("/");
                panel8.add(btnDivide);
                btnDivide.setBounds(75, 365, 60, 32);

                //---- btnEquals ----
                btnEquals.setText("=");
                panel8.add(btnEquals);
                btnEquals.setBounds(150, 365, 60, 32);

                //---- btnDot ----
                btnDot.setText(".");
                panel8.add(btnDot);
                btnDot.setBounds(220, 365, 60, 32);

                //---- btnClear ----
                btnClear.setText("C");
                panel8.add(btnClear);
                btnClear.setBounds(5, 400, 60, 32);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel8.getComponentCount(); i++) {
                        Rectangle bounds = panel8.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel8.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel8.setMinimumSize(preferredSize);
                    panel8.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("Calculator", panel8);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(530, 55, 295, 470);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Nijat Aghayev
    private JLabel lblTitle;
    private JPanel panel0;
    private JCheckBox cbChickenBurger;
    private JTextField fieldChickenBurger;
    private JCheckBox cbChickenBurgerMeal;
    private JTextField fieldChickenBurgerMeal;
    private JCheckBox cbBaconAndCheeseBurger;
    private JTextField fieldBaconAndCheeseBurger;
    private JLabel lblDrinks;
    private JComboBox comboDrinks;
    private JCheckBox cbTax;
    private JCheckBox cbHomeDelivery;
    private JPanel panel2;
    private JPanel panel3;
    private JComboBox comboCurrency;
    private JTextField fieldCurrency;
    private JButton btnConvert;
    private JButton btnCloseCurrency;
    private JTextField fieldCurrencyOutput;
    private JPanel panel4;
    private JLabel lblCostOfDrinks;
    private JTextField fieldCostOfDrinks;
    private JLabel lblCostOfMeal;
    private JTextField fieldCostOfMeal;
    private JLabel lblCostOfDelivery;
    private JTextField fieldCostOfDelivery;
    private JPanel panel6;
    private JLabel lblSubTotal;
    private JLabel lblTax;
    private JLabel lblTotal;
    private JTextField fieldSubTotal;
    private JTextField fieldTax;
    private JTextField fieldTotal;
    private JPanel panel7;
    private JButton btnTotal;
    private JButton btnReceipt;
    private JButton btnReset;
    private JButton btnExit;
    private JTabbedPane tabbedPane1;
    private JPanel panel5;
    private JScrollPane scrollPane1;
    private JTextArea areaReceipt;
    private JPanel panel8;
    private JScrollPane scrollPane2;
    private JTextArea areaCalculatorDisplay;
    private JLabel lblCalculator;
    private JButton btn0;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btnPlus;
    private JButton btnMinus;
    private JButton btnMultiply;
    private JButton btnDivide;
    private JButton btnEquals;
    private JButton btnDot;
    private JButton btnClear;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

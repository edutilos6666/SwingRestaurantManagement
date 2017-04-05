package com.edutilos.main;


import java.util.Stack;

public class CalculatorEngine {
   public static Double evaluate(String input) throws Exception {
       Double res = 0.0;
       Stack<Double> operands = new Stack<>() ;
       Stack<Character> operators = new Stack<>();
       String [] splitted = input.split("\\s+");
       //System.out.println(splitted);
       for(int i=0; i< splitted.length-2; i+=2) {
           String str0 = splitted[i],
                   str1 = splitted[i+1];
           Double n = Double.parseDouble(str0);
           operands.push(n);
           if(str1.equals("+")) operators.push('+');
           else if(str1.equals("-")) operators.push('-');
           else if(str1.equals("*")) operators.push('*');
           else if(str1.equals("/")) operators.push('/');
           else throw new Exception("Invalid Input");
       }

       operands.add(Double.parseDouble(splitted[splitted.length-1]));
       if((operands.size() - operators.size())!= 1) throw new Exception("Invalid Input");
       Stack<Double> reversedOperands = new Stack<>();
       Stack<Character> reversedOperators = new Stack<>();
       while(!operands.isEmpty()) reversedOperands.push(operands.pop());
       while(!operators.isEmpty()) reversedOperators.push(operators.pop());

       while(!reversedOperators.isEmpty()) {
           Double n0 = reversedOperands.pop(),
                   n1 = reversedOperands.pop();
           Character op = reversedOperators.pop();
           switch(op) {
               case '+': n0 = n0 + n1; break;
               case '-': n0 = n0 - n1; break;
               case '*': n0 = n0 * n1; break;
               case '/': n0 = n0 / n1; break;
           }

           reversedOperands.push(n0);
       }

       res = reversedOperands.pop();
       return res ;
   }
}

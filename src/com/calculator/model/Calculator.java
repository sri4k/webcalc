package com.calculator.model;

import java.io.Serializable;

public class Calculator implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private double number1;
	private double number2;
	private String operator;
	private double result;
	
	public double getNumber1() {
		return number1;
	}
	public void setNumber1(double number1) {
		this.number1 = number1;
	}
	public double getNumber2() {
		return number2;
	}
	public void setNumber2(double number2) {
		this.number2 = number2;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	
}


//public static void main(String[] args) {
//
//    Scanner reader = new Scanner(System.in);
//    System.out.print("Enter two numbers: ");
//
//    first = reader.nextDouble();
//    second = reader.nextDouble();
//
//    System.out.print("Enter an operator (+, -, *, /): ");
//    char operator = reader.next().charAt(0);
//
//    double result;
//
//    switch(operator)
//    {
//        case '+':
//            result = first + second;
//            break;
//
//        case '-':
//            result = first - second;
//            break;
//
//        case '*':
//            result = first * second;
//            break;
//
//        case '/':
//            result = first / second;
//            break;
//
//        default:
//            System.err.print("Error! operator is not correct");
//            return;
//    }
//
//    System.err.printf("%.1f %c %.1f = %.1f", first, operator, second, result);
//}
package com.calculator.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.calculator.dao.CalculatorDao;
import com.calculator.model.Calculator;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CalculatorDao calculatorDao = new CalculatorDao();
	
    public CalculatorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 	List<Calculator> list = null;
	 	System.out.println("inside do get");
		try {
			list = calculatorDao.getCalculations();
			System.out.println(list.size());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	 	
	 	request.setAttribute("list", list);
	 	RequestDispatcher dispatcher = request.getRequestDispatcher("/views/results.jsp");
	 	dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		double number1 = Double.parseDouble(request.getParameter("number1"));
		double number2 = Double.parseDouble(request.getParameter("number2"));
		String operator = request.getParameter("operator");
		double result = Double.parseDouble(request.getParameter("result"));
		
		Calculator calculator = new Calculator();
		calculator.setNumber1(number1);
		calculator.setOperator(operator); 
		calculator.setNumber2(number2);
		calculator.setResult(result);
		
		try {
			calculatorDao.submitCalculation(calculator);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/results.jsp");
		dispatcher.forward(request, response);
	}
}

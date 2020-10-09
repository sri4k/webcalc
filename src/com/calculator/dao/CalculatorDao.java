package com.calculator.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.calculator.model.Calculator;

public class CalculatorDao {
	
	public int submitCalculation(Calculator calculator) throws ClassNotFoundException
	{
		String insertCalculation = "INSERT INTO calculator " +
									"(number1, operator, number2, result) values " +
									"(?,?,?,?)" ;
		
		int res = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection conn = DriverManager.
				getConnection("jdbc:mysql://localhost:3306/webdb?useSSL=false", "root", "root");
				PreparedStatement ps = conn.prepareStatement(insertCalculation)) {
			
			ps.setDouble(1, calculator.getNumber1());
			ps.setString(2, calculator.getOperator());
			ps.setDouble(3, calculator.getNumber2()); 
			ps.setDouble(4, calculator.getResult());
			
			res = ps.executeUpdate();
			System.out.println("Inserted into db " + res);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;	
	}
	
	public List<Calculator> getCalculations() throws ClassNotFoundException
	{
		List<Calculator> list = new ArrayList<Calculator>();
		String getCalculations = "SELECT * FROM calculator" ;
		
		try (Connection conn = DriverManager.
				getConnection("jdbc:mysql://localhost:3306/webdb?useSSL=false", "root", "root")) {
				
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(getCalculations);
			
			while(rs.next()) {
				Calculator calculator = new Calculator();
				calculator.setNumber1(rs.getDouble("number1"));
				calculator.setOperator(rs.getString("operator"));
				calculator.setNumber2(rs.getDouble("number2"));
				calculator.setResult(rs.getDouble("result"));
				list.add(calculator);
			}
			
			System.out.println("Fetched from db " + rs.getFetchSize());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}

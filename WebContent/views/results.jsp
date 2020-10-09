<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculator Web UI</title>
</head>
<body>
 <div align="center">
  <h1>Calculated Results</h1>
  <form action="<%= request.getContextPath() %>/CalculatorServlet" method="get">
   <table>
		<tr>
			<th>Number1</th>
			<th>Operator</th>
			<th>Number2</th>
			<th>Result</th>
		</tr>
		<c:forEach items = "${list}" var = "calculator">
			<tr>
				<td>${calculator.number1}</td>
				<td>${calculator.operator}</td>
				<td>${calculator.number2}</td>
				<td>${calculator.result}</td>
			</tr>
		</c:forEach>
	</table>
  </form>
 </div>
</body>
</html>
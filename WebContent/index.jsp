<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculator Web UI</title>
</head>
<body>
 <div align="center">
  <h1>Calculator</h1>
  <form action="<%= request.getContextPath() %>/CalculatorServlet" method="post">
   <table style="with: 80%">
    <tr>
     <th>Number1</th>
     <th>Operator</th>
     <th>Number2</th>
     <th>Result</th>
    </tr>
    <tr>
     <td><input type="text" name="number1" /></td>
     <td><input type="text" name="operator" /></td>
     <td><input type="text" name="number2" /></td>
     <td><input type="text" name="result" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>
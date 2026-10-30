<%@page import="aiwa.entity.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%

  Customer customer = (Customer) request.getAttribute("customer");

%>
</head>
<body>
  
  <h1><%= customer.getCustomerName() %></h1>

</body>
</html>
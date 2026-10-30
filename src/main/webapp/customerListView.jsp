
<%@page import="aiwa.entity.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客リスト</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
    rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.2/font/bootstrap-icons.min.css">
</head>
<body>

<div class="container">

<h1 class="display-1 text-primary text-center">顧客リスト</h1>

<a href="CustomerListController?keyword=タ">クリック</a>

<form action="CustomerListController" method="get">

    <div class="mb-3">
        <input class="form-control"
            placeholder="キーワード"
            type="text"
            name="keyboard"
            value="<%= request.getParameter("keyboard") != null ? request.getParameter("keyboard") : "" %>">
    </div>
    <div class="mb-3 d-grid">
        <button class="btn btn-primary" type="submit"><i class="bi bi-search-heart"></i>検索</button>
    </div>
</form>

<%
ArrayList<Customer> customers =
    (ArrayList<Customer>) request.getAttribute("customers");
%>

<table class="table table-striped">
    <tr>
        <th>顧客ID</th>
        <th>顧客名</th>
        
    </tr>

    <% if (customers != null) {
        for (Customer c : customers) { %>
    <tr>
        <td><a href="CustomerDetailController?customerid=<%= c.getCustomerId() %>"><%= c.getCustomerId() %></a></td>
        <td><%= c.getCustomerName() %></td>
        
    </tr>
    <% }
        
        }%>
        
</table>

</div>
</body>
</html>


<%@page import="aiwa.entity.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員リスト</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
    rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.2/font/bootstrap-icons.min.css">
</head>
<body>

<div class="container">

<h1 class="display-1 text-primary">社員リスト</h1>

<form action="EmployeeListController" method="get">
    <div class="mb-3">
        <input class="form-control"
            placeholder="キーワード"
            type="text"
            name="keyboard"
            value="<%= request.getParameter("keyboard") != null
                ? request.getParameter("keyboard") : "" %>">
    </div>
    <div class="mb-3 d-grid">
        <button class="btn btn-primary" type="submit">検索<i class="bi bi-person-circle"></i></button>
    </div>
</form>

<%
ArrayList<Employee> employees =
    (ArrayList<Employee>) request.getAttribute("employees");
%>

<table class="table table-striped">
    <tr>
        <th>社員ID</th>
        <th>社員名</th>
        <th>身長</th>
        <th>メール</th>
        <th>体重</th>
        <th>入社年度</th>
        <th>誕生日</th>
        <th>血液型</th>
    </tr>

    <% if (employees != null) {
        for (Employee e : employees) { %>
    <tr>
        <td><%= e.getEmployeeId() %></td>
        <td><%= e.getEmployeeName() %></td>
        <td><%= e.getHeight() %></td>
        <td><%= e.getEmail() %></td>
        <td><%= e.getWeight() %></td>
        <td><%= e.getHirefiscalyear() %></td>
        <td><%= e.getBirthday() %></td>
        <td><%= e.getBloodtype() %></td>
    </tr>
    <%  }
       } %>
</table>

</div>
</body>
</html>

<%@page import="com.dao.EmpDAO"%>
<%@page import="com.bean.EmpBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table {
 
  width: 70%;

}</style>
</head>
<body>

 <%
 
 List<EmpBean> l=EmpDAO.getAllData();
 
 %>
 <h1>All Data Of Employees</h1>
 <table border="1" align="center">
    <tr>
     <th>Id</th>
     <th>Employee Name</th>
     <th>Employee Degree</th>
     <th>Employee Email</th>
     <th>Delete</th>
     <th>Edit</th>
    </tr>
  <%
    for(EmpBean b:l)
    {
  %>
    <tr> 
      <td><%=b.getEid() %></td>
      <td><%=b.getEname() %></td>
      <td><%=b.getEdegree() %></td>
      <td><%=b.getEemail()%></td>
      <td>
         <form action="SaveServlet" method="post">
         <input type="hidden" name="eid" value="<%=b.getEid() %>">
      
          <input type="submit" name="action" value="Delete">
         </form>
      </td>
      <td>
         <form action="SaveServlet" method="post">
         <input type="hidden" name="eid" value="<%=b.getEid() %>">
      
          <input type="submit" name="action" value="Update">
         </form>
      </td>
 
    </tr>
 <%
    }
 
 %>
 </table>

</body>
</html>
<%@page import="com.dao.EmpDAO"%>
<%@page import="com.bean.EmpBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

Long eid=Long.parseLong(request.getParameter("eid"));
EmpBean b=EmpDAO.updateData(eid);

%>
   <form action="SaveServlet" method="post">
<table>
    <tr>
      <td>Employee Id</td>
     <td><input type="text" name="eid" value="<%=b.getEid() %>"></td>
    </tr>
   <tr>
      <td>Employee Name</td>
     <td><input type="text" name="ename" value="<%=b.getEname() %>"></td>
    </tr>
    <tr>
      <td>Employee Degree</td>
      <td><input type="text" name="edegree" value="<%=b.getEdegree() %>"></td>
    </tr>
    <tr>
      <td>Employee Email</td>
   <td><input type="text" name="eemail" value="<%=b.getEemail() %>"></td>
    </tr>
    <tr>
      <td><input type="submit" name="action" value="Update_Data"></td>
   
    </tr>
  






</table>


</form>
   




</body>
</html>
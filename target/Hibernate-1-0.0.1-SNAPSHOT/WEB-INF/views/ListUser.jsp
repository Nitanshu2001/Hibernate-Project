<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List User</title>
</head>
<body>
<h2>List User</h2>

<table border=1>

	<thead>
		<tr>
			<th>UserId</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Action</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${users}"  var="u">
		<tr>
			<td>${u.userId}</td>
			<td>${u.firstName}</td>
			<td>${u.lastName}</td>
			<td>
                    <!-- Delete action link -->
                    <a href="<c:url value='/deleteuser/${u.userId}'/>">Delete</a> | 
                    <a href="<c:url value='/edituser/${u.userId}'/>">Edit</a> <!-- You can add an edit link if needed -->
            </td>
		</tr>
		</c:forEach>
	
	
	
	</tbody>


</table>
<br><br>

<a href="newuser">Add User</a>		

</body>
</html>
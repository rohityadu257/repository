<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab5-StudentForm</title>
</head>
<body bgcolor="skyblue">
	<h3>${mode} Student for College Festival</h3>
	 
	 <form action="save" method="POST">
	 
	 
		<input type="hidden" name="Id" value="${student.id}" placeholder = "id">
		 <br>
		  <input type="text" name="fname" value="${student.fname}"	placeholder="First Name">
			 <br>
			  <input type="text" name="lname" value="${student.lname}" placeholder="Last Name">
				<br>
				<input type="text" name="course" value="${student.course}" placeholder="Course">
			 <br> 
			 <input type="text" name="country" value="${student.country}" placeholder="Country">
				<br>
		<button type="submit">Save</button>
		
	</form>
	<a href="list">Back to Students List</a>

</body>
</html>
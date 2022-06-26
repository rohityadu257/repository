<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab5-StudentForm</title>
</head>
<body>
<h3> student for for ${mode})</h3>
<form action="save" method="POST">
                <input type="hidden" name="id" value="${Student.id}" />
                <input type="text" name="firstName" value="${Student.f_Name}" placeholder="First Name">
                <input type="text" name="lastName" value="${Student.l_Name}" placeholder="Last Name">
                <input type="text" name="course" value="${Student.course}" placeholder="Course">
                <input type="text" name="country" value="${Student.country}" placeholder="Country">
                <button type="submit" >Save</button>
            </form>
            <a href="list">Back to Students List</a>

</body>
</html>
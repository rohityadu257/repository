<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Student Management </title>
</head>
<body>
<h3>Student Registration Portal</h3>
<a href = "ShowFormForAdd">Add new Student </a>
 <table>
        <thead>
        
        <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>courses</th>
        <th>Country</th>
        </tr>
<tbody>
          <c:forEach items="${Student}" var="student" >
			<tr>
                <td>${Student.f_Name}</td>
                <td>${Student.l_Name}</td>
                <td>${Student.course}</td>
                <td>${Student.country}</td>
                <td><a href="showFormForUpdate?studentId=${Student.id}">Update </a>
                    <a href="delete?studentId=${Student.id}" onclick="if (!(confirm('Are you sure you want to delete this Student?'))) return false">Delete</a></td>
            </tr>
          </c:forEach>
        </tbody>
    </table>
</body>
</html>
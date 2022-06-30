<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Page</title>
<style>
.rem {
	border: "solid";
	cellpadding: "4";
	width: "30%";
	bgcolor: "#9f9f9f";
	align: "center";
	cellspacing: "4";
}
</style>
</head>
<body bgcolor="skyblue">
	<div id="wrapper"></div>

	<div id="container">

		<div id="content">

			<h1 type="textbox" align="center">Student Registration Portal</h1>
			<div
				style="border: 4px; color: red; padding: 20px; font-size: 20px; align: center">
				<input type="button" value="New Registration"
					onclick="window.location.href='ShowFormForAdd'; return false;"
					class="add-button" />
				<p>List of Student registered for the Cultural fest:</p>
				<table class="rem">

					<thead>
						<tr>
							<th width="100">FirstName</th>
							<th width="120">LastName</th>
							<th width="100">Courses</th>
							<th width="100">Country</th>
							<th width="120">Action</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${students}" var="student">
							<tr>
								<td>${student.fname}</td>
								<td>${student.lname}</td>
								<td>${student.course}</td>
								<td>${student.country}</td>
								<td><a href="ShowFormForupdate?Id=${student.id}">
										Update </a> <a href="delete?Id=${student.id}"
									onclick="if (!(confirm('Are you sure you want to delete this Student?'))) return false">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<style>
.add-button {background-color:skyblue;padding:5px 8px;font-size: 12px;border-radius:6px; margin : 2px 4px; display:block}
.button1 {  background-color: #4CAF50; color: black;  padding: 10px 470px;  text-align: center; border-color:white; text-decoration: none;
  font-weight: Bold;  font-size: 20px;  margin: 8px 4px; border-radius:6px; cursor: pointer;}
		.tg {align :center; width:125px;border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:5px 100px;border-style:solid;border-width:2px;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:bold;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#4CAF50;}
		.tg .tg-4eph{background-color:#f9f9f9}
		
</style>
<head>

<title>List Customers</title>

<body>
<b>
<button class="button1" >Customer Relationship Management</button>
</b>	
	<div id="container">
		
			<input type="button" value="Add Customer" 
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
			<table class = tg style = margin-left:auto;margin-right:auto; width=125px>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
	
	</div>
	

</body>

</html>










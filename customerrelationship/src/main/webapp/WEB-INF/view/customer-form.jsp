<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>

	<title>Save Customer</title>
</head>
<style>
.button1 {  background-color: #4CAF50; color: black;  padding: 10px 470px;  text-align: center; border-color:white; text-decoration: none;
  font-weight: Bold;  font-size: 20px;  margin: 8px 4px;  cursor: pointer;}
</style>
<body>
	
	<div id="wrapper">
		<div id="header">
		<b>
<button class="button1" >Customer Relationship Management</button>
</b>
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Customer</h3>
	
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>
				
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
		
		<div style="clear; both;"></div>
		
		  
	</div>
	<a href="list">Back to customer List</a>
</body>

</html>











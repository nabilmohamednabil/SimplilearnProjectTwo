<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
	<style>
		.error{
			color:red;
		}
	</style>
</head>
<body>
	<div class='container'>
		<h1>online management system : </h1>
		<hr style="width:50%", size="3", color=black>  
		<div class='container'>
	<h2>Student DashBoard</h2>
	<hr style="width:50%", size="3", color=black>  
	<table class="table table-hover">
		<thead>
			<tr>
			    <th scope="col">Student Name</th>
				<th scope="col">Class Name</th>
			</tr>
		</thead>
		<tbody>
		        <c:forEach items="${mylist}" var="students"> 		
				<tr>
			     	
							<td>${students.studentname}</td>
							<td>${students.schoolclass.classname}</td>
					
				</tr>
				</c:forEach>
		</tbody>
	</table>
	</div>		  
	</div>
</body>
</html>

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
	<h2>Classes DashBoard</h2>
	<hr style="width:50%", size="3", color=black>  
    <c:forEach items="${myclasslist}" var="mylist">
	<table class="table table-hover">
		<thead>
			<tr>
			    <th scope="col">category</th>
				<th scope="col">${mylist.classname}</th>
			</tr>
		</thead>
		<tbody>		
				<tr>
				   <td>Subjects</td>
			     	<c:forEach items="${mylist.subjects}" var="subjects">
							<td>${subjects.subjectname}</td>
					</c:forEach>
				</tr>
				<tr>
				  <td>Teachers</td>
				  <c:forEach items="${mylist.teachers}" var="teachers">
					 <td>${teachers.teachername}</td>
				  </c:forEach>
				</tr>
				<tr>
				  <td>Students</td>				  	
					<c:forEach items="${mylist.students}" var="students">
							<td>${students.studentname}</td>
					</c:forEach>
				</tr>
		</tbody>
	</table>
    </c:forEach>
	</div>
		
		  
	</div>
</body>
</html>

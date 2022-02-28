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
	    <a href="/SimpliLearnPhaseTwo/students"> Get ALL Students</a>
		<a href="/SimpliLearnPhaseTwo/dashboard">Go To Dashboard</a>
		<hr style="width:50%", size="3", color=black>  
		<form action='class' method=POST>
			<div class="mb-3">
			  <label for="exampleInputEmail1" class="form-label">Subject Name</label>
			  <input type="text" class="form-control" name="Subject"> 
			</div>			
			<div>
				<%
					String errMsg = request.getParameter("error");
						if(errMsg != null){
				%>
				<span class='error'><%= errMsg %></span>
				<%} %>
			</div>
			<button type="submit" class="btn btn-primary">Add Subject</button>
		</form>
		<hr style="width:50%", size="3", color=black>  
		<form action='class' method=POST>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Teacher Name</label>
		        <input type="text" class="form-control" name="teacher">
			</div>
			<div>
				<%
					String errMsg2 = request.getParameter("error2");
						if(errMsg2 != null){
				%>
				<span class='error'><%= errMsg2 %></span>
				<%} %>
			</div>
			<button type="submit" class="btn btn-primary">Add Teacher</button>
		</form>
		<hr style="width:50%", size="3", color=black>  
		<form action='class' method=POST>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Class Name</label>
			    <input type="text" class="form-control" name="class">
			</div>
			<div>
				<%
					String errMsg3 = request.getParameter("error3");
						if(errMsg3 != null){
				%>
				<span class='error'><%= errMsg3 %></span>
				<%} %>
			</div>
			<button type="submit" class="btn btn-primary">Add Class</button>
		</form>
		<hr style="width:50%", size="3", color=black>  
		<form action='class' method=POST>
			<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label">Assign Subject</label>
			    <select name="assignsubject">
		            <c:forEach   items="${mysubjectlist}" var="sub">
			            <option  value=" ${sub.subjectname}" > ${sub.subjectname} </option>
			         </c:forEach>
                </select>
			</div>
			<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label">To A class</label>
			    <select name="assignclass">
		            <c:forEach   items="${myclasslist}" var="sub">
			            <option  value=" ${sub.classname}" > ${sub.classname} </option>
			         </c:forEach>
                </select>
			</div>
			<div>
				<%
					String errMsg4 = request.getParameter("error4");
						if(errMsg4 != null){
				%>
				<span class='error'><%= errMsg4 %></span>
				<%} %>
			</div>
			<button type="submit" class="btn btn-primary">Assign Subject to Class</button>
		</form>
		<hr style="width:50%", size="3", color=black>  
		<form action='class' method=POST>
			<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label">Assign A Teacher </label>
                <select name="assignteacher">
		            <c:forEach   items="${myteacherlist}" var="sub">
			            <option  value=" ${sub.teachername}" > ${sub.teachername} </option>
			         </c:forEach>
                </select>
			</div>
			<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label">To A Class </label>
				<select name="assignteachertoclass">
		            <c:forEach   items="${myclasslist}" var="sub">
			            <option  value=" ${sub.classname}" > ${sub.classname} </option>
			         </c:forEach>
                </select>
			</div>
			<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label">To A Subject </label>
			    <select name="assignteachertosubject">
		            <c:forEach   items="${mysubjectlist}" var="sub">
			            <option  value=" ${sub.subjectname}" > ${sub.subjectname} </option>
			         </c:forEach>
                </select>
			</div>
			<div>
				<%
					String errMsg5 = request.getParameter("error5");
						if(errMsg5 != null){
				%>
				<span class='error'><%= errMsg5 %></span>
				<%} %>
			</div>
			<button type="submit" class="btn btn-primary">Assign Teacher to class</button>
		</form>
		<hr style="width:50%", size="3", color=black>  
	</div>
</body>
</html>

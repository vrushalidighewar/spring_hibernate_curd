<!DOCTYPE html>
<html lang="en">
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<title>Student CURD</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">

		<form class="form-horizontal" action="save" method="post">
			<fieldset>
			<c:if test="${not empty success}">
			<font color="green">${success}</font>
			</c:if>
			<c:if test="${not empty error}">
			<font color="red">${error}</font>
			</c:if>

				<!-- Form Name -->
				<legend>Form Name</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="name">Enter name</label>
					<div class="col-md-4">
						<input id="name" name="name" type="text" placeholder="Enter name"
							class="form-control input-md" required="">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="surname">Enter
						Lastname</label>
					<div class="col-md-4">
						<input id="surname" name="surname" type="text"
							placeholder="Enter Lastname" class="form-control input-md"
							required="">

					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for=""></label>
					<div class="col-md-4">
						<button id="" name="" class="btn btn-primary">save</button>
					</div>
				</div>

			</fieldset>
		</form>

		<h2>Basic Table</h2>

		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>FIRSTNAME</th>
					<th>LASTNAME</th>
					<th>ACTION</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${students}" var="student">
					<tr>
						<td>${student.id}</td>
						<td>${student.name}</td>
						<td>${student.surname}</td>
						<td><a href="modify?id=${student.id}">Edit</a>|<a
							href="delete?id=${student.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>

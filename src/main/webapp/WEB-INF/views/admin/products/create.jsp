<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<!DOCTYPE html>
<html lang="en">
<head>
<title>CSS Template</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
	box-sizing: border-box;
	padding: 0px;
	margin: 0px;
}

body {
	font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
header {
	background-color: #666;
	padding: 30px;
	text-align: center;
	font-size: 35px;
	color: white;
}

/* Create two columns/boxes that floats next to each other */
nav {
	float: left;
	width: 30%;
	height: 300px; /* only for demonstration, should be removed */
	background: #ccc;
	padding: 20px;
}

/* Style the list inside the menu */
nav ul {
	list-style-type: none;
	padding: 0;
}

article {
	float: left;
	padding: 20px;
	width: 70%;
	background-color: #f1f1f1;
	height: 300px; /* only for demonstration, should be removed */
}

/* Clear floats after the columns */
section:after {
	content: "";
	display: table;
	clear: both;
}

/* Style the footer */
footer {
	background-color: #777;
	padding: 10px;
	text-align: center;
	color: white;
}

/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media ( max-width : 600px) {
	nav, article {
		width: 100%;
		height: auto;
	}
}
</style>

</head>
<body>



	<section>
		<h4>
			<a href="${pageContext.request.contextPath}/products">Trang chủ</a> > <a
				href="${pageContext.request.contextPath}/products">Quản lý Sản phẩm</a> > <a
				href="${pageContext.request.contextPath}/product/create">Tạo
				sản phẩm</a>
		</h4>
		<div class="row">
			<div class="col-12">
				<div class="col-6 offset-3">
					<form:form method="POST"
						action="${pageContext.request.contextPath}/product/create"
						modelAttribute="productForm">
						
						<div class="mt-3">
							<label for="id" class="form-label">id</label>
							<form:input type="text" class="form-control" id="id"
								path="id" maxlength="200" />
							<p>
								<form:errors path="id" delimiter=";" />
							</p>
						</div>
						
						<div class="mt-3">
							<label for="name" class="form-label">Tên sản phẩm</label>
							<form:input type="text" class="form-control" id="name"
								path="name" maxlength="200" />
							<p>
								<form:errors path="name" delimiter=";" />
							</p>
						</div>
						
						<div class="mt-3">
							<label for="image" class="form-label">Ảnh</label>
							<form:input type="text" class="form-control" id="image"
								path="image" />
							<p>
								<form:errors path="image" delimiter=";" />
							</p>
						</div>
						<div class="mt-3">
							<label for="price" class="form-label">Giá</label>
							<form:input type="number" class="form-control" id="price"
								path="price" />
							<p>
								<form:errors path="price" delimiter=";" />
							</p>
						</div>
						<div class="mt-3">
							<label for="category" class="form-label">category</label>
							<form:input type="number" class="form-control" id="price"
								path="category" />
							<p>
								<form:errors path="price" delimiter=";" />
							</p>
						</div>
						<div class="mt-3">
							<input type="submit" class="btn btn-primary mb-3" value="Submit" />
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</section>




</body>
</html>
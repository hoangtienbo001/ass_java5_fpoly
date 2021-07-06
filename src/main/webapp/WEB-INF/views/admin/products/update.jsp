
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@page import="java.util.List"%>
<%@page import="io.spring.entities.Product"%>	
<article>

		<div class="row">
			<div class="col-12">
				<div class="col-6 offset-3">
					<form:form method="POST"
						action="${pageContext.request.contextPath}/product/create"
						modelAttribute="productForm">
						<div class="mt-3">
							<label for="id" class="form-label">id</label>
							<form:input type="text" class="form-control" id="id" path="id"
								readonly="true" />
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
							<label for="updatedDate" class="form-label">Ngày cập nhật
								cuối</label>
							<form:input type="updatedDate" class="form-control"
								id="updatedDate" path="updatedDate" disabled="true" />
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
	</article>
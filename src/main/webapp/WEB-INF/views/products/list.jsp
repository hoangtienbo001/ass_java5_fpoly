<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<%@page import="io.spring.model.ProductVO"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">

<section>

	<article>
		<h4>
			<a href="${pageContext.request.contextPath}/products">Trang chủ</a>
			> <a href="${pageContext.request.contextPath}/products">Quản lý Sản
				phẩm</a>
		</h4>

		<p style="color: black; font-weight: 500;">${ Message }</p>

		<form class="d-flex">
			<a type="button" class="btn btn-primary btn-lg"
				href="${pageContext.request.contextPath}/product/create">Tạo mới</a>
		</form>
		<table>
			<thead>
				<tr>

					<th>Id</th>

					<th>Tên</th>

					<th>Ảnh</th>

					<th>Gía</th>

					<th>Danh mục</th>

					<th>Ngày tạo</th>

					<th>Ngày cập nhật</th>

					<th colspan="2" style="text-align: center;">Hành động</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="productItem" items="${productList}">
					<tr>
						<td>${productItem.id}</td>

						<td>${productItem.name}</td>

						<td><img width="200" height="150" alt="ảnh"
							src="${productItem.image}"></td>

						<td>${productItem.price}</td>

						<td>${productItem.category.name}</td>


						<td>${productItem.createdDate}</td>

						<td>${productItem.updatedDate}</td>

						<td><a
							href="${pageContext.request.contextPath}/product/update/${ productItem.id }"
							class="btn btn-primary">Update</a></td>

						<td><a
							href="${pageContext.request.contextPath}/admin/products/delete/${ productItem.id }"
							class="btn btn-danger"
							onclick="if (!confirm('Bạn có chắc muốn xóa?')) { return false }">Delete</a>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</article>
</section>



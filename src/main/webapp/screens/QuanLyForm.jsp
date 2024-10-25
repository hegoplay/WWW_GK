<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="display: flex; justify-content: center; gap: 5px">
		<div style="width: 50%; border: 1px solid black; padding: 10px">
			<h2 style="text-align: center">Danh sách tin tức</h2>
			<table style="width: 100%; text-align: center;">
				<tr>
					<th>Mã ĐT</th>
					<th>Tên ĐT</th>
					<th>Năm sản xuất</th>
				</tr>
				<!-- add data from database -->
				<c:forEach items="${list}" var="item">
					<tr>
						<td>${item.maDienThoai}</td>
						<td>${item.tenDienThoai}</td>
						<td>${item.namSanXuat}</td>
						<td>
							<form action="QuanLyFormServlet" method="post">
								<button type="submit" value="${item.maDienThoai}"
									name="maDienThoai">Xóa</button>
							</form>
						</td>
					</tr>

				</c:forEach>

			</table>
		</div>
	</div>
</body>
</html>
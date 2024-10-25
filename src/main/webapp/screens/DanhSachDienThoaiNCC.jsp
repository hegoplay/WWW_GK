<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<style>
.item {
	border: 1px solid black;
	flex-direction: column;
}

.container {
	display: flex;
	flex-wrap: wrap;
	flex-direction: column;
}
</style>
</head>
<body>
	<div class="container">
		<form method="post">
			<table>
				<tr>
					<td>Ma nha cung cap</td>
					<td>Ten nha cung cap</td>
					<td>dia chi</td>
					<td>so dien thoai</td>
					<td>ten nha cung cap</td>
				</tr>
				<tr>
					<td><input type="text" name="maNCC" /></td>
					<td><input type="text" name="tenNCC" /></td>
					<td><input type="text" name="diaChi" /></td>
					<td><input type="text" name="SDT" /></td>
					<td>
						<select name = "mNCC">
							<c:forEach items = "${listNCC}" var="ncc">
								<option value="${ncc.maNhaCungCap}">${ncc.tenNhaCungCap}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="maNCC" name="type"></td>
					<td><input type="submit" value="tenNCC" name="type"></td>
					<td><input type="submit" value="diaChi" name="type"></td>
					<td><input type="submit" value="SDT" name="type"></td>
					<td>
            <input type="submit" value="findPhone" name="type"></td>
				</tr>
				
			</table>
		</form>
		<p>List Nha cung cap</p>
		<div>
			<c:forEach items="${listNCC}" var="ncc">
				<div class="item">
					<p>${ncc.maNhaCungCap} </p> <br />
					<p>${ncc.tenNhaCungCap}</p> <br />
					<p>${ncc.diaChi}</p> <br />
					<p>${ncc.soDienThoai}</p> <br />
				</div>
			</c:forEach>
		</div>
		<p>List Item</p>
		<div>
		<c:forEach items="${listDienThoai}" var="phone">
				<div class="item">
					<p>${phone.maDienThoai} </p> <br />
					<p>${phone.tenDienThoai}</p> <br />
					<p>${phone.namSanXuat}</p> <br />
					<p>${phone.cauHinh}</p> <br />
					<img src="${pageContext.request.contextPath}/assets/${phone.hinhanh}" alt="dienThoai">
				</div>
			</c:forEach></div>
	</div>
</body>
</html>

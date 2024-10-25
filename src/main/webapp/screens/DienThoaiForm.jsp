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
	
}
</style>
</head>
<body>
	<div class="container">
		<form method="post" action="DienThoaiFormServlet" enctype="multipart/form-data">
			<p>Nhap thong tin muon them dien thoai</p>
			<label for="id">mã dien thoai</label>
			<input type="text" id="id" name="id" required />
			<br>
			<label for="name">ten dien thoai</label>
			<input type="text" id="name" name="name" required />
			<br>
			<label for="yearRelease">Năm sản xuất</label>
			<input type="text" id="yearRelease" name="yearRelease" pattern="^[0-9]{4}$" required/>
			<br>
			<label for="info">thong tin cấu hình</label>
			<input type="text" id="info" name="info" pattern="^.{0,255}$" required />
			<br>
			<label for="maNcc">nha cung cap</label>
			<select name = "maNcc">
				<c:forEach items = "${listNCC}" var="ncc">
					<option value="${ncc.maNhaCungCap}">${ncc.tenNhaCungCap}</option>
				</c:forEach>
			</select>
			<br>
			<label for="img">Hình ảnh</label>
			<input type = "file" id="img" name="img" accept=".png, .jpg, .jpeg" required/>
			<br>
			<input type="submit" value="Thêm" />
		</form>
		
	</div>
</body>
</html>
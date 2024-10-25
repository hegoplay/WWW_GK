<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <style>
      .header {
        background-color: #fff;
        text-align: center;
        min-height: 95vh;
      }
      .footer {
        background-color: #fff;
        justify-content: center;
        align-items: center;
        max-height: 5vh;

        width: auto;
        display: flex;
      }
      .border_basic {
        border: 1px solid black;
      }
      .image {
        width: 100%;
        height: 20vh;
      }
      .nav{
        display: flex;
        justify-content: center;
        align-items: center;
        background-color: #fff;
        gap: 4px;
        flex-direction: row;
      }
    </style>
  </head>
  <body>
    <div class="header">
      <img class="image" alt="theme image" src="${pageContext.request.contextPath}/assets/theme.jpeg" />
      <div class="border_basic nav">
        <a href="DanhSachDienThoaiNCCServlet">Danh sách sản phẩm</a>
        <span> | </span>
        <a href="DienThoaiFormServlet">Thêm sản phẩm</a>
        <span> | </span>
        <a href="QuanLyFormServlet">Chức năng quản lý</a>
      </div>
    </div>
    <div class="footer border_basic">
      <p>Phạm Thế Mạnh - 21086121 - DHKTPM17ATT</p>
    </div>
  </body>
</html>

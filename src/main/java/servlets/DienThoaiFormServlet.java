package servlets;

import java.io.IOException;

import dao.NhaCungCapDAO;
import daoImpl.DienThoaiDAOImpl;
import daoImpl.NhaCungCapDAOImpl;
import entities.DienThoai;
import entities.NhaCungCap;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class DienThoaiFormServlet
 */
@MultipartConfig(maxFileSize = 16177215, maxRequestSize = 16177215)
public class DienThoaiFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	private String uploadPath;
	public DienThoaiFormServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		uploadPath = getServletContext().getRealPath("/assets");
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAOImpl();

		request.setAttribute("listNCC", nhaCungCapDAO.getAll());
		request.getRequestDispatcher("/screens/DienThoaiForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = (String) request.getParameter("id");
		String ten = (String) request.getParameter("name");
		int nam = Integer.parseInt((String) request.getParameter("yearRelease"));
		String info = (String) request.getParameter("info");
		String maNCC = (String) request.getParameter("maNcc");
		NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAOImpl();
		NhaCungCap ncc = nhaCungCapDAO.findById(maNCC);
		Part imgPart = request.getPart("img");
		String fileName = imgPart.getSubmittedFileName();
		String filePath = uploadPath + "\\" + fileName;
		imgPart.write(filePath);
		System.out.println(filePath);
		DienThoai dt = new DienThoai(id, ten, nam, info, ncc, fileName);
		DienThoaiDAOImpl dienThoaiDAO = new DienThoaiDAOImpl();
		dienThoaiDAO.insert(dt);
		response.sendRedirect( request.getContextPath() +"/DanhSachDienThoaiNCCServlet");
	}

}

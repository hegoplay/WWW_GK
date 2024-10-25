package servlets;

import java.io.IOException;

import dao.DienThoaiDAO;
import daoImpl.DienThoaiDAOImpl;
import entities.DienThoai;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuanLyFormServlet
 */
public class QuanLyFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLyFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DienThoaiDAO dienThoaiDAO = new DienThoaiDAOImpl();
		request.setAttribute("list", dienThoaiDAO.getAll());
		request.getRequestDispatcher("/screens/QuanLyForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String maDT = request.getParameter("maDienThoai");
		
		DienThoaiDAO dienThoaiDAO = new DienThoaiDAOImpl();
		DienThoai dt = dienThoaiDAO.findById(maDT);
		dienThoaiDAO.delete(dt);
		doGet(request, response);
	}

}

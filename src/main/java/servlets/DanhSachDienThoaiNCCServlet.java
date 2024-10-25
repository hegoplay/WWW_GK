package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.DienThoaiDAO;
import dao.NhaCungCapDAO;
import daoImpl.DienThoaiDAOImpl;
import daoImpl.NhaCungCapDAOImpl;
import entities.DienThoai;
import entities.NhaCungCap;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DanhSachDienThoaiNCCServlet
 */
public class DanhSachDienThoaiNCCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<NhaCungCap> listNCC = new ArrayList<NhaCungCap>();
	List<DienThoai> listDienThoai = new ArrayList<DienThoai>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachDienThoaiNCCServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAOImpl();
		listNCC = nhaCungCapDAO.getAll();
		request.setAttribute("listNCC", listNCC);
		DienThoaiDAO dienThoaiDAO = new DienThoaiDAOImpl();
		listDienThoai = dienThoaiDAO.getAll();
		for (DienThoai dt : listDienThoai) {
			System.out.println(dt);
		}
		request.setAttribute("listDienThoai", listDienThoai);
		request.getRequestDispatcher("/screens/DanhSachDienThoaiNCC.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAOImpl();
		DienThoaiDAO dienThoaiDAO = new DienThoaiDAOImpl();
		switch (type) {
		case "maNCC":
			String maNCC = request.getParameter("maNCC");
			NhaCungCap nhaCungCap = nhaCungCapDAO.findById(maNCC);
			if (nhaCungCap != null) {
				listNCC = new ArrayList<NhaCungCap>();
				listNCC.add(nhaCungCap);
			}
			else {
				listNCC = new ArrayList<NhaCungCap>();
			}
			break;
			
		case "tenNCC":
			String tenNCC = request.getParameter("tenNCC");
			listNCC = nhaCungCapDAO.getByName(tenNCC);
			break;
		case "diaChi":
			String diaChi = request.getParameter("diaChi");
			listNCC = nhaCungCapDAO.getByDiaChi(diaChi);
			break;
		case "SDT":
		    String sdt = request.getParameter("SDT");
            listNCC = nhaCungCapDAO.getBySDT(sdt);
            break;
		case "findPhone":
			String maNCC1 = request.getParameter("mNCC");
			NhaCungCap nhaCungCap1 = nhaCungCapDAO.findById(maNCC1);
			listDienThoai= dienThoaiDAO.getByNhaCungCap(nhaCungCap1);
			break;
		}
		request.setAttribute("listNCC", listNCC);
		request.setAttribute("listDienThoai", listDienThoai);
		request.getRequestDispatcher("/screens/DanhSachDienThoaiNCC.jsp").forward(request, response);
	}

}

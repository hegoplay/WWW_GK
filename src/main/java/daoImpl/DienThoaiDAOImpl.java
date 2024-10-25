package daoImpl;

import java.util.List;

import connectDB.ConnectDB;
import dao.CrudDAO;
import dao.DienThoaiDAO;
import entities.DienThoai;
import entities.NhaCungCap;

public class DienThoaiDAOImpl implements DienThoaiDAO {

	ConnectDB connectDB = ConnectDB.instance;

	@Override
	public void insert(DienThoai obj) {
		// TODO Auto-generated method stub
		try {

			connectDB.manager.getTransaction().begin();
			connectDB.manager.persist(obj);
			connectDB.manager.getTransaction().commit();
		} catch (Exception e) {
			connectDB.manager.getTransaction().rollback();
		}

	}

	@Override
	public void update(DienThoai obj) {
		// TODO Auto-generated method stub
		try {

			connectDB.manager.getTransaction().begin();
			connectDB.manager.merge(obj);
			connectDB.manager.getTransaction().commit();
		} catch (Exception e) {
			connectDB.manager.getTransaction().rollback();
		}
	}

	@Override
	public void delete(DienThoai obj) {
		// TODO Auto-generated method stub
		try {

			connectDB.manager.getTransaction().begin();
			connectDB.manager.remove(obj);
			connectDB.manager.getTransaction().commit();
		} catch (Exception e) {
			connectDB.manager.getTransaction().rollback();
		}
	}

	@Override
	public DienThoai findById(String id) {
		// TODO Auto-generated method stub
		return connectDB.manager.find(DienThoai.class, id);	
	}

	@Override
	public List<DienThoai> getAll() {
		// TODO Auto-generated method stub
		return connectDB.manager.createQuery("from DienThoai", DienThoai.class).getResultList()	;
	}

	@Override
	public List<DienThoai> getByNhaCungCap(String maNhaCungCap) {
		// TODO Auto-generated method stub
		NhaCungCap nhaCungCap = new NhaCungCap(maNhaCungCap);	
		return connectDB.manager.createQuery("from DienThoai where maNhaCungCap = :maNhaCungCap", DienThoai.class)
                .setParameter("maNhaCungCap", nhaCungCap).getResultList();
	}

	@Override
	public List<DienThoai> getByNhaCungCap(NhaCungCap nhaCungCap) {
		// TODO Auto-generated method stub
		return connectDB.manager.createQuery("from DienThoai where nhaCungCap = :nhaCungCap", DienThoai.class)
                .setParameter("nhaCungCap", nhaCungCap).getResultList();
	}

}

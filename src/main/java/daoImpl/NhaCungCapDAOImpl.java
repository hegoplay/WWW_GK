package daoImpl;

import java.util.List;

import connectDB.ConnectDB;
import dao.CrudDAO;
import dao.NhaCungCapDAO;
import entities.NhaCungCap;

public class NhaCungCapDAOImpl implements  NhaCungCapDAO {

	ConnectDB connectDB = ConnectDB.instance;

	@Override
	public void insert(NhaCungCap obj) {
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
	public void update(NhaCungCap obj) {
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
	public void delete(NhaCungCap obj) {
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
	public NhaCungCap findById(String id) {
		// TODO Auto-generated method stub
		return connectDB.manager.find(NhaCungCap.class, id);
	}

	@Override
	public List<NhaCungCap> getAll() {
		// TODO Auto-generated method stub
		return connectDB.manager.createQuery("from NhaCungCap", NhaCungCap.class).getResultList();
	}

	@Override
	public List<NhaCungCap> getByName(String name) {
		// TODO Auto-generated method stub
		return connectDB.manager.createQuery("from NhaCungCap where tenNhaCungCap like :name", NhaCungCap.class)
				.setParameter("name", "%" + name +  "%" ).getResultList();
	}

	@Override
	public List<NhaCungCap> getByDiaChi(String diaChi) {
		// TODO Auto-generated method stub
		return  connectDB.manager.createQuery("from NhaCungCap where diaChi like :name", NhaCungCap.class)
				.setParameter("name", "%" + diaChi+ "%").getResultList();
	}

	@Override
	public List<NhaCungCap> getBySDT(String sdt) {
		// TODO Auto-generated method stub
		return connectDB.manager.createQuery("from NhaCungCap where soDienThoai like :name", NhaCungCap.class)
                .setParameter("name", "%" + sdt + "%").getResultList();
	}


}

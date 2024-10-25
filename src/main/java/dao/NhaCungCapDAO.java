package dao;

import java.util.List;

import entities.DienThoai;
import entities.NhaCungCap;

public interface NhaCungCapDAO extends CrudDAO<NhaCungCap, String> {
	public List<NhaCungCap> getByName(String name);
	public List<NhaCungCap> getByDiaChi(String diaChi);
	public List<NhaCungCap> getBySDT(String sdt);
	
}

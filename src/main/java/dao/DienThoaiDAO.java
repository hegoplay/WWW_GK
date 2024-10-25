package dao;

import java.util.List;

import entities.DienThoai;
import entities.NhaCungCap;

public interface DienThoaiDAO extends CrudDAO<DienThoai, String> {
	public List<DienThoai> getByNhaCungCap(String maNhaCungCap);
	public List<DienThoai> getByNhaCungCap(NhaCungCap nhaCungCap);
}

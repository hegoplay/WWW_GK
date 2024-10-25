package entities;

import jakarta.persistence.ManyToOne;

@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "DIENTHOAI")
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class DienThoai {
	@jakarta.persistence.Id
	@jakarta.persistence.Column(name = "MADT")
	private String maDienThoai;
	@jakarta.persistence.Column(name = "TENDT")
	private String tenDienThoai;
	@jakarta.persistence.Column(name = "NAMSANXUAT")
	private int namSanXuat;
	@jakarta.persistence.Column(name = "CAUHINH")
	private String cauHinh;
	@ManyToOne
	@jakarta.persistence.JoinColumn(name = "MANCC")
	private NhaCungCap nhaCungCap;
	@jakarta.persistence.Column(name = "HINHANH")
	private String hinhanh;
}

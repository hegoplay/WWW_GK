package entities;

import java.util.Set;

@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "NHACUNGCAP")
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(callSuper = false)
public class NhaCungCap {
	@jakarta.persistence.Id
	@jakarta.persistence.Column(name = "MANCC")
	@lombok.EqualsAndHashCode.Include
	private String maNhaCungCap;
	@jakarta.persistence.Column(name = "TENNHACC")
	private String tenNhaCungCap;
	@jakarta.persistence.Column(name = "DIACHI")
	private String diaChi;
	@jakarta.persistence.Column(name = "SODIENTHOAI")
	private String soDienThoai;
	@jakarta.persistence.OneToMany(mappedBy = "nhaCungCap")
	private Set<DienThoai> dsDienThoai;
	public NhaCungCap(String maNhaCungCap) {
		super();
		this.maNhaCungCap = maNhaCungCap;
	}
	
}

package spring.model.bean;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class Information {
	private int id;

	@NotBlank
	private String name;
	@NotBlank
	private String ngaysinh;
	@Email
	private String email;
	@NotBlank
	private String diachi;
	@NotBlank
	private String sdt;
	@NotBlank
	private String noidung;
	private int trangthai;

	public String getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	public Information(int id, String name, String ngaysinh, String email, String diachi, String sdt, String noidung,
			int trangthai) {
		super();
		this.id = id;
		this.name = name;
		this.ngaysinh = ngaysinh;
		this.email = email;
		this.diachi = diachi;
		this.sdt = sdt;
		this.noidung = noidung;
		this.trangthai = trangthai;
	}

	public Information() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Information(int id, String name, String ngaysinh, String email, String diachi, String sdt, String noidung) {
		super();
		this.id = id;
		this.name = name;
		this.ngaysinh = ngaysinh;
		this.email = email;
		this.diachi = diachi;
		this.sdt = sdt;
		this.noidung = noidung;
	}

}

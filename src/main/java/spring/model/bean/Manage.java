package spring.model.bean;

import javax.validation.constraints.NotBlank;

public class Manage {
	private int id;
	@NotBlank
	private String ten;
	@NotBlank
	private String thoigian;
	@NotBlank
	private String phanloai;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getThoigian() {
		return thoigian;
	}

	public void setThoigian(String thoigian) {
		this.thoigian = thoigian;
	}

	public String getPhanloai() {
		return phanloai;
	}

	public void setPhanloai(String phanloai) {
		this.phanloai = phanloai;
	}

	public Manage(int id, String ten, String thoigian, String phanloai) {
		super();
		this.id = id;
		this.ten = ten;
		this.thoigian = thoigian;
		this.phanloai = phanloai;
	}

	public Manage() {
		super();
	}

}

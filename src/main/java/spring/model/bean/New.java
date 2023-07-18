package spring.model.bean;

import javax.validation.constraints.NotBlank;

public class New {
	private int id_tin;
	@NotBlank
	private String tentin;
	private Category category;
	private String hinhanh;
	private int trangthai;
	private int cout;
	@NotBlank
	private String noidung;
	
	public int getId_tin() {
		return id_tin;
	}
	public void setId_tin(int id_tin) {
		this.id_tin = id_tin;
	}
	public String getTentin() {
		return tentin;
	}
	public void setTentin(String tentin) {
		this.tentin = tentin;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getHinhanh() {
		return hinhanh;
	}
	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}
	public int getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}
	public int getCout() {
		return cout;
	}
	public void setCout(int cout) {
		this.cout = cout;
	}
	public String getNoidung() {
		return noidung;
	}
	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}
	public New(int id_tin, String tentin, Category category, String hinhanh, int trangthai, int cout, String noidung) {
		super();
		this.id_tin = id_tin;
		this.tentin = tentin;
		this.category = category;
		this.hinhanh = hinhanh;
		this.trangthai = trangthai;
		this.cout = cout;
		this.noidung = noidung;
	}
	public New() {
		super();
	}
	public New(int id_tin, String tentin) {
		super();
		this.id_tin = id_tin;
		this.tentin = tentin;
	}
	
	
	

	
	
	
	

}

package spring.model.bean;

public class Contact {
	private int id;
	private String name;
	private String email;
	private String diachi;
	private String sdt;
	private String noidung;
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
	public void setSđt(String sdt) {
		this.sdt = sdt;
	}
	public String getNoidung() {
		return noidung;
	}
	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}
	public Contact(int id, String name, String email, String diachi, String sdt, String noidung) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.diachi = diachi;
		this.sdt = sdt;
		this.noidung = noidung;
	}
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

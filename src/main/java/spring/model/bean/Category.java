package spring.model.bean;

import javax.validation.constraints.NotBlank;

public class Category {
	private int id;
	
	@NotBlank
	private String tendanhmuc;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTendanhmuc() {
		return tendanhmuc;
	}
	public void setTendanhmuc(String tendanhmuc) {
		this.tendanhmuc = tendanhmuc;
	}
	public Category(int id, String tendanhmuc) {
		super();
		this.id = id;
		this.tendanhmuc = tendanhmuc;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

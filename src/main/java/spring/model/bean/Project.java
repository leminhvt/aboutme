package spring.model.bean;

import javax.validation.constraints.NotBlank;

public class Project {
	private int id;
	@NotBlank
	private String tenduan;
	@NotBlank
	private String link;
	private String hinhanh;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenduan() {
		return tenduan;
	}

	public void setTenduan(String tenduan) {
		this.tenduan = tenduan;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public Project(int id, String tenduan, String link, String hinhanh) {
		super();
		this.id = id;
		this.tenduan = tenduan;
		this.link = link;
		this.hinhanh = hinhanh;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

}

package spring.model.bean;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Skill {
	private int id;
	@NotBlank
	private String tenkynang;
	private int giatri;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenkynang() {
		return tenkynang;
	}

	public void setTenkynang(String tenkynang) {
		this.tenkynang = tenkynang;
	}

	public int getGiatri() {
		return giatri;
	}

	public void setGiatri(int giatri) {
		this.giatri = giatri;
	}

	public Skill(int id, String tenkynang, int giatri) {
		super();
		this.id = id;
		this.tenkynang = tenkynang;
		this.giatri = giatri;
	}

	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}

}

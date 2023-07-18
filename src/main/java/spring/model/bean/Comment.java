package spring.model.bean;

import java.sql.Timestamp;

public class Comment {
	private int id_cmt;
	private New news;
	private String noidung;
	private Timestamp ngayBL;
	private String user;
	
	
	public String getUser() {
		return user;
	}
	public void setUsername(String user) {
		this.user = user;
	}
	public Timestamp getNgayBL() {
		return ngayBL;
	}
	public void setNgayBL(Timestamp ngayBL) {
		this.ngayBL = ngayBL;
	}
	public int getId_cmt() {
		return id_cmt;
	}
	public void setId_cmt(int id_cmt) {
		this.id_cmt = id_cmt;
	}
	public New getNews() {
		return news;
	}
	public void setNews(New news) {
		this.news = news;
	}
	public String getNoidung() {
		return noidung;
	}
	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(int id_cmt, New news,String noidung) {
		super();
		this.id_cmt = id_cmt;
		this.news = news;
		this.noidung = noidung;
	}
	public Comment(int id_cmt, New news, String noidung, Timestamp ngayBL, String user) {
		super();
		this.id_cmt = id_cmt;
		this.news = news;
		this.noidung = noidung;
		this.ngayBL = ngayBL;
		this.user = user;
	}
	
	
	
	
	
	
	

}

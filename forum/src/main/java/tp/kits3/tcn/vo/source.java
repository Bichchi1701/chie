package tp.kits3.tcn.vo;

import java.sql.Timestamp;

public class source {
	private int sourceid;
	private Timestamp date;
	private String sourcename;
	private String size;
	private String contentdetails;
	private String title;
	private int userid;
	private int ctgid;
	private double price;
	private String avatar;
	private int stateid;
	public source() {
		super();
	}
	public source(Timestamp date, String sourcename, String size, String contentdetails, String title,
			int userid, int ctgid, double price, String avatar, int stateid) {
		super();
	
		this.date = date;
		this.sourcename = sourcename;
		this.size = size;
		this.contentdetails = contentdetails;
		this.title = title;
		this.userid = userid;
		this.ctgid = ctgid;
		this.price = price;
		this.avatar = avatar;
		this.stateid = stateid;
	}
	public int getSourceid() {
		return sourceid;
	}
	public void setSourceid(int sourceid) {
		this.sourceid = sourceid;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getSourcename() {
		return sourcename;
	}
	public void setSourcename(String sourcename) {
		this.sourcename = sourcename;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getContentdetails() {
		return contentdetails;
	}
	public void setContentdetails(String contentdetails) {
		this.contentdetails = contentdetails;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getCtgid() {
		return ctgid;
	}
	public void setCtgid(int ctgid) {
		this.ctgid = ctgid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public int getStateid() {
		return stateid;
	}
	public void setStateid(int stateid) {
		this.stateid = stateid;
	}
	

}

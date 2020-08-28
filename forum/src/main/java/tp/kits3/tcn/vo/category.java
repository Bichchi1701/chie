package tp.kits3.tcn.vo;

public class category {
	private int ctgid;
	private String ctgname ;
	private String ctgdate;
	private int parentid;
	public category() {
		super();
	}
	public category(String ctgname) {
		super();
	
		this.ctgname = ctgname;
		
	}
	public int getCtgid() {
		return ctgid;
	}
	public void setCtgid(int ctgid) {
		this.ctgid = ctgid;
	}
	public String getCtgname() {
		return ctgname;
	}
	public void setCtgname(String ctgname) {
		this.ctgname = ctgname;
	}
	public String getCtgdate() {
		return ctgdate;
	}
	public void setCtgdate(String ctgdate) {
		this.ctgdate = ctgdate;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	


}

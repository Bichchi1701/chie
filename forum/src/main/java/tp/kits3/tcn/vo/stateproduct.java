package tp.kits3.tcn.vo;

public class stateproduct {
	private int stateid ;
	private String statename;
	public stateproduct() {
		super();
	}
	public stateproduct(int stateid, String statename) {
		super();
		this.stateid = stateid;
		this.statename = statename;
	}
	public int getStateid() {
		return stateid;
	}
	public void setStateid(int stateid) {
		this.stateid = stateid;
	}
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
	
	

}

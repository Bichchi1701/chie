package tp.kits3.tcn.vo;

public class user {
	private int userid;
	private String username;
	private String password;
	private String fullname;
	private String email;
	private int roleid;
	private String status;
	private String avatar;
	private String token;
	private double money;
	public user() {
		super();
	}
	public user(int userid, String username, String password, String fullname, String email, int roleid, String status,
			String avatar, String token, double money) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.roleid = roleid;
		this.status = status;
		this.avatar = avatar;
		this.token = token;
		this.money = money;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
	
	
	

}

package entity;

public class Users {
	private	int AdminID;
	private String AdminName;
	private String AdminPwd;
	private String AdminType;
	private String LastLoginTime;
	
	public Users() {
		
	}
	public int getAdminID() {
		return AdminID;
	}
	public void setAdminID(int adminID) {
		AdminID = adminID;
	}
	public String getAdminName() {
		return AdminName;
	}
	public void setAdminName(String adminName) {
		AdminName = adminName;
	}
	public String getAdminPwd() {
		return AdminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		AdminPwd = adminPwd;
	}
	public String getAdminType() {
		return AdminType;
	}
	public void setAdminType(String adminType) {
		AdminType = adminType;
	}
	public String getLastLoginTime() {
		return LastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		LastLoginTime = lastLoginTime;
	}
	
	
}

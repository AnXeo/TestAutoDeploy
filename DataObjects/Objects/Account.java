package Objects;

import Common.Utilities;

public class Account {
	private String email;
	private String password;
	private String cfrPassword;
	private String pid;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCfrPassword() {
		return cfrPassword;
	}

	public void setCfrPassword(String cfrPassword) {
		this.cfrPassword = cfrPassword;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	

	public Account() {
		super();
	}

	public void initRandomAccount() {
		String radom = Integer.toString(Utilities.randBetween(10000000, 90000000));
		this.email = "email" + radom + "@gmail.com";
		this.password = "pass" + radom;
		this.cfrPassword = this.password;
		this.pid = Integer.toString(Utilities.randBetween(10001000, 20001000));
	}

}

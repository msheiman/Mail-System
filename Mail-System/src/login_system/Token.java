package login_system;

public class Token {

	private String user;
	private String pword;

	Token(String username, String password) {
		this.user = username;
		this.pword = password;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}
}

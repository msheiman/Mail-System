package login_system;

public class Token {

	private String user;
	private String pword;

	/**
	 * Method name: Token()
	 * Heading: Token(String username, String password) 
	 * Description: to create the constructor of Token
	 * Parameters: String username, String password
	 * Precondition: the contructor is called
	 * Postcondition: creates the constructor
	 * Throws list: N/A
	 */
	public Token(String username, String password) {
		this.user = username;
		this.pword = password;
	}

	/**
	 * Method name: getUser()
	 * Heading: public String getUser() 
	 * Description: to returns user
	 * Parameters: none
	 * Precondition: is called
	 * Postcondition: returns user
	 * Throws list: N/A
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Method name: setUser()
	 * Heading: public void setUser(String user)
	 * Description: to sets user
	 * Parameters: String user
	 * Precondition: is called
	 * Postcondition: sets user to this.user
	 * Throws list: N/A
	 */	
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Method name: getPword()
	 * Heading: public String getPword() 
	 * Description: to return pword
	 * Parameters: none
	 * Precondition: is called
	 * Postcondition: return pword
	 * Throws list: N/A
	 */
	public String getPword() {
		return pword;
	}
	
	/**
	 * Method name: setPword()
	 * Heading: public void setPword(String pword) 
	 * Description: to set pword
	 * Parameters: String pword
	 * Precondition: is called
	 * Postcondition: sets pword to this.pword
	 * Throws list: N/A
	 */
	public void setPword(String pword) {
		this.pword = pword;
	}
}

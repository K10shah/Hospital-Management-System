package common;
import java.util.*;

public class Login {

	private Hashtable<String, String> loginData = new Hashtable<String, String>();

	//getter for loginData
	public Hashtable<String, String> getLoginData()
	{
		return this.loginData;
	}
	public Login()
	{
		//Default admin user so that atleast the admin can login
		//This is only for the demo purpose
		loginData.put("admin", "admin");
	}


	//Function for adding new user
	public void addNewUser(String username, String pwd)
	{
		loginData.put(username, pwd);
	}


	//To verify is the user exists and the to validate the password if user exists
	//@Requires("!username.isNullOrEmpty()" && "!pwd.isNullOrEmpty()" && "loginData!=null")s
	public Boolean loginVerify(String username, String pwd)
	{
		if(loginData.containsKey(username))
		{
			String check = loginData.get(username).toString();
			if(check.equals(pwd))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
}

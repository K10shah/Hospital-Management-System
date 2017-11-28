import java.util.*;

public class Login {
	
	Hashtable loginData = new Hashtable();
	
	Login()
	{
		loginData.put("admin", "admin");
	}

	public void addNewUser(String username, String pwd)
	{
		loginData.put(username, pwd);
	}
	
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

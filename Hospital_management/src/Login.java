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
}

package common;
import java.util.*;

public class Login {

	//Usernames and passwords
	private Hashtable<String, String> loginData = new Hashtable<String, String>();

	//list of all the users of the system mapping to their roles(doctors, admin, patient, etc)
	public static Hashtable<String, String> users = new Hashtable<String, String>();

	//list of doctors
	public static Hashtable<String, Doctor> doctors = new Hashtable<String, Doctor>();

	//list of patients
	public static Hashtable<String, Patient> patients = new Hashtable<String, Patient>();

	//list of receptionists
	public static Hashtable<String, Receptionist> receps= new Hashtable<String, Receptionist>();


	//getter for loginData
	public Hashtable<String, String> getLoginData()
	{
		return this.loginData;
	}
	
	public String getRole(String username)
	{
		return users.get(username);
	}
	
	public Login()
	{
		//Default admin user so that atleast the admin can login
		//This is only for the demo purpose
		loginData.put("admin", "admin");
		users.put("admin","admin");
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

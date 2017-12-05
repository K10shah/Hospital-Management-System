package common;
import java.util.*;

public class Login {

	//Usernames and passwords
	private Hashtable<String, String> loginData = new Hashtable<String, String>();

	//list of all the users of the system mapping to their roles(doctors, admin, patient, etc)
	private static Hashtable<String, String> users = new Hashtable<String, String>();

	//list of doctors
	private static Hashtable<String, Doctor> doctors = new Hashtable<String, Doctor>();

	//list of patients
	private static Hashtable<String, Patient> patients = new Hashtable<String, Patient>();

	//list of receptionists
	private static Hashtable<String, Receptionist> receps= new Hashtable<String, Receptionist>();


	//getter for loginData
	public Hashtable<String, String> getLoginData()
	{
		return this.loginData;
	}

	public Hashtable<String, String> getUsers()
	{
		return this.users;
	}

	public Hashtable<String, Doctor> getDoctors()
	{
		return this.doctors;
	}

	public Hashtable<String, Patient> getPatients()
	{
		return this.patients;
	}

	public Hashtable<String, Receptionist> getRecep()
	{
		return this.receps;
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
	public void addNewUser(String username, String name, String pwd, String role)
	{
		loginData.put(username, pwd);
		users.put(username, role);
		if(role.equals("doctor"))
		{
			doctors.put(username, new Doctor(username, name));
		}
		else if(role.equals("recep"))
		{
			receps.put(username, new Receptionist(username, name));
		}
		else if(role.equals("patient"))
		{
			patients.put(username, new Patient(username, name));
		}
	}


	//Function for deleting the user from the system
	public void deleteUser(String username)
	{
		String role = users.get(username);
		loginData.remove(username);
		users.remove(username);
		if(role.equals("patient"))
		{
			patients.remove(username);
		}
		else if(role.equals("doctor"))
		{
			doctors.remove(username);
		}
		else if(role.equals("recep"))
		{
			receps.remove(username);
		}
	}

	//To verify is the user exists and the to validate the password if user exists
	//@Requires("!username.isNullOrEmpty()" && "!pwd.isNullOrEmpty()" && "loginData!=null")s
	public Boolean loginVerify(String username, char[] pwd)
	{
		if(loginData.containsKey(username))
		{
			char[] check = loginData.get(username).toCharArray();
			if(Arrays.equals(check,pwd))
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

	public Boolean verifyUserName(String username)
	{
		if(loginData.containsKey(username))
		{
			return false;
		}
		else
		{
			if(username.length() < 8)
			{
				return false;
			}
			else if(username.contains(" "))  
			{
				return false;
			}
			else
			{
				return true;
			}
		}
	}

	public Boolean verifyName(String name)
	{
		if(name.length() == 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public Boolean verifyPassword(String pwd)
	{
		if(pwd.length() < 4)
		{
			return false;
		}
		else if(pwd.contains(" "))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}

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

	//list of cashier
	private static Hashtable<String, Cashier> cashier= new Hashtable<String, Cashier>();

	//list of nurse
	private static Hashtable<String, Nurse> nurse= new Hashtable<String, Nurse>();

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
	
	
	public Hashtable<String, Cashier> getCashier()
	{
		return this.cashier;
	}
	
	public Hashtable<String, Nurse> getNurse()
	{
		return this.nurse;
	}
	
	public String getRole(String username)
	{
		return users.get(username);
	}

	public Login()
	{
		//Default admin user so that atleast the admin can login
		//This is only for the demo purpose
		loginData.put("admin123", "password");
		users.put("admin123","admin");
		
		//some default data entry for verification
		loginData.put("patient123", "password");
		loginData.put("doctor123", "password");
		loginData.put("nurse123", "password");
		loginData.put("cashier123", "password");
		loginData.put("recep123", "password");
		
		users.put("patient123", "patient");
		users.put("doctor123", "doctor");
		users.put("nurse123", "nurse");
		users.put("cashier123", "cash");
		users.put("recep123", "recep");
		
		patients.put("patient123", new Patient("patient123", "pat"));
		doctors.put("doctor123", new Doctor("doctor123", "doc"));
		nurse.put("nurse123", new Nurse("nurse123", "nur"));
		cashier.put("cashier123", new Cashier("cashier123", "cas"));
		receps.put("recep123", new Receptionist("recep123", "rec"));
		
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
		else if(role.equals("cash"))
		{
			cashier.put(username, new Cashier(username, name));
		}
		else if(role.equals("nurse"))
		{
			nurse.put(username, new Nurse(username, name));
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
		else if(role.equals("nurse"))
		{
			nurse.remove(username);
		}
		else if(role.equals("cashier"))
		{
			cashier.remove(username);
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

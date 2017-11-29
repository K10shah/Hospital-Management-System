import java.util.*;
import java.io.*;
public class MainSystem {


	public static Login loginInfo = new Login();

	//list of all the users of the system mapping to their roles(doctors, admin, patient, etc)
	public static Hashtable<String, String> users = new Hashtable<String, String>();

	//list of doctors
	public static Hashtable<String, Doctor> doctors = new Hashtable<String, Doctor>();

	//list of patients
	public static Hashtable<String, Patient> patients = new Hashtable<String, Patient>();

	//list of receptionists
	public static Hashtable<String, Receptionist> receps= new Hashtable<String, Receptionist>();

	public static void main(String[] args) 
	{

		Scanner scanf = new Scanner(System.in);
		String username = "";
		String pwd = "";



		users.put("admin", "admin");

		while(true)
		{
			System.out.println("------------------------\nEnter username to login");
			username = scanf.nextLine();
			System.out.println("Enter the password");
			pwd = scanf.nextLine();

			//Verifying if the credentials are proper or not
			if(loginInfo.loginVerify(username, pwd))
			{
				String role = users.get(username).toString();
				if(role.equals("admin"))
				{
					ShowAdminOptions();
				}
				if(role.equals("patient"))
				{
					ShowPatientOptions(username);
				}
				if(role.equals("doctor"))
				{
					ShowDoctorOptions(username);
				}
				if(role.equals("recep"))
				{
					ShowReceptionistOptions();
				}
			}
		}
	}

	//Options for the receptionist	
	public static void ShowReceptionistOptions()
	{
		Scanner scanf = new Scanner(System.in);
		int choice = 0;
		while(true)
		{
			System.out.println("\nPlease choose from the following actions to perform:");
			System.out.println("1. Add patient\n"
					+"2. Logout");

			//Taking input from the admin user for action to perform
			try
			{
				choice = scanf.nextInt();
			}
			catch(NumberFormatException e)
			{
				//just in case someone enters something weird 
				System.out.println("-----------Invalid choice-----------");
				continue;
			}

			switch(choice)
			{
			case 1:
			{
				ShowAddPatientMenu();
				continue;
			}
			case 2: 
			{
				return;
			}
			}
		}
	}


	//Options for the doctor
	public static void ShowDoctorOptions(String username)
	{
		Scanner scanf = new Scanner(System.in);
		int choice = 0;
		Doctor d1 = doctors.get(username);

		while(true)
		{
			System.out.println("Hello Dr. " + d1.getName() +  " Enter the action to perform " 
					+ "\n1. View patient record history"
					+ "\n2. Update patient record"
					+ "\n3. Logout");

			try
			{
				choice = Integer.parseInt(scanf.nextLine());
			}
			catch(NumberFormatException e)
			{
				//just in case someone enters something weird 
				System.out.println("-----------Invalid choice-----------");
				continue;
			}

			String pUsername = "";
			switch(choice)
			{
			case 1:
			{
				try
				{
					System.out.println("Enter the patient username: ");
					pUsername = scanf.nextLine();
					if(patients.containsKey(pUsername))
					{
						Patient patient = patients.get(pUsername);
						patient.ViewRecords();
						continue;
					}
				}
				catch(Exception e)
				{
					System.out.println("Invalid input");
					continue;
				}
			}
			case 2:
			{
				System.out.println("Enter the patient username: ");

				try
				{
					pUsername = scanf.nextLine();
					if(patients.containsKey(pUsername))
					{
						d1.TreatPatient(patients.get(pUsername));
					}
					continue;
				}
				catch(Exception e)
				{
					System.out.println("Invalid input");
				}
			}
			case 3:
			{
				return;
			}
			default:
			{
				System.out.println("---------Invalid choice--------");
				continue;
			}
			}
		}

	}

	//Options for the patients to perform
	public static void ShowPatientOptions(String username)
	{
		Scanner scanf = new Scanner(System.in);
		int choice = 0;
		Patient p1 = patients.get(username);

		while(true)
		{
			System.out.println("Hello " + p1.getName() + " Enter the action to perform " 
					+ "\n1. View record history"
					+ "\n2. View account balance"
					+ "\n3. Logout");

			try
			{
				choice = scanf.nextInt();
			}
			catch(NumberFormatException e)
			{
				//just in case someone enters something weird 
				System.out.println("-----------Invalid choice-----------");
				continue;
			}

			switch(choice)
			{
			case 1:
			{
				p1.ViewRecords();
				continue;
			}
			case 2:
			{
				p1.ViewAccount();
				continue;
			}
			case 3:
			{
				return;
			}
			default:
			{
				System.out.println("---------Invalid choice--------");
				continue;
			}
			}
		}
	}

	//Options for the admin
	public static void ShowAdminOptions()
	{
		Scanner scanf = new Scanner(System.in);
		int choice = 0;
		while(true)
		{
			System.out.println("\nPlease choose from the following actions to perform:");
			System.out.println("1. Add user\n"
					+"2. Delete user\n"
					+"3. Log out");

			//Taking input from the admin user for action to perform
			try
			{
				choice = scanf.nextInt();
			}
			catch(NumberFormatException e)
			{
				//just in case someone enters something weird 
				System.out.println("-----------Invalid choice-----------");
				continue;
			}

			switch(choice)
			{
			case 1:
			{
				ShowAddUserOptions();
				continue;
			}
			case 2:
			{
				ShowDeleteUserOptions();
			}
			case 3:
			{
				return;
			}
			default:
			{
				System.out.println("---------Invalid choice--------");
				continue;
			}
			}
		}

	}

	//---------------------------------------------------------------------------------------------------
	//Add user menu for the admin
	public static void ShowAddUserOptions()
	{
		Scanner scanf = new Scanner(System.in);
		int userchoice = 0;
		Boolean exitFlag = false;
		while(true)
		{
			System.out.println("Choose what type of user you want to add" + "\n1. Doctor" + 
					"\n2. Receptionist" +
					"\n3. Admin" +
					"\n4. Return to previous menu");
			try
			{
				userchoice = scanf.nextInt();
			}
			catch(NumberFormatException e)
			{
				//Just in case someone enters something weird 
				System.out.println("-----------Invalid choice-----------");
				continue;
			}
			switch(userchoice)
			{
			case 1:
			{
				ShowAddDoctorMenu();
				continue;
			}
			case 2:
			{
				ShowAddRecepMenu();
				continue;
			}
			case 3:
			{
				ShowAddAdminMenu();
			}
			case 4:
			{
				break;
			}
			default:
			{
				System.out.print("Invalid choice");
				continue;
			}
			}
			return;
		}

	}

	//Displaying adding admin menu
	public static void ShowAddAdminMenu()
	{
		Scanner scanf = new Scanner(System.in);
		System.out.println("Enter full name of the admin: ");
		try
		{
			String name = scanf.nextLine();

			while(name.isEmpty())
			{
				System.out.println("This name is invalid, please enter proper data");
				name = scanf.nextLine();
			}
			//taking username as an input from the admin
			//This username should be unique
			System.out.println("Enter unique username for the admin: ");
			String username = scanf.nextLine();

			while(users.containsKey(username) || username.isEmpty())
			{
				System.out.println("This username is invalid, please enter another: ");
				username = scanf.nextLine();
			}	

			//Taking password as input
			System.out.println("Enter the password for this account");
			String pwd = scanf.nextLine();

			while(pwd.isEmpty())//this check can be made more stronger later imposing more constraints on the user
			{
				System.out.println("This password is invalid, please enter proper data");
				pwd = scanf.nextLine();
			}

			//adding the user to the actual login class
			loginInfo.addNewUser(username, pwd);

			//updating the all users list
			users.put(username, "admin");

		}
		catch(Exception e)
		{
			System.out.println("Some error occured");
		}
	}


	//Displaying adding receptionist menu
	//@Requires("receps!= null" && "loginInfo!=null")
	//@Ensures("new(receps.size()) = old(receps.size()) + 1" && "new(loginInfo.logindata.size()) == old(loginInfo.loginData.size()) +1" 
	//			&& "receps.containsKey(username)" && "users.containsKey(username)")
	public static void ShowAddRecepMenu()
	{
		Scanner scanf = new Scanner(System.in);
		System.out.println("Enter full name of the receptionst: ");
		try
		{
			String name = scanf.nextLine();

			while(name.isEmpty())
			{
				System.out.println("This name is invalid, please enter proper data");
				name = scanf.nextLine();
			}
			//taking username as an input from the admin
			//This username should be unique
			System.out.println("Enter unique username for the receptionist: ");
			String username = scanf.nextLine();

			while(users.containsKey(username) || username.isEmpty())
			{
				System.out.println("This username is invalid, please enter another: ");
				username = scanf.nextLine();
			}	

			//Taking password as input
			System.out.println("Enter the password for this account");
			String pwd = scanf.nextLine();

			while(pwd.isEmpty())//this check can be made more stronger later imposing more constraints on the user
			{
				System.out.println("This password is invalid, please enter proper data");
				pwd = scanf.nextLine();
			}

			//adding the user to the actual login class
			loginInfo.addNewUser(username, pwd);

			//updating the all users list
			users.put(username, "recep");
			Receptionist r = new Receptionist(name, username);

			//adding the user to doctors list
			receps.put(username, r);
		}
		catch(Exception e)
		{
			System.out.println("Some error occured");
		}
	}
	//Displaying Adding doctor menu 
	//@Requires("doctors!= null" && "loginInfo!=null")
	//@Ensures("new(doctors.size()) = old(doctors.size()) + 1" && "new(loginInfo.logindata.size()) == old(loginInfo.loginData.size()) +1")
	public static void ShowAddDoctorMenu()
	{
		Scanner scanf = new Scanner(System.in);
		System.out.println("Enter full name of the doctor: ");
		try
		{
			String name = scanf.nextLine();

			while(name.isEmpty())
			{
				System.out.println("This name is invalid, please enter proper data");
				name = scanf.nextLine();
			}
			//taking username as an input from the admin
			//This username should be unique
			System.out.println("Enter unique username for the doctor: ");
			String username = scanf.nextLine();

			while(users.containsKey(username) || username.isEmpty())
			{
				System.out.println("This username is invalid, please enter another: ");
				username = scanf.nextLine();
			}	

			//Taking password as input
			System.out.println("Enter the password for this account");
			String pwd = scanf.nextLine();

			while(pwd.isEmpty())//this check can be made more stronger later imposing more constraints on the user
			{
				System.out.println("This password is invalid, please enter proper data");
				pwd = scanf.nextLine();
			}

			//adding the user to the actual login class
			loginInfo.addNewUser(username, pwd);

			//updating the all users list
			users.put(username, "doctor");
			Doctor d = new Doctor(name, username);

			//adding the user to doctors list
			doctors.put(username, d);
		}
		catch(Exception e)
		{
			System.out.println("Some error occured");
		}

	}

	//Displaying Add patient menu
	//Displaying Adding doctor menu 
	//@Requires("patients!= null" && "loginInfo!=null")
	//@Ensures("new(patients.size()) = old(patients.size()) + 1" && "new(loginInfo.logindata.size()) == old(loginInfo.loginData.size()) +1")
	public static void ShowAddPatientMenu()
	{
		Scanner scanf = new Scanner(System.in);
		System.out.println("Enter full name of the patient: ");
		try
		{
			String name = scanf.nextLine();

			while(name.isEmpty())
			{
				System.out.println("This name is invalid, please enter proper data");
				name = scanf.nextLine();
			}
			//taking username as an input from the admin
			//This username should be unique
			System.out.println("Enter unique username for the patient: ");
			String username = scanf.nextLine();

			while(users.containsKey(username) || username.isEmpty())
			{
				System.out.println("This username is invalid, please enter another: ");
				username = scanf.nextLine();
			}	

			//Taking password as input
			System.out.println("Enter the password for this account");
			String pwd = scanf.nextLine();

			while(pwd.isEmpty())//this check can be made more stronger later imposing more constraints on the user
			{
				System.out.println("This password is invalid, please enter proper data");
				pwd = scanf.nextLine();
			}

			//adding the user to the actual login class
			loginInfo.addNewUser(username, pwd);

			//updating the all users list
			users.put(username, "patient");
			Patient p = new Patient(name, username);

			//adding the user to doctors list
			patients.put(username, p);
		}
		catch(Exception e)
		{
			System.out.println("Some error occured");
		}

	}

	//---------------------------------------------------------------------------------------------------

	//Displaying delete user options for the admin
	//Requires("users!=null")
	public static void ShowDeleteUserOptions()
	{
		Scanner scanf = new Scanner(System.in);
		String deleteUsrName = "";
		while(true)
		{
			System.out.println("Enter the username you want to delete");
			try
			{
				deleteUsrName = scanf.nextLine();
				if(users.containsKey(deleteUsrName))
				{

					String role = users.get((deleteUsrName));
					if(role.equals("doctor"))
					{
						users.remove(deleteUsrName);
						doctors.remove(deleteUsrName);
					}
					else if(role.equals("patient"))
					{
						users.remove(deleteUsrName);
						patients.remove(deleteUsrName);
					}

					System.out.println("User deleted from the system");
					return;
				}
				else
				{
					System.out.println("User name not found, press 1 for entering a new username or 2 for exit");
					try
					{
						int option = scanf.nextInt();
						if(option == 1)
						{
							continue;
						}
						else
						{
							System.out.println("Returning to the previous menu");
							return;
						}
					}
					catch(Exception e)
					{
						System.out.println("Invalid choice, returning to previous menu");
					}

				}
			}
			catch(Exception e)
			{
				System.out.println("Invalid input, try again");
			}
		}
	}

}

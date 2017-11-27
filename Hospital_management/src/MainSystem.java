import java.util.*;
import java.io.*;
public class MainSystem {


	public static Login loginInfo = new Login();

	//list of all the users of the system mapping to their roles(doctors, admin, patient, etc)
	public static Hashtable<String, String> users = new Hashtable<String, String>();

	//list of doctors
	public static Hashtable<String, Doctor> doctors = new Hashtable<String, Doctor>();
	public static Hashtable<String, Patient> patients = new Hashtable<String, Patient>();

	public static void main(String[] args) 
	{

		Scanner scanf = new Scanner(System.in);
		String username = "";
		String pwd = "";



		while(true)
		{
			System.out.println("\n------------------------\nEnter username to login");
			username = scanf.nextLine();
			System.out.println("Enter the password");
			pwd = scanf.nextLine();
			users.put("admin", "admin");
			//Verifying if the credentials are proper or not
			if(loginInfo.loginVerify(username, pwd))
			{
				if(users.get("admin").toString().equals("admin"))
				{
					ShowAdminOptions();
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
					"\n2. Patient" +
					"\n3. Receptionist" +
					"\n4. Admin"+
					"\n5. Return to previous menu");
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
				ShowAddPatientMenu();
				continue;
			}
			case 3:
			{
				System.out.println("Add receptionist");
				continue;
			}
			case 4:
			{
				System.out.println("Add admin");
				continue;
			}
			case 5:
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

	//Displaying Adding doctor menu 
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

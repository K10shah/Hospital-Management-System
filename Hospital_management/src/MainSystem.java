import java.util.*;
import java.io.*;
public class MainSystem {

	//list of all the users of the system mapping to their roles(doctors, admin, patient, etc)
	static Hashtable users = new Hashtable();

	//list of doctors
	static Hashtable doctors = new Hashtable();
	static Hashtable patients = new Hashtable();

	public static void main(String[] args) 
	{

		Scanner scanf = new Scanner(System.in);
		String username = "";
		String pwd = "";


		Login loginInfo = new Login();
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
	
	//Add user menu for the admin
	public static void ShowAddUserOptions()
	{
		Scanner scanf = new Scanner(System.in);
		int userchoice = 0;
		Boolean exitFlag = false;
		while(true)
		{
			System.out.println("\nChoose what type of user you want to add");
			System.out.println("1. Doctor" + 
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
				//just in case someone enters something weird 
				System.out.println("-----------Invalid choice-----------");
				continue;
			}
			switch(userchoice)
			{
			case 1:
			{
				System.out.print("Adding a doctor in the system");
			}
			case 2:
			{

			}
			case 5:
			{
				return;
			}
			default:
			{
				System.out.print("Invalid choice");
			}
			}
		}
	}

}

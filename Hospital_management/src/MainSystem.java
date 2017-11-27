import java.util.*;
import java.io.*;
public class MainSystem {

	public static void main(String[] args) {
		
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
			
			//Verifying if the credentials are proper or not
			System.out.println(loginInfo.loginVerify(username, pwd).toString());
		}
	}

}

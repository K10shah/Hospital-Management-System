package views;
import common.*;
public class MainView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Login loginData = new Login();
	
		try
		{
			LoginPage logPage = new LoginPage(loginData);
			logPage.setVisible(true);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}

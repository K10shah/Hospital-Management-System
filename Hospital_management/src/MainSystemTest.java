import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainSystemTest {

	@Test
	void ShowAddPatientMenutest() 
	{
		MainSystem ma = new MainSystem();
		ma.ShowAddPatientMenu();
		assert(2 == ma.loginInfo.loginData.size());
		assert(ma.patients.size() == 1);
	}
	
	void ShowAddREceptionistMenutest()
	{
		MainSystem ma1 = new MainSystem();
		ma1.ShowAddRecepMenu();
		assert(2 == ma1.loginInfo.loginData.size());
		assert(ma1.receps.size() == 1);
	}

}

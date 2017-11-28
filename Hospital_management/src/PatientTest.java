import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import org.junit.jupiter.api.Test;

class PatientTest {

	
	final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	
	@Test
	void ViewAccounttest() {
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
		Patient p = new Patient("pat1", "pat1");
		p.ViewAccount();
		assertEquals("Your outstanding amount to be paid is 0.0\r\n", outContent.toString());
	}
	
	@Test
	void ViewRecordtest()
	{
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	    
	    Patient p = new Patient("pat","pat");
	    p.ViewRecords();
	    
	    assertEquals("Nothing to show\r\n" , outContent.toString());
	}

}

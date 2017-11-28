import java.io.*;
import java.util.*;
import java.time.LocalTime;


public class Doctor extends Employee{
	
	Doctor(String name, String username)
	{
		this.name = name;
		this.username = username;
	}
	
	public void TreatPatient(Patient p)
	{
		Scanner scanf = new Scanner(System.in);
		System.out.println("Enter the diagnosis");
		
		String diagnosis = scanf.nextLine();
		
		System.out.println("Enter the prescription");
		
		String pres = scanf.nextLine();
		
		PatientRecord pr = new PatientRecord(LocalTime.now(), diagnosis, pres, this.name);
		
		p.patientRecord.add(pr);
	}
}

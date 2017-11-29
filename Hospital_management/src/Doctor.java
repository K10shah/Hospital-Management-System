import java.io.*;
import java.util.*;
import java.time.LocalTime;


public class Doctor extends Employee{

	Doctor(String name, String username)
	{
		this.setName(name);
		this.setUserName(username);
	}


	//This method will prompt the doctor to enter the diagnosis and prescription for the patient he selected
	//@Require ("p!= null")
	//@Ensures ("p.patientRecord.size.new = p.patientRecord.size.old + 1" and "pr.getDoctorName() == this.getName()")
	public void TreatPatient(Patient p)
	{

		Scanner scanf = new Scanner(System.in);
		System.out.println("Enter the diagnosis");

		String diagnosis = scanf.nextLine();

		System.out.println("Enter the prescription");

		//String that stores the prescription info
		String pres = scanf.nextLine();

		//For storing the time the record was created
		LocalTime lt = LocalTime.now();

		//Making a new instance of the Patient record corresponding to the one just made
		PatientRecord pr = new PatientRecord(lt , diagnosis, pres, this.getName());

		//Adding this new instance to the patient record history
		p.AddRecord(pr);
	}
}

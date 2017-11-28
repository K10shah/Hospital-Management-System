import java.util.*;
import java.io.*;

public class Patient {
	String name = "";
	String username = "";
	double accountbalance = 0;
	ArrayList<PatientRecord> patientRecord = new ArrayList<PatientRecord>();
	
	Patient(String name, String username)
	{
		this.name = name;
		this.username = username;
	}
	
	public void ViewRecords()
	{
		String records = "";
		for(int i = 0; i< patientRecord.size(); i++)
		{
			records = records + (patientRecord.iterator().next().toString());
		}
		
		if(records.isEmpty())
		{
			System.out.println("Nothing to show");
		}
		else
		{
			System.out.println(records);
		}
	}
	
	public void ViewAccount()
	{
		System.out.println("Your outstanding amount to be paid is " + accountbalance);
	}
}
